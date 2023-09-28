package exterceraconv117diciembre2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistrosDeuda {
	
	//ATRIBUTOS
	private List<RegistroDeuda> registros;
	
	//CONSTRUCTOR
	public RegistrosDeuda(Stream<RegistroDeuda> srd) {
		srd.collect(Collectors.toList());
	}
	
	public List<RegistroDeuda> getRegistros() {
		return new ArrayList<RegistroDeuda>(registros);
	}
	
	//a)
	public SortedSet<String> getNombrePaisesEmpiezanCon(String s) {
		return this.registros.stream()
				.filter(reg -> reg.getNombrePais().toUpperCase().startsWith(s.toUpperCase()))
				.map(reg -> reg.getNombrePais())
				.collect(Collectors.toCollection(TreeSet::new));
	}
	
	//b)
	public String getPaisMasDeudaPerCapita(List<String> paises, Integer anyo) {
		return this.registros.stream()
				.filter(reg -> paises.contains(reg.getNombrePais()) && reg.getFecha().getYear() == anyo)
				.max(Comparator.comparing(RegistroDeuda::getDeudaPerCapita))
				.map(RegistroDeuda::getNombrePais)
				.get();
	}
	
	//c)
	private List<RegistroDeuda> ordenarLista(List<RegistroDeuda> l) {
		return l.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
	}
	
	public SortedMap<String, List<RegistroDeuda>> getRegistrosPorPaisEnOrdenCronologico() {
		return this.registros.stream()
				.collect(Collectors.groupingBy(reg -> reg.getNombrePais()
						, TreeMap::new
						, Collectors.collectingAndThen(Collectors.toList()
								, l -> ordenarLista(l))));	
	}
	
	//d)
	private Double porcentajeCambioDeudaTotal(List<RegistroDeuda> l) {
		List<Integer> ld = l.stream()
				.sorted(Comparator.reverseOrder())
				.map(RegistroDeuda::getDeudaTotal)
				.collect(Collectors.toList());
		Integer inicio = ld.get(0);
		Integer fin = ld.get(ld.size() - 1);
		return 100.-(fin *100. /inicio);
			}
	
	public SortedMap<String, Double> getPorcentajeCambioDeudaTotalPorPaises() {
		return this.registros.stream()
				.collect(Collectors.groupingBy(reg -> reg.getNombrePais()
						, TreeMap::new
						, Collectors.collectingAndThen(Collectors.toList()
								, l -> porcentajeCambioDeudaTotal(l))));			
	}
	
	//Solución alternativa
	public SortedMap<String, Double> getPorcentajeCambioDeudaTotalPorPaises2() {
		SortedMap<String, List<RegistroDeuda>> map = getRegistrosPorPaisEnOrdenCronologico();
		return new TreeMap<String, Double>(
				map.keySet().stream()
					.filter(key -> map.get(key).size() > 1)
					.collect(Collectors.toMap((String key) -> key
							, (String key) -> porcentajeCambioDeudaTotal(map.get(key)))));
				
	}

}
