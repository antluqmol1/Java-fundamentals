package fp.aeropuerto.test;

import fp.aeropuerto.*;

public class TestRedAeropuertos {

	public static void main(String[] args) {

//Creamos un primer Aeropuerto y le a�adimos los vuelo de "vuelos.csv"
		Aeropuerto a1=new Aeropuerto ("San Pablo (Sevilla)");
		a1.a�adeVuelos(Factor�aVuelos1.leerVuelos("data/vuelos.csv"));
//Creamos un segundo Aeropuerto y le a�adimos los vuelos de "vuelos2.csv"
		Aeropuerto a2=new Aeropuerto ("Lepe (Huelva)");
		a1.a�adeVuelos(Factor�aVuelos1.leerVuelos("data/vuelos2.csv"));
//Creamos una red de Aeropuerto
		RedDeAeropuertos ra=new RedDeAeropuertos("Dos aeropuertos andaluces");
//A�adimos los dos aeropuertos a la red
		ra.a�adeAeropuerto(a1);
		ra.a�adeAeropuerto(a2);
		System.out.println("RedDeAeropuertos: "+ra);
//		testGetN�meroVuelosADestino(ra);
//		testGetPromedioPlazasVuelosCompletos(ra);
		
	}
//Apartado 14 a)	
	private static void testGetN�meroVuelosADestino(RedDeAeropuertos r) {
		try {
			System.out.println("\ngetN�meroVuelosADestino a Madrid:"+
					r.getN�meroVuelosADestino("Madrid"));
		}catch(Exception e) {
			System.out.println("Capturada excepci�n: "+e.getStackTrace());
		}
	}
//Apartado 14 b)	
	private static void testGetPromedioPlazasVuelosCompletos(RedDeAeropuertos r) {
		try {
			System.out.println("\ngetPromedioPlazasVuelosCompletos:"+
					r.getPromedioPlazasVuelosCompletos());
		}catch(Exception e) {
			System.out.println("Capturada excepci�n: "+e.getStackTrace());
		}
	}

}
