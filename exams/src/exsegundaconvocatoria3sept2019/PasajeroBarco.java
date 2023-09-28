package exsegundaconvocatoria3sept2019;

import java.util.Objects;

import fp.utiles.Checkers;

public class PasajeroBarco {
	
	//ATRIBUTOS
	private Integer id;
	private Boolean superviviente;
	private Integer clase;
	private String nombre;
	private Sexo sexo;
	private Integer edad;
	private Integer numHermanosOParejaAbordo;
	private Integer numPadresOHijosAbordo;
	private Double precioTicket;
	private String cabina;
	private String ciudadEmbarque;
	
	//CONSTRUCTOR
	public PasajeroBarco(Integer id, Boolean superviviente, Integer clase,
			String nombre, Sexo sexo, Integer edad, Integer numHermanosOParejaAbordo,
			Integer numPadresOHijosAbordo, Double precioTicket, String cabina,
			String ciudadEmbarque) {
		
		//RESTRICCIONES
		Checkers.checkNoNull(id, superviviente, clase, edad, numHermanosOParejaAbordo,
				numPadresOHijosAbordo, precioTicket);
		Checkers.check(" Las propiedades numéricas deben tener un valor mayor o igual que cero", clase >= 0);
		Checkers.check(" Las propiedades numéricas deben tener un valor mayor o igual que cero", edad >= 0);
		Checkers.check(" Las propiedades numéricas deben tener un valor mayor o igual que cero", numHermanosOParejaAbordo >= 0);
		Checkers.check(" Las propiedades numéricas deben tener un valor mayor o igual que cero", numPadresOHijosAbordo >= 0);
		Checkers.check(" Las propiedades numéricas deben tener un valor mayor o igual que cero", precioTicket >= 0);
		
		this.id = id;
		this.superviviente = superviviente;
		this.clase = clase;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.numHermanosOParejaAbordo = numHermanosOParejaAbordo;
		this.numPadresOHijosAbordo = numPadresOHijosAbordo;
		this.precioTicket = precioTicket;
		this.cabina = cabina;
		this.ciudadEmbarque = ciudadEmbarque;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getSuperviviente() {
		return superviviente;
	}

	public Integer getClase() {
		return clase;
	}

	public String getNombre() {
		return nombre;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getNumHermanosOParejaAbordo() {
		return numHermanosOParejaAbordo;
	}

	public Integer getNumPadresOHijosAbordo() {
		return numPadresOHijosAbordo;
	}

	public Double getPrecioTicket() {
		return precioTicket;
	}

	public String getCabina() {
		return cabina;
	}

	public String getCiudadEmbarque() {
		return ciudadEmbarque;
	}
	
	//PROPEDAD DERIVADA
	public Integer getNumFamiliares() {
		 return getNumHermanosOParejaAbordo() + getNumPadresOHijosAbordo();
	}

	//CRITERIO DE IGUALDAD
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasajeroBarco other = (PasajeroBarco) obj;
		return Objects.equals(id, other.id);
	}
	
	//CRITERIO DE ORDENACION
	public int CompareTo(PasajeroBarco o) {
		int res = getId().compareTo(o.getId());
		return res;
	}
	
	//REPRESENTACIÓN COMO CADENA
	@Override
	public String toString() {
		return "PasajeroBarco [id=" + id + ", superviviente=" + superviviente + ", clase=" + clase + ", nombre="
				+ nombre + ", sexo=" + sexo + ", edad=" + edad + ", numHermanosOParejaAbordo="
				+ numHermanosOParejaAbordo + ", numPadresOHijosAbordo=" + numPadresOHijosAbordo + ", precioTicket="
				+ precioTicket + ", cabina=" + cabina + ", ciudadEmbarque=" + ciudadEmbarque + ", getNumFamiliares()="
				+ getNumFamiliares() + "]";
	}
	
}
