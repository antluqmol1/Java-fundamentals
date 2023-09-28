package parcial2sesion2jun2022;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public record Profesor(String nombre, LocalDate fechaIngreso, Set<Asignatura> asignaturasCursosAnteriores, 
		Set<Asignatura> asignaturasPrimerCuatri, Set<Asignatura> asignaturasSegundoCuatri, Double creditosTeoricosPrimerCuatri,
		Double creditosTeoricosSegundoCuatri, Double creditosLaboratorioPrimerCuatri, Double creditosLaboratorioSegundoCuatri, 
		Double capacidad, Set<Asignatura> asignaturasCoordinadas) implements Comparable<Profesor> {

	//RESTRICCIONES
	public Profesor{
		Checkers.check("la fecha de ingreso debe ser anterior a la fecha actual", 
				fechaIngreso.isBefore(LocalDate.now()));
		Checkers.check("la suma de créditos de docencia asignados debe ser mayor o igual que 0", 
				creditosTeoricosPrimerCuatri + creditosTeoricosSegundoCuatri + creditosLaboratorioPrimerCuatri + creditosLaboratorioSegundoCuatri >= 0 );
		Checkers.check(" la capacidad docente debe ser mayor o igual que 0", 
				capacidad >= 0);
	}
	
	public Double getCreditosAsignados() {
		return creditosTeoricosPrimerCuatri + creditosTeoricosSegundoCuatri + creditosLaboratorioPrimerCuatri + creditosLaboratorioSegundoCuatri;
	}
	
	public Integer getExperiencia() {
		Period res = Period.between(LocalDate.now(), fechaIngreso);
		return res.getYears();
	}
	
	public Boolean EsOcioso() {
		Boolean res = false;
		if (getCreditosAsignados() <= capacidad/2) {
			res = true;
		}
		return res;
	}
	
	public Set<Asignatura> getAsignaturasImpartidas() {
		Set<Asignatura> res = new HashSet<Asignatura>(asignaturasPrimerCuatri);
		res.addAll(asignaturasSegundoCuatri);
		return res;
	}
	
	public Boolean esCoordinador() {
		Boolean res = false;
		if (!asignaturasCoordinadas.isEmpty()) {
			res = true;
		}
		return res;
	}
	
	public Double creditosTeoricos() {
		return creditosTeoricosPrimerCuatri + creditosTeoricosSegundoCuatri;
	}

	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//ORDEN NATURAL
	public int compareTo(Profesor p) {
		return nombre().compareTo(p.nombre());	
	}
	
	
	
}
