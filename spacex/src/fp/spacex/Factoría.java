package fp.spacex;

import java.io.IOException;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import fp.common.TipoCliente;
import fp.utiles.Checkers;

public class Factoría {	
	
	//Método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y devuelve una lista de objetos del tipo.
	public static List<SpaceX> leerSpaceX(String nombreFichero){
		Checkers.checkNoNull(nombreFichero);
		List<SpaceX> res=new ArrayList<SpaceX>();
		try {
			List<String>lineas=Files.readAllLines(Paths.get("data/SpaceXdef.csv"));
			for (String linea:lineas.subList(1, lineas.size())) {
				res.add(stringASpaceX(linea));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static List<String> getLista_4_mejores_inversores(String cadena){
		List<String> res = new ArrayList<String>();
		String[] trozos = cadena.split(";");
		List<String> listatrozos = Arrays.asList(trozos);
		for(String trozo: listatrozos) {
			res.add(trozo);
		}
		return res;
		
		/*
			String n1 = trozos[0].trim();
			String n2 = trozos[1].trim();
			String n3 = trozos[2].trim();
			String n4 = trozos[3].trim();
			res.add(n1);
			res.add(n2);
			res.add(n3);
			res.add(n4);
		return res;
		*/
	}
	
	
	//Método que recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y devuelve un objeto del tipo a partir de esa cadena.
	public static SpaceX stringASpaceX(String s) {
		
		//Trocear la cadena y checkiar el número de trozos
		String[] trozos = s.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length == 17);
		
		//Convertir trozos al tipo correspondiente
		String numero_vuelo_del_vehiculo = trozos[0].trim();
		LocalDate fecha_de_lanzamiento = LocalDate.parse(trozos[1].trim(),DateTimeFormatter.ofPattern("d MMMM yyyy").withLocale( Locale.US ));
		LocalTime hora_de_lanzamiento = LocalTime.parse(trozos[2].trim(),DateTimeFormatter.ofPattern("H:mm"));
		LocalDateTime fecha_y_hora_de_lanzamiento = LocalDateTime.parse(trozos[3].trim(),DateTimeFormatter.ofPattern("d MMMM yyyy - H:mm").withLocale( Locale.US ));
		String tipo_del_vehiculo = trozos[4].trim();
		String empresa_carga_util = trozos[5].trim();
		String tipo_carga_util = trozos[6].trim();
		Double peso_carga_util = Double.valueOf(trozos[7].trim().isEmpty() ? "0" : trozos[7].trim()); //Operador ? :, que hace de condicional
		String órbita_carga_util = trozos[8].trim();
		String cliente = trozos[9].trim();
		TipoCliente tipo_de_cliente = TipoCliente.valueOf(trozos[10].trim().isEmpty() ? "Unknown" : trozos[10].trim());
		String pais_cliente = trozos[11].trim();
		Boolean mision_cumplida = Boolean.valueOf(trozos[12].trim());
		String razón_del_fallo = trozos[13].trim();
		String sitio_de_lanzamiento = trozos[14].trim();
		Integer dias_empleados_en_el_proyecto = Integer.valueOf(trozos[15].trim().isEmpty() ? "0" : trozos[15].trim());
		List<String> lista_4_mejores_inversores = getLista_4_mejores_inversores(trozos[16].trim());
		
		//Construcción del objeto
		return new SpaceX(numero_vuelo_del_vehiculo, fecha_de_lanzamiento, hora_de_lanzamiento, fecha_y_hora_de_lanzamiento, tipo_del_vehiculo,
				empresa_carga_util, tipo_carga_util, peso_carga_util, órbita_carga_util, cliente, tipo_de_cliente, pais_cliente, mision_cumplida,
				razón_del_fallo, sitio_de_lanzamiento, dias_empleados_en_el_proyecto, lista_4_mejores_inversores);
		
		
	}public static Contenedor leerContenedor(String nombreFichero) {
		Contenedor res=null;
		try {
			Stream<SpaceX> proyectos = Files.lines(Paths.get(nombreFichero))
					.skip(1)
					.map(Factoría::stringASpaceX);
			res=new Contenedor(proyectos);
			
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: "+ nombreFichero);
			e.printStackTrace();
		}
	return res;
	}
	
	
}
