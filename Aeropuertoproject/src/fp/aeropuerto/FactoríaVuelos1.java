package fp.aeropuerto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoríaVuelos1 {
	
	public static List<Vuelo> leerVuelos(String nombreFichero){
		List<Vuelo> res = new ArrayList<Vuelo>();
		try {
			List<String> líneas = Files.readAllLines(Paths.get(nombreFichero));
			for (String línea:líneas.subList(1, líneas.size())) {
				res.add(new Vuelo(línea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	

}
