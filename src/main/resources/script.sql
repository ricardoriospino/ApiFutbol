CREATE DATABASE bdApiFutbol;
USE bdApiFutbol;

CREATE TABLE IF NOT EXISTS tb_equipo (

id_equipo INTEGER UNSIGNED PRIMARY KEY auto_increment,
nombre_equipo VARCHAR (200) UNIQUE NOT NULL,
anio_fundacion DATE NULL,
anios_existencia INTEGER (10) NOT NULL,
imagen_escudo VARCHAR (200) NOT NULL,
duenio_actual VARCHAR (100) NOT NULL,
patrocinador_oficial VARCHAR (100) NOT NULL

);
CREATE TABLE IF NOT EXISTS tb_titulos(

id_titulo INTEGER UNSIGNED PRIMARY KEY auto_increment,
anio_titulo VARCHAR (100) NOT NULL,
id_equipo INTEGER UNSIGNED,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo)
);

CREATE TABLE IF NOT EXISTS tb_entrenador (
id_entrenador INTEGER UNSIGNED PRIMARY KEY auto_increment,
nombre_entrenador VARCHAR (50) NOT NULL,
edad INTEGER (10) NOT NULL,
nacionalidad VARCHAR (50) NOT NULL,
anios_experiencia INTEGER (10) NOT NULL,
titulos_ganados INTEGER (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_equipo_entrenador(
id_equipo_entrenador INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_equipo INTEGER UNSIGNED,
id_entrenador INTEGER UNSIGNED,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo),
FOREIGN KEY (id_entrenador) REFERENCES tb_entrenador(id_entrenador)

);
CREATE TABLE IF NOT EXISTS tb_jugador(
id_jugador INTEGER UNSIGNED PRIMARY KEY auto_increment,
nombre_jugador VARCHAR (50)NOT NULL,
edad INTEGER (10)NOT NULL,
anios_de_carrera INTEGER (10) NOT NULL,
nacionalidad VARCHAR(50) NOT NULL,
dorsal INTEGER (10) NOT NULL,
posicion VARCHAR(50)NOT NULL

);

CREATE TABLE IF NOT EXISTS tb_equipo_jugador(
id_equipo_jugador INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_equipo INTEGER UNSIGNED,
id_jugador INTEGER UNSIGNED,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo),
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador)

);

CREATE TABLE IF NOT EXISTS tb_goles(
id_goles INTEGER  UNSIGNED PRIMARY KEY auto_increment,
total_goles INTEGER (10) NOT NULL,
id_jugador INTEGER UNSIGNED,
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador)

);

CREATE TABLE IF NOT EXISTS tb_faltas(
id_faltas INTEGER  UNSIGNED PRIMARY KEY auto_increment,
faltas_amarilla INTEGER (10) ,
faltas_roja INTEGER (10) ,
id_jugador INTEGER UNSIGNED,
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador)
);

CREATE TABLE IF NOT EXISTS tb_estadio(
id_estadio INTEGER  UNSIGNED PRIMARY KEY auto_increment,
nombre_estadio VARCHAR (50) NOT NULL,
capacidad INTEGER (50) NOT NULL,
ubicacion VARCHAR (200 )NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_equipo_estadio (
id_equipo_estadio INTEGER  UNSIGNED PRIMARY KEY auto_increment,
id_equipo INTEGER UNSIGNED,
id_estadio INTEGER UNSIGNED,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo (id_equipo),
FOREIGN KEY (id_estadio) REFERENCES tb_estadio (id_estadio)
);

CREATE TABLE IF  NOT EXISTS tb_partido(
id_partido INTEGER  UNSIGNED PRIMARY KEY auto_increment,
duracion_partido VARCHAR (20) NOT NULL,
numero_goles INTEGER (10) NOT NULL,
numero_faltas INTEGER(10) NOT NULL,
goles_equipo1 INTEGER (10) NULL,
goles_equipo2 INTEGER (10) NULL,
faltas_equipo1 INTEGER (10)NULL,
faltas_equipo2 INTEGER (10)NULL,
ganador VARCHAR (50) NULL,
empate VARCHAR (50) NULL,
perdedor VARCHAR (50)  NULL,
id_equipo INTEGER UNSIGNED,
id_equipo2 INTEGER UNSIGNED,
CONSTRAINT FK_PartidoEquipo FOREIGN KEY (id_equipo) REFERENCES tb_equipo (id_equipo),
CONSTRAINT FK_PartidoEquipo2 FOREIGN KEY (id_equipo2)REFERENCES tb_equipo (id_equipo)
);

CREATE TABLE IF NOT EXISTS tb_posiciones(
id_posiciones INTEGER  UNSIGNED PRIMARY KEY auto_increment,
temporada INTEGER (10) NOT NULL,
nombre_equipo VARCHAR  (50) NOT NULL,
partidos_jugados INTEGER (10) NOT NULL,
partidos_ganados INTEGER (10) NOT NULL,
partidos_empatados INTEGER (10) NOT NULL,
partidos_perdidos INTEGER (10) NOT NULL,
puntos INTEGER (10)NOT NULL

);

/*
DROP TABLE tb_posiciones;
DROP TABLE tb_partido;
DROP TABLE tb_estadio;
DROP TABLE tb_equipo_estadio;
DROP TABLE tb_faltas;
DROP TABLE tb_goles;
DROP TABLE tb_equipo_jugador;
DROP TABLE tb_jugador;
DROP TABLE tb_equipo_entrenador;
DROP TABLE tb_entrenador;
DROP TABLE tb_titulos;
DROP TABLE tb_equipo;
 */

SELECT * FROM tb_entrenador;
SELECT * FROM tb_equipo;
SELECT * FROM tb_estadio;
SELECT * FROM tb_jugador;
SELECT * FROM tb_posiciones;
