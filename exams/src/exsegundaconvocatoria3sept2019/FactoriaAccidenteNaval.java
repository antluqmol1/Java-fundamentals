package exsegundaconvocatoria3sept2019;

import fp.utiles.Checkers;

public class FactoriaAccidenteNaval {
	
	public static PasajeroBarco parsearRegistro(String linea) {
		
		//Trocear linea y chekear nº trozos
		String [] trozos = linea.split(",");
		Checkers.check("Se ha troceado mal la linea", trozos.length == 11);
		
		//Convertir trozos al tipo correspondiente
		Integer id = Integer.valueOf(trozos[0].trim());
		Boolean superviviente = Boolean.valueOf(trozos[1].trim());
		Integer clase = Integer.valueOf(trozos[2].trim());
		String nombre = trozos[3].trim();
		Sexo sexo = Sexo.valueOf(trozos[4].trim());
		Integer edad = Integer.valueOf(trozos[5].trim());
		Integer numHermanosOParejaAbordo = Integer.valueOf(trozos[6].trim());
		Integer numPadresOHijosAbordo = Integer.valueOf(trozos[7].trim());
		Double precioTicket = Double.valueOf(trozos[8].trim());
		String cabina = trozos[9].trim();
		String ciudadEmbarque = trozos[10].trim();
			
		//Construcción del objeto
		return new PasajeroBarco(id, superviviente, clase, nombre, sexo, edad,
				numHermanosOParejaAbordo, numPadresOHijosAbordo, precioTicket,
				cabina, ciudadEmbarque);
		
	}

}
