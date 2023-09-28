package fp.aeropuerto;
import java.util.*;

public class RedDeAeropuertos {
	private String denominación;
	private List<Aeropuerto> aeropuertos;
	
	public RedDeAeropuertos(String denominación) {
		this.denominación = denominación;
		this.aeropuertos = new ArrayList<Aeropuerto>();
	}
	public void añadeAeropuerto(Aeropuerto la) {
		this.aeropuertos.add(la); 
	}
	public String getDenominación() {
		return denominación;
	}
	public List<Aeropuerto> getAeropuertos() {
		return new ArrayList<Aeropuerto> (aeropuertos);
	}

	public String toString() {
		return "RedDeAeropuertos [denominación=" + denominación +
				"("+this.getAeropuertos().size()+")]";
	}

//Apartado 14.a)

	public int getNúmeroVuelosADestino(String ciudad) {
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
