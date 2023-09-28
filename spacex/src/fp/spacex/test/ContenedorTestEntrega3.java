package fp.spacex.test;


import java.util.List;
import java.util.Map.Entry;
import fp.common.TipoCliente;
import fp.spacex.Contenedor;
import fp.spacex.Factor�a;
import fp.spacex.SpaceX;

public class ContenedorTestEntrega3 {

	public static void main(String[] args) {
		Contenedor proyectos = Factor�a.leerContenedor("data/SpaceXdef.csv");
		
		//BLOQUE I
		testExisteTipodeVehiculoEnPaisCliente(proyectos, "Falcon 9 (v1.0)", "United States");
		testCalcularMediaPesoCargaUtil(proyectos);
		testFiltraProyectosConMisi�nCumplida(proyectos);
		testMaximoDeD�asEmpleadosSegunSitioDeLanzamiento(proyectos, "Cape Canaveral AFS LC-40");
		testSeleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora(proyectos, TipoCliente.Government);
		
		//BLOQUE II
		testAgrupaProyectosPorEmpresaCargaUtil(proyectos);
		testAgrupaDiasEmpleadosPorTipoDeVehiculo(proyectos);
		testAgrupaProyectosConMenosPesoPorA�o(proyectos);
		testAgrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til(proyectos);
		agrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til(proyectos);
		testAgrupaNEmpresasDeCarga�tilConM�sDiasEmpleadosPorTipoCarga�til(proyectos, 3);
		testObtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto(proyectos);
	}
				
		private static void testExisteTipodeVehiculoEnPaisCliente(Contenedor proyectos, String tipo_del_vehiculo, String pais_cliente) {
			System.out.print("\n~~~~~~~~~~~~~~~~testExisteTipodeVehiculoEnPaisCliente~~~~~~~~~~~~~~~~");
			System.out.print("\n�Existe el veh�culo: " + tipo_del_vehiculo + " en el pa�s: " + pais_cliente +"? ");
			System.out.println(proyectos.existeTipodeVehiculoEnPaisCliente(tipo_del_vehiculo, pais_cliente));
		}
		
		private static void testCalcularMediaPesoCargaUtil(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testCalcularMediaPesoCargaUtil~~~~~~~~~~~~~~~~");
			System.out.println(String.format("\nLa media de del peso de la carga �til (con 3 decimales) de los distintos proyectos es: %.3f", proyectos.calcularMediaPesoCargaUtil()));
			System.out.print("La media de del peso de la carga �til con todos los decimales es: ");
			System.out.println(proyectos.calcularMediaPesoCargaUtil());
		}
		
		private static void testFiltraProyectosConMisi�nCumplida(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testFiltraProyectosConMisi�nCumplida~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos que han cumplido con �xito la misi�n son: ");
			for (SpaceX proyecto : proyectos.filtraProyectosConMisi�nCumplida()) {
				System.out.println(proyecto);
			}
			System.out.println(String.format("(En total %d proyectos)", proyectos.filtraProyectosConMisi�nCumplida().size()));
		}
		
		private static void testMaximoDeD�asEmpleadosSegunSitioDeLanzamiento(Contenedor proyectos, String sitio_de_lanzamiento) {
			System.out.print("\n~~~~~~~~~~~~~~~~testMaximoDeD�asEmpleadosSegunSitioDeLanzamiento~~~~~~~~~~~~~~~~");
			System.out.println("\nEl proyecto con el m�ximo de d�as empleados en " + sitio_de_lanzamiento + ", donde se ha lanzado, es: ");
			System.out.println(proyectos.maximoDeD�asEmpleadosSegunSitioDeLanzamiento(sitio_de_lanzamiento ));
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
			System.out.println("\nLos proyectos de cada empresa de carga �til son:");
			for(Entry<String, List<SpaceX>> par : proyectos.agrupaProyectosPorEmpresaCargaUtil().entrySet()) {
				System.out.println(par.getKey() + " -> " + par.getValue());
			}
		}
		
		private static void testAgrupaDiasEmpleadosPorTipoDeVehiculo(Contenedor proyectos) {
			System.out.print("\n~~~~~~~~~~~~~~~~testAgrupaDiasEmpleadosPorTipoDeVehiculo~~~~~~~~~~~~~~~~");
			System.out.println("\nN�mero de d�as empleados por cada vehiculo: ");
			for(Entry<String,Double> par : proyectos.agrupaDiasEmpleadosPorTipoDeVehiculo().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " d�as");
			}
		}
		
		private static void testAgrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada a�o son: ");
			for(Entry<String, SpaceX> par : proyectos.agrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " d�as");
			}
		}
		
		private static void testAgrupaProyectosConMenosPesoPorA�o(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaProyectosConMenosPesoPorA�o~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada a�o son: ");
			for(Entry<Integer, SpaceX> par : proyectos.agrupaProyectosConMenosPesoPorA�o().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " d�as");
			}
		}
		
		private static void agrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til(Contenedor proyectos) {
			System.out.println("\n~~~~~~~~~~~~~~~~agrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til~~~~~~~~~~~~~~~~");
			System.out.println("\nLos proyectos con menos peso por cada a�o son: ");
			for(Entry<String, SpaceX> par : proyectos.agrupaProyectosConMasDiasEmpleadosPor�rbitaCarga�til().entrySet()) {
				System.out.println(par.getKey() + " = " + par.getValue() + " d�as");
			}
		}
		
		private static void testAgrupaNEmpresasDeCarga�tilConM�sDiasEmpleadosPorTipoCarga�til(Contenedor proyectos, int n) {
			try {
				System.out.println("\n~~~~~~~~~~~~~~~~testAgrupaNEmpresasDeCarga�tilConM�sDiasEmpleadosPorTipoCarga�til~~~~~~~~~~~~~~~~");
				//System.out.println("\ngetC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor (M) y n=3: ");
				for (Entry<String,List<String>> par:proyectos.agrupaNEmpresasDeCarga�tilConM�sDiasEmpleadosPorTipoCarga�til(3).entrySet()) {
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
				System.out.println("El mayor (par clave, valor) con la clave: n�mero del vuelo del vehiculo y el valor: media de d�as empleados en el proyecto seg�n el valor es: ");
				System.out.print(proyectos.obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto().getKey());
				System.out.print(" ---> ");
				System.out.println(proyectos.obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto().getValue());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}