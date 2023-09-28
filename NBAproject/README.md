# Proyecto del Segundo Cuatrimestre Fundamentos de Programaci�n (Curso  \<21\>/\<22\>)
Autor/a: \<Antonio Manuel Luque Molina\>   uvus:\<antluqmol1\>

Este proyecto trata de un dataset acerca de los jugadores de la semana de la NBA desde el 1979 hasta ahora.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Est� estructurado en los siguentes paquetes:
  * **fp.\<nba\>**: Paquete que contiene el tipo Nba del proyecto.
  * **fp.\<nba.test\>**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto, ahora mismo los enumerados: "Conferencia" y "Posicion".
  * **fp.utiles**:  Paquete que contiene las clases de utilidad., en este caso la clase Checkers
* **/data**: Contiene el dataset del proyecto.
    * **\<NBA.csv\>**: Es el csv del proyecto de la forma:String, String, enum, LocalDate,
     enum, double, int, int, int, int, int, String, int, int, Boolean.
* **/doc**: Contiene el README del proyecto.
	* **\<README.md\>**: Es el csv del proyecto de la forma:String, String, enum, LocalDate,
    
## Estructura del *dataset*

URL del dataset original: https://www.kaggle.com/jacobbaruch/nba-player-of-the-week
Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset usado en este proyecto est� compuesto por \<844\> filas y \<15\> columnas, con la siguiente descripci�n:

* **\<Player>**: de tipo \<String\>, representa todos los jugadores de la NBA
* **\<Team>**: de tipo \<String\>, representa todos los equipos de la NBA
* **\<Conference>**: de tipo \<Conferencia\>(enum), representa la conferencia de la NBA
* **\<Date>**: de tipo \<LocalDate\>, representa las fechas de los partidos de la NBA, de la forma:(yyyy-mm-dd)
* **\<Position>**: de tipo \<Posicion\>(enum), representa las posiciones de todos los jugadores de la NBA
* **\<Height>**: de tipo \<Double\>, representa todas las alturas (en pies) de los jugadores de los equipos de la NBA
* **\<Weight>**: de tipo \<Integer\>, representa el peso (en libras) de los jugadores de la NBA
* **\<Age>**: de tipo \<Integer\>, representa las edades de todos los jugadores de los equipos de la NBA
* **\<Draft Year>**: de tipo \<Integer\>, representa todos los a�os en el que los jugadores de la NBA fueron Draft
* **\<Seasons in league>**: de tipo \<Integer\>, representa todas las temporadas en liga de los equipos de la NBA
* **\<Pre-draft Team>**: de tipo \<String\>, representa el equipo anterior de todos los equipos de la NBA
* **\<Height CM>**: de tipo \<Integer\>, representa todas las alturas (en centimetros) de los jugadores de los equipos de la NBA
* **\<Weight KG>**: de tipo \<Integer\>, representa el peso (en kilogramos) de los jugadores de la NBA
* **\<Rings>**: de tipo \<Boolean\>, representa si un jugador tiene o no anillo

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Nba
Representa un registro base del csv.

**Propiedades**:

- jugador, de tipo \<String\>, consultable y modificable.
- conferencia, de tipo \<Conferencia\>, consultable y modificable.
- fecha, de tipo \<LocalDate\>, consultable y modificable.
- posicion, de tipo \<Posicion\>, consultable y modificable. 
- altura, de tipo \<Double\>, consultable y modificable.
- peso, de tipo \<Integer\>, consultable y modificable.
- edad, de tipo \<Integer\>, consultable y modificable.
- a�o_draft_del_jugador, de tipo \<Integer\>, consultable y modificable.
- temporadas_en_liga, de tipo \<Integer\>, consultable y modificable.
- a�o_fin_de_temporada, de tipo \<Integer\>, consultable y modificable.
- equipo_anterior, de tipo \<String\>, consultable y modificable.
- altura_en_centimetros, de tipo \<Integer\>, consultable y modificable.
- peso_en_kilogramos, de tipo \<Integer\>, consultable y modificable.
- anillos, de tipo \<Boolean\>, consultable y modificable.


**Constructores**: 

- C1: Tiene un par�metro por cada propiedad b�sica del tipo.
- C2: Crea un objeto de tipo Nba a partir de los siguientes par�metros: String jugador, String equipo, Conferencia conferencia, Posicion posicion, Double altura, Integer peso, Integer edad, Integer a�o_draft_del_jugador, Integer temporadas_en_liga, Integer a�o_fin_de_temporada, String equipo_anterior, Integer altura_en_centimetros.

**Restricciones**:
 
- R1: El peso en kilogramos debe ser positivo.
- R2: Los anillos no pueden tener un valor nulo.
- R3: Tiene que tener una edad superior a 18 a�os
- 
**Criterio de igualdad**: Dos registros son iguales si todas sus propiedades b�sicas son iguales.

**Criterio de ordenaci�n**: Por altura en centimetros, peso en kilogramos y nombre del jugador.

**Otras operaciones**:
 
- getTiempoEnA�os(), de tipo \<Integer\>,  devuelve el tiempo en a�os desde una determinada fecha hasta el d�a de hoy.
- getIndiceMasaCorporal(), de tipo \<Double\>, devuelve el IMC del jugador en base a su altura y peso .
- getSignificadoIndiceMasaCorporal(), de tipo \<String\>, explica el IMC de cada jugador.

#### Tipos auxiliares

�Conferencia, enumerado. Puede tomar los valores East, West.
�Posicion, enumerado. Puede tomar los valores C, F, FC, G, GF, PF, PG, SF, SG.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
