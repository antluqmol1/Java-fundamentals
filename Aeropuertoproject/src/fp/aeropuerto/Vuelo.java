package fp.aeropuerto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;


public class Vuelo implements Comparable<Vuelo>{
	private String destino;
	private Double precio;
	private Integer numPlazas;
	private Integer numPasajeros;
	private String codigo;
	private LocalDateTime fechaHora;
	private Duration duracion;
	private Integer numPlazasPrimera;
	private Double recargoPrecioPrimera;
	

	//Constructores

public Vuelo(String destino, Double precio, Integer numPlazas, Integer numPasajeros,
		String codigo, LocalDateTime fechaHora, Duration duracion, Integer numPlazasPrimera,
		Double recargoPrecioPrimera) {
	
	this.destino = destino;
	this.precio = precio;
	this.numPlazas = numPlazas;
	this.numPasajeros = numPasajeros;
	this.codigo = codigo;
	this.fechaHora = fechaHora;
	this.duracion = duracion;
	this.numPlazasPrimera = numPlazasPrimera;
	this.recargoPrecioPrimera = recargoPrecioPrimera;
	compruebaRestricciones();
}

public Vuelo (String s) {
String [] trozos =s.split(";");
Checkers.check("La cadena está mal troceada", trozos.length==9);
this.destino = trozos[0].trim();
this.precio = Double.valueOf(trozos[1].trim());
this.numPlazas = Integer.valueOf(trozos[2].trim());
this.numPasajeros = Integer.valueOf(trozos[3].trim());
this.codigo =trozos[4].trim();
this.fechaHora = LocalDateTime.parse(trozos[5].trim(),DateTimeFormatter.ofPattern("d/M/y-H:m"));
this.duracion = Duration.ofMinutes(Integer.valueOf(trozos[6].trim()));
this.numPlazasPrimera = Integer.valueOf(trozos[7].trim());
this.recargoPrecioPrimera =Double.valueOf(trozos[1].trim());
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public String getDestino() {
	return destino;
}


public void setDestino(String destino) {
	this.destino = destino;
}


public Double getPrecio() {
	return precio;
}


public void setPrecio(Double precio) {
	this.precio = precio;
}


public Integer getNumPlazas() {
	return numPlazas;
}


public void setNumPlazas(Integer numPlazas) {
	this.numPlazas = numPlazas;
}


public Integer getNumPasajeros() {
	return numPasajeros;
}


public void setNumPasajeros(Integer numPasajeros) {
	this.numPasajeros = numPasajeros;
}


public String getCodigo() {
	return codigo;
}


public void setCodigo(String codigo) {
	this.codigo = codigo;
}


public LocalDateTime getFechaHora() {
	return fechaHora;
}


public void setFechaHora(LocalDateTime fechaHora) {
	this.fechaHora = fechaHora;
}


public Duration getDuracion() {
	return duracion;
}


public void setDuracion(Duration duracion) {
	this.duracion = duracion;
}


public Integer getNumPlazasPrimera() {
	return numPlazasPrimera;
}


public void setNumPlazasPrimera(Integer numPlazasPrimera) {
	this.numPlazasPrimera = numPlazasPrimera;
}


public Double getRecargoPrecioPrimera() {
	return recargoPrecioPrimera;
}


public void setRecargoPrecioPrimera(Double recargoPrecioPrimera) {
	this.recargoPrecioPrimera = recargoPrecioPrimera;
}

public LocalDate getFecha() {
	return this.fechaHora.toLocalDate();
}


	//RESTRICCIONES

public void compruebaRestricciones() {
Checkers.checkNoNull(this.getNumPlazas(),this.getDestino(),this.getPrecio(),this.getNumPasajeros(),this.getCodigo(),
this.getCodigo(),this.getFechaHora(),this.getDuracion(),this.getNumPlazasPrimera(),this.getRecargoPrecioPrimera());

Checkers.check("El precio debe ser mayor de cero",this.getPrecio()>0);
Checkers.check("La duracion debe ser mayor que cero",this.getDuracion().toMinutes()>0);
Checkers.check("El recargo no puede ser negativo",this.recargoPrecioPrimera>0);
Checkers.check("Los pasajeros deben de ser positivos y menor al numero de plazas",this.numPasajeros>0 && this.numPlazas>0);

}

public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((destino == null) ? 0 : destino.hashCode());
result = prime * result + ((getFecha() == null) ? 0 : getFecha().hashCode());
return result;
}

public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Vuelo other = (Vuelo) obj;
if (destino == null) {
if (other.destino != null)
return false;
} else if (!destino.equals(other.destino))
return false;
if (getFecha() == null) {
if (other.getFecha() != null)
return false;
} else if (!getFecha().equals(other.getFecha()))
return false;
return true;
}


public int compareTo(Vuelo v) {
int res=this.getFecha().compareTo(v.getFecha());
if(res ==0) {
res=this.getDestino().compareTo(v.getDestino());
}
return res;
}


public String toString() {
return "\nVuelo [destino=" + destino + ", precio=" + precio + ", numPlazas=" + numPlazas + ", numPasajeros="
+ numPasajeros + ", codigo=" + codigo + ", fechaHora=" + fechaHora + ", duracion=" + duracion
+ ", numPlazasPrimera=" + numPlazasPrimera + ", recargoPrecioPrimera=" + recargoPrecioPrimera + "]\n";
}

}

