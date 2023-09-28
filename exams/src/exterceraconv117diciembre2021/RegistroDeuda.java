package exterceraconv117diciembre2021;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class RegistroDeuda implements Comparable<RegistroDeuda> {
	
	//ATRIBUTOS
	private String nombrePais;
	private LocalDate fecha;
	private Integer deudaTotal;
	private Double deudaPorcentajePIB;
	private Integer deudaPerCapita;
	
	//CONSTRUCTORES
		//C1
	public RegistroDeuda(String nombrePais, LocalDate fecha, Integer deudaTotal,
			Double deudaPorcentajePIB, Integer deudaPerCapita) {
		Checkers.checkNoNull(nombrePais, fecha, deudaTotal, deudaPorcentajePIB,
				deudaPerCapita);
		Checkers.check("Las fechas no pueden ser anteriores al 1/1/1945"
				, fecha.isAfter(LocalDate.of(1945, 1, 1)));
		Checkers.check("Los valores numéricos debe ser mayores o iguales a 0"
				, deudaTotal >= 0 && deudaPorcentajePIB >= 0 && deudaPerCapita >= 0);
		
		this.nombrePais = nombrePais;
		this.fecha = fecha;
		this.deudaTotal = deudaTotal;
		this.deudaPorcentajePIB = deudaPorcentajePIB;
		this.deudaPerCapita = deudaPerCapita;
	}
	
		//C2
	public RegistroDeuda(String cadena) {
		
		Checkers.checkNoNull(nombrePais, fecha, deudaTotal, deudaPorcentajePIB,
				deudaPerCapita);
		Checkers.check("Las fechas no pueden ser anteriores al 1/1/1945"
				, fecha.isAfter(LocalDate.of(1945, 1, 1)));
		Checkers.check("Los valores numéricos debe ser mayores o iguales a 0"
				, deudaTotal >= 0 && deudaPorcentajePIB >= 0 && deudaPerCapita >= 0);
		
		//Trocear cadena y checkear nº trozos
		Checkers.checkNoNull(cadena);
		String trozos[] = cadena.split(",");
		Checkers.check("La cadena está mal troceada", trozos.length==5);
		
		//Convertir cada trozo al tipo correspondiente
		String nombrePais = trozos[0].trim();
		Integer anyo = Integer.valueOf(trozos[1].trim());
		LocalDate fecha = LocalDate.of(anyo, 1, 1);
		Integer deudaTotal = Integer.valueOf(trozos[2].trim());
		Double deudaPorcentajePIB = Double.valueOf(trozos[3].trim());
		Integer deudaPerCapita = Integer.valueOf(trozos[4].trim());
		
		//Devolver el objeto
		this.nombrePais = nombrePais;
		this.fecha = fecha;
		this.deudaTotal = deudaTotal;
		this.deudaPorcentajePIB = deudaPorcentajePIB;
		this.deudaPerCapita = deudaPerCapita;
	}
	
	//GETTERS Y SETTERS

	public Integer getDeudaTotal() {
		return deudaTotal;
	}

	public void setDeudaTotal(Integer deudaTotal) {
		this.deudaTotal = deudaTotal;
	}

	public Double getDeudaPorcentajePIB() {
		return deudaPorcentajePIB;
	}

	public void setDeudaPorcentajePIB(Double deudaPorcentajePIB) {
		this.deudaPorcentajePIB = deudaPorcentajePIB;
	}

	public Integer getDeudaPerCapita() {
		return deudaPerCapita;
	}

	public void setDeudaPerCapita(Integer deudaPerCapita) {
		this.deudaPerCapita = deudaPerCapita;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	//PROPIEDADES DERIVADAS
	public Integer getPoblacionAproximada() {
		return (int) Math.ceil(getDeudaTotal() / getDeudaPerCapita());
	}
	
	public Integer getPIBAproximado() {
		double res = deudaTotal * (deudaPorcentajePIB / 100);
		return (int) Math.floor(res);
	}

	//ORDEN NATURAL
	public int compareTo(RegistroDeuda reg) {
		int res = getNombrePais().compareTo(reg.getNombrePais());
		if (res == 0) {
			res = getFecha().compareTo(reg.getFecha());
		}
		return res;
	}
	
	
	
	
	
	

}
