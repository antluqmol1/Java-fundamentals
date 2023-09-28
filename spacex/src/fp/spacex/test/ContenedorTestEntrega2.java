package fp.spacex.test;

import java.util.Map.Entry;
import java.util.List;

import fp.spacex.SpaceX;
import fp.spacex.Contenedor;
import fp.spacex.Factor�a;

public class ContenedorTestEntrega2 {
	public static void main(String[] args) {
		
		try {
			List<SpaceX> ls = Factor�a.leerSpaceX("data/SpaceXdef.csv");
			
			Contenedor c = new Contenedor("ProjecX", ls);
			//System.out.println(ls);
			c.incorporaProyectos(ls);
			System.out.println("N�mero total de proyectos realizados: " + c.getProyectos().size());
			
			testParaTodaMisi�nCumplida(c);
			testGetMediaPesoCargaUtil(c);
			testNumeroDelVueloConMisi�nCumplida(c);
			testGetClientesPorVehiculo(c);
			testGetProyectosPorEmpresaCargaUtil(c);
			testgetDiasEmpleadosPorTipoDeVehiculo(c);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	private static void testParaTodaMisi�nCumplida(Contenedor c) {
		System.out.print("\n�Han cumplido todos los proyectos su misi�n? ");
		System.out.println(c.paraTodaMisi�nCumplida());
	}
	
	private static void testGetMediaPesoCargaUtil(Contenedor c) {
		System.out.print("\nMedia del peso de la carga �til: ");
		System.out.println(c.getMediaPesoCargaUtil());
	}
	
	private static void testNumeroDelVueloConMisi�nCumplida(Contenedor c) {
		System.out.println("\nLos vuelos que han cumplido la misi�n son:");
		List<SpaceX> res = c.getNumeroDelVueloConMisi�nCumplida();
		for(SpaceX proyecto: res) {
			System.out.println(proyecto);
		}
	}
	
	private static void testGetClientesPorVehiculo(Contenedor c) {
		System.out.println("\nLos clientes de cada vehiculo son:");
		for(Entry<String,List<String>> par : c.getClientesPorVehiculo().entrySet()) {
			System.out.println(par);
		}
	}
	
	private static void testGetProyectosPorEmpresaCargaUtil(Contenedor c) {
		System.out.println("\nLos proyectos de cada empresa de carga �til son:");
		for(Entry<String, List<SpaceX>> par : c.getProyectosPorEmpresaCargaUtil().entrySet()) {
			System.out.println(par.getKey() + " -> " + par.getValue());
		}
	}
	
	private static void testgetDiasEmpleadosPorTipoDeVehiculo(Contenedor c) {
		System.out.println("\nN�mero de d�as empleados por cada vehiculo: ");
		for(Entry<String,Integer> par : c.getDiasEmpleadosPorTipoDeVehiculo().entrySet()) {
			System.out.println(par.getKey() + " = " + par.getValue() + " d�as");
		}
	}

}
