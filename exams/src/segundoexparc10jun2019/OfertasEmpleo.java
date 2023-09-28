package segundoexparc10jun2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class OfertasEmpleo {
	
	//ATRIBUTOS
	private List<OfertaEmpleo> ofertasEmpleo;
	
	//CONSTRUCTOR LISTA VACÍA
	public OfertasEmpleo() {
		this.ofertasEmpleo = new ArrayList<OfertaEmpleo>();
	}
	
	//CONSTRUCTOR STREAM
	public OfertasEmpleo(Stream<OfertaEmpleo> os) {
		this.ofertasEmpleo = os.collect(Collectors.toList());
	}
	
	//PROPIEDADES
	public List<OfertaEmpleo> getOfertasEmpleo() {
		return new ArrayList<OfertaEmpleo>(ofertasEmpleo);
	}
	
	public Integer getNumOfertasEmpleo() {
		return getOfertasEmpleo().size();
	}

	
	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(ofertasEmpleo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfertasEmpleo other = (OfertasEmpleo) obj;
		return Objects.equals(ofertasEmpleo, other.ofertasEmpleo);
	}

	//REPRESENTACIÓN COMO CADENA
	
	@Override
	public String toString() {
		return "OfertasEmpleo [ofertasEmpleo=" + ofertasEmpleo + "]";
	}
	
	
	//OPERACIONES
	
	//A)
	public Boolean hayAlgunaOfertaConPorcentajePlazasDiscapacidadMayorA(Double umbral) {
		Checkers.check("El umbral no está en el intervalo [0,100]", umbral >=0 && umbral <= 100);
		Predicate<OfertaEmpleo> p1 = oferta -> oferta.getPorcentajePlazasDiscapacidad() >= umbral;
		return ofertasEmpleo.stream()
				.anyMatch(p1);
	}
	
	//B)
	public Integer getNumeroEspecialidadesFacultativosEspecialistas() {
		Long cuenta = ofertasEmpleo.stream()
				.filter(oferta -> oferta.getEspecialidad().startsWith("FEA"))
				.map(oferta -> oferta.getEspecialidad())
				.distinct()
				.count();
		return cuenta.intValue();
	}
	
	//C)
	public Integer getTotalPlazas(String especialidad, Integer anyo) {
		return ofertasEmpleo.stream()
				.filter(oferta -> oferta.getEspecialidad().equals(especialidad) 
						&& oferta.getFechaPublicacionBoja().getYear() == anyo)
				.mapToInt(oferta -> oferta.getNumPlazasTotales())
				.sum();
	}
		
	public Integer getTotalPlazas2(String especialidad, Integer anyo) {
		return ofertasEmpleo.stream()
				.filter(oferta -> oferta.getEspecialidad().equals(especialidad) 
						&& oferta.getFechaPublicacionBoja().getYear() == anyo)
				.map(oferta -> oferta.getNumPlazasTotales())
				.reduce(Integer::sum)
				.get();
	}
	
	//D
	public SortedMap<Integer, Integer> getTotalPlazasTipo(TipoAcceso tipo) {
		return ofertasEmpleo.stream()
				.filter(oferta -> oferta.getTipoAcceso().equals(tipo))
				.collect(Collectors.groupingBy(oferta -> oferta.getFechaPublicacionBoja().getYear()
						, TreeMap::new
						//, () -> new TreeMap(Comparator.reverseOrder())
						, Collectors.summingInt(oferta -> oferta.getNumPlazasTotales())));
	}
	
	//E)
	public String getEspecialidadMasOfertada() {
		return ofertasEmpleo.stream()
				.collect(Collectors.groupingBy(oferta -> oferta.getEspecialidad()
						, Collectors.summingInt(OfertaEmpleo::getNumPlazasTotales)))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();		
	}
	
	//F)
	public Map<Object, Object> getNEspecialidadesMasPlazasPorAnyo(Integer n) {
		return ofertasEmpleo.stream()
				.collect(Collectors.groupingBy(
				of->of.getFechaPublicacionBoja().getYear(),
				Collectors.collectingAndThen(
				Collectors.toList(),
				l -> obtenerNOfertasMayorNumPlazasTotales(l, n)
				)));

	}
	
	//Método auxiliar 1
	private Map<Integer, List<OfertaEmpleo>> obtenerOfertasPorAnyo() {
		return ofertasEmpleo.stream()
				.collect(Collectors.groupingBy(oferta -> oferta.getFechaPublicacionBoja().getYear()));
	}
	
	//Método auxiliar 2
	private List<String> obtenerNOfertasMayorNumPlazasTotales(List<OfertaEmpleo> lista, Integer n) {
		return lista.stream()
				.sorted(Comparator.comparing(OfertaEmpleo::getNumPlazasTotales).reversed())
				.limit(n)
				.map(OfertaEmpleo::getEspecialidad)
				.collect(Collectors.toList());
	}
	
	
	
	
	

}
