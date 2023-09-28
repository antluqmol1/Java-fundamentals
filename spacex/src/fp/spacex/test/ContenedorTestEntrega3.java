package fp.spacex.test;


import java.util.List;
import java.util.Map.Entry;
import fp.common.TipoCliente;
import fp.spacex.Contenedor;
import fp.spacex.Factoría;
import fp.spacex.SpaceX;

public class ContenedorTestEntrega3 {

	public static void main(String[] args) {
		Contenedor proyectos = Factoría.leerContenedor("data/SpaceXdef.csv");
		
		//BLOQUE I
		testExisteTipodeVehiculoEnPaisCliente(proyectos, "Falcon 9 (v1.0)", "United States");
		testCalcularMediaPesoCargaUtil(proyectos);
		testFiltraProyectosConMisiónCumplida(proyectos);
		testMaximoDeDíasEmpleadosSegunSitioDeLanzamiento(proyectos, "Cape Canaveral AFS LC-40");
		testSeleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora(proyectos, TipoCliente.Government);
		
		//BLOQUE II
		testAgrupaProyectosPorEmpresaCargaUtil(proyectos);
		testAgrupaDiasEmpleadosPorTipoDeVehiculo(proyectos);
		testAgrupaProyectosConMenosPesoPorAño(proyectos);
		testAgrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil(proyectos);
		agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil(proyectos);
		testAgrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(proyectos, 3);
		testObtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto(proyectos);
	}
				
		private static void testExisteTipodeVehiculoEnPaisCliente(Contenedor proyectos, String tipo_del_vehiculo, String pais_cliente) {
			System.out.print("\n~~~~~~~~~~~~~~~~testExisteTipodeVehiculoEnPaisCliente~~~~~~~~~~~~~~~~");
			System.out.print("\n¿Existe el vehículo: " + tipo_del_vehiculo + " en el país: " + pais_cliente +"? ");
			System.out.println(proyectos.existeTipodeVehiculoEnPaisCliente(tipo_del_vehiculo, pais_cliente));
		}
		
		private static void testCalcularMediaPesoCargaUtil(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testCalcularMediaPesoCargaUtil~~~~~~~~~~~~~~~~");
			System.out.println(String.format("\nLa media de del peso de la carga útil (con 3 decimales) de los distintos proyectos es: %.3f", proyectos.calcularMediaPesoCargaUtil()));
			System.out.print("La media de del peso de la carga útil con todos los decimales es: ");
			System.out.println(proyectos.calcularMediaPesoCargaUtil());
		}
		
		private static void testFiltraProyectosConMisiónCumplida(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testFiltraProyectosConMisiónCumplida~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos que han cumplido con éxito la misión son: ");
			for (SpaceX proyecto : proyectos.filtraProyectosConMisiónCumplida()) {
				System.out.println(proyecto);
			}
			System.out.println(String.format("(En total %d proyectos)", proyectos.filtraProyectosConMisiónCumplida().size()));
		}
		
		private static void testMaximoDeDíasEmpleadosSegunSitioDeLanzamiento(Contenedor proyectos, String sitio_de_lanzamiento) {
			System.out.print("\n~~~~~~~~~~~~~~~~testMaximoDeDíasEmpleadosSegunSitioDeLanzamiento~~~~~~~~~~~~~~~~");
			System.out.println("\nEl proyecto con el máximo de días empleados en " + sitio_de_lanzamiento + ", donde se ha lanzado, es: ");
			System.out.println(proyectos.maximoDeDíasEmpleadosSegunSitioDeLanzamiento(sitio_de_lanzamiento ));
		}
		
		private static void testSeleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora(Contenedor proyectos, TipoCliente tipo_de_cliente) {
			System.out.print("\n~~~~~~~~~~~~~~~~testSeleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos filtrados por el tipo de cliente: " + tipo_de_cliente + ", ordenados por fecha y hora son: ");
			int i = 1;
			for (SpaceX proyecto : proyectos.seleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora(tipo_de_cliente)) {
				System.out.print(i + " - > ");
				System.out.println(proyecto);
				i = i+1;
			}
		}
		
		//BLOQUE II
		private static void testAgrupaProyectosPorEmpresaCargaUtil(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testAgrupaProyectosPorEmpresaCargaUtil~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos de cada empresa de carga útil son:");
			for(Entry<String, List<SpaceX>> par : proyectos.agrupaProyectosPorEmpresaCargaUtil().entrySet()) {
				System.out.println(par.getKey() + " -> " + par.getValue());
			}
		}
		
		private static void testAgrupaDiasEmpleadosPorTipoDeVehiculo(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testAgrupaDiasEmpleadosPorTipoDeVehiculo~~~~~~~~~~~~~~~~");
			System.out.println("\nNúmero de días empleados por cada vehiculo: ");
			for(Entry<String,Double> par : proyectos.agrupaDiasEmpleadosPorTipoDeVehiculo().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " días");
			}
		}
		
		private static void testAgrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada año son: ");
			for(Entry<String, SpaceX> par : proyectos.agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " días");
			}
		}
		
		private static void testAgrupaProyectosConMenosPesoPorAño(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaProyectosConMenosPesoPorAño~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada año son: ");
			for(Entry<Integer, SpaceX> par : proyectos.agrupaProyectosConMenosPesoPorAño().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " días");
			}
		}
		
		private static void agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada año son: ");
			for(Entry<String, SpaceX> par : proyectos.agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " días");
			}
		}
		
		private static void testAgrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(Contenedor proyectos, int n) {
			try {
				System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil~~~~~~~~~~~~~~~~");
				//System.out.println("\ngetCódigosVuelosMasDuraciónPorCompañiaADestinoQueComienzaPor (M) y n=3: ");
				for (Entry<String,List<String>> par:proyectos.agrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(3).entrySet()) {
					System.out.println(String.format("%-10s--> ",par.getKey())+par.getValue());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void testObtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto(Contenedor proyectos) {
			//System.out.println(proyectos.obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto());
			try {
				System.out.println("\n~~~~~~~~~~~~~~~~testObtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto~~~~~~~~~~~~~~~~");
				System.out.println("El mayor (par clave, valor) con la clave: número del vuelo del vehiculo y el valor: media de días empleados en el proyecto según el valor es: ");
				System.out.print(proyectos.obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto().getKey());
				System.out.print(" ---> ");
				System.out.println(proyectos.obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto().getValue());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}