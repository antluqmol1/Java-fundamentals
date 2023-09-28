package parcial2sesion2jun2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaDepartamento {
	
	public static Departamento leerDepartamento(String rutaFichero) {
		Departamento res = null;
		try {
			Stream<Profesor> departamento = Files.lines(Paths.get(rutaFichero))
					.skip(1)
					.map(FactoriaDepartamento::parsearProfesor);
			res = new Departamento(departamento);
		}catch(IOException e){
			System.out.println("Fichero no encontrado" + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static Profesor parsearProfesor(String lineaCSV) {
		
		//Trocear cadena y checkear nº trozos
		String [] trozos = lineaCSV.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length==11);
		
		//Convertir el trozo al tipo correspondiente
		String nombre = trozos[0].trim();
		LocalDate fechaIngreso = LocalDate.parse(trozos[1].trim(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Set<Asignatura> asignaturasCursosAnteriores = parsearConjAsignaturas(trozos[2].trim());
		Set<Asignatura> asignaturasPrimerCuatri = parsearConjAsignaturas(trozos[3].trim());
		Set<Asignatura> asignaturasSegundoCuatri = parsearConjAsignaturas(trozos[4].trim());
		Double creditosTeoricosPrimerCuatri = Double.valueOf(trozos[5].trim() == null ? "0" : trozos[5].trim());
		Double creditosTeoricosSegundoCuatri = Double.parseDouble(trozos[6].trim());
		Double creditosLaboratorioPrimerCuatri = Double.parseDouble(trozos[7].trim());
		Double creditosLaboratorioSegundoCuatri = Double.parseDouble(trozos[8].trim());
		Double capacidad = Double.parseDouble(trozos[9].trim());
		Set<Asignatura> asignaturasCoordinadas = parsearConjAsignaturas(trozos[10].trim());
		
		//Devolver el objeto
		return new Profesor(nombre, fechaIngreso, asignaturasCursosAnteriores, asignaturasPrimerCuatri,
				asignaturasSegundoCuatri, creditosTeoricosPrimerCuatri, creditosTeoricosSegundoCuatri, 
				creditosLaboratorioPrimerCuatri, creditosLaboratorioSegundoCuatri, capacidad, asignaturasCoordinadas);
	}
	
	//Método auxiliar
	public static Set<Asignatura> parsearConjAsignaturas(String cadenaConjAsig) {
		String limpia = cadenaConjAsig.replace("{", "").replace("}", "").trim();
		Set<Asignatura> res = new HashSet<Asignatura>();
		String trozos[] = limpia.split(";");
		for (int i = 0; i < trozos.length; i++) {
			if (!trozos[i].trim().isEmpty()) {
				Asignatura a = Asignatura.valueOf(trozos[i].trim());
				res.add(a);
			}
		}
		return res;
	}

}
