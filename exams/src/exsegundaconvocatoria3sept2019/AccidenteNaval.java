package exsegundaconvocatoria3sept2019;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccidenteNaval {
	
	//ATRIBUTOS
	private SortedSet<PasajeroBarco> pasajeros;
	
	
	//CONSTRUCTOR
	
		//SIN PARAMETROS
	public AccidenteNaval() {
		this.pasajeros = new TreeSet<PasajeroBarco>();
	}
	
		//CON STREAM
	public AccidenteNaval(Stream<PasajeroBarco> sp) {
		this.pasajeros = sp.collect(Collectors.toCollection(TreeSet::new));
	}

	public SortedSet<PasajeroBarco> getPasajeros() {
		return new TreeSet<PasajeroBarco>(pasajeros);
	}

	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(pasajeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccidenteNaval other = (AccidenteNaval) obj;
		return Objects.equals(pasajeros, other.pasajeros);
	}

	//REPRESENTACION COMO CADENA
	public String toString() {
		return pasajeros.stream()
				.map(p -> p.toString())
				.collect(Collectors.joining("\n"));
	}
	
	
	
	
	
	

}
