package segundoexparc10jun2019sesion3;

import java.util.Objects;

import fp.utiles.Checkers;

public class Registro {
	
	//ATRIBUTOS
	private Integer anyo;
	private String pais;
	private Double puntos;
	private Double gobierno;
	private Double justicia;
	private Double derechos;
	
	//CONSTRUCTOR
	public Registro(Integer anyo, String pais, Double puntos,
			Double gobierno, Double justicia, Double derechos) {
		
		//RESTRICCIONES 
		Checkers.check("El año debe estar comprendido entre 2009 y 2016, ambos inclusive"
				, anyo >= 2009 && anyo <= 2016);
		Checkers.check("La puntuación global debe estar entre 0 y 10, ambos inclusive, o tomar el valor -1"
				, puntos >= 0 && puntos >= 0 || puntos == -1);
		Checkers.check("La puntuación del gobierno debe estar entre 0 y 10, ambos inclusive, o tomar el valor -1"
				, gobierno >= 0 && gobierno >= 0 || gobierno == -1);
		Checkers.check("La puntuación de la justicia debe estar entre 0 y 10, ambos inclusive, o tomar el valor -1"
				, justicia >= 0 && justicia >= 0 || justicia == -1);
		Checkers.check("La puntuación de los derechos legales debe estar entre 0 y 10, ambos inclusive, o tomar el valor -1"
				, derechos >= 0 && derechos >= 0 || derechos == -1);
		
	
		this.anyo = anyo;
		this.pais = pais;
		this.puntos = puntos;
		this.gobierno = gobierno;
		this.justicia = justicia;
		this.derechos = derechos;
	
	}
	
	//GETTERS

	public Integer getAnyo() {
		return anyo;
	}

	public String getPais() {
		return pais;
	}

	public Double getPuntos() {
		return puntos;
	}

	public Double getGobierno() {
		return gobierno;
	}

	public Double getJusticia() {
		return justicia;
	}

	public Double getDerechos() {
		return derechos;
	}
	
	//PROPIEDAD DERIVADA
	public Nivel getNivel() {
		Nivel res = Nivel.BAJO;
		if (puntos >= getGobierno() && puntos >= getJusticia()) {
			res = Nivel.ALTO;
		}
		else if (puntos >= getGobierno() && puntos <= getJusticia()
				||puntos <= getGobierno() && puntos >= getJusticia()) {
			res = Nivel.MEDIO;
		}
		return res;
	}

	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(anyo, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		return Objects.equals(anyo, other.anyo) && Objects.equals(pais, other.pais);
	}
	
	//COMPARE TO
	public int compareTo(Registro r) {
		int res = getAnyo().compareTo(r.getAnyo());
		if (res == 0) {
			res = getPais().compareTo(r.getPais());
		}
		return res;
	}
	
	//REPRESENRTACION COMO CADENA
	@Override
	public String toString() {
		return "Registro [anyo=" + anyo + ", pais=" + pais + ", puntos=" + puntos + ", gobierno=" + gobierno
				+ ", justicia=" + justicia + ", derechos=" + derechos + "]";
	}
	

}
