package segundoexparc10jun2019;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import fp.utiles.Checkers;

public class FactoriaOfertasEmpleo {
	
	public static OfertaEmpleo parsearOferta(String lineaCSV) {
		
		//Trocear la cadena y chekear el nº de trozos
		String [] trozos = lineaCSV.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length == 5);
		
		//Convertir trozos al tipo correspondiente
		String especialidad = trozos[0].trim();
		Integer numPlazas = Integer.valueOf(trozos[1].trim());
		Integer numPlazasDiscapacidad = Integer.valueOf(trozos[2].trim());
		LocalDate fechaPublicacionBoja = LocalDate.parse(trozos[3].trim(), DateTimeFormatter.ofPattern("d/M/yyyy"));
		TipoAcceso tipoAcceso = TipoAcceso.valueOf(trozos[4].trim());
		
		//Construcción del objeto
		return new OfertaEmpleo(especialidad, numPlazas, numPlazasDiscapacidad, fechaPublicacionBoja, tipoAcceso);
	}
}