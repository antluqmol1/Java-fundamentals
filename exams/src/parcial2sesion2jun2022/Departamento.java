package parcial2sesion2jun2022;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Departamento {
	
	//ATRIBUTOS
	private Set<Profesor> profesores;
	
	//C1
	public Departamento() {
		this.profesores = new HashSet<Profesor>();
	}
	
	//C2
	public Departamento(Stream<Profesor> sp) {
		this.profesores = sp.collect(Collectors.toSet());
	}
	
	public Set<Profesor> getProfesores() {
		return new HashSet<Profesor>(profesores);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profesores == null) ? 0 : profesores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (profesores == null) {
			if (other.profesores != null)
				return false;
		} else if (!profesores.equals(other.profesores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [profesores=" + profesores + "]";
	}
	
	//OTRAS OPERACIONES
	public void añadirProfesor(Profesor p) {
		profesores.add(p);
	}
	
	public void eliminarProfesor(String n) {
		Profesor pb = null;
		for(Profesor p:profesores) {
			if (p.nombre().equals(n)) {
				pb = p;
				break;
			}
		}
		if (pb != null) {
			profesores.remove(pb);
		}
	}
	
	//TRATAMIENTOS SECUENCIALES
	
	//1.
	Map<Asignatura, List<Profesor>> profesoresPorAsignatura() {
		Map<Asignatura, List<Profesor>> res = new HashMap<Asignatura, List<Profesor>>();
		for (Profesor p : this.profesores) {
			for (Asignatura a : p.getAsignaturasImpartidas()) {
				if (!res.containsKey(a)) {
					List<Profesor> lp = new ArrayList<Profesor>();
					lp.add(p);
					res.put(a, lp);
				}
				else {
					res.get(a).add(p);
				}
			}
		}
		return res;
	}
	
	//2.
	Set<Profesor> profesoresQueSoloImpartenAsignaturasQueCoordinan() {
		return this.profesores.stream()
				.filter(p -> p.asignaturasCoordinadas().containsAll(p.getAsignaturasImpartidas()))
				.collect(Collectors.toSet());			
	}
	
	//3.
	Boolean departamentoResponsable() {
		return this.profesores.stream()
				.filter(p -> p.esCoordinador())
				.allMatch(p -> p.getExperiencia() >= 5 && p.getAsignaturasImpartidas().containsAll(p.asignaturasCoordinadas()));
	}
	
	//4.
	List<String> ordenarProfesoresPorNumeroCreditosTeoricos() {
		return this.profesores.stream()
				.filter(p -> p.creditosTeoricos() > 0)
				.sorted(Comparator.comparing(Profesor::creditosTeoricos).reversed())
				.distinct()
				.map(p -> p.nombre())
				.collect(Collectors.toList());
				
	}
	
	//5.
	Integer añoIncorporacionMasCoordinadores() {
		return this.profesores.stream()
				.filter(p -> p.esCoordinador())
				.collect(Collectors.groupingBy(p -> p.fechaIngreso().getYear()
						,Collectors.counting()))
				.entrySet().stream()
				.max(Comparator.comparing(x -> x.getValue()))
				.orElseThrow(NoSuchElementException::new).getKey();
				
		
	}

}
