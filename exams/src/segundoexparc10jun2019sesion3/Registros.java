package segundoexparc10jun2019sesion3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registros {
	
	//ATRIBUTOS
	private SortedSet<Registro> registros;
	
	//CONSTRUCTOR
		//STREAM
	public Registros(Stream<Registro> rs) {
		this.registros = rs.collect(Collectors.toCollection(TreeSet::new));
	}

	//TO STRING
	@Override
	public String toString() {
		return "Registros [registros=" + registros + "]";
	}
	
	//OPERACIONES;
	public Double getValorMedioPuntuacionConjuntoPaises(Set<String> paises) {
		return this.registros.stream()
				.filter(r -> paises.contains(r.getPais()))
				.mapToDouble(r -> r.getPuntos())
				.average()
				.getAsDouble();	
	}
	
	public String getPaisMayorPuntuacion(int anyo) {
		return this.registros.stream()
				.filter(r -> r.getAnyo() == anyo)
				.max(Comparator.comparing(Registro::getPuntos))
				.orElseThrow(NoSuchElementException::new)
				.getPais();
	}
	
	//ESTÁ BIEN
	public Map<String, Double> getMediaDerechosPorPais() {
		return this.registros.stream()
				.filter(r -> !r.getDerechos().equals(-1.0))
				.collect(Collectors.groupingBy(r -> r.getPais()
						, Collectors.averagingDouble(Registro::getDerechos)));
	}
	
	//NO SÉ SI ESTÁ BIEN
	/*
	public Map<String, Double> getMediaDerechosPorPais() {
		return this.registros.stream()
				.collect(Collectors.groupingBy(r -> r.getPais()
						, Collectors.collectingAndThen(Collectors.toList()
								, l -> getMediaDerechos(l))));
	}
	
	private Double getMediaDerechos(List<Registro> lr) {
		return lr.stream()
				.mapToDouble(r -> r.getDerechos())
				.skip(-1l)
				.average()
				.getAsDouble();
				
	}
	*/
	
	public String getPaisConMenorMediaDerechos() {
		Map<String, Double> res = getMediaDerechosPorPais();
		return res.entrySet().stream()
				.min(Comparator.comparing(entry -> entry.getValue()))
				.get()
				.getKey();
	}
	
	public Map<Integer, String> getPaisMasDerechosPorAnyo() {
		return this.registros.stream()
				.collect(Collectors.groupingBy(r -> r.getAnyo()
						, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Registro::getDerechos))
								,max -> max.orElseThrow(NoSuchElementException::new).getPais())));
	}
	
	public Map<Integer, List<String>> getListaNPaisesPorAnyo(int n) {
		return organizaRegistrosPorAnyo().entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey()
						, entry -> obtenListaNombresNPaisesMasJusticiaOrdenados(entry.getValue(), n)));
				
	}
	
	private Map<Integer, List<Registro>> organizaRegistrosPorAnyo() {
		return this.registros.stream()
				.collect(Collectors.groupingBy(r -> r.getAnyo()));
	}
	
	private List<String> obtenListaNombresNPaisesMasJusticiaOrdenados(List<Registro> lr, int n) {
		return lr.stream()
				.sorted(Comparator.comparing(Registro::getJusticia).reversed())
				.limit(n)
				.map(r -> r.getPais())
				.collect(Collectors.toList());
	}
	
	

}
