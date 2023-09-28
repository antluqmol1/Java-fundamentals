package fp.aeropuerto.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.aeropuerto.FactoríaVuelos1;
import fp.aeropuerto.Vuelo;

public class TestVuelos02 {

	public static void main(String[] args) {
		
		List<Vuelo> listVuelos = FactoríaVuelos1.leerVuelos("data/vuelos.csv");		
		System.out.println("Nro. eltos listVuelos: " + listVuelos.size());
		
		Set<Vuelo> conjVuelosA = new HashSet<Vuelo>(listVuelos);
		System.out.println("Nro. eltos listVuelos: " + conjVuelosA.size());
		
		Set<Vuelo> conjVuelosB = new HashSet<Vuelo>();
		for (Vuelo v: listVuelos) {
			if (v.getNumPasajeros()<=150) {
				conjVuelosB.add(v);
			}
		}
		System.out.println("\nNro. elementos conjVuelosB: " + conjVuelosB.size());
		
		Set<Vuelo> conjVuelosC = new HashSet<Vuelo>();
		for (Vuelo v: listVuelos) {
			if (v.getPrecio()<=75) {
				conjVuelosC.add(v);
			}
		}
		System.out.println("\nNro. elementos conjVuelosC: " + conjVuelosC.size());
		
		Set<Vuelo> conjBackup = new HashSet<Vuelo>(conjVuelosB);
		conjVuelosB.retainAll(conjVuelosC);
		System.out.println("\nNro. eltos B intersección C: " + conjVuelosB.size());
		
		conjVuelosB.clear();
		conjVuelosB.addAll(conjBackup);
		conjVuelosB.removeAll(conjVuelosC);
		System.out.println("\nNro.eltos B menos C: "+conjVuelosB.size());
		
		SortedSet<Vuelo> conjOrdVuelos = new TreeSet<Vuelo>();
		conjOrdVuelos.addAll(listVuelos);
		System.out.println("\nNro. eltos conjunto ordenado: " + conjOrdVuelos.size());
		
		System.out.println("\nConjunto ordenado");
		for (Vuelo v:conjOrdVuelos) {
			System.out.println(v);
		}
	}

}
