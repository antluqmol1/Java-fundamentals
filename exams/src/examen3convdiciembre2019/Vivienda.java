package examen3convdiciembre2019;

import fp.utiles.Checkers;

public class Vivienda implements Comparable<Vivienda>{
	
	//ATRIBUTOS
	private Double superficie;
	private Double precio;
	private Integer numhabitaciones;
	private TipoVivienda tipo;
	private String direccion;
	private String distrito;
	
	
	//CONSTRUCTOR
	public Vivienda(Double superficie, Double precio, Integer numhabitaciones, 
			TipoVivienda tipo, String direccion, String distrito) {
		//RESTRICCIONES
		Checkers.check("La superficie y el precio deben ser mayores que cero"
				, superficie > 0. && precio > 0.);
		Checkers.check("El número de habitaciones debe ser mayor o igual que cero"
				, numhabitaciones >= 0);
		Checkers.check("El distrito postal debe estar compuesto por 5 dígitos"
				, distrito.length() == 5);
		for (Character c: distrito.toCharArray()) {
			Checkers.check("El distrito postal debe estar compuesto por 5 dígitos"
					, Character.isDigit(c));
		}
		
		
		this.superficie = superficie;
		this.precio = precio;
		this.numhabitaciones = numhabitaciones;
		this.tipo = tipo;
		this.direccion = direccion;
		this.distrito = distrito;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public Double getPrecio() {
		return precio;
	}


	public Integer getNumhabitaciones() {
		return numhabitaciones;
	}


	public TipoVivienda getTipo() {
		return tipo;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getDistrito() {
		return distrito;
	}
	
	//PROPIEDADES DERIVADAS
	public Double getPrecioMetroCuadrado() {
		return superficie / precio;
	}
	
	public Boolean getCapital() {
		return distrito.charAt(2) == '0';
	}


	//Criterio de igualdad
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((distrito == null) ? 0 : distrito.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vivienda other = (Vivienda) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (distrito == null) {
			if (other.distrito != null)
				return false;
		} else if (!distrito.equals(other.distrito))
			return false;
		return true;
	}
	
	//Criterio de ordenación
	public int compareTo(Vivienda v) {
		int res = getDireccion().compareTo(v.getDireccion());
		if (res == 0) {
			res = getDistrito().compareTo(v.getDistrito());
		}
		return res;
	}


	//Representación como cadena
	public String toString() {
		return "Vivienda [superficie=" + superficie + ", precio=" + precio + ", numhabitaciones=" + numhabitaciones
				+ ", tipo=" + tipo + ", direccion=" + direccion + ", distrito=" + distrito + "]";
	}
	
	
	
	
	
	

}
