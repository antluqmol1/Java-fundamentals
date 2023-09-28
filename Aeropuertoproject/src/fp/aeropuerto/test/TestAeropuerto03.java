package fp.aeropuerto.test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import fp.aeropuerto.*;

public class TestAeropuerto03 {

	public static void main(String[] args) {
		try {
 // Se crea un Aeropuerto "a"
			Aeropuerto a=new Aeropuerto("Sevilla (San Pablo)");
  //Se añaden a "a" los vuelos del dataset
			a.añadeVuelos(FactoríaVuelos1.leerVuelos("data/vuelos.csv"));
  			System.out.println("***Vuelos del Aeropuerto "+a.getNombre());
  			testNúmeroDeVuelosPorCompañía(a);
  			testCódigosVuelosPorDestino(a);
  			//testPromedioPreciosPorFecha(a);
  //Apartado 12
  			testOrdenaVuelosPorOrdenNatural(a);
  			testOrdenaVuelosPorFechaSalida(a);
  			testOrdenaVuelosPorDestinoYFechaSalida(a);
  			testOrdenaVuelosPorNroPasajerosAlReves(a);
  			testOrdenaVuelosPorDuraciónYMayorNumeroPasajeros(a);
  //Apartado 13
  			testGetNúmeroVuelosADestino(a);
  			testGetNumPasajerosADestino(a);
  			testGetRecaudacionADestino(a);
  			testGetPromedioPasajerosDeUnaFecha(a);
  			testGetCodigoPrimerVueloADestinoConPlazasLibres(a);
  			/*
  //Apartado 15
  			testGetListaTresVuelosMasBaratos(a);
  			testGetListaNVuelosMayorDuracion(a);
  			testGetListaVuelosOrdenadosFechaYNumPasajeros(a);
  			testGetConjuntoOrdenadoDestinos(a);
  			testGetMapListaVuelosPorDestinos(a);

  			testGetMapSetVuelosPorFecha(a);
  			testGetMapSetOrdenadoVuelosPorFecha(a);
  			testGetMapNumVuelosPorFecha(a);
  			testGetMapPrecioMedioPorDestino(a);
  //Apartado 16			
  			testGetMapVuelosCompletosMásBaratoPorDestino(a);
  			testGetMapCódigoVuelosCompletosMásBaratoPorDestino(a);
  			testGetMapOrdenadoNumPasajerosPorDuraciónDeCompañía(a);
  			testGetMapPorcentajeVuelosPorDestino(a);			
  			*/
  			//testGetSegundaCompañiaConMenosVuelos(a);			
  //Apartado 17
  			testGetDestinoConMásVuelos(a);
  			testGetFechaConMásDestinosDiferentes(a);
  			testGetPromedioMásCaroYMásBaratoPorDestino(a);
  			testGetCódigosVuelosMasDuraciónPorCompañiaADestinoQueComienzaPor(a);
  			testGetCódigosVuelosMásBaratoYMásCaroPorCompañía(a);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //Maps
	private static void testNúmeroDeVuelosPorCompañía(Aeropuerto a) {
		try {
			System.out.println("\ntestNúmeroDeVuelosPorCompañía");
			for (Entry<String,Integer> par:a.númeroDeVuelosPorCompañia().entrySet()) {
				System.out.println(par);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testCódigosVuelosPorDestino(Aeropuerto a) {
		try {
			System.out.println("\ntestCódigosVuelosPorDestino");
			for (Entry<String,List<String>> par:a.códigosVuelosPorDestino().entrySet()) {
				System.out.println(par.getKey()+" --> "+par.getValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	private static void testPromedioPreciosPorFecha(Aeropuerto a) {
		try {
			System.out.println("\ntestPromedioPreciosPorFecha");
			for (Entry<LocalDate,Double> par:a.promedioPreciosPorFecha().entrySet()) {
				System.out.println(par);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
  //Comparator
  //a)
	private static void testOrdenaVuelosPorOrdenNatural(Aeropuerto a) {
		try {
			System.out.println("\ntestOrdenaVuelosPorOrdenNatural");
			for (Vuelo v: a.ordenaVuelosPorOrdenNatural()) {
				System.out.println(v.getFecha()+" "+v.getDestino()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //b)
	private static void testOrdenaVuelosPorFechaSalida(Aeropuerto a) {
		try {
			System.out.println("\ntestordenaVuelosPorFechaSalida");
			for (Vuelo v: a.ordenaVuelosPorFechaSalida()) {
				System.out.println(v.getFecha()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //c
	private static void testOrdenaVuelosPorDestinoYFechaSalida(Aeropuerto a) {
		try {
			System.out.println("\ntestordenaVuelosPorDestinoYFechaSalida");
			for (Vuelo v: a.ordenaVuelosPorDestinoYFechaSalida()) {
				System.out.println(v.getDestino()+" "+v.getFecha()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //d
	private static void testOrdenaVuelosPorNroPasajerosAlReves(Aeropuerto a) {
		try {
			System.out.println("\ntestordenaVuelosPorNroPasajerosAlReves");
			for (Vuelo v: a.ordenaVuelosPorNroPasajerosAlReves()) {
				System.out.println(v.getNumPasajeros()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //e
	private static void testOrdenaVuelosPorDuraciónYMayorNumeroPasajeros(Aeropuerto a) {
		try {
			System.out.println("\ntestordenaVuelosPorDuraciónYMayorNumeroPasajeros");
			for (Vuelo v: a.ordenaVuelosPorDuracionYMayorNumeroPasajeros()) {
				System.out.println(v.getDuracion()+" "+v.getNumPasajeros()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//Secuenciales fáciles
	private static void testGetNúmeroVuelosADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetNúmeroVuelosADestino a Málaga: "+
					a.getNúmerosVuelosADestino("Málaga"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetNumPasajerosADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetNumPasajerosADestino a Málaga: "+
					a.getNúmPasajerosADestino("Málaga"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetRecaudacionADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetRecaudacionADestino a Málaga: "+
					a.getRecaudacionADestino("Málaga"));
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	private static void testGetPromedioPasajerosDeUnaFecha(Aeropuerto a) {
		try {
			System.out.println("\ngetPromedioPasajerosDeUnaFecha del 2/6/2020: "+
					a.getPromedioPasajerosDeUnaFecha(LocalDate.of(2020,6,2)));
			System.out.println("\ngetPromedioPasajerosDeUnaFecha de hoy: "+
					a.getPromedioPasajerosDeUnaFecha(LocalDate.now()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testGetCodigoPrimerVueloADestinoConPlazasLibres(Aeropuerto a) {
		try {
			System.out.println("\ngetCodigoPrimerVueloADestinoConPlazasLibres a Málaga: "+
					a.getCodigoPrimerVueloADestinoConPlazasLibres("Málaga"));
			System.out.println("\ngetCodigoPrimerVueloADestinoConPlazasLibres a Dos Hermanas: ");
			System.out.println(a.getCodigoPrimerVueloADestinoConPlazasLibres("Dos Hermanas"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//Secuenciales intermedios
	
	/*
	private static void testGetListaTresVuelosMasBaratos(Aeropuerto a) {
		try {
			System.out.println("\ngetListaTresVuelosMasBaratos: ");
			for (Vuelo v: a.ListTresVuelosMasBaratos()) {
				System.out.println(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testGetListaNVuelosMayorDuracion(Aeropuerto a) {
		try {
			System.out.println("\ngetListaNVuelosMayorDuracion (10): ");
			for (Vuelo v: a.getListaNVuelosMayorDuracion(10)) {
				System.out.println(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testGetListaVuelosOrdenadosFechaYNumPasajeros(Aeropuerto a) {
		try {
			System.out.println("\ngetListaVuelosOrdenadosFechaYNumPasajeros: ");
			for (Vuelo v: a.getListaVuelosOrdenadosFechaYNumPasajeros()) {
				System.out.println(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testGetConjuntoOrdenadoDestinos(Aeropuerto a) {
		try {
			System.out.println("\ngetConjuntoOrdenadoDestinos: ");
			for (String d: a.getConjuntoOrdenadoDestinos()) {
				System.out.println(d);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testGetMapListaVuelosPorDestinos(Aeropuerto a) {
		try {
			System.out.println("\ngetMapListaVuelosPorDestinos: ");
			for (Entry<String,List<Vuelo>> par: a.getMapListaVuelosPorDestinos().entrySet()) {
				System.out.println(par);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  	private static void testGetMapSetVuelosPorFecha(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapSetVuelosPorFecha: ");
  			for (Entry<LocalDate,Set<Vuelo>> par: a.getMapSetVuelosPorFecha().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	private static void testGetMapSetOrdenadoVuelosPorFecha(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapSetOrdenadoVuelosPorFecha: ");
  			for (Entry<LocalDate,SortedSet<Vuelo>> par: a.getMapSetOrdenadoVuelosPorFecha().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	private static void testGetMapNumVuelosPorFecha(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapNumVuelosPorFecha: ");
  			for (Entry<LocalDate,Integer> par: a.getMapNumVuelosPorFecha().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	private static void testGetMapPrecioMedioPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapPrecioMedioPorDestino: ");
  			for (Entry<String,Double> par: a.getMapPrecioMedioPorDestino().entrySet()) {
  				System.out.println(
  						String.format("%-15s --> %8.3f",par.getKey(),par.getValue()));
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
	
  	private static void testGetMapVuelosCompletosMásBaratoPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapVuelosCompletosMásBaratoPorDestino: ");
  			for (Entry<String,Vuelo> par: a.getMapVuelosCompletosMásBaratoPorDestino().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	private static void testGetMapCódigoVuelosCompletosMásBaratoPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapCódigoVuelosCompletosMásBaratoPorDestino: ");
  			for (Entry<String,String> par: a.getMapCódigoVuelosCompletosMásBaratoPorDestino().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	private static void testGetMapPorcentajeVuelosPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapPorcentajeVuelosPorDestino: ");
  			for (Entry<String,Double> par:a.getMapPorcentajeVuelosPorDestino().entrySet()) {
  				System.out.println(String.format("%-10s-->%7.3f",par.getKey(),par.getValue()));
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	private static void testGetMapOrdenadoNumPasajerosPorDuraciónDeCompañía(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapOrdenadoNumPasajerosPorDuraciónDeCompañía (IBE): ");
  			for (Entry<Duration,Integer> par:a.getMapOrdenadoNumPasajerosPorDuraciónDeCompañia("IBE").entrySet()) {
  				System.out.println(String.format("%-10s-->%7d",par.getKey(),par.getValue()));
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	*/
  	
  	private static void testGetSegundaCompañiaConMenosVuelos(Aeropuerto a) {
  		try {
  			System.out.println("\ngetSegundaCompañiaConMenosVuelos: ");
  			System.out.println(a.getSegundaCompañíaConMenosVuelos());
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
	
  	private static void testGetDestinoConMásVuelos(Aeropuerto a) {
		try {
			System.out.println("\ngetDestinoConMásVuelos: ");
			System.out.println(a.getDestinoConMásVuelos());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetFechaConMásDestinosDiferentes(Aeropuerto a) {
		try {
			System.out.println("\ngetFechaConMásDestinosDiferentes: ");
			System.out.println(a.getFechaConMásDestinosDiferentes());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetPromedioMásCaroYMásBaratoPorDestino(Aeropuerto a) {
		try {
			System.out.println("\ngetPromedioMásCaroYMásBaratoPorDestino: ");
			for (Entry<String,Double> par:a.getPromedioMásCaroYMásBaratoPorDestino().entrySet()) {
				System.out.println(String.format("%-10s-->%10.2f",par.getKey(),par.getValue()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void testGetCódigosVuelosMasDuraciónPorCompañiaADestinoQueComienzaPor(Aeropuerto a) {
		try {
			System.out.println("\ngetCódigosVuelosMasDuraciónPorCompañiaADestinoQueComienzaPor (M) y n=3: ");
			for (Entry<String,List<String>> par:a.getCódigosVuelosMasDuraciónPorCompañiaADestinoQueComienzaPor("M",3).entrySet()) {
				System.out.println(String.format("%-10s--> ",par.getKey())+par.getValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void testGetCódigosVuelosMásBaratoYMásCaroPorCompañía(Aeropuerto a) {
		try {
			System.out.println("\ngetCódigosVuelosMásBaratoYMásCaroPorCompañía: ");
			for (Entry<String,List<String>> par:a.getCódigosVueloMásBaratoYMásCaroPorCompañía().entrySet()) {
				System.out.println(String.format("%-10s--> ",par.getKey())+par.getValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


