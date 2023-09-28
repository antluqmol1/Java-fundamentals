package segundoexparc10jun2019sesion2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class FactoriaOfertasEmpleo {
	
	public static OfertaEmpleo parsearOferta(String lineaCSV) {
		
		//Trocear cadena y chekear nº trozos
		String [] trozos = lineaCSV.split(";");
		Checkers.check("La cadena está mal troceada", trozos.length == 5);
		
		//Convertir trozos al tipo correspondiente
		String cuerpo = trozos[0].trim();
		String especialidad = trozos[1].trim();
		Integer numPlazas = Integer.valueOf(trozos[2].trim());
		Integer numBOJA = Integer.valueOf(trozos[3].trim());
		LocalDate fechaPublicacionBOJA = LocalDate.parse(trozos[4].trim()
				, DateTimeFormatter.ofPattern("d/M/yyyy"));
		
		//Construcción del objeto
		return new OfertaEmpleo(cuerpo, especialidad, numPlazas,
				numBOJA, fechaPublicacionBOJA);
	}

}
