CREATE DATABASE bdApiFutbol;
USE bdApiFutbol;

CREATE TABLE IF NOT EXISTS tb_equipo (

id_equipo INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_equipo VARCHAR (10) UNIQUE NOT NULL,
nombre_equipo VARCHAR (200) UNIQUE NOT NULL,
anio_fundacion DATE NULL,
imagen_escudo VARCHAR (200) NOT NULL,
duenio_actual VARCHAR (100) NOT NULL,
cantidad_titulo_nacional INT (10) NOT NULL,
cantidad_titulo_internacional INT (10)NOT NULL,
patrocinador_principal VARCHAR (100) NOT NULL

);
CREATE TABLE IF NOT EXISTS tb_titulos(

id_titulo INTEGER UNSIGNED PRIMARY KEY auto_increment,
anio_titulo VARCHAR (100) NOT NULL,
nombre_titulo VARCHAR (100) NOT NULL,
tipo_titulo BOOLEAN NOT NULL,
id_equipo INTEGER UNSIGNED,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo)
);

CREATE TABLE IF NOT EXISTS tb_entrenador (
id_entrenador INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_entrenador VARCHAR (10) UNIQUE NOT NULL,
nombre_entrenador VARCHAR (50) NOT NULL,
fecha_nacimiento DATE NOT NULL,
nacionalidad VARCHAR (50) NOT NULL,
anios_inicio_laboral DATE NOT NULL,
titulos_ganados INTEGER (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_equipo_entrenador(
id_equipo_entrenador INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_equipo INTEGER UNSIGNED,
id_entrenador INTEGER UNSIGNED,
anio INTEGER (10) NOT NULL,
partidos_jugados INTEGER (10) NOT NULL,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo),
FOREIGN KEY (id_entrenador) REFERENCES tb_entrenador(id_entrenador)

);
CREATE TABLE IF NOT EXISTS tb_jugador(
id_jugador INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_jugador VARCHAR (10) UNIQUE NOT NULL,
nombre_jugador VARCHAR (50)NOT NULL,
fecha_nacimiento DATE NOT NULL,
anio_de_debut INTEGER (10) NOT NULL,
nacionalidad VARCHAR(50) NOT NULL,
dorsal INTEGER (10) NOT NULL,
posicion VARCHAR(50)NOT NULL,
numero_goles INT (10) NOT NULL,
numero_faltas INT(10) NOT NULL

);

CREATE TABLE IF NOT EXISTS tb_equipo_jugador(
id_equipo_jugador INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_equipo INTEGER UNSIGNED,
id_jugador INTEGER UNSIGNED,
anio INTEGER (10) NOT NULL,
FOREIGN KEY (id_equipo) REFERENCES tb_equipo(id_equipo),
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador)

);

CREATE TABLE IF NOT EXISTS tb_estadio(
id_estadio INTEGER  UNSIGNED PRIMARY KEY auto_increment,
codigo_estadio VARCHAR (10) UNIQUE NOT NULL,
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
codigo_partido VARCHAR(10) UNIQUE NOT NULL,
fecha_hora DATETIME  NOT NULL,
numero_goles INTEGER (10) NOT NULL,
numero_faltas INTEGER(10) NOT NULL,
goles_equipo1 INTEGER (10) NULL,
goles_equipo2 INTEGER (10) NULL,
faltas_equipo1 INTEGER (10)NULL,
faltas_equipo2 INTEGER (10)NULL,
ganador VARCHAR (50) NULL,
perdedor VARCHAR (50)  NULL,
arbitro VARCHAR (100) NOT NULL,
id_equipo1 INTEGER UNSIGNED,
id_equipo2 INTEGER UNSIGNED,
CONSTRAINT FK_PartidoEquipo FOREIGN KEY (id_equipo1) REFERENCES tb_equipo (id_equipo),
CONSTRAINT FK_PartidoEquipo2 FOREIGN KEY (id_equipo2)REFERENCES tb_equipo (id_equipo)
);

CREATE TABLE IF NOT EXISTS tb_goles(
id_goles INTEGER  UNSIGNED PRIMARY KEY auto_increment,
minuto_gol INT (10) NOT NULL,
descripcion_gol VARCHAR(250) NOT NULL,
id_partido INTEGER UNSIGNED,
id_jugador INTEGER UNSIGNED,
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador),
FOREIGN KEY (id_partido) REFERENCES tb_partido (id_partido)

);

CREATE TABLE IF NOT EXISTS tb_faltas(
id_faltas INTEGER  UNSIGNED PRIMARY KEY auto_increment,
tipo_falta VARCHAR (50) NOT NULL,
minuto_falta INT (10) NOT NULL, 
id_partido INTEGER UNSIGNED,
id_jugador INTEGER UNSIGNED,
FOREIGN KEY (id_jugador) REFERENCES tb_jugador (id_jugador),
FOREIGN KEY (id_partido) REFERENCES tb_partido (id_partido)
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

CREATE TABLE IF NOT EXISTS tb_security(
id INTEGER UNSIGNED PRIMARY KEY auto_increment,
usuario VARCHAR (50) UNIQUE NOT NULL,
clave VARCHAR(50) NOT NULL,
rol  CHAR NOT NULL,
activo BOOLEAN NOT NULL
);

/*
DROP TABLE tb_security;
DROP TABLE tb_posiciones;
DROP TABLE tb_faltas;
DROP TABLE tb_goles;
DROP TABLE tb_partido;
DROP TABLE tb_equipo_estadio;
DROP TABLE tb_estadio;
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
SELECT * FROM tb_partido;
SELECT * FROM tb_titulos;
SELECT * FROM tb_equipo_entrenador;
SELECT * FROM tb_equipo_jugador;
SELECT * FROM tb_equipo_estadio;
SELECT * FROM tb_goles;
SELECT * FROM tb_faltas;
SELECT * FROM tb_posiciones;
SELECT * FROM tb_security;

-- DATA EQUIPOS
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ01","San Martin","2010-02-14","imagen1","Enrique",3,0,"Marathon");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ02","Sporting Cristal","1955-12-12","imagen1","Gustavo",20,0,"Adidas");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ03","Universitario","1920-04-12","imagen1","Raffo",26,0,"Marathon");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ04","Alianza Lima ","1905-04-23","imagen1","Manrique",23,0,"Banco Pichincha");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ05","Cienciano","1999-12-23","imagen1","Orlando",1,1,"Gaytorade");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ06","Melgar","1900-12-23","imagen1","Fausto",2,0,"Aje");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ07","Universidad Cesar Vallejo","2006-12-23","imagen1","Acuña",0,0,"Universidad Cesar Vallejo");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ08","Sport Boys","1920-12-23","imagen1","Kevin",6,0,"Loma");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ09","Alianza Atletico","1940-12-23","imagen1","Carlos",1,0,"Inka Kola");
INSERT INTO tb_equipo (codigo_equipo,nombre_equipo,anio_fundacion,imagen_escudo,duenio_actual,cantidad_titulo_nacional,cantidad_titulo_internacional,patrocinador_principal) VALUE
("EQ10","Cantolao","2000-12-23","imagen1","Carlos",0,0,"Cable vision");

-- DATA TITULOS
INSERT INTO tb_titulos (anio_titulo,nombre_titulo,tipo_titulo,id_equipo) VALUE ("2000","Campeonato 2000",true,2);
INSERT INTO tb_titulos (anio_titulo,nombre_titulo,tipo_titulo,id_equipo) VALUE ("2001","Campeonato 2001",true,1);
INSERT INTO tb_titulos (anio_titulo,nombre_titulo,tipo_titulo,id_equipo) VALUE ("2002","Campeonato 2002",true,2);

-- DATA ENTRENADORES
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN001","Roberto Mosquera","1950-02-","Peru","2003-05-09",6);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN002","Teddy Cardama","1970-03-09","Peru","2005-05-09",2);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN003","Soso","1980-06-09","Argentina","2010-08-09",1);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN004","Ricardo Gareca","1972-06-09","Argentina","2007-08-09",4);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN005","Mario Salas","1970-06-09","Chile","2003-08-09",3);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN006","Grioni","1950-06-11","Uruguay","2000-08-09",4);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN007","Jorge Soto","1982-10-11","Peru","2020-08-09",0);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN008","Paulo Autori","1957-05-10","Brasil","1990-02-24",6);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN009","Markarian","1950-09-30","Uruguay","1985-08-09",4);
INSERT INTO tb_entrenador (codigo_entrenador,nombre_entrenador,fecha_nacimiento,nacionalidad,anios_inicio_laboral,titulos_ganados) VALUE 
("EN010","San paoli","1964-09-30","Chile","1994-08-09",4);


-- DATA EQUIPOS CON ENTRENADORES
INSERT INTO tb_equipo_entrenador (id_equipo,id_entrenador,anio,partidos_jugados)VALUE (2,1,2020,38);
INSERT INTO tb_equipo_entrenador (id_equipo,id_entrenador,anio,partidos_jugados)VALUE (1,2,2020,38);
INSERT INTO tb_equipo_entrenador (id_equipo,id_entrenador,anio,partidos_jugados)VALUE (3,3,2020,38);

-- DATA JUGADORES
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0001","Cazulo","1985-04-10",1999,"Uruguay",10,"Central",30,50);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0002","Gonzales","1992-12-04",2009,"Peru",20,"Lateral",20,30);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0003","Carrillo","1989-07-10",2003,"Peru",18,"Lateral",44,34);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0004","Hober","1990-03-14",2009,"Argentina",7,"Delantero",47,21);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0005","Calcaterra","1985-04-10",1999,"Argentina",22,"Central",11,80);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0006","Soto","1985-04-10",1999,"Peru",13,"Delantero",36,20);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0007","Paolo","1985-04-10",1999,"Uruguay",10,"Delantero",100,40);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0008","Farfan","1985-04-10",1999,"Uruguay",10,"Delantero",70,23);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0009","Ascues","1985-04-10",1999,"Uruguay",10,"Defensa",5,38);
INSERT INTO tb_jugador (codigo_jugador,nombre_jugador,fecha_nacimiento,anio_de_debut,nacionalidad,dorsal,posicion,numero_goles,numero_faltas)VALUE 
("JU0010","Yotun","1985-04-10",1999,"Uruguay",10,"Lateral",22,40);

-- DATA EQUIPOS JUGADORES 
INSERT INTO tb_equipo_jugador (id_equipo,id_jugador,anio)VALUE (1,1,2020);
INSERT INTO tb_equipo_jugador (id_equipo,id_jugador,anio)VALUE (2,2,2020);
INSERT INTO tb_equipo_jugador (id_equipo,id_jugador,anio)VALUE (3,3,2020);

-- DATA ESTADIO 
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES001","Bombonera",25000,"Trujillo");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES002","Estadio Nacional",44000,"Lima");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES003","Alberto Gallardo",11000,"Lima");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES004","Monumental",65000,"Lima");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES005","Manciche",25000,"Trujillo");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES006","Miguel Grau",25000,"Callao");
INSERT INTO tb_estadio (codigo_estadio,nombre_estadio,capacidad,ubicacion)VALUES ("ES007","San Marcos",35000,"Lima");


-- DATA ESTADIOS EQUIPOS
INSERT INTO tb_equipo_estadio (id_equipo,id_estadio)VALUES (2,3);
INSERT INTO tb_equipo_estadio (id_equipo,id_estadio)VALUES (3,4);
INSERT INTO tb_equipo_estadio (id_equipo,id_estadio)VALUES (8,6);

-- DATA PARTIDO
INSERT INTO tb_partido (codigo_partido,fecha_hora,numero_goles,numero_faltas,goles_equipo1,goles_equipo2,faltas_equipo1,faltas_equipo2,ganador,perdedor,arbitro,id_equipo1,id_equipo2)VALUES
("PA00001","2021-04-09 13:40:20",3,10,2,1,4,6,"Sporting Cristal","Universitario","Olivares",2,3);
INSERT INTO tb_partido (codigo_partido,fecha_hora,numero_goles,numero_faltas,goles_equipo1,goles_equipo2,faltas_equipo1,faltas_equipo2,ganador,perdedor,arbitro,id_equipo1,id_equipo2)VALUES
("PA00002","2021-04-09 16:30:00",1,13,0,1,7,6,"San Martin","Cienciano","Bustos",1,5);
INSERT INTO tb_partido (codigo_partido,fecha_hora,numero_goles,numero_faltas,goles_equipo1,goles_equipo2,faltas_equipo1,faltas_equipo2,ganador,perdedor,arbitro,id_equipo1,id_equipo2)VALUES
("PA00003","2021-04-09 20:00:00",4,15,3,1,10,5,"Cantolao","Sport Boys","Manrique",10,8);

-- DATA GOLES
INSERT INTO tb_goles (minuto_gol,descripcion_gol,id_partido,id_jugador) VALUES (30,"Gol de cabeza de un tiro de esquina",1,1);
INSERT INTO tb_goles (minuto_gol,descripcion_gol,id_partido,id_jugador) VALUES (45,"Tiro Penal ",1,1);
INSERT INTO tb_goles (minuto_gol,descripcion_gol,id_partido,id_jugador) VALUES (65,"Luego de un centro izquierdo, al centro de la cancha",1,2);

-- DATA FALTAS
INSERT INTO tb_faltas(tipo_falta,minuto_falta,id_partido,id_jugador)VALUES("Amarilla", 25,1,1);
INSERT INTO tb_faltas(tipo_falta,minuto_falta,id_partido,id_jugador)VALUES("Amarilla", 49,1,3);
INSERT INTO tb_faltas(tipo_falta,minuto_falta,id_partido,id_jugador)VALUES("Amarilla", 69,1,4);

-- DATA JWTS SECURITY
insert into tb_security(activo,clave,rol,usuario) values(true,'123',3,'prios');
insert into tb_security(activo,clave,rol,usuario) values(false,'123',2,'rrios');
insert into tb_security(activo,clave,rol,usuario) values(true,'123',1,'zrios');
insert into tb_security(activo,clave,rol,usuario) values(true,'123',0,'xrios');
