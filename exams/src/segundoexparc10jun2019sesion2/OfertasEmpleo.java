package segundoexparc10jun2019sesion2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OfertasEmpleo {
	
	//ATRIBUTOS
	private List<OfertaEmpleo> ofertasEmpleo;
	
	//CONSTRUCTOR
	
		//LISTA VACÍA
	public OfertasEmpleo() {
		this.ofertasEmpleo = new ArrayList<OfertaEmpleo>();
	}
	
		//STREAM
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

	//REPRESENTACIN COMO CADENA
	@Override
	public String toString() {
		return "OfertasEmpleo [ofertasEmpleo=" + ofertasEmpleo + "]";
	}
	
	//OTRAS OPERACIONES
	
		//A)
	public SortedSet<String> getEspecialidadesDeCuerpo(String cuerpo) {
		return ofertasEmpleo.stream()
				.filter(o -> o.getCuerpo().equals(cuerpo))
				.map(o -> o.getEspecialidad())
				.collect(Collectors.toCollection(TreeSet::new));
				//.collect(Collectors.toCollection(() -> new TreeSet<OfertaEmpleo>(Comparator.comparing(OfertaEmpleo::getEspecialidad))));
	}
	
		//B)
	public Double getMediaPlazasPorOferta(String cuerpo, String especialidad) {
		return ofertasEmpleo.stream()
				.filter(o -> o.getCuerpo().equals(cuerpo) && o.getEspecialidad().equals(especialidad))
				.mapToInt(o -> o.getNumPlazas())
				.average()
				.getAsDouble();
	}
	
		//C)
	public List<OfertaEmpleo> getNOfertasMasPlazas(Integer anyo, Integer n) {
		return ofertasEmpleo.stream()
				.filter(o -> o.getFechaPublicacionBOJA().getYear() == anyo)
				.sorted(Comparator.comparing(OfertaEmpleo::getNumPlazas).reversed())
				.limit(n)
				.collect(Collectors.toList());
	}
	
		//D)
	public Map<NivelEducativo, Integer> getNumPlazasPorNivelEducativo(Integer anyo) {
		return ofertasEmpleo.stream()
				.filter(o -> o.getFechaPublicacionBOJA().getYear() == anyo)
				.collect(Collectors.groupingBy(o -> o.getNivelEducativo()
						, Collectors.summingInt(OfertaEmpleo::getNumPlazas)));
	}
	
		//E)
	public Integer getAnyoMasOferta (String cuerpo) {
		return ofertasEmpleo.stream()
				.filter(o -> o.getCuerpo().equals(cuerpo))
				.collect(Collectors.groupingBy(o -> o.getFechaPublicacionBOJA().getYear()
						, Collectors.summingInt(OfertaEmpleo::getNumPlazas)))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
	}
	
		//F)
	public Map<NivelEducativo, Double> getPorcentajePlazasPorNivelEducativo(Integer anyo) {
		
		Map<NivelEducativo, Integer> mp = getNumPlazasPorNivelEducativo(anyo);
		
		Integer totalPlazas = mp.values().stream()
				.mapToInt(o -> o)
				.sum();

		return mp.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey
						, entry -> entry.getValue() * 100. / totalPlazas));
	}
	
	
	

}
