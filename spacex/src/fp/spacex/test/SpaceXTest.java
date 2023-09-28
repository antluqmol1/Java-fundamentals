package fp.spacex.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import fp.common.TipoCliente;
import fp.spacex.SpaceX;



public class SpaceXTest {
	
	public static void main(String[] args) {
		
		
		System.out.println("--------------------SpaceXTest--------------------");
		System.out.println("\n~~~~~~~~~~~~~~~~~Test registros y excepciones~~~~~~~~~~~~~~~~~");
		
		List<String> ls = new ArrayList<String>();
		ls.add("Bo Rayhill");
		ls.add("Kenn Brideau");
		ls.add("Frederica Louisot");
		ls.add("Charyl Woolfitt");
				
		SpaceX reg = new SpaceX("F9-4", LocalDate.of(2012, Month.OCTOBER, 8), LocalTime.of(00, 35), LocalDateTime.of(2012, 10, 8, 00, 35), "Falcon 9 (v1.0)", "Orbcomm-OG2", "Communication Satellite",
				150d, "Low Earth Orbit", "Orbcomm", TipoCliente.Business, "United States", false, "Engine Failure During Flight", 
				"Cape Canaveral AFS LC-40", 174, ls);
		
		SpaceX reg2 = new SpaceX("F9-4", LocalDateTime.of(2012, 10, 8, 00, 35), LocalTime.of(00, 35), "Orbcomm-OG2", "Communication Satellite",
				150d, "Low Earth Orbit", "United States", "Orbcom", "Cape Canaveral AFS LC-40", "Falcon 9 (v1.0)", 174, ls);
		System.out.println(reg2);
		
		
		
		//RESTRICCIONES DE NULL
		try {
		SpaceX reg3 = new SpaceX("F9-4", LocalDateTime.of(2012, 10, 8, 00, 35), LocalTime.of(00, 35), "Orbcomm-OG2", null,
				150d, "Low Earth Orbit", "United States", "Orbcom", "Cape Canaveral AFS LC-40", "Falcon 9 (v1.0)", 174, ls);
		System.out.println(reg3);
		}catch (Exception e) {
			System.out.println("Se ha producido una excepci�n: " + e.getMessage());
		}
		
		
		//RESTRICCI�N DE LA FECHA
		
		try {
			SpaceX reg4 = new SpaceX("F9-4", LocalDate.of(2005, 10, 8), LocalTime.of(00, 35), LocalDateTime.of(2012, 10, 8, 00, 35), "Falcon 9 (v1.0)", "Orbcomm-OG2", "Communication Satellite",
					150d, "Low Earth Orbit", "Orbcomm", TipoCliente.Business, "United States", false, "Engine Failure During Flight", 
					"Cape Canaveral AFS LC-40", 174, ls);
			System.out.println(reg4);
		}catch (Exception e) {
			System.out.println("Se ha producido una excepci�n: " + e.getMessage());
		}
		
		
		//RESTRICCI�N DE EL TIPO DE CLIENTE
		try {
			SpaceX reg5 = new SpaceX("F9-4", LocalDate.of(2012, 10, 8), LocalTime.of(00, 35), LocalDateTime.of(2012, 10, 8, 00, 35), "Falcon 9 (v1.0)", "Orbcomm-OG2", "Communication Satellite",
					150d, "Low Earth Orbit", "Orbcomm", null, "United States", false, "Engine Failure During Flight", 
					"Cape Canaveral AFS LC-40", 174, ls);
			System.out.println(reg5);
		}catch (Exception e) {
			System.out.println("Se ha producido una excepci�n: " + e.getMessage());
		}
		
		//RESTRICCI�N EN LOS SETTERS IMPLICADOS
		try {
			reg.set�rbita_carga_util(null);
			System.out.println(reg.get�rbita_carga_util());
		}catch (Exception e) {
			System.out.println("Se ha producido una excepci�n: " + e.getMessage());
		}
			
			
		System.out.println("\n~~~~~~~~~~~~~~~~~Test m�todos y propiedades derivadas~~~~~~~~~~~~~~~~~");
		
		System.out.println("Numero del Vuelo (Tipo del veh�culo - N� vuelo): " + reg.getNumero_vuelo_del_vehiculo());
		System.out.println("Fecha del lanzamiento: " + reg.getFecha_de_lanzamiento());
		System.out.println("Hora del lanzamiento: " + reg.getHora_de_lanzamiento());
		System.out.println("Fecha y hora del lanzamiento: " + reg.getFecha_y_hora_de_lanzamiento());
		System.out.println("Tipo del veh�culo: " + reg.getTipo_del_vehiculo());
		System.out.println("Empresa que gestiona la carga �til: " + reg.getEmpresa_carga_util());
		System.out.println("Tipo de la carga �til: " + reg.getTipo_carga_util());
		System.out.println("Peso de la carga �til (en kg): " + reg.getPeso_carga_util());
		System.out.println("�rbita a la que ha sido lanzada: " + reg.get�rbita_carga_util());
		System.out.println("Cliente: " + reg.getCliente());
		System.out.println("Tipo de cliente: " + reg.getTipo_de_cliente());
		System.out.println("Pa�s del cliente: " + reg.getPais_cliente());
		System.out.println("�Se cumpli� la misi�n?: " + reg.isMision_cumplida());
		System.out.println("Raz�n del fallo (si no se cumpli� la misi�n): " + reg.getRaz�n_del_fallo());
		System.out.println("Sitio del lanzamiento: " + reg.getSitio_de_lanzamiento());
		System.out.println("N�mero de d�as totales empleados en el proyecto: " + reg.getDias_empleados_en_el_proyecto());
		
		//OTRAS OPERACIONES
		System.out.println("A�o de la fecha: " + reg.getA�o_de_fecha());
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test propiedades tipo lista y conjuntos~~~~~~~~~~~~~~~~~");
		List<String> lista10PrimerosClientes = new ArrayList<String>();
		lista10PrimerosClientes.add("DARPA");
		lista10PrimerosClientes.add("DARPA");	
		lista10PrimerosClientes.add("ORS");
		lista10PrimerosClientes.add("NASA");	
		lista10PrimerosClientes.add("Celestis");
		lista10PrimerosClientes.add("");	
		lista10PrimerosClientes.add("ATSB");
		lista10PrimerosClientes.add("");	
		lista10PrimerosClientes.add("NASA");
		lista10PrimerosClientes.add("NASA");	
		
		reg.setClientes(lista10PrimerosClientes); //Modificamos la lista de clientes, inicialmente vac�a, a�adiendole los 10 primeros clientes
		System.out.println("Una lista con los primeros 10 clientes ser�a: " + reg.getClientes());
		
		System.out.println("La lista ordenada y quitando los elementos repetidos ser�a: " + reg.getClientesOrdenadosYSinRepetir() + ". ");
		System.out.println("La lista quitando los elementos repetidos y nulos ser�a: " + reg.getClientesSinRepeticionNiNulos() + ". ");
		System.out.println("El n�mero total de clientes ser�a: " + reg.getNumeroDeClientes() + ". ");
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test hashcode~~~~~~~~~~~~~~~~~");
		System.out.println("�Son id�nticos... ");
		System.out.print("reg y reg? "); System.out.println(reg == reg);
		System.out.print("reg y reg2? "); System.out.println(reg == reg2);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test equals~~~~~~~~~~~~~~~~~");
		System.out.println("�Son iguales... ");
		System.out.print("reg y reg? "); System.out.println(reg.equals(reg) && reg.equals(reg));
		System.out.print("reg y reg2? "); System.out.println(reg.equals(reg) && reg.equals(reg2));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test Orden Natural~~~~~~~~~~~~~~~~~");
		System.out.print("reg y reg: "); System.out.println(reg.compareTo(reg));
		System.out.print("reg y reg2: "); System.out.println(reg.compareTo(reg2));
		if (reg.compareTo(reg2) > 0) {
			System.out.println("reg" + " va despu�s de " + "reg2");
			System.out.println(reg + " va despu�s de " + reg2);
		}
		else if (reg.compareTo(reg2) == 0) {
			System.out.println("reg" + " es igual a " + "reg2");
			System.out.println(reg + " es igual a " + reg2);
		}
		else {
			System.out.println("reg" + "va antes de" + "reg2");
			System.out.println(reg + "va antes de" + reg2);
		}
	}


}
