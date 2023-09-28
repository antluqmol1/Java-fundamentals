package fp.spacex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.common.TipoCliente;
import fp.utiles.Checkers;

public class SpaceX implements Comparable<SpaceX>{
	
	//ATRIBUTOS
	
	private String numero_vuelo_del_vehiculo;
	private LocalDate fecha_de_lanzamiento;
	private LocalTime hora_de_lanzamiento;
	private LocalDateTime fecha_y_hora_de_lanzamiento;
	private String tipo_del_vehiculo;
	private String empresa_carga_util;
	private String tipo_carga_util;
	private Double peso_carga_util;
	private String órbita_carga_util;
	private String cliente;
	private TipoCliente tipo_de_cliente;
	private String pais_cliente;
	private boolean mision_cumplida;
	private String razón_del_fallo;
	private String sitio_de_lanzamiento;
	private Integer dias_empleados_en_el_proyecto;
	private List<String> lista_4_mejores_inversores;
	private List<String> clientes;
	
	
	//CONSTRUCTOR 1
	
	public SpaceX(String numero_vuelo_del_vehiculo, LocalDate fecha_de_lanzamiento, LocalTime hora_de_lanzamiento,
			LocalDateTime fecha_y_hora_de_lanzamiento, String tipo_del_vehiculo, String empresa_carga_util,
			String tipo_carga_util, Double peso_carga_util, String órbita_carga_util, String cliente,
			TipoCliente tipo_de_cliente, String pais_cliente, boolean mision_cumplida, String razón_del_fallo,
			String sitio_de_lanzamiento, Integer dias_empleados_en_el_proyecto, List<String> lista_4_mejores_inversores) {
		super();
		
		//RESTRICCIONES CONSTRUCTOR 1
		Checkers.check("EL año no puede ser inferior a 2006", fecha_de_lanzamiento.getYear() >= 2006);
		Checkers.check("El tipo de cliente no puede ser distinto de: Government, Bussiness o Unknown", tipo_de_cliente == TipoCliente.Government 
																						|| tipo_de_cliente == TipoCliente.Business || tipo_de_cliente == TipoCliente.Unknown);
		Checkers.checkNoNull(tipo_carga_util);
		Checkers.checkNoNull(peso_carga_util);
		Checkers.checkNoNull(órbita_carga_util);
		Checkers.checkNoNull(dias_empleados_en_el_proyecto);
		
		//DEFENSA
		Checkers.check("EL atributo numero_vuelo_del_vehiculo debe comenzar por A y tener 10 caracteres", numero_vuelo_del_vehiculo.startsWith("A")
																													&& numero_vuelo_del_vehiculo.length() == 10);
		
		this.numero_vuelo_del_vehiculo = numero_vuelo_del_vehiculo;
		this.fecha_de_lanzamiento = LocalDate.of(2012, Month.OCTOBER, 8);
		this.hora_de_lanzamiento = hora_de_lanzamiento;
		this.fecha_y_hora_de_lanzamiento = fecha_y_hora_de_lanzamiento;
		this.tipo_del_vehiculo = tipo_del_vehiculo;
		this.empresa_carga_util = empresa_carga_util;
		this.tipo_carga_util = tipo_carga_util;
		this.peso_carga_util = peso_carga_util;
		this.órbita_carga_util = órbita_carga_util;
		this.cliente = cliente;
		this.tipo_de_cliente = tipo_de_cliente;
		this.pais_cliente = pais_cliente;
		this.mision_cumplida = mision_cumplida;
		this.razón_del_fallo = razón_del_fallo;
		this.sitio_de_lanzamiento = sitio_de_lanzamiento;
		this.dias_empleados_en_el_proyecto = dias_empleados_en_el_proyecto;
		this.lista_4_mejores_inversores = new ArrayList<String>(lista_4_mejores_inversores);
		this.clientes = new ArrayList<String>();
		
	}
	
	//CONSTRUCTOR 2

	public SpaceX(String numero_vuelo_del_vehiculo, LocalDateTime fecha_y_hora_de_lanzamiento, LocalTime hora_de_lanzamiento,
			String empresa_carga_util, String tipo_carga_util, Double peso_carga_util, String órbita_carga_util,
			String pais_cliente, String cliente, String sitio_de_lanzamiento, String tipo_del_vehiculo,
			Integer dias_empleados_en_el_proyecto, List<String> lista_4_mejores_inversores) {
		super();
		
		//RESTRICCIONES CONSTRUCTOR 2
		Checkers.checkNoNull(tipo_carga_util);
		Checkers.checkNoNull(peso_carga_util);
		Checkers.checkNoNull(órbita_carga_util);
		Checkers.checkNoNull(dias_empleados_en_el_proyecto);
		Checkers.check("EL atributo numero_vuelo_del_vehiculo debe comenzar por A y tener 10 caracteres", numero_vuelo_del_vehiculo.charAt(0) == 'A'
				|| numero_vuelo_del_vehiculo.length() == 10);

		this.numero_vuelo_del_vehiculo = numero_vuelo_del_vehiculo;
		this.fecha_de_lanzamiento = LocalDate.of(2012, Month.OCTOBER, 8);
		this.hora_de_lanzamiento = hora_de_lanzamiento;
		this.fecha_y_hora_de_lanzamiento = fecha_y_hora_de_lanzamiento;
		this.tipo_del_vehiculo = tipo_del_vehiculo;
		this.empresa_carga_util = empresa_carga_util;
		this.tipo_carga_util = tipo_carga_util;
		this.peso_carga_util = peso_carga_util;
		this.órbita_carga_util = órbita_carga_util;
		this.cliente = cliente;
		this.tipo_de_cliente = TipoCliente.Government;
		this.pais_cliente = pais_cliente;
		this.mision_cumplida = true;
		this.razón_del_fallo = null;
		this.sitio_de_lanzamiento = sitio_de_lanzamiento;
		this.dias_empleados_en_el_proyecto = dias_empleados_en_el_proyecto;
		this.lista_4_mejores_inversores = new ArrayList<String>();
		this.clientes = new ArrayList<String>();
		
	}

	//MÉTODOS - GETTERS Y SETTERS

	public String getNumero_vuelo_del_vehiculo() {
		return numero_vuelo_del_vehiculo;
	}


	public void setNumero_vuelo_del_vehiculo(String numero_vuelo_del_vehiculo) {
		Checkers.check("EL atributo numero_vuelo_del_vehiculo debe comenzar por A y tener 10 caracteres", numero_vuelo_del_vehiculo.charAt(0) == 'A'
				|| numero_vuelo_del_vehiculo.length() == 10);
		this.numero_vuelo_del_vehiculo = numero_vuelo_del_vehiculo;
	}


	public LocalDate getFecha_de_lanzamiento() {
		return fecha_de_lanzamiento;
	}


	public void setFecha_de_lanzamiento(LocalDate fecha_de_lanzamiento) {
		Checkers.check("EL año no puede ser inferior a 2006", getAño_de_fecha() >= 2006);
		this.fecha_de_lanzamiento = fecha_de_lanzamiento;
	}


	public LocalTime getHora_de_lanzamiento() {
		return hora_de_lanzamiento;
	}


	public void setHora_de_lanzamiento(LocalTime hora_de_lanzamiento) {
		this.hora_de_lanzamiento = hora_de_lanzamiento;
	}


	public String getTipo_del_vehiculo() {
		return tipo_del_vehiculo;
	}


	public void setTipo_del_vehiculo(String tipo_del_vehiculo) {
		this.tipo_del_vehiculo = tipo_del_vehiculo;
	}


	public String getEmpresa_carga_util() {
		return empresa_carga_util;
	}


	public void setEmpresa_carga_util(String empresa_carga_util) {
		this.empresa_carga_util = empresa_carga_util;
	}


	public String getTipo_carga_util() {
		return tipo_carga_util;
	}


	public void setTipo_carga_util(String tipo_carga_util) {
		Checkers.checkNoNull(tipo_carga_util);
		this.tipo_carga_util = tipo_carga_util;
	}


	public Double getPeso_carga_util() {
		return peso_carga_util;
	}


	public void setPeso_carga_util(Double peso_carga_util) {
		Checkers.checkNoNull(peso_carga_util);
		this.peso_carga_util = peso_carga_util;
	}


	public String getÓrbita_carga_util() {
		return órbita_carga_util;
	}


	public void setÓrbita_carga_util(String órbita_carga_util) {
		Checkers.checkNoNull(órbita_carga_util);
		this.órbita_carga_util = órbita_carga_util;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public TipoCliente getTipo_de_cliente() {
		return tipo_de_cliente;
	}


	public void setTipo_de_cliente(TipoCliente tipo_de_cliente) {
		Checkers.check("El tipo de cliente no puede ser distinto de: Government o Bussiness", tipo_de_cliente == TipoCliente.Government 
				|| tipo_de_cliente == TipoCliente.Business || tipo_de_cliente == TipoCliente.Unknown);
		this.tipo_de_cliente = tipo_de_cliente;
	}


	public String getPais_cliente() {
		return pais_cliente;
	}


	public void setPais_cliente(String pais_cliente) {
		this.pais_cliente = pais_cliente;
	}


	public boolean isMision_cumplida() {
		return mision_cumplida;
	}


	public void setMision_cumplida(boolean mision_cumplida) {
		this.mision_cumplida = mision_cumplida;
	}


	public String getRazón_del_fallo() {
		return razón_del_fallo;
	}


	public void setRazón_del_fallo(String razón_del_fallo) {
		this.razón_del_fallo = razón_del_fallo;
	}


	public String getSitio_de_lanzamiento() {
		return sitio_de_lanzamiento;
	}


	public void setSitio_de_lanzamiento(String sitio_de_lanzamiento) {
		this.sitio_de_lanzamiento = sitio_de_lanzamiento;
	}


	public Integer getDias_empleados_en_el_proyecto() {
		return dias_empleados_en_el_proyecto;
	}


	public void setDias_empleados_en_el_proyecto(Integer dias_empleados_en_el_proyecto) {
		Checkers.checkNoNull(dias_empleados_en_el_proyecto);
		this.dias_empleados_en_el_proyecto = dias_empleados_en_el_proyecto;
	}
	
	public List<String> getLista_4_mejores_inversores() {
		return new ArrayList<String>(this.lista_4_mejores_inversores);
	}
	
	public void setLista_4_mejores_inversores(List<String> lista_4_mejores_inversores) {
		this.lista_4_mejores_inversores = lista_4_mejores_inversores;
	}
	
	public List<String> getClientes() {
		return new ArrayList<String>(this.clientes);
	}
	
	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}
	

	
	//PROPIEDAD DERIVADA
	
	public LocalDateTime getFecha_y_hora_de_lanzamiento() {
		return LocalDateTime.parse(fecha_de_lanzamiento + " - " + hora_de_lanzamiento, DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm").withLocale( Locale.US ));
	}
	
	
	//OTRAS OPERACIONES
	
	public Integer getAño_de_fecha() {
		return fecha_de_lanzamiento.getYear();
	}
	
	public SortedSet<String> getClientesOrdenadosYSinRepetir(){
		return new TreeSet<String>(getClientes());
	}
	public HashSet<String> getClientesSinRepeticionNiNulos() {
		HashSet<String> conjunto = new HashSet<String>();
		conjunto.addAll(getClientes());
		for (String elemento : conjunto) {
			if ( elemento.isEmpty()) {
				conjunto.remove(elemento);
				break;
			}
		}
		return conjunto;
	}
	
	public Integer getNumeroDeClientes() {
		return getClientesSinRepeticionNiNulos().size();
	}


	//REPRESENTACIÓN COMO CADENA
	
	public String toString() {
		return "SpaceX [Numero del vuelo: " + numero_vuelo_del_vehiculo + ", Fecha de lanzamiento: "
				+ fecha_de_lanzamiento + ", Hora de lanzamiento: " + hora_de_lanzamiento
				+ ", Fecha y hora de lanzamiento: " + fecha_y_hora_de_lanzamiento + ", Tipo del vehiculo: "
				+ tipo_del_vehiculo + ", Empresa de la carga útil: " + empresa_carga_util + ", Tipo de la carga útil: "
				+ tipo_carga_util + ", Peso de la carga útil: " + peso_carga_util + ", Órbita de la carga útil: " + órbita_carga_util
				+ ", Cliente: " + cliente + ", Tipo de cliente: " + tipo_de_cliente + ", País del cliente: " + pais_cliente
				+ ", Misión cumplida: " + mision_cumplida + ", Razón del fallo: " + razón_del_fallo
				+ ", Sitio del lanzamiento: " + sitio_de_lanzamiento + ", Días empleados en el proyecto="
				+ dias_empleados_en_el_proyecto + ", Lista de los 4 que más dinero han invertido: "
				+ lista_4_mejores_inversores + "]";
	}


	//CRITERIO DE IGUALDAD
	
	public int hashCode() {
		return Objects.hash(cliente, dias_empleados_en_el_proyecto, empresa_carga_util, fecha_de_lanzamiento,
				fecha_y_hora_de_lanzamiento, hora_de_lanzamiento, numero_vuelo_del_vehiculo, peso_carga_util,
				sitio_de_lanzamiento, tipo_carga_util, tipo_del_vehiculo, órbita_carga_util);
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceX other = (SpaceX) obj;
		return Objects.equals(cliente, other.cliente)
				&& Objects.equals(dias_empleados_en_el_proyecto, other.dias_empleados_en_el_proyecto)
				&& Objects.equals(empresa_carga_util, other.empresa_carga_util)
				&& Objects.equals(fecha_de_lanzamiento, other.fecha_de_lanzamiento)
				&& Objects.equals(fecha_y_hora_de_lanzamiento, other.fecha_y_hora_de_lanzamiento)
				&& Objects.equals(hora_de_lanzamiento, other.hora_de_lanzamiento)
				&& Objects.equals(numero_vuelo_del_vehiculo, other.numero_vuelo_del_vehiculo)
				&& Objects.equals(peso_carga_util, other.peso_carga_util)
				&& Objects.equals(sitio_de_lanzamiento, other.sitio_de_lanzamiento)
				&& Objects.equals(tipo_carga_util, other.tipo_carga_util)
				&& Objects.equals(tipo_del_vehiculo, other.tipo_del_vehiculo)
				&& Objects.equals(órbita_carga_util, other.órbita_carga_util);
	}

	
	//ORDEN NATURAL

	public int compareTo(SpaceX proyecto) {
		int r;
		if (proyecto == null) {
			throw new NullPointerException();
		}
		r = getFecha_y_hora_de_lanzamiento().compareTo(proyecto.getFecha_y_hora_de_lanzamiento());
		if (r == 0) {
			r = getNumero_vuelo_del_vehiculo().compareTo(proyecto.getNumero_vuelo_del_vehiculo());
			if (r == 0) {
				r = getTipo_del_vehiculo().compareTo(proyecto.getTipo_del_vehiculo());
				if (r==0) {
					r = getEmpresa_carga_util().compareTo(proyecto.getEmpresa_carga_util());
					if (r==0) {
						r = getTipo_carga_util().compareTo(proyecto.getTipo_carga_util());
						if (r == 0) {
							r = getPeso_carga_util().compareTo(proyecto.getPeso_carga_util());
							if (r==0) {
								r = getÓrbita_carga_util().compareTo(proyecto.getÓrbita_carga_util());
								if (r == 0) {
									r = getCliente().compareTo(proyecto.getCliente());
									if (r==0) {
										r = getSitio_de_lanzamiento().compareTo(proyecto.getSitio_de_lanzamiento());
										if (r==0) {
											r = getDias_empleados_en_el_proyecto().compareTo(proyecto.getDias_empleados_en_el_proyecto());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return r;
	}

	
	
	
	
	
	
	

}
