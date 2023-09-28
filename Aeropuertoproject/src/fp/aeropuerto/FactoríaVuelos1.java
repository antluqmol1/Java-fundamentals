package fp.aeropuerto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Factor�aVuelos1 {
	
	public static List<Vuelo> leerVuelos(String nombreFichero){
		List<Vuelo> res = new ArrayList<Vuelo>();
		try {
			List<String> l�neas = Files.readAllLines(Paths.get(nombreFichero));
			for (String l�nea:l�neas.subList(1, l�neas.size())) {
				res.add(new Vuelo(l�nea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	

}
