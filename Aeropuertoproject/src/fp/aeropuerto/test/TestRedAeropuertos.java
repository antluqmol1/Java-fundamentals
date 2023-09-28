package fp.aeropuerto.test;

import fp.aeropuerto.*;

public class TestRedAeropuertos {

	public static void main(String[] args) {

//Creamos un primer Aeropuerto y le añadimos los vuelo de "vuelos.csv"
		Aeropuerto a1=new Aeropuerto ("San Pablo (Sevilla)");
		a1.añadeVuelos(FactoríaVuelos1.leerVuelos("data/vuelos.csv"));
//Creamos un segundo Aeropuerto y le añadimos los vuelos de "vuelos2.csv"
		Aeropuerto a2=new Aeropuerto ("Lepe (Huelva)");
		a1.añadeVuelos(FactoríaVuelos1.leerVuelos("data/vuelos2.csv"));
//Creamos una red de Aeropuerto
		RedDeAeropuertos ra=new RedDeAeropuertos("Dos aeropuertos andaluces");
//Añadimos los dos aeropuertos a la red
		ra.añadeAeropuerto(a1);
		ra.añadeAeropuerto(a2);
		System.out.println("RedDeAeropuertos: "+ra);
//		testGetNúmeroVuelosADestino(ra);
//		testGetPromedioPlazasVuelosCompletos(ra);
		
	}
//Apartado 14 a)	
	private static void testGetNúmeroVuelosADestino(RedDeAeropuertos r) {
		try {
			System.out.println("\ngetNúmeroVuelosADestino a Madrid:"+
					r.getNúmeroVuelosADestino("Madrid"));
		}catch(Exception e) {
			System.out.println("Capturada excepción: "+e.getStackTrace());
		}
	}
//Apartado 14 b)	
	private static void testGetPromedioPlazasVuelosCompletos(RedDeAeropuertos r) {
		try {
			System.out.println("\ngetPromedioPlazasVuelosCompletos:"+
					r.getPromedioPlazasVuelosCompletos());
		}catch(Exception e) {
			System.out.println("Capturada excepción: "+e.getStackTrace());
		}
	}

}
