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
  //Se a�aden a "a" los vuelos del dataset
			a.a�adeVuelos(Factor�aVuelos1.leerVuelos("data/vuelos.csv"));
  			System.out.println("***Vuelos del Aeropuerto "+a.getNombre());
  			testN�meroDeVuelosPorCompa��a(a);
  			testC�digosVuelosPorDestino(a);
  			//testPromedioPreciosPorFecha(a);
  //Apartado 12
  			testOrdenaVuelosPorOrdenNatural(a);
  			testOrdenaVuelosPorFechaSalida(a);
  			testOrdenaVuelosPorDestinoYFechaSalida(a);
  			testOrdenaVuelosPorNroPasajerosAlReves(a);
  			testOrdenaVuelosPorDuraci�nYMayorNumeroPasajeros(a);
  //Apartado 13
  			testGetN�meroVuelosADestino(a);
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
  			testGetMapVuelosCompletosM�sBaratoPorDestino(a);
  			testGetMapC�digoVuelosCompletosM�sBaratoPorDestino(a);
  			testGetMapOrdenadoNumPasajerosPorDuraci�nDeCompa��a(a);
  			testGetMapPorcentajeVuelosPorDestino(a);			
  			*/
  			//testGetSegundaCompa�iaConMenosVuelos(a);			
  //Apartado 17
  			testGetDestinoConM�sVuelos(a);
  			testGetFechaConM�sDestinosDiferentes(a);
  			testGetPromedioM�sCaroYM�sBaratoPorDestino(a);
  			testGetC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor(a);
  			testGetC�digosVuelosM�sBaratoYM�sCaroPorCompa��a(a);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  //Maps
	private static void testN�meroDeVuelosPorCompa��a(Aeropuerto a) {
		try {
			System.out.println("\ntestN�meroDeVuelosPorCompa��a");
			for (Entry<String,Integer> par:a.n�meroDeVuelosPorCompa�ia().entrySet()) {
				System.out.println(par);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void testC�digosVuelosPorDestino(Aeropuerto a) {
		try {
			System.out.println("\ntestC�digosVuelosPorDestino");
			for (Entry<String,List<String>> par:a.c�digosVuelosPorDestino().entrySet()) {
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
	private static void testOrdenaVuelosPorDuraci�nYMayorNumeroPasajeros(Aeropuerto a) {
		try {
			System.out.println("\ntestordenaVuelosPorDuraci�nYMayorNumeroPasajeros");
			for (Vuelo v: a.ordenaVuelosPorDuracionYMayorNumeroPasajeros()) {
				System.out.println(v.getDuracion()+" "+v.getNumPasajeros()+" "+v.getCodigo());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//Secuenciales f�ciles
	private static void testGetN�meroVuelosADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetN�meroVuelosADestino a M�laga: "+
					a.getN�merosVuelosADestino("M�laga"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetNumPasajerosADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetNumPasajerosADestino a M�laga: "+
					a.getN�mPasajerosADestino("M�laga"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetRecaudacionADestino(Aeropuerto a) {
		try {
			System.out.println("\ngetRecaudacionADestino a M�laga: "+
					a.getRecaudacionADestino("M�laga"));
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
			System.out.println("\ngetCodigoPrimerVueloADestinoConPlazasLibres a M�laga: "+
					a.getCodigoPrimerVueloADestinoConPlazasLibres("M�laga"));
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
	
  	private static void testGetMapVuelosCompletosM�sBaratoPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapVuelosCompletosM�sBaratoPorDestino: ");
  			for (Entry<String,Vuelo> par: a.getMapVuelosCompletosM�sBaratoPorDestino().entrySet()) {
  				System.out.println(par);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	private static void testGetMapC�digoVuelosCompletosM�sBaratoPorDestino(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapC�digoVuelosCompletosM�sBaratoPorDestino: ");
  			for (Entry<String,String> par: a.getMapC�digoVuelosCompletosM�sBaratoPorDestino().entrySet()) {
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
  	private static void testGetMapOrdenadoNumPasajerosPorDuraci�nDeCompa��a(Aeropuerto a) {
  		try {
  			System.out.println("\ngetMapOrdenadoNumPasajerosPorDuraci�nDeCompa��a (IBE): ");
  			for (Entry<Duration,Integer> par:a.getMapOrdenadoNumPasajerosPorDuraci�nDeCompa�ia("IBE").entrySet()) {
  				System.out.println(String.format("%-10s-->%7d",par.getKey(),par.getValue()));
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	*/
  	
  	private static void testGetSegundaCompa�iaConMenosVuelos(Aeropuerto a) {
  		try {
  			System.out.println("\ngetSegundaCompa�iaConMenosVuelos: ");
  			System.out.println(a.getSegundaCompa��aConMenosVuelos());
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
	
  	private static void testGetDestinoConM�sVuelos(Aeropuerto a) {
		try {
			System.out.println("\ngetDestinoConM�sVuelos: ");
			System.out.println(a.getDestinoConM�sVuelos());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetFechaConM�sDestinosDiferentes(Aeropuerto a) {
		try {
			System.out.println("\ngetFechaConM�sDestinosDiferentes: ");
			System.out.println(a.getFechaConM�sDestinosDiferentes());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testGetPromedioM�sCaroYM�sBaratoPorDestino(Aeropuerto a) {
		try {
			System.out.println("\ngetPromedioM�sCaroYM�sBaratoPorDestino: ");
			for (Entry<String,Double> par:a.getPromedioM�sCaroYM�sBaratoPorDestino().entrySet()) {
				System.out.println(String.format("%-10s-->%10.2f",par.getKey(),par.getValue()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void testGetC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor(Aeropuerto a) {
		try {
			System.out.println("\ngetC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor (M) y n=3: ");
			for (Entry<String,List<String>> par:a.getC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor("M",3).entrySet()) {
				System.out.println(String.format("%-10s--> ",par.getKey())+par.getValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void testGetC�digosVuelosM�sBaratoYM�sCaroPorCompa��a(Aeropuerto a) {
		try {
			System.out.println("\ngetC�digosVuelosM�sBaratoYM�sCaroPorCompa��a: ");
			for (Entry<String,List<String>> par:a.getC�digosVueloM�sBaratoYM�sCaroPorCompa��a().entrySet()) {
				System.out.println(String.format("%-10s--> ",par.getKey())+par.getValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


