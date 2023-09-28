package fp.aeropuerto.test;

import fp.aeropuerto.Aeropuerto;
import fp.aeropuerto.FactoríaVuelos1;
import fp.aeropuerto.Vuelo;

public class TestAeropuerto01 {

	public static void main(String[] args) {
		Aeropuerto a = new Aeropuerto("Sevilla (San Pablo)");
		a.añadeVuelos(FactoríaVuelos1.leerVuelos("data/vuelos.csv"));
		System.out.println("***Vuelos del Aeropuerto " + a.getNombre());
		for (Vuelo v:a.getVuelos()) {
			System.out.println(v);
		}

	}

}
