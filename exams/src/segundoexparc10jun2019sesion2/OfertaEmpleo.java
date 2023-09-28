package segundoexparc10jun2019sesion2;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class OfertaEmpleo {
	
	//ATRIBUTOS
	private String cuerpo;
	private String especialidad;
	private Integer numPlazas;
	private Integer numBOJA;
	private LocalDate fechaPublicacionBOJA;
	
	//CONSTRUCTOR
	public OfertaEmpleo(String cuerpo, String especialidad, Integer numPlazas,
						Integer numBOJA, LocalDate fechaPublicacionBOJA) {
		Checkers.check("El número de plazas no puede ser negativo", numPlazas >= 0);
		Checkers.check("El número del BOJA debe ser mayor o igual que uno", numBOJA >= 1);
		Checkers.check("El año de publicación debe ser posterior o igual a 1992 y la fecha de publicación debe ser anterior o\r\n"
				+ "igual a la fecha de hoy", fechaPublicacionBOJA.getYear() >= 1992
				&& fechaPublicacionBOJA.isBefore(LocalDate.now()));
		
		this.cuerpo = cuerpo;
		this.especialidad = especialidad;
		this.numPlazas = numPlazas;
		this.numBOJA = numBOJA;
		this.fechaPublicacionBOJA = fechaPublicacionBOJA;
		
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public Integer getNumBOJA() {
		return numBOJA;
	}

	public LocalDate getFechaPublicacionBOJA() {
		return fechaPublicacionBOJA;
	}
	
	//PROPIEDADES DERIVADAS
	public NivelEducativo getNivelEducativo() {
		NivelEducativo res = NivelEducativo.OTROS;
		if (getCuerpo().equals("CUERPO DE MAESTROS")) {
			res = NivelEducativo.PRIMARIA;
		}
		else if (getCuerpo().equals("PROFESORES DE ENSEÑANZA SECUNDARIA")) {
			res = NivelEducativo.SECUNDARIA;
		}
		else if (getCuerpo().equals("PROFESORES TÉCNICOS DE FORMACIÓN PROFESIONAL")) {
			res = NivelEducativo.FP;
		}
		return res;
	}

	
	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(cuerpo, especialidad, fechaPublicacionBOJA, numBOJA, numPlazas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfertaEmpleo other = (OfertaEmpleo) obj;
		return Objects.equals(cuerpo, other.cuerpo) && Objects.equals(especialidad, other.especialidad)
				&& Objects.equals(fechaPublicacionBOJA, other.fechaPublicacionBOJA)
				&& Objects.equals(numBOJA, other.numBOJA) && Objects.equals(numPlazas, other.numPlazas);
	}
	
	//CRITERIO DE ORDENACIÓN
	public int compareTo(OfertaEmpleo o) {
		int res = getFechaPublicacionBOJA().compareTo(o.getFechaPublicacionBOJA());
		if (res == 0) {
			res = getCuerpo().compareTo(o.getCuerpo());
			if (res == 0) {
				res = getEspecialidad().compareTo(o.getEspecialidad());
				if (res == 0) {
					res = getNumPlazas().compareTo(o.getNumPlazas());
				}
			}
		}
		return res;
	}

	//REPRESENTACION COMO CADENA
	@Override
	public String toString() {
		return "OfertaEmpleo [cuerpo=" + cuerpo + ", especialidad=" + especialidad + ", numPlazas=" + numPlazas
				+ ", numBOJA=" + numBOJA + ", fechaPublicacionBOJA=" + fechaPublicacionBOJA + ", getNivelEdicativo()="
				+ getNivelEducativo() + "]";
	}
	
	
	
	
	

}
