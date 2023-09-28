package fp.spacex.test;

import java.util.Map.Entry;
import java.util.List;

import fp.spacex.SpaceX;
import fp.spacex.Contenedor;
import fp.spacex.Factoría;

public class ContenedorTestEntrega2 {
	public static void main(String[] args) {
		
		try {
			List<SpaceX> ls = Factoría.leerSpaceX("data/SpaceXdef.csv");
			
			Contenedor c = new Contenedor("ProjecX", ls);
			//System.out.println(ls);
			c.incorporaProyectos(ls);
			System.out.println("Número total de proyectos realizados: " + c.getProyectos().size());
			
			testParaTodaMisiónCumplida(c);
			testGetMediaPesoCargaUtil(c);
			testNumeroDelVueloConMisiónCumplida(c);
			testGetClientesPorVehiculo(c);
			testGetProyectosPorEmpresaCargaUtil(c);
			testgetDiasEmpleadosPorTipoDeVehiculo(c);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	private static void testParaTodaMisiónCumplida(Contenedor c) {
		System.out.print("\n¿Han cumplido todos los proyectos su misión? ");
		System.out.println(c.paraTodaMisiónCumplida());
	}
	
	private static void testGetMediaPesoCargaUtil(Contenedor c) {
		System.out.print("\nMedia del peso de la carga útil: ");
		System.out.println(c.getMediaPesoCargaUtil());
	}
	
	private static void testNumeroDelVueloConMisiónCumplida(Contenedor c) {
		System.out.println("\nLos vuelos que han cumplido la misión son:");
		List<SpaceX> res = c.getNumeroDelVueloConMisiónCumplida();
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
		System.out.println("\nLos proyectos de cada empresa de carga útil son:");
		for(Entry<String, List<SpaceX>> par : c.getProyectosPorEmpresaCargaUtil().entrySet()) {
			System.out.println(par.getKey() + " -> " + par.getValue());
		}
	}
	
	private static void testgetDiasEmpleadosPorTipoDeVehiculo(Contenedor c) {
		System.out.println("\nNúmero de días empleados por cada vehiculo: ");
		for(Entry<String,Integer> par : c.getDiasEmpleadosPorTipoDeVehiculo().entrySet()) {
			System.out.println(par.getKey() + " = " + par.getValue() + " días");
		}
	}

}
