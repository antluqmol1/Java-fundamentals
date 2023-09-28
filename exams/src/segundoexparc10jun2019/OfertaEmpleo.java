package segundoexparc10jun2019;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class OfertaEmpleo {
	
	//ATRIBUTOS
	
	private String especialidad;
	private Integer numPlazas;
	private Integer numPlazasDiscapacidad;
	private LocalDate fechaPublicacionBoja;
	private TipoAcceso tipoAcceso;
	
	//CONSTRUCTOR 1
	public OfertaEmpleo(String especialidad, Integer numPlazas,
				Integer numPlazasDiscapacidad, LocalDate fechaPublicacionBoja,
				TipoAcceso tipoAcceso) {
		
		Checkers.check("El nº de plazas no puede ser negativo", numPlazas >=0);
		Checkers.check("El nº de  plazas reservadas para discapacitados no puede ser negativo",
							numPlazasDiscapacidad >=0);
		Checkers.check("El año de publicación debe ser posterior o igual a 1990 y la fecha de publicación debe ser anterior o\r\n"
				+ "igual a la fecha de hoy", fechaPublicacionBoja.getYear() >= 1990 && 
				fechaPublicacionBoja.compareTo(LocalDate.now()) <= 0);
		
		this.especialidad = especialidad;
		this.numPlazas = numPlazas;
		this.numPlazasDiscapacidad = numPlazasDiscapacidad;
		this.fechaPublicacionBoja = fechaPublicacionBoja;
		this.tipoAcceso = tipoAcceso;
		
		
	}
	
	//GETTERS AND SETTERS

	public String getEspecialidad() {
		return especialidad;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public Integer getNumPlazasDiscapacidad() {
		return numPlazasDiscapacidad;
	}

	public LocalDate getFechaPublicacionBoja() {
		return fechaPublicacionBoja;
	}


	public TipoAcceso getTipoAcceso() {
		return tipoAcceso;
	}
	
	//PROPIEDADES DERIVADAS
	
	public Integer getNumPlazasTotales() {
		return getNumPlazas() + getNumPlazasDiscapacidad();
	}
	
	public Double getPorcentajePlazasDiscapacidad() {
		return getNumPlazasDiscapacidad() *100. / getNumPlazasTotales();
	}

	
	
	//CRITERIO DE IGUALDAD
	
	@Override
	public int hashCode() {
		return Objects.hash(especialidad, fechaPublicacionBoja, tipoAcceso);
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
		return Objects.equals(especialidad, other.especialidad)
				&& Objects.equals(fechaPublicacionBoja, other.fechaPublicacionBoja) && tipoAcceso == other.tipoAcceso;
	}
	
	//compareTO
	
	public int compareTo(OfertaEmpleo o) {
		int res = getFechaPublicacionBoja().compareTo(o.getFechaPublicacionBoja());
		if (res==0) {
			res = getEspecialidad().compareTo(o.getEspecialidad());
			if (res==0) {
				res = getTipoAcceso().compareTo(o.getTipoAcceso());
				if (res==0) {
					res = getNumPlazasTotales().compareTo(o.getNumPlazasTotales());
				}
			}
		}
		return res;	
	}

	@Override
	public String toString() {
		return "OfertaEmpleo [especialidad=" + especialidad + ", numPlazas=" + numPlazas + ", numPlazasDiscapacidad="
				+ numPlazasDiscapacidad + ", fechaPublicacionBoja=" + fechaPublicacionBoja + ", tipoAcceso="
				+ tipoAcceso + ", getNumPlazasTotales()=" + getNumPlazasTotales()
				+ ", getPorcentajePlazasDiscapacidad()=" + getPorcentajePlazasDiscapacidad() + "]";
	}
	
	
	
	


}
