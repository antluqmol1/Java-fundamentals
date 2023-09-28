package examen3convdiciembre2019;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCatalogo {

	public static void main(String[] args) {
		
		Catalogo viv = FactoriaCatalogo.leerCatalogo("data/catalogo.csv");
		viv.getViviendas().stream()
			.forEach(System.out::println);
		
		System.out.println("1º===================");
		Set<TipoVivienda> conjTipos = new HashSet<TipoVivienda>();
		conjTipos.add(TipoVivienda.ADOSADO);
		conjTipos.add(TipoVivienda.CHALET);
		conjTipos.add(TipoVivienda.PISO);
		testGetPrecioMedioPorDistritoDeTipos(viv, conjTipos);
		
		System.out.println("2º===================");
		int n1 = 2;
		testGetDistritosMasNViviendas(viv, n1);
		
		System.out.println("3º===================");
		String calle = "Fraguas";
		int n2 = 3;
		testGetTiposViviendasMasCarasCalle(viv, calle, n2);
		
		System.out.println("4º===================");
		testGetViviendaMasBarataPorTipoEnCapital(viv);
		
		System.out.println("5º===================");
		Double umbral = 0.5;
		testGetPorcViviendasPreciosMayorUmbralPorDistrito(viv, umbral);
		

	}
	
	 private static void testGetPrecioMedioPorDistritoDeTipos(Catalogo reg, Set<TipoVivienda> conjTipos) {
		 try {
			 System.out.println("~~~~~~~~~~~~testGetPrecioMedioPorDistritoDeTipos~~~~~~~~~~~~");
			 Map<String, Double> m = reg.getPrecioMedioPorDistritoDeTipos(conjTipos);
			 m.entrySet().stream()
			 	.forEach(e -> System.out.println(e.getKey() + "-->" + e.getValue()));
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		} 
	 }
	 
	 private static void testGetDistritosMasNViviendas(Catalogo reg, int n) {
		 try {
			 Set<String> ss = reg.getDistritosMasNViviendas(n);
			 ss.stream()
			 	.forEach(System.out::println);
			 System.out.println(ss);
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	 }
	 
	 private static void testGetTiposViviendasMasCarasCalle(Catalogo reg, String calle, Integer n) {
		 try {
			 List<TipoVivienda> ltv = reg.getTiposViviendasMasCarasCalle(calle, n);
			 System.out.println("La lista con las n viviendas mas caras de la calle " + calle + " son:");
			 ltv.stream()
			 	.forEach(System.out::println);
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	 }
	 
	 private static void testGetViviendaMasBarataPorTipoEnCapital(Catalogo reg) {
		 try {
			 Map<TipoVivienda, Vivienda> m = reg.getViviendaMasBarataPorTipoEnCapital();
			 m.entrySet().stream()
			 	.forEach(e -> System.out.println(e.getKey() + "-->" + e.getValue()));		 
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	 }
	 
	 private static void testGetPorcViviendasPreciosMayorUmbralPorDistrito(Catalogo reg, Double umbral) {
		 try {
			 Map<String, Double> m = reg.getPorcViviendasPreciosMayorUmbralPorDistrito(umbral);
			 m.entrySet().stream()
			 	.forEach(e -> System.out.println(e.getKey() + "-->" + e.getValue()));
		} catch (Exception e) {
			System.err.println("Captura excepción inesperada");
		}
	 }

}
