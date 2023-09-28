# Proyecto del Segundo Cuatrimestre Fundamentos de ProgramaciÛn (Curso  \<21\>/\<22\>)
Autor/a: \<Antonio Manuel Luque Molina\>   uvus:\<antluqmol1\>

Este proyecto trata de un dataset acerca de los jugadores de la semana de la NBA desde el 1979 hasta ahora.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Est· estructurado en los siguentes paquetes:
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
Aqu√≠ debes describir la estructura del dataset explicando qu√© representan los datos que contiene y la descripci√≥n de cada una de las columnas. Incluye tambi√©n la URL del dataset original.

El dataset usado en este proyecto est· compuesto por \<844\> filas y \<15\> columnas, con la siguiente descripciÛn:

* **\<Player>**: de tipo \<String\>, representa todos los jugadores de la NBA
* **\<Team>**: de tipo \<String\>, representa todos los equipos de la NBA
* **\<Conference>**: de tipo \<Conferencia\>(enum), representa la conferencia de la NBA
* **\<Date>**: de tipo \<LocalDate\>, representa las fechas de los partidos de la NBA, de la forma:(yyyy-mm-dd)
* **\<Position>**: de tipo \<Posicion\>(enum), representa las posiciones de todos los jugadores de la NBA
* **\<Height>**: de tipo \<Double\>, representa todas las alturas (en pies) de los jugadores de los equipos de la NBA
* **\<Weight>**: de tipo \<Integer\>, representa el peso (en libras) de los jugadores de la NBA
* **\<Age>**: de tipo \<Integer\>, representa las edades de todos los jugadores de los equipos de la NBA
* **\<Draft Year>**: de tipo \<Integer\>, representa todos los aÒos en el que los jugadores de la NBA fueron Draft
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
- aÒo_draft_del_jugador, de tipo \<Integer\>, consultable y modificable.
- temporadas_en_liga, de tipo \<Integer\>, consultable y modificable.
- aÒo_fin_de_temporada, de tipo \<Integer\>, consultable y modificable.
- equipo_anterior, de tipo \<String\>, consultable y modificable.
- altura_en_centimetros, de tipo \<Integer\>, consultable y modificable.
- peso_en_kilogramos, de tipo \<Integer\>, consultable y modificable.
- anillos, de tipo \<Boolean\>, consultable y modificable.


**Constructores**: 

- C1: Tiene un par·metro por cada propiedad b·sica del tipo.
- C2: Crea un objeto de tipo Nba a partir de los siguientes par·metros: String jugador, String equipo, Conferencia conferencia, Posicion posicion, Double altura, Integer peso, Integer edad, Integer aÒo_draft_del_jugador, Integer temporadas_en_liga, Integer aÒo_fin_de_temporada, String equipo_anterior, Integer altura_en_centimetros.

**Restricciones**:
 
- R1: El peso en kilogramos debe ser positivo.
- R2: Los anillos no pueden tener un valor nulo.
- R3: Tiene que tener una edad superior a 18 aÒos
- 
**Criterio de igualdad**: Dos registros son iguales si todas sus propiedades b·sicas son iguales.

**Criterio de ordenaciÛn**: Por altura en centimetros, peso en kilogramos y nombre del jugador.

**Otras operaciones**:
 
- getTiempoEnAÒos(), de tipo \<Integer\>,  devuelve el tiempo en aÒos desde una determinada fecha hasta el dÌa de hoy.
- getIndiceMasaCorporal(), de tipo \<Double\>, devuelve el IMC del jugador en base a su altura y peso .
- getSignificadoIndiceMasaCorporal(), de tipo \<String\>, explica el IMC de cada jugador.

#### Tipos auxiliares

ïConferencia, enumerado. Puede tomar los valores East, West.
ïPosicion, enumerado. Puede tomar los valores C, F, FC, G, GF, PF, PG, SF, SG.

### Factor√≠a
Descripci√≥n breve de la factor√≠a.

- _m√©todo 1_: Descripci√≥n del m√©todo 1.
-	_m√©todo 2_: Descripci√≥n del m√©todo 2.

### Tipo Contenedor

Descripci√≥n breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripci√≥n del constructor 1.
- C2: Descripci√≥n del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripci√≥n de la restricci√≥n 1.
- R2: Descripci√≥n de la restricci√≥n 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenaci√≥n**: Describir el criterio de ordenaci√≥n (si lo hay).

**Otras operaciones**:
 
-	_m√©todo 1_: Descripci√≥n del m√©todo 1.
- ...
