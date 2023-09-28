package fp.aeropuerto.test;

import java.util.Collections;
import java.util.List;

import fp.aeropuerto.Factor�aVuelos1;
import fp.aeropuerto.Vuelo;

public class TestVuelo03 {

	public static void main(String[] args) {
		List<Vuelo> listVuelos = Factor�aVuelos1.leerVuelos("data/vuelos.csv");
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
		
		Vuelo m�ximo = Collections.max(listVuelos);
		System.out.println("\nVuelo m�ximo: ");
		System.out.println(m�ximo);
	}

}
