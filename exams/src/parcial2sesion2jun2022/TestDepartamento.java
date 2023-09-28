package parcial2sesion2jun2022;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestDepartamento {

	public static void main(String[] args) {
		
		Departamento dep = FactoriaDepartamento.leerDepartamento("data/profesores.csv");
		dep.getProfesores().stream().forEach(System.out::println);

		System.out.println("1 =============================");
		testProfesoresPorAsignatura(dep);
		System.out.println("2 =============================");
		testProfesoresQueSoloImpartenAsignaturasQueCoordinan(dep);
		System.out.println("3 =============================");
		testDepartamentoResponsable(dep);
		System.out.println("4 =============================");
		testOrdenarProfesoresPorNumeroCreditosTeoricos(dep);
		System.out.println("5 =============================");
		testAñoIncorporacionMasCoordinadores(dep);

	}
	
	private static void testProfesoresPorAsignatura(Departamento dep) {
		try {
			Map<Asignatura, List<Profesor>> m = dep.profesoresPorAsignatura();
			m.entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + "-->" + e.getValue()));
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	}
	
	private static void testProfesoresQueSoloImpartenAsignaturasQueCoordinan(Departamento dep) {
		try {
			Set<Profesor> sp = dep.profesoresQueSoloImpartenAsignaturasQueCoordinan();
			System.out.println("Los profesores que solo imparten las asign. que coordinan son: ");
			sp.stream().forEach(System.out::println);
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	}
	
	private static void testDepartamentoResponsable(Departamento dep) {
		try {
		Boolean res = dep.departamentoResponsable();
		String msg = String.format("¿Es el departamento responsable? %s", res.toString());
		System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	}
	
	private static void testOrdenarProfesoresPorNumeroCreditosTeoricos(Departamento dep) {
		try {
			List<String> ls = dep.ordenarProfesoresPorNumeroCreditosTeoricos();
			System.out.println("Profesores ordenados por numero créditos teóricos");
			ls.stream().forEach(System.out::println);
		} catch(Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	}
	
	private static void testAñoIncorporacionMasCoordinadores(Departamento dep) {
		try {
			Integer res = dep.añoIncorporacionMasCoordinadores();
			String msg = String.format("El año en el que se incorporaron más coordinadores fue %d", res);
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	}

}
