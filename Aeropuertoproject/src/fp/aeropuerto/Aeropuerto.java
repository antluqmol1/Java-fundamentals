package fp.aeropuerto;

import java.time.Duration;

import java.time.LocalDate;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Aeropuerto {
	private String nombre;
	private List<Vuelo> vuelos;
	
	public Aeropuerto(String nombre) {
		this.nombre=nombre;
		this.vuelos=new ArrayList<Vuelo>();
	}
	public String getNombre() {
		return this.nombre;
	}
	public List<Vuelo> getVuelos(){
		return new ArrayList<Vuelo>(this.vuelos);
	}
	public void a�adeVuelos(List<Vuelo> lv) {
		this.vuelos.addAll(lv);
	}
	public String toString() {
		return this.getNombre() + "-> [" +
				this.getVuelos().size() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
	//Enunciado 4
	
	
	/*	
		public Map<LocalDate, Double> promedioPreciosPorFecha() {
		}
		
		private static Double sumaPrecios(List<Double>precios) {
		
		}
		*/
		
		public Map<String,Integer> n�meroDeVuelosPorCompa�ia() {
			Map<String,Integer> res=new HashMap<String,Integer>();
			for (Vuelo v:this.getVuelos()) {
				String clave=v.getCodigo().substring(0,3);
				if(!res.containsKey(clave)) {
					res.put(clave, 1);
			}
			else {
				Integer valor=res.get(clave);
				valor++;
				res.put(clave, valor);
			}
			}
		return res;
		
		}
		public Map<String,List<String>> c�digosVuelosPorDestino() {
			Map<String,List<String>> res=new HashMap<String,List<String>>();
			for (Vuelo v:this.getVuelos()) {
				String clave=v.getDestino();
				if(!res.containsKey(clave)) {
					List<String> valor=new ArrayList<String>();
					valor.add(v.getCodigo());
					res.put(clave, valor);
				}
				else {
					List<String> valor=res.get(clave);
					valor.add(v.getCodigo());
					res.put(clave, valor);
			
				}
			} 
			return res;
		}
	
	
//Enunciado 5 Comparadores (apartado 12)
//a)
	
	public List<Vuelo> ordenaVuelosPorOrdenNatural(){
		//Collections.sort(this.getVuelos());   --> Sirve pa lo mismo
		List<Vuelo> lv = new ArrayList<Vuelo>(this.getVuelos());
		Comparator<Vuelo> cmp = Comparator.naturalOrder();
		Collections.sort(lv, cmp);
		return lv;
	}
	
//b)
	
	public List<Vuelo> ordenaVuelosPorFechaSalida(){
		List<Vuelo> lv = new ArrayList<Vuelo>(this.getVuelos());
		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getFecha);
		Collections.sort(lv, cmp);
		return lv;
	}
	
//c)
	public List<Vuelo> ordenaVuelosPorDestinoYFechaSalida(){
		List<Vuelo> lv = new ArrayList<Vuelo>(this.getVuelos());
		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getDestino).thenComparing(Vuelo::getFecha);
		Collections.sort(lv, cmp);
		return lv;
	}

//d)
	public List<Vuelo> ordenaVuelosPorNroPasajerosAlReves(){
		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getNumPasajeros).reversed();
		List<Vuelo> lv = new ArrayList<Vuelo>(this.getVuelos());
		Collections.sort(lv,cmp);
		return lv;
	}

//e)
	public List<Vuelo> ordenaVuelosPorDuracionYMayorNumeroPasajeros(){
		Comparator<Vuelo> cmp1 = Comparator.comparing(Vuelo::getDuracion);
		Comparator<Vuelo> cmp2 = Comparator.comparing(Vuelo::getNumPasajeros).reversed();
		Comparator<Vuelo> cmp = cmp1.thenComparing(cmp2);
		List<Vuelo> lv = new ArrayList<Vuelo>(this.getVuelos());
		Collections.sort(lv,cmp);
		return lv;
	}
	
//Apartado 13
	
	public int getN�merosVuelosADestino(String ciudad) {
		return (int)this.getVuelos().stream()
				.filter(v->v.getDestino().equals(ciudad))
				.count();
	}
	
	public int getN�mPasajerosADestino(String ciudad) {
		return this.getVuelos().stream()
				.filter(v->v.getDestino().equals(ciudad))
				.mapToInt(v->v.getNumPasajeros())
				.sum();
	}
	
	public Double getRecaudacionADestino(String ciudad) {
		return this.getVuelos().stream()
				.filter(v->v.getDestino().equals(ciudad))
				.mapToDouble(v->v.getNumPasajeros()*v.getPrecio())
				.sum();
	}
	
	public Double getPromedioPasajerosDeUnaFecha(LocalDate fecha) {
		return this.getVuelos().stream()
				.filter(v->v.getFecha().equals(fecha))
				.mapToDouble(v->v.getNumPasajeros())
				.average().orElse(0.00);
	}
	
	public String getCodigoPrimerVueloADestinoConPlazasLibres(String ciudad) {
		return this.getVuelos().stream()
				.filter(v->v.getDestino().equals(ciudad))
				.filter(v->v.getNumPlazas()>v.getNumPasajeros())
				.sorted(Comparator.comparing(Vuelo::getFechaHora))
				.findFirst().orElseThrow().getCodigo();
	}
	
	
	
	
	
	

//Apartado 15

//a
	public List<Vuelo> ListTresVuelosMasBaratos() {
		return this.getVuelos().stream()
				.sorted(Comparator.comparing(Vuelo::getPrecio))
				.limit(3)
				.collect(Collectors.toList());
		
	}

//b
	public List<Vuelo> getListaNVuelosMayorDuracion(int n) {
		return this.getVuelos().stream()
				.sorted(Comparator.comparing(Vuelo::getDuracion).reversed())
				.limit(n)
				.collect(Collectors.toList());
	}

//c
	public List<Vuelo> getListaVuelosOrdenadosFechaYNumPasajeros() {
		return this.getVuelos().stream()
				.sorted(Comparator.comparing(Vuelo::getFecha).thenComparing(Vuelo::getNumPasajeros))
				.collect(Collectors.toList());
	}

//d
	public SortedSet<String> getConjuntoOrdenadoDestinos() {
		return this.getVuelos().stream()
				.map(Vuelo::getDestino)
				.collect(Collectors.toCollection(TreeSet<String>::new));
				//.collect(Collectors.toCollection(()->new TreeSet<String>()));
	//En orden inverso -->    .collect(Collectors.toCollection(()->new TreeSet<String>(Comparator.reverseOrder())));
			
	}
	
//e
	public Map<String, List<Vuelo>> getMapListaVuelosPorDestinos() {
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino));
	}

//f
	public Map<LocalDate, Set<Vuelo>>getMapSetVuelosPorFecha() {
			 return this.vuelos.stream()
					 .collect(Collectors.groupingBy(x -> x.getFecha(),
							 Collectors.toCollection(() -> new HashSet<Vuelo>())));
	}

//g
	public Map<LocalDate, SortedSet<Vuelo>> getMapSetOrdenadoVuelosPorFecha() {			//por n�mero de pasajeros
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(x -> x.getFecha()
						, Collectors.toCollection(() -> new TreeSet<Vuelo>(Comparator.comparing(Vuelo::getNumPasajeros)))));
				
	}
		
//h
	public Map<LocalDate, Integer>getMapNumVuelosPorFecha() {
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha
						,Collectors.collectingAndThen(Collectors.counting(), cont -> cont.intValue())));
		
				
	}

//i
	public Map<String, Double> getMapPrecioMedioPorDestino() {
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(x -> x.getDestino()
						, Collectors.averagingDouble(x -> x.getPrecio())));
	}
		
		
//Apartado 16

//a)
	public Map<String, Vuelo> getMapVuelosCompletosM�sBaratoPorDestino() {
		return this.vuelos.stream()
				.filter(v->v.getNumPasajeros()>=v.getNumPlazas())
				.collect(Collectors.groupingBy(Vuelo::getDestino
						, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Vuelo::getPrecio))
						, x->x.orElse(null))));
		
	}
//b)
	public Map<String, String> getMapC�digoVuelosCompletosM�sBaratoPorDestino() {
		return this.vuelos.stream()
				.filter(v->v.getNumPasajeros()>=v.getNumPlazas())
				.collect(Collectors.groupingBy(Vuelo::getDestino
						, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Vuelo::getPrecio))
						, x->x.orElse(null).getCodigo())));
		}

//c)
	public SortedMap<Duration, Integer> getMapOrdenadoNumPasajerosPorDuraci�nDeCompa�ia(String compa��a) {
		return this.vuelos.stream()
				.filter(v->v.getCodigo().substring(0, 3).equals(compa��a))
				.collect(Collectors.groupingBy(Vuelo::getDuracion
						, () -> new TreeMap<>(Comparator.reverseOrder())
						, Collectors.summingInt(Vuelo::getNumPasajeros)));
			}
	
//d)
	public Map<String, Double> getMapPorcentajeVuelosPorDestino() {
		Map<String, Double> res = null;
		long totalVuelos = this.getVuelos().stream().count();
		if (totalVuelos>0) 
			res = this.getVuelos().stream()
					.collect(Collectors.groupingBy(Vuelo::getDestino
							, Collectors.collectingAndThen(Collectors.counting(), c->100.0*c/totalVuelos)));
			return res;
			}
//e)
	public String getSegundaCompa��aConMenosVuelos() {
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(v -> v.getCodigo().substring(0, 3), Collectors.counting()))
				.entrySet().stream()
				.sorted(Comparator.comparing(Entry -> Entry.getValue()))
					.skip(1)
					.findFirst().orElse(null).getKey();
			}

//Apartado 17
 //a)
	public String getDestinoConM�sVuelos() {
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino
						, Collectors.counting()))
				.entrySet().stream()
				.max(Comparator.comparing(Entry -> Entry.getValue()))
				.orElse(null).getKey();
	}
	
 //b)
	public LocalDate getFechaConM�sDestinosDiferentes() {
		Comparator <Entry<LocalDate,Integer>> cmp=Comparator.comparing(Entry::getValue);
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha
						, Collectors.collectingAndThen(Collectors.mapping(Vuelo::getDestino, Collectors.toSet())
								, c -> c.size())))
				.entrySet().stream()
				.max(Comparator.comparing(Entry::getValue))
				.orElseThrow(NoSuchElementException::new)
				.getKey();
	}
	
 //c)
	private static double promedioM�sCaroM�sMarato(List<Vuelo> lv) {
		double m�sCaro = lv.stream()
				.map(Vuelo::getPrecio)
				.max(Comparator.naturalOrder())
				.orElse(0d);
		double m�sBarato= lv.stream()
				.min(Comparator.comparing(Vuelo::getPrecio))
				.orElse(null).getPrecio();
		return (m�sCaro+m�sBarato)/2;
	}
	
	public SortedMap<String, Double> getPromedioM�sCaroYM�sBaratoPorDestino() {
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino,
						() -> new TreeMap<>(),
						Collectors.collectingAndThen(Collectors.toList(), l -> promedioM�sCaroM�sMarato(l))));
				
	}
	
 //d)
	private static List<String> seleccionaC�digosVuelos(List<Vuelo> lv, int n) {
		return lv.stream()
				.sorted(Comparator.comparing(Vuelo::getDuracion).reversed())
				.limit(n)
				.map(v -> v.getCodigo())
				.collect(Collectors.toList());
	}
	
	public Map<String, List<String>> getC�digosVuelosMasDuraci�nPorCompa�iaADestinoQueComienzaPor(String cadena, int n) {
		return this.vuelos.stream()
				.filter(v -> v.getDestino().startsWith(cadena))
				.collect(Collectors.groupingBy(Vuelo -> Vuelo.getCodigo().substring(0,3)
						, Collectors.collectingAndThen(
								Collectors.toList()
								, lv -> seleccionaC�digosVuelos(lv, n))));
	}

 //e)
	
	private static List<String> obtenerC�digos(List<Vuelo> lv) {
		List<String> res = new ArrayList<String>();
		res.add(lv.stream()
				.min(Comparator.comparing(Vuelo::getPrecio))
				.orElse(null).getCodigo());
		res.add(lv.stream()
				.max(Comparator.comparing(Vuelo::getPrecio))
				.orElse(null).getCodigo());
		return res;
	}
	
	public Map<String, List<String>> getC�digosVueloM�sBaratoYM�sCaroPorCompa��a() {
		return this.vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo -> Vuelo.getCodigo().substring(0,3)
						, Collectors.collectingAndThen(
								Collectors.toList()
								, lv -> obtenerC�digos(lv))));
	}
	
}
	
