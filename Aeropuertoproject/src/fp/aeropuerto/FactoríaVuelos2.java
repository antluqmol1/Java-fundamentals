package fp.aeropuerto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class Factor�aVuelos2 {
	
	//a) El m�todo leerVuelos debe devolver una lista de vuelos a partir del nombre de un archivo
		//con vuelos. Este m�todo se apoya en el m�todo del siguiente apartado.
	
	public static List<Vuelo> leerVuelos(String nombreFichero){
		List<Vuelo> res = new ArrayList<Vuelo>();
		try {
			List<String> l�neas = Files.readAllLines(Paths.get(nombreFichero));
			for (String l�nea:l�neas.subList(1, l�neas.size())) {
				res.add(stringAVuelo(l�nea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
//	Madrid;107;150;150;RYR-80;01/06/2020-15:28;78;15;21.4
	private static Vuelo stringAVuelo(String s) {
		Checkers.checkNoNull(s);
		String[] trozos = s.split(";");
		Checkers.check("La cadena est� mal formada", trozos.length == 9);
		String destino = trozos[0].trim();
		Double precio = Double.valueOf(trozos[1].trim());
		Integer numPlazas = Integer.valueOf(trozos[2].trim());
		Integer numPasajeros = Integer.valueOf(trozos[3].trim());
		String codigo = trozos[4].trim();
		LocalDateTime fechaHora = LocalDateTime.parse(trozos[5].trim(), DateTimeFormatter.ofPattern("dd/MM/yyy-HH:mm"));
		Duration duraci�n = Duration.ofMinutes(Integer.valueOf(trozos[6].trim()));
		Integer numPlazasPrimera = Integer.valueOf(trozos[7].trim());
		Double recargoPrecioPrimera = Double.valueOf(trozos[8].trim());
		
		return new Vuelo(destino, precio, numPlazas, numPasajeros, codigo, fechaHora,
				duraci�n, numPlazasPrimera, recargoPrecioPrimera);
	}
	
	
	
	
	
}
