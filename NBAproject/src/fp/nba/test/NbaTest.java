package fp.nba.test;

import java.time.LocalDate;

import fp.common.Conferencia;
import fp.common.Posicion;
import fp.nba.*;

public class NbaTest {

	public static void main(String[] args) {
		
		
		
		System.out.println("--------------------NbaTest--------------------");
		System.out.println("\n~~~~~~~~~~~~~~~~~Test registros y excepciones~~~~~~~~~~~~~~~~~");
		
		Nba reg = new Nba("Stephen Curry", "Golden State Warriors", Conferencia.West, LocalDate.of(2007,7,14),
				Posicion.G, 6.3, 190, 28, 2009, 7, 2017, "Davidson", 190, 86, false);
		System.out.println(reg);
		
		Nba reg2 = new Nba("Stephen Curry", "Golden State Warriors", Conferencia.West, LocalDate.of(2007,7,14),
				Posicion.G, 6.3, 190, 28, 2009, 7, 2017, "Davidson", 190, 86, false);
		System.out.println(reg2);
		
		try {
			Nba reg3 = new Nba("Stephen Curry", "Golden State Warriors", Conferencia.West,Posicion.G,
					6.3, 190, 28, 2009, 7, 2017, "Davidson", 190);
			System.out.println(reg3);
		}catch (Exception e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
		
		try {
			Nba reg4 = new Nba("LeBron James", "Cleveland Cavaliers", Conferencia.East, LocalDate.of(2002,1,4),
					Posicion.F, 6.8, 250, 24, 2003, 5, 2009, "St. Vincent St. Mary High School (Ohio)", 203, 113, true);
			System.out.println(reg4);
		}catch (Exception e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
			
			
		System.out.println("\n~~~~~~~~~~~~~~~~~Test métodos y propiedades derivadas~~~~~~~~~~~~~~~~~");
		
		System.out.println("Nombre del jugador: " + reg.getJugador());
		System.out.println("Nombre del equipo: " + reg.getEquipo());
		System.out.println("Conferencia: " + reg.getConferencia());
		System.out.println("Fecha: " + reg.getFecha());
		System.out.println("Posición del jugador: ");
		System.out.println("Altura (en pies): " + reg.getAltura());
		System.out.println("Peso (en libras): " + reg.getPeso());
		System.out.println("Edad del jugador: " + reg.getEdad());
		System.out.println("Año en el que el jugador fue draft: " + reg.getAño_draft_del_jugador());
		System.out.println("Número de temporadas en liga: " + reg.getTemporadas_en_liga());
		System.out.println("Año en el que terminó la temporada: " + reg.getAño_fin_de_temporada());
		System.out.println("Equipo contra el que jugó anteriormente: " + reg.getEquipo_anterior());
		System.out.println("Altura en centímetros: " + reg.getAltura_en_centimetros());
		System.out.println("Peso en kilogramos: " + reg.getPeso_en_kilogramos());
		System.out.println("¿Tiene anilos este jugador? " + reg.getAnillos());
		
		System.out.println("El tiempo en años desde la fecha hasta hoy es de: " + reg.getTiempoEnAños() + " años");
		System.out.print("El índice de Masa Corporal del jugador es de: " + reg.getIndiceMasaCorporal() + ". ");
		System.out.println("Eso significa que tiene: " + reg.getSignificadoIndiceMasaCorporal());
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test hashcode~~~~~~~~~~~~~~~~~");
		System.out.print("¿Son idénticos? ");
		System.out.println(reg == reg2);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test equals~~~~~~~~~~~~~~~~~");
		System.out.print("¿Son iguales? ");
		System.out.println(reg.equals(reg2) && reg2.equals(reg));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~Test Orden Natural~~~~~~~~~~~~~~~~~");
		System.out.println(reg.compareTo(reg2));
		if (reg.compareTo(reg2) > 0) {
			System.out.println(reg + " va después de " + reg2);
		}
		else if (reg.compareTo(reg2) == 0) {
			System.out.println(reg + " es igual a " + reg2);
		}
		else {
			System.out.println(reg + "va antes de" + reg2);
		}
	}

}
