package examen3convdiciembre2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalogo {
	
	//ATRIBUTOS 
	private List<Vivienda> viviendas;
	
	//CONSTRUCTOR
	public Catalogo(Stream<Vivienda> sv) {
		this.viviendas = sv.collect(Collectors.toList());
	}
	
	public List<Vivienda> getViviendas() {
		return new ArrayList<Vivienda>(viviendas);
	}

	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((viviendas == null) ? 0 : viviendas.hashCode());
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
		Catalogo other = (Catalogo) obj;
		if (viviendas == null) {
			if (other.viviendas != null)
				return false;
		} else if (!viviendas.equals(other.viviendas))
			return false;
		return true;
	}
	
	//REPRESENTACIÓN COMO CADENA
	@Override
	public String toString() {
		return "Catalogo [viviendas=" + viviendas + "]";
	}
	
	//TRATAMIENTOS SECUENCIALES
		//A)
	public Map<String, Double> getPrecioMedioPorDistritoDeTipos(Set<TipoVivienda> conjTipos) {
		return this.viviendas.stream()
				.filter(reg -> conjTipos.contains(reg.getTipo()))
				.collect(Collectors.groupingBy(reg -> reg.getDistrito()
						, Collectors.averagingDouble(reg -> reg.getPrecio())));
	}
	
		//B)
	public Map<String, Long> getNumViviendasPorDistrito() {
		return this.viviendas.stream()
				.collect(Collectors.groupingBy(reg -> reg.getDistrito()
						, Collectors.counting()));
	}
	
	public Set<String> getDistritosMasNViviendas (Integer n) {
		return getNumViviendasPorDistrito().entrySet().stream()
				.filter(reg -> reg.getValue()>0)
				.map(reg -> reg.getKey())
				.distinct()
				.collect(Collectors.toSet());
	}
	
		//C)
	public List<TipoVivienda> getTiposViviendasMasCarasCalle (String calle, Integer n) {
		return this.viviendas.stream()
				.filter(reg -> reg.getDireccion().contains(calle))
				.sorted(Comparator.comparing(Vivienda::getPrecioMetroCuadrado).reversed())
				.map(Vivienda::getTipo)
				.distinct()
				.limit(n)
				.collect(Collectors.toList());
	}
	
		//D)
	public Map<TipoVivienda, Vivienda> getViviendaMasBarataPorTipoEnCapital() {
		return this.viviendas.stream()
				.filter(reg -> reg.getCapital())
				.collect(Collectors.groupingBy(reg -> reg.getTipo()
						, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(reg -> reg.getPrecio()))
								, x -> x.get())));				
	}
	
		//E)
	private Double getPorcentaje(List<Vivienda> lv, Double umbral) {
		Double viviendasTotales = (double) lv.size();
		Long viviendasSuperanUmbral = lv.stream()
				.filter(reg -> reg.getPrecioMetroCuadrado() > umbral)
				.count();
		return (viviendasSuperanUmbral / viviendasTotales);
	}
	
	public Map<String, Double> getPorcViviendasPreciosMayorUmbralPorDistrito(Double umbralPrecio) {
		return this.viviendas.stream()
				.collect(Collectors.groupingBy(reg -> reg.getDistrito()
						, Collectors.collectingAndThen(Collectors.toList()
								, l -> getPorcentaje(l, umbralPrecio))));
	}
	
	
	
	
	
	

}
