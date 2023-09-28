package fp.nba;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

import fp.common.Conferencia;
import fp.common.Posicion;
import fp.utiles.Checkers;

public class Nba {
	
	private String jugador;
	private String equipo;
	private Conferencia conferencia;
	private LocalDate fecha;
	private Posicion posicion;
	private Double altura;
	private Integer peso;
	private Integer edad;
	private Integer año_draft_del_jugador;
	private Integer temporadas_en_liga;
	private Integer año_fin_de_temporada;
	private String equipo_anterior;
	private Integer altura_en_centimetros;
	private Integer peso_en_kilogramos;
	private Boolean anillos;
	
	
//Constructor 1	
	public Nba(String jugador, String equipo, Conferencia conferencia, LocalDate fecha, Posicion posicion, Double altura,
			Integer peso, Integer edad, Integer año_draft_del_jugador, Integer temporadas_en_liga, Integer año_fin_de_temporada,
			String equipo_anterior, Integer altura_en_centimetros, Integer peso_en_kilogramos, Boolean anillos) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.conferencia = conferencia;
		this.fecha = fecha;
		this.posicion = posicion;
		this.altura = altura;
		this.peso = peso;
		this.edad = edad;
		this.año_draft_del_jugador = año_draft_del_jugador;
		this.temporadas_en_liga = temporadas_en_liga;
		this.año_fin_de_temporada = año_fin_de_temporada;
		this.equipo_anterior = equipo_anterior;
		this.altura_en_centimetros = altura_en_centimetros;
		this.peso_en_kilogramos = peso_en_kilogramos;
		this.anillos = anillos;
	}
	
	
	
//Constructor 2
public Nba(String jugador, String equipo, Conferencia conferencia, Posicion posicion, Double altura,
		Integer peso, Integer edad, Integer año_draft_del_jugador, Integer temporadas_en_liga, Integer año_fin_de_temporada,
		String equipo_anterior, Integer altura_en_centimetros) {
	super();
	this.jugador = jugador;
	this.equipo = equipo;
	this.conferencia = conferencia;
	this.fecha = LocalDate.of(2016, Month.SEPTEMBER, 19);
	this.posicion = posicion;
	this.altura = altura;
	this.peso = peso;
	this.edad = edad;
	this.año_draft_del_jugador = año_draft_del_jugador;
	this.temporadas_en_liga = temporadas_en_liga;
	this.año_fin_de_temporada = año_fin_de_temporada;
	this.equipo_anterior = equipo_anterior;
	this.altura_en_centimetros = altura_en_centimetros;
	this.peso_en_kilogramos = 79;
	this.anillos = null;


//Restricciones
	Checkers.check("El peso en kilogramos debe ser positivo", peso_en_kilogramos>=0);
	Checkers.check("Los anillos no pueden tener un valor nulo", anillos!=null);
	Checkers.check("Tiene que tener una edad superior a 18 años", edad>=18);

}

//Métodos

	public String getJugador() {
		return jugador;
	}


	public void setJugador(String jugador) {
		this.jugador = jugador;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public Conferencia getConferencia() {
		return conferencia;
	}


	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Integer getPeso() {
		return peso;
	}


	public void setPeso(Integer peso) {
		this.peso = peso;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Integer getAño_draft_del_jugador() {
		return año_draft_del_jugador;
	}


	public void setAño_draft_del_jugador(Integer año_draft_del_jugador) {
		this.año_draft_del_jugador = año_draft_del_jugador;
	}


	public Integer getTemporadas_en_liga() {
		return temporadas_en_liga;
	}


	public void setTemporadas_en_liga(Integer temporadas_en_liga) {
		this.temporadas_en_liga = temporadas_en_liga;
	}


	public Integer getAño_fin_de_temporada() {
		return año_fin_de_temporada;
	}


	public void setAño_de_temporada(Integer año_fin_de_temporada) {
		this.año_fin_de_temporada = año_fin_de_temporada;
	}


	public String getEquipo_anterior() {
		return equipo_anterior;
	}


	public void setEquipo_anterior(String equipo_anterior) {
		this.equipo_anterior = equipo_anterior;
	}


	public Integer getAltura_en_centimetros() {
		return altura_en_centimetros;
	}


	public void setAltura_en_centimetros(Integer altura_en_centimetros) {
		this.altura_en_centimetros = altura_en_centimetros;
	}


	public Integer getPeso_en_kilogramos() {
		return peso_en_kilogramos;
	}


	public void setPeso_en_kilogramos(Integer peso_en_kilogramos) {
		this.peso_en_kilogramos = peso_en_kilogramos;
	}


	public Boolean getAnillos() {
		return anillos;
	}


	public void setAnillos(Boolean anillos) {
		this.anillos = anillos;
	}
	
	public Integer getTiempoEnAños() {
		Period p = this.fecha.until(LocalDate.now());
		return p.getYears();
	}
	
	public Double getIndiceMasaCorporal() {
		return (double)this.getPeso_en_kilogramos()/Math.pow(((double)this.altura_en_centimetros/100), 2);
		
	}
	
	public String getSignificadoIndiceMasaCorporal() {
		String cadena="";
		if(getIndiceMasaCorporal()<16.00){
		  cadena="Infrapeso (Delgadez Severa)";
		}else if(getIndiceMasaCorporal()>=16.00 && getIndiceMasaCorporal()<=16.99){
		  cadena="Infrapeso (Delgadez moderada)";
		}else if(getIndiceMasaCorporal()>=17.00 && getIndiceMasaCorporal()<=18.49){
		  cadena="Infrapeso (Delgadez aceptable)";
		}else if(getIndiceMasaCorporal()>=18.50 && getIndiceMasaCorporal()<=24.99){
		  cadena="Peso Normal";
		}else if(getIndiceMasaCorporal()>=25.00 && getIndiceMasaCorporal()<=29.99){
		  cadena="Sobrepeso";
		}else if(getIndiceMasaCorporal()>=30.00 && getIndiceMasaCorporal()<=34.99){
		  cadena="Obeso (Tipo I)";
		}else if(getIndiceMasaCorporal()>=35.00 && getIndiceMasaCorporal()<=40.00){
		  cadena="Obeso (Tipo III)";
		}else{
		  cadena="no existe clasificacion";
		}
		  return cadena;
	}


@Override
	public int hashCode() {
		return Objects.hash(altura, altura_en_centimetros, anillos, año_draft_del_jugador, año_fin_de_temporada,
				conferencia, edad, equipo, equipo_anterior, fecha, jugador, peso, peso_en_kilogramos, posicion,
				temporadas_en_liga);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nba other = (Nba) obj;
		return Objects.equals(altura, other.altura)
				&& Objects.equals(altura_en_centimetros, other.altura_en_centimetros)
				&& Objects.equals(anillos, other.anillos)
				&& Objects.equals(año_draft_del_jugador, other.año_draft_del_jugador)
				&& Objects.equals(año_fin_de_temporada, other.año_fin_de_temporada) && conferencia == other.conferencia
				&& Objects.equals(edad, other.edad) && Objects.equals(equipo, other.equipo)
				&& Objects.equals(equipo_anterior, other.equipo_anterior) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(jugador, other.jugador) && Objects.equals(peso, other.peso)
				&& Objects.equals(peso_en_kilogramos, other.peso_en_kilogramos) && posicion == other.posicion
				&& Objects.equals(temporadas_en_liga, other.temporadas_en_liga);
	}



public int compareTo(Nba h) {
	int r;
	if (h == null) {
		throw new NullPointerException();
	}
	r = getAltura_en_centimetros().compareTo(h.getAltura_en_centimetros());
	if (r == 0) {
		r = getPeso_en_kilogramos().compareTo(h.getPeso_en_kilogramos());
		if (r == 0) {
			r = getJugador().compareTo(h.getJugador());
		}
	}
	return r;
}



@Override
public String toString() {
	return "Nba [jugador=" + jugador + ", equipo=" + equipo + ", conferencia=" + conferencia + ", fecha=" + fecha
			+ ", posicion=" + posicion + ", altura=" + altura + ", peso=" + peso + ", edad=" + edad
			+ ", año_draft_del_jugador=" + año_draft_del_jugador + ", temporadas_en_liga=" + temporadas_en_liga
			+ ", año_fin_de_temporada=" + año_fin_de_temporada + ", equipo_anterior=" + equipo_anterior
			+ ", altura_en_centimetros=" + altura_en_centimetros + ", peso_en_kilogramos=" + peso_en_kilogramos
			+ ", anillos=" + anillos + ", getJugador()=" + getJugador() + ", getEquipo()=" + getEquipo()
			+ ", getConferencia()=" + getConferencia() + ", getFecha()=" + getFecha() + ", getPosicion()="
			+ getPosicion() + ", getAltura()=" + getAltura() + ", getPeso()=" + getPeso() + ", getEdad()=" + getEdad()
			+ ", getAño_draft_del_jugador()=" + getAño_draft_del_jugador() + ", getTemporadas_en_liga()="
			+ getTemporadas_en_liga() + ", geAño_fin_de_temporada()=" + getAño_fin_de_temporada()
			+ ", getEquipo_anterior()=" + getEquipo_anterior() + ", getAltura_en_centimetros()="
			+ getAltura_en_centimetros() + ", getPeso_en_kilogramos()=" + getPeso_en_kilogramos() + ", getAnillos()="
			+ getAnillos() + ", getTiempoEnAños()=" + getTiempoEnAños() + ", getIndiceMasaCorporal()="
			+ getIndiceMasaCorporal() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
			+ super.toString() + "]";
}



	

	
	
	
	

	
	
	
}
