package fp.aeropuerto;
import java.util.*;

public class RedDeAeropuertos {
	private String denominaci�n;
	private List<Aeropuerto> aeropuertos;
	
	public RedDeAeropuertos(String denominaci�n) {
		this.denominaci�n = denominaci�n;
		this.aeropuertos = new ArrayList<Aeropuerto>();
	}
	public void a�adeAeropuerto(Aeropuerto la) {
		this.aeropuertos.add(la); 
	}
	public String getDenominaci�n() {
		return denominaci�n;
	}
	public List<Aeropuerto> getAeropuertos() {
		return new ArrayList<Aeropuerto> (aeropuertos);
	}

	public String toString() {
		return "RedDeAeropuertos [denominaci�n=" + denominaci�n +
				"("+this.getAeropuertos().size()+")]";
	}

//Apartado 14.a)

	public int getN�meroVuelosADestino(String ciudad) {
		return (int)this.getAeropuertos().stream()
				.flatMap(a->a.getVuelos().stream())
				.filter(v->v.getDestino().equals(ciudad))
				.count();
	}

//Apartado 14.b)
	public double getPromedioPlazasVuelosCompletos() {
		return this.getAeropuertos().stream()
				.flatMap(a->a.getVuelos().stream())
				.filter(v->v.getNumPasajeros()>=v.getNumPlazas())
				.mapToDouble(Vuelo::getNumPlazas)
				.average().orElse(-1);
	}
	
//Apartado 154.a)
	
	
}
