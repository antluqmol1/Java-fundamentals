package fp.aeropuerto.test;

import java.util.Collections;
import java.util.List;

import fp.aeropuerto.FactoríaVuelos1;
import fp.aeropuerto.Vuelo;

public class TestVuelo03 {

	public static void main(String[] args) {
		List<Vuelo> listVuelos = FactoríaVuelos1.leerVuelos("data/vuelos.csv");
		System.out.println("Nro. eltos listVuelos: " + listVuelos.size());
		
		Collections.shuffle(listVuelos);
		System.out.println("\nVuelos barajados: ");
		for (Vuelo v: listVuelos) {
			System.out.println(v);
		}
		Collections.sort(listVuelos);
		System.out.println("\nVuelos ordenados: ");
		for (Vuelo v:listVuelos) {
			System.out.println(v);
		}
		
		Vuelo máximo = Collections.max(listVuelos);
		System.out.println("\nVuelo máximo: ");
		System.out.println(máximo);
	}

}
