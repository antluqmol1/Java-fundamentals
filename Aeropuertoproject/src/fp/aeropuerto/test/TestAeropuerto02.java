package fp.aeropuerto.test;


import java.util.List;
import java.util.Map.Entry;

import fp.aeropuerto.Factor�aVuelos1;
import fp.aeropuerto.Vuelo;
import fp.aeropuerto.Aeropuerto;

public class TestAeropuerto02 {

	public static void main(String[] args) {
		try {
			Aeropuerto a=new Aeropuerto("Reina Mercedes");
			List<Vuelo>lv=Factor�aVuelos1.leerVuelos("data/Vuelos(5).csv");
			a.a�adeVuelos(lv);
			testN�meroDeVuelosPorCompa�ia(a);
			testC�digosVuelosPorDestino(a);
			testOrdenaVuelosPorOrdenNatural(a);
			testOrdenaVuelosPorDestinoYFechaSalida(a);
			testOrdenaVuelosPorNroPasajerosAlReves(a);
			testOrdenaVuelosPorDuracionYMayorNumeroPasajeros(a);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	private static void testN�meroDeVuelosPorCompa�ia(Aeropuerto a) {
		System.out.println("ntestNu�meroDeVuelosPorCompa�ia");
		for (Entry <String,Integer>par:a.n�meroDeVuelosPorCompa�ia().entrySet())
			System.out.println(par);
	}
	private static void testC�digosVuelosPorDestino(Aeropuerto a) {
		System.out.println("ntestc�digosVuelosPorDestino");
		for (Entry <String,List<String>>par:a.c�digosVuelosPorDestino().entrySet())
			System.out.println(par.getKey()+"-->"+par.getValue());
	}
	
	private static void testOrdenaVuelosPorOrdenNatural(Aeropuerto a) {
		System.out.println("\ntestOrdenaVuelosPorOrdenNatural");
		for(Vuelo v: a.ordenaVuelosPorOrdenNatural()) {
			System.out.println(v.getFecha() + " " + v.getDestino() + " " + v.getCodigo());
		}
	}
	private static void testOrdenaVuelosPorDestinoYFechaSalida(Aeropuerto a) {
		System.out.println("\ntestOrdenaVuelosPorDestinoYFechaSalida");
		for(Vuelo v: a.ordenaVuelosPorDestinoYFechaSalida()) {
			System.out.println(v.getFecha() + " " + v.getDestino() + " " + v.getCodigo());
		}
	}
	private static void testOrdenaVuelosPorNroPasajerosAlReves(Aeropuerto a) {
		System.out.println("\ntestOrdenaVuelosPorNroPasajerosAlReves");
		for(Vuelo v: a.ordenaVuelosPorNroPasajerosAlReves()) {
			System.out.println(v.getDestino() + " " + v.getNumPasajeros());
		}
	}
	private static void testOrdenaVuelosPorDuracionYMayorNumeroPasajeros(Aeropuerto a) {
		System.out.println("\ntestOrdenaVuelosPorDuracionYMayorNumeroPasajeros");
		for(Vuelo v: a.ordenaVuelosPorDuracionYMayorNumeroPasajeros()) {
			System.out.println(v.getDestino() + " " + v.getDuracion() + " " + v.getNumPasajeros());
		}
	}
	
}
