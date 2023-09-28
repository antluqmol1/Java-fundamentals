package examen3convdiciembre2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaCatalogo {
	
	public static Vivienda parseaAVivienda(String nomFichero) {
		//Trocear cadena y checkear nº trozos
		Checkers.checkNoNull(nomFichero);
		String trozos[] = nomFichero.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length == 6);
		
		//Convertir cada trozo al tipo correspondiente
		Double superficie = Double.valueOf(trozos[0].trim());
		Double precio = Double.valueOf(trozos[1].trim());
		Integer numhabitaciones = Integer.valueOf(trozos[2].trim());
		TipoVivienda tipo = TipoVivienda.valueOf(trozos[3].trim());
		String direccion = trozos[4].trim();
		String distrito = trozos[5].trim();
		
		//Devolver el objeto
		return new Vivienda(superficie, precio, numhabitaciones,
				tipo, direccion, distrito);
	}
	
	public static Catalogo leerCatalogo(String nomFichero) {
		Catalogo res = null;
		try {
			Stream<Vivienda> registros = Files.lines(Paths.get(nomFichero))
					.skip(1)
					.map(FactoriaCatalogo::parseaAVivienda);
			res = new Catalogo(registros);
		}catch (IOException ioe) {
			System.err.println("Error leyendo fichero");
		}
		return res;
	}

}
