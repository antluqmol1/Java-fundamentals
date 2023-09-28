# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21 - 22)
Autor: Antonio Manuel Luque Molina   uvus: antluqmol1

Este proyecto trata de un dataset acerca de los distintos proyectos de Elon Musk con su empresa SpaceX desde el 2006 hasta ahora.

## Estructura de las carpetas del proyecto

* **src**: Contiene los diferentes archivos que forman parte del proyecto. Está estructurado en los siguentes paquetes:

  -> *fp.spacex*: Paquete que contiene el tipo SpaceX del proyecto, el tipo Factoría y el tipo Contenedor.

  -> *fp.spacex.test*: Paquete que contiene las clases de test del proyecto, ahora mismo: SpaceXTest y SaceXTest2.

  -> *fp.common*: Paquete que contiene los tipos auxiliares del proyecto, ahora mismo el enumerado: "TipoCliente".

  -> *fp.utiles*:  Paquete que contiene las clases de utilidad., en este caso la clase Checkers


* **data**: Contiene el dataset del proyecto.

  -> *SpaceXDef.csv*: Es el csv del proyecto de la forma:String, LocalDate, LocalTime, LocalDateTime, String, String, String, Double, String,
    		String, TipoCliente, String, Boolean, String, String, Integer.

* **doc**: Contiene el README del proyecto.

  -> *README.md*
    
## Estructura del dataset

URL del dataset original: http://kaggle.com/spacex/spacex-missions

El dataset usado en este proyecto está compuesto por 42 filas y 16 columnas, con la siguiente descripción:

* *Flight Number*: de tipo String, representa todos los vuelos de las distintas naves, de la forma: nombre de la nave (de forma abreviada) - número del vuelo.

* *Launch Date*: de tipo LocalDate, representa la fecha de lanzamiento de las respectivas naves, de la forma:("d MMMM yyyy").

* *Launch Time*: de tipo LocalTime, representa la hora en la que se produjo el lanzamiento de cada nave, de la forma: ("H:mm").

* *Launch DateTime*: de tipo LocalDateTime, representa la fecha y hora de lanzamiento de las respectivas naves, de la forma:("d MMMM yyyy - H:mm"").

* *Vehicle Type*: de tipo String, representa el tipo de nave que es, con vehiculo se refiere a nave.

* *Payload Name*: de tipo String, representa el nombre de la carga útil, que son todos los elementos del RPAS que no son necesarios para volar pero que son transportados para el cumplimiento de la misión específica que tienen encomendada.

* *Payload Type*: de tipo String, representa el tipo de la carga útil.

* *Payload Mass (kg)*: de tipo Double, representa el peso en kg de las respectivas cargas útiles.

* *Payload Orbit*: de tipo String, representa la órbita a la que ha sido enviada esa carga útil.

* *Customer Name*: de tipo String, representa el nombre de los respectivos clientes, en este caso empresas.

* *Customer Type*: de tipo TipoCliente,(enum) representa el tipo de cliente que es; puede ser: Government, Business o Unknown si el parámetro es nulo.

* *Customer Country*: de tipo String, representa el país del que es cada cliente.

* *Mission Accomplished*: de tipo Boolean, representa si la misión ha tenido éxito o no.

* *Failure Reason*: de tipo String, representa la razón del fallo, en caso de no haber sido cumplida la misión.

* *Launch Site*: de tipo String, representa el sitio desde donde se ha producido el lanzamient al espacio.

* *Days Project*: de tipo Integer, representa los días totales que se han necesitado para cada proyecto.

* *List 4 Best Investors*: de tipo List<String>, representa las 4 personas que más dinero han invertido en el proyecto.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - SpaceX
Representa un registro base del csv.

**Propiedades**:

- numero_vuelo_del_vehiculo, de tipo String, consultable y modificable.
- fecha_de_lanzamiento, de tipo LocalDate, consultable y modificable.
- hora_de_lanzamiento, de tipo LocalTime, consultable y modificable.
- fecha_y_hora_de_lanzamiento, de tipo LocalDateTime, consultable y DERIVADA. 
- tipo_del_vehiculo, de tipo String, consultable y modificable.
- empresa_carga_util, de tipo String, consultable y modificable.
- tipo_carga_util, de tipo String, consultable y modificable.
- peso_carga_util, de tipo Double, consultable y modificable.
- órbita_carga_util, de tipo String, consultable y modificable.
- cliente, de tipo String, consultable y modificable.
- tipo_de_cliente, de tipo TipoCliente,(enum), consultable y modificable.
- pais_cliente, de tipo String, consultable y modificable.
- mision_cumplida, de tipo Boolean, consultable y modificable.
- razón_del_fallo, de tipo String, consultable y modificable.
- sitio_de_lanzamiento, de tipo String, consultable y modificable.
- dias_empleados_en_el_proyecto, de tipo Integer, consultable y modificable.
- lista_4_mejores_inversores, de tipo List<String>, consultable y modificable.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Nba a partir de los siguientes parámetros: String numero_vuelo_del_vehiculo, LocalDateTime 			fecha_y_hora_de_lanzamiento, LocalTime hora_de_lanzamiento, String empresa_carga_util, String tipo_carga_util, 
			Double peso_carga_util, String órbita_carga_util, String pais_cliente, String cliente, String sitio_de_lanzamiento, 
			String tipo_del_vehiculo, Integer dias_empleados_en_el_proyecto, List<String> lista_4_mejores_inversores.
		Los valores que no quedan inicializados son inializados de la siguiente forma:
			this.fecha_de_lanzamiento = LocalDate.of(2012, Month.OCTOBER, 8);
			this.tipo_de_cliente = TipoCliente.Government;
			this.mision_cumplida = true;
			this.razón_del_fallo = null;

**Restricciones**:
 
- R1: EL año no puede ser inferior a 2006.
- R2: El tipo de cliente no puede ser distinto de: Government, Bussiness o Unknown
- R3: El tipo de la carga útil no puede tener el valor nulo.
- R4: El peso de la carga útil no puede tener el valor nulo.
- R3: La órbita de la carga útil no puede tener el valor nulo.
- R4: Los días empleados en el proyecto no puede tener el valor nulo.

**Criterio de igualdad**: Dos registros son iguales las propiedades: cliente, dias_empleados_en_el_proyecto, empresa_carga_util, fecha_de_lanzamiento,
				fecha_y_hora_de_lanzamiento, hora_de_lanzamiento, numero_vuelo_del_vehiculo, peso_carga_util, sitio_de_lanzamiento, tipo_carga_util, tipo_del_vehiculo y
				órbita_carga_util son iguales.

**Criterio de ordenación**: Se ordena por: cliente, dias_empleados_en_el_proyecto, empresa_carga_util, fecha_de_lanzamiento, fecha_y_hora_de_lanzamiento, 
				hora_de_lanzamiento, numero_vuelo_del_vehiculo, peso_carga_util, sitio_de_lanzamiento, tipo_carga_util, tipo_del_vehiculo, órbita_carga_util.

**Otras operaciones**:
 
- getAño_de_fecha(), de tipo \<Integer\>,  devuelve el año de una determinada fecha.


#### Tipo auxiliar o Lista


•lista_4_mejores_inversores, de tipo \<List<String>\>, consultable y modificable.
•clientes, de tipo \<List<String>\>, consultable y modificable.

**Otras operaciones**:
- getClientesOrdenadosYSinRepetir(), de tipo \<SortedSet<String>\>, devuelve la lista de clientes de forma ordenada y sin repetición.
- getClientesSinRepeticionNiNulos(), de tipo \<HashSet<String>\>, devuelve la lista de clientes sin repetición ni elementos nulos.
- getNumeroDeClientes(), de tipo \<Integer\>, devuelve el tamaño de la lista de clientes sin repetición ni elementos nulos.

### Factoría
- leerSpaceX: Lee el csv y añade en una lista, inicialmente vacía, todos los reistros del tipo SpaceX.
- stringASpaceX: Parsea de string a los distintos tipos de atributos de los nacimientos.
- getLista_4_mejores_inversores: Parsea de una cadena de tipo String a una ArrayList<String>.

### Tipo Contenedor

**Propiedades**:

- nombre, de tipo String, consultable. 
- proyectos, de tipo List<SpaceX>, consultable y modificable. 


**Constructores**: 

- C1: Crea un objeto de tipo contenedor sin ningún elemento en la colección
- C2: Crea un objeto del tipo contenedor a partir de los parámetros String nombre y List<SpaceX> proyectos, con todos los elementos de la colección.

**Restricciones**:
 
- R1: En la factoría, el fichero no puede tener el valor nulo.
- R2: En el contenedor, el valor del numero total de proyectos no puede ser 0 o menor que 0
- ...
- 
**Criterio de igualdad**: Dos proyectos son iguales si lo son sus nombres. 

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
- getNumeroProyectos: Devuelve el número de proyectos.
- incorporaProyecto: Añade un proyecto a la lista.
- incorporaProyectos: Añade una lista de proyectos a la lista.
- eliminaProyecto: Elimina un proyecto de la lista.
- paraTodaMisiónCumplida: Comprueba si todos los proyectos han cumplido la misión.
- getSumaPesoCargaUtil: Suma todos los pesos de la carga útil para posteriormente hacer la media.
- getMediaPesoCargaUtil: Hace la media de todos los pesos de las respectivas cargas útiles.
- getNumeroDelVueloConMisiónCumplida: Añade a una lista todos los proyectos que han cumplido la misión.
- getClientesPorVehiculo: Añade a un map cada vehiculo vendido a sus respectivos clientes.
- getProyectosPorEmpresaCargaUtil: Añade a un map cada proyecto relacionado con su empresa de carga útil.
- getDiasEmpleadosPorTipoDeVehiculo: Añade a un map el tipo del vehículo con sus respectivos dias empleados para su fabricación.

**Métodos implementados con Stream**:

**BLOQUE I**

-    existeTipodeVehiculoEnPaisCliente(String tipo_del_vehiculo, String pais_cliente): lleva a cabo la misma tarea que paraTodaMisiónCumplida(), pero mediante streams

-    calcularMediaPesoCargaUtil() : lleva a cabo la misma tarea que getMediaPesoCargaUtil(), pero mediante streams

-    filtraProyectosConMisiónCumplida(): lleva a cabo la misma tarea que getNumeroDelVueloConMisiónCumplida(), pero mediante streams

-    maximoDeDíasEmpleadosSegunSitioDeLanzamiento(String sitio_de_lanzamiento): obtiene el proyecto con el máximo de días empleados filtrando por el sitio de lanzamiento

-    seleccionaProyectosSegunTipoDeClienteOrdenadosPorFechaYHora: obtiene una lista con los proyectos ordenados por la fecha y hora de lanzamiento y filtrados por el tipo de cliente.

**BLOQUE II**


-    agrupaProyectosPorEmpresaCargaUtil(): lleva a cabo la misma tarea que getProyectosPorEmpresaCargaUtil() , pero mediante streams

-    agrupaDiasEmpleadosPorTipoDeVehiculo(): lleva a cabo la misma tarea que getDiasEmpleadosPorTipoDeVehiculo(), pero mediante streams

-    agrupaProyectosConMenosPesoPorAño(): devuelve un mapa que hace corresponder a cada año el proyecto con el mínimo peso de carga útil

-    agrupaProyectosConMasDiasEmpleadosPorÓrbitaCargaÚtil(): obtiene un mapa que por cada órbita devuelve el proyecto con los máximos de los días empleados

-    agrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(int n): obtiene un mapa ordenado por el orden natural que por cada tipo de carga útil decuelve una lista con las n empresas con más días empleados 

-    obtenNumeroVueloDelVehiculoConLaMayorMediaDeDiasEmpleadosEnElProyecto(): obtiene el numero del vehiculo con la mayor media de dias empleados en el proyecto de todo el Map. Como no se indica correctamente si se quiere obtener solo la clave o el par (clave, valor) yo he obtenido el par para que quede más presentable, pero si se quisiese obtener la clave bastaría con poner al final el método getKey

**Funciones auxiliares**

-    seleccionaAñosPorNDiasEmpleados(List<SpaceX> ls, int n): obtiene una lista con las empresas de carga útil ordenado con los n mayores dias empleados que le pasaremos al método agrupaNEmpresasDeCargaÚtilConMásDiasEmpleadosPorTipoCargaÚtil(int n)
