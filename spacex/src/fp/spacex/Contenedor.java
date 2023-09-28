package fp.spacex;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.TipoCliente;
import fp.utiles.Checkers;

public class Contenedor {
	
	//ATRIBUTOS
	
	private String nombre;
	private List<SpaceX> proyectos;
	
	
	//CONSTRUCTOR 1
	
	public Contenedor() {
		this.proyectos = new ArrayList<SpaceX>();
	}
	
	
	//CONSTRUCTOR 2
	public Contenedor(String nombre, List<SpaceX> pl) {
		this.nombre = "ProjectX";
		this.proyectos = new ArrayList<SpaceX>(pl);
	}
	
	//CONSTRUCTOR 3
	public Contenedor(Stream<SpaceX> ps) {
		this.nombre = "ProjectX";
		this.proyectos = ps.collect(Collectors.toList());
	}
	
	
	//CONSULTORES
	
	public String getNombre() {
		return nombre;
	}
	
	public List<SpaceX> getProyectos(){
		return new ArrayList<SpaceX>(this.proyectos);
	}
	
	
	//CRITERIO DE IGUALDAD
	
	@Override
	public int hashCode() {
		return Objects.hash(proyectos);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenedor other = (Contenedor) obj;
		return Objects.equals(proyectos, other.proyectos);
	}
	


	//REPRESENTACIÓN COMO CADENA
	
	public String toString() {
		return "Contenedor [proyectos=" + proyectos + "]";
	}
	
	
	//OPERACIONES

	//a) Obtener el número de elementos
	public Integer getNumeroProyectos() {
		return this.getProyectos().size();
	}
	
		//b) Añadir un elemento.
	public void incorporaProyecto(SpaceX proyecto) {
		if (!this.getProyectos().contains(proyecto)) {
			this.proyectos.add(proyecto);
		}
	}
	
		//c) Añadir una colección de elementos.
	public void incorporaProyectos(List<SpaceX> listaproyectos) {
		for (SpaceX proyecto:listaproyectos) {
			this.incorporaProyecto(proyecto);
		}
	}
	
		//d) Eliminar un elemento.
	public void eliminaProyecto(SpaceX proyecto) {
		if (this.getProyectos().contains(proyecto)) {
			this.proyectos.remove(proyecto);
		}
	}
	
	
	//TRATAMIENTOS SECUENCIALES
	
		//1.) Para todo
	public boolean paraTodaMisiónCumplida() {
		boolean res = true;
		for (SpaceX proyecto:this.getProyectos()) {
			if (proyecto.isMision_cumplida() != true) {
				res = false;
				break;
			}
		}
		return res;
	}
	
		//2.) Media
	public Double getSumaPesoCargaUtil() {
		Double res = 0d;
		for (SpaceX proyecto: this.getProyectos()) {
			if(proyecto.isMision_cumplida()==true) {
				res += proyecto.getPeso_carga_util();
			}
			
		}
		return res;
	}
	
	//DEFENSA
	
	public Double getMediaPesoCargaUtil() {
		int numeroproyectos = this.proyectos.size();
		Checkers.check("El valor del numero total de proyectos no puede ser 0 o menor que 0", numeroproyectos > 0);
		Double res = 0d;
		if (numeroproyectos>0) {
			res = getSumaPesoCargaUtil() / numeroproyectos;
		}
		return res;
	}
	
		//3.) Una selección con filtrado.
	public List<SpaceX> getNumeroDelVueloConMisiónCumplida() {
		List<SpaceX> res = new ArrayList<SpaceX>();
		for (SpaceX proyecto:this.getProyectos()) {
			
			if (proyecto.isMision_cumplida()) {
				res.add(proyecto);
			}
		}
		return res;
	}
	
		//4.) Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.  --> 
																												//	Lo he hecho con objetos de tipo String este; Con el tipo base está justo abajo.
	public Map<String, List<String>> getClientesPorVehiculo() {
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (SpaceX proyecto:this.getProyectos()) {
			String clave = proyecto.getTipo_del_vehiculo();
			if(!res.containsKey(clave)) {
				List<String> valor = new ArrayList<String>();
				valor.add(proyecto.getCliente());
				res.put(clave, valor);
			}	
			else {
				List<String> valor = res.get(clave);
				valor.add(proyecto.getCliente());
				res.put(clave, valor);
			}
		}
	return res;
	}
	
		//4.) Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.
	public Map<String, List<SpaceX>> getProyectosPorEmpresaCargaUtil() {
		Map<String, List<SpaceX>> res = new HashMap<String, List<SpaceX>>();
		for (SpaceX proyecto:this.getProyectos()) {
			String clave = proyecto.getEmpresa_carga_util();
			if(!res.containsKey(clave)) {
				List<SpaceX> valor = new ArrayList<SpaceX>();
				valor.add(proyecto);
				res.put(clave, valor);
			}	
			else {
				List<SpaceX> valor = res.get(clave);
				valor.add(proyecto);
				res.put(clave, valor);
			}
		}
	return res;
	}

	
	
		//5.) Un método de acumulación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que tienen como valor esa propiedad.
	public Map<String, Integer> getDiasEmpleadosPorTipoDeVehiculo() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for (SpaceX proyecto:this.getProyectos()) {
			String clave = proyecto.getTipo_del_vehiculo();
			if(!res.containsKey(clave)) {
				res.put(clave, proyecto.getDias_empleados_en_el_proyecto());
			}
			else {
				Integer valor = res.get(clave);
				valor += proyecto.getDias_empleados_en_el_proyecto();
				res.put(clave,  valor);
			}
		}
		return res;
	}
	
	//ENTREGA 3
	/*Bloque I: Implementar, documentar y probar CINCO métodos que trabajen sobre el dataset y respondan a preguntas interesantes
		A escoger uno de los dos siguientes: existe / para todo (el mismo implementado en la entrega 2, pero con streams).
		A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).
		Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).
		Un máximo/mínimo con filtrado.
		Una selección, con filtrado y ordenación.
	 */
	
	//MÉTODOS BLOQUE 1
	
	//A escoger uno de los dos siguientes: existe / para todo (el mismo implementado en la entrega 2, pero con streams).
	public Boolean existeTipodeVehiculoEnPaisCliente(String tipo_del_vehiculo, String pais_cliente) {
		return this.proyectos.stream()
				.filter(x -> x.getPais_cliente().equals(pais_cliente))
				.anyMatch(x -> x.getTipo_del_vehiculo().equals(tipo_del_vehiculo));
	}
	
	
	//A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).
	public Double calcularMediaPesoCargaUtil() {
		return this.proyectos.stream()
				.mapToDouble(x -> x.getPeso_carga_util())
				.average()
				.orElseThrow(()->new NoSuchElementException());
	}
	
	//Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).
	public List<SpaceX> filtraProyectosConMisiónCumplida() {
		return this.proyectos.stream()
				.filter(x -> x.isMision_cumplida() == Boolean.TRUE)
				.collect(Collectors.toList());
	}
	
	//Un máximo/mínimo con filtrado.
	public SpaceX maximoDeDíasEmpleadosSegunSitioDeLanzamiento(String sitio_de_lanzamiento) {
		return this.proyectos.stream()
				.filter(x -> x.getSitio_de_lanzamiento().equals(sitio_de_lanzamiento))
				.max(Comparator.comparing(SpaceX::getDias_empleados_en_el_proyecto))
				.get();
	}
	
    //Una selección, con filtrado y ordenación.
	public List<SpaceX> seleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora(TipoCliente tipo_de_cliente) {
		return this.proyectos.stream()
				.filter(x -> x.getTipo_de_cliente().equals(tipo_de_cliente))
				.sorted(Comparator.comparing(SpaceX::getFecha_de_lanzamiento).thenComparing(SpaceX::getHora_de_lanzamiento))
				.collect(Collectors.toList());
		
	}
	
	//MÉTODOS BLOQUE II
	
	//Los métodos (4) y (5) implementados en la entrega 2, pero con streams.
	public Map<String, List<SpaceX>> agrupaProyectosPorEmpresaCargaUtil() {
		return this.proyectos.stream()
				.collect(Collectors.groupingBy(SpaceX::getEmpresa_carga_util));
	}
	
	//DEFENSA
	public SortedMap<String, Double> agrupaDiasEmpleadosPorTipoDeVehiculo() {
		return this.proyectos.stream()
				.collect(Collectors.groupingBy(SpaceX::getTipo_del_vehiculo
						, TreeMap::new
						, Collectors.averagingInt(SpaceX::getDias_empleados_en_el_proyecto)));
	}
	
	//Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	public Map<Integer, SpaceX> agrupaProyectosConMenosPesoPorAño() {
		return this.proyectos.stream()
				.collect(Collectors.groupingBy(SpaceX::getAño_de_fecha
						, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(SpaceX::getPeso_carga_util))
								, min -> min.orElse(null))));
	}
	
	//Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y 
	//los valores son máximos/mínimos de los elementos que tienen ese valor.
	 public Map<String, SpaceX> agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil() {
		 return this.proyectos.stream()
				 .collect(Collectors.groupingBy(SpaceX::getÓrbita_carga_util
						 , Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(SpaceX::getDias_empleados_en_el_proyecto))
								 , max -> max.get())));
	 }
	 
	 //Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas
	 //con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	 
	 private static List<String> seleccionaAñosPorNDiasEmpleados(List<SpaceX> ls, int n) {
			return ls.stream()
					.sorted(Comparator.comparing(SpaceX -> ((fp.spacex.SpaceX) SpaceX).getDias_empleados_en_el_proyecto()).reversed())
					.limit(n)
					.map(SpaceX::getEmpresa_carga_util)
					//.map(SpaceX::Año_de_fecha)
					.collect(Collectors.toList());
		}
	 
	 
	 public SortedMap<String, List<String>> agrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(int n) {
		 return this.proyectos.stream()
				 .collect(Collectors.groupingBy(SpaceX::getTipo_carga_util
						 , TreeMap::new
						 , Collectors.collectingAndThen(
									Collectors.toList()
									, ls -> seleccionaAñosPorNDiasEmpleados(ls, n))));		 
	 }
	 
	 //Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	 public Entry<String, Double> obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto() {
		 return this.proyectos.stream()
				 .collect(Collectors.groupingBy(SpaceX -> SpaceX.getNumero_vuelo_del_vehiculo().substring(0, 2),
						 Collectors.averagingDouble(SpaceX::getDias_empleados_en_el_proyecto)))
				 .entrySet().stream()
				 .max(Comparator.comparing(Entry::getValue))
				 .orElseThrow();
	 }
	 
}