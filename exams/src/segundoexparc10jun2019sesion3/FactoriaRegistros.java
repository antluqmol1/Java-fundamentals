package segundoexparc10jun2019sesion3;

import fp.utiles.Checkers;

public class FactoriaRegistros {
	
	public static Registro parsearRegistro(String lineaCSV) {
		
		//TROCEARR CADENA Y CHEKEAR Nº TROZOS
		String [] trozos = lineaCSV.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length == 6);
		
		//CONVERTIR TROZOS AL TIPO CORRESPONDIENTE
		Integer anyo = Integer.valueOf(trozos[0].trim());
		String pais = trozos[1].trim();
		Double puntos = Double.valueOf(trozos[2].trim());
		Double gobierno = Double.valueOf(trozos[3].trim());
		Double justicia = Double.valueOf(trozos[4].trim());
		Double derechos = Double.valueOf(trozos[5].trim());
		
		//CONSTRUCCION DEL OBJETO
		return new Registro(anyo, pais, puntos, gobierno,
				justicia, derechos);
		
	}

}
