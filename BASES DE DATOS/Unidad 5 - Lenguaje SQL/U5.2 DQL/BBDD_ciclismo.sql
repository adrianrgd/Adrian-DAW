CREATE DATABASE ciclismo;
USE ciclismo;

CREATE TABLE ciclista (
  dorsal smallint(6) default NULL,
  nombre varchar(30) default NULL,
  edad smallint(6) default NULL,
  nomeq varchar(25) default NULL
) ;


INSERT INTO ciclista (dorsal,nombre,edad,nomeq) VALUES 
 (1,'Miguel Induráin',32,'Banesto'),
 (2,'Pedro Delgado',35,'Banesto'),
 (3,'Alex Zulle',27,'ONCE'),
 (4,'Tony Rominger',30,'Mapei-Clas'),
 (5,'Gert-Jan Theunisse',32,'TVM'),
 (6,'Adriano Baffi',33,'Mercatone Uno'),
 (7,'Massimiliano Lelli',30,'Mercatone Uno'),
 (8,'Jean Van Poppel',33,'Lotus Festina'),
 (9,'Massimo Podenzana',34,'Navigare'),
 (10,'Mario Cipollini',28,'Mercatone Uno'),
 (11,'Flavio Giupponi',31,'Bresciali-Refin'),
 (12,'Alessio Di Basco',31,'Amore Vita'),
 (13,'Lale Cubino',28,'Seguros Amaya'),
 (14,'Roberto Pagnin',33,'Navigare'),
 (15,'Jesper Skibby',31,'TVM'),
 (16,'Dimitri Konishev',29,'Jolly Club'),
 (17,'Bruno Leali',37,'Bresciali-Refin'),
 (18,'Robert Millar',37,'TVM'),
 (19,'Julian Gorospe',34,'Banesto'),
 (20,'Alfonso Gutiérrez',29,'Artiach'),
 (21,'Erwin Nijboer',31,'Artiach'),
 (22,'Giorgio Furlan',32,'Gewiss'),
 (23,'Lance Armstrong',27,'Motorola'),
 (24,'Claudio Chiappucci',29,'Carrera'),
 (25,'Gianni Bugno',32,'Gatorade');
INSERT INTO ciclista (dorsal,nombre,edad,nomeq) VALUES 
 (26,'Mikel Zarrabeitia',27,'Banesto'),
 (27,'Laurent Jalabert',28,'ONCE'),
 (28,'Jesus Montoya',33,'Banesto'),
 (29,'Angel Edo',28,'Kelme'),
 (30,'Melchor Mauri',28,'Banesto'),
 (31,'Vicente Aparicio',30,'Banesto'),
 (32,'Laurent Dufaux',28,'ONCE'),
 (33,'Stefano della Santa',29,'Mapei-Clas'),
 (34,'Angel Yesid Camargo',30,'Kelme'),
 (35,'Erik Dekker',28,'Wordperfect'),
 (36,'Gian Matteo Fagnini',32,'Mercatone Uno'),
 (37,'Scott Sunderland',29,'TVM'),
 (38,'Javier Palacin',25,'Euskadi'),
 (39,'Rudy Verdonck',30,'Lotus Festina'),
 (40,'Viatceslav Ekimov',32,'Wordperfect'),
 (41,'Rolf Aldag',25,'Telecom'),
 (42,'Davide Cassani',29,'TVM'),
 (43,'Francesco Casagrande',28,'Mercatone Uno'),
 (44,'Luca Gelfi',27,'Gatorade'),
 (45,'Alberto Elli',26,'Artiach'),
 (46,'Agustin Sagasti',24,'Euskadi'),
 (47,'Laurent Pillon',32,'Gewiss'),
 (48,'Marco Saligari',29,'Gewiss'),
 (49,'Eugeni Berzin',23,'Gewiss'),
 (50,'Fernando Escartin',27,'Mapei-Clas');

CREATE TABLE equipo (
  nomeq varchar(25) default NULL,
  director varchar(30) default NULL
) ;

INSERT INTO equipo (nomeq,director) VALUES 
 ('Artiach','José Peréz'),
 ('Banesto','Miguel Echevarria'),
 ('Bresciali-Refin','Pietro Armani'),
 ('Carrera','Luigi Petroni'),
 ('Castorama','Jean Philip'),
 ('Euskadi','Pedro Txucaru'),
 ('Gatorade','Gian Luca Pacceli'),
 ('Gewiss','Moreno Argentin'),
 ('Jolly Club','Johan Richard'),
 ('Kelme','Álvaro Pino'),
 ('Lotus Festina','Suarez Cuevas'),
 ('Mapei-Clas','Juan Fernandez'),
 ('Mercatone Uno','Ettore Romano'),
 ('Motorola','John Fidwell'),
 ('Navigare','Lonrenzo Sciacci'),
 ('ONCE','Manuel Sainz'),
 ('PDM','Piet Van Der Kruis'),
 ('Seguros Amaya','Minguez'),
 ('Telecom','Morgan Reikcard'),
 ('TVM','Steveens Henk'),
 ('Wordperfect','Bill Gates'),
 ('Amore Vita','Ricardo Padacci');



CREATE TABLE etapa (
  netapa smallint(6) default NULL,
  km smallint(6) default NULL,
  salida varchar(35) default NULL,
  llegada varchar(35) default NULL,
  dorsal smallint(6) default NULL
) ;

INSERT INTO etapa (netapa,km,salida,llegada,dorsal) VALUES 
 (1,9,'Valladolid','Valladolid',1),
 (2,180,'Valladolid','Salamanca',36),
 (3,240,'Salamanca','Caceres',12),
 (4,230,'Almendralejo','Córdoba',33),
 (5,170,'Córdoba','Granada',27),
 (6,150,'Granada','Sierra Nevada',12),
 (7,250,'Baza','Alicante',22),
 (8,40,'Benidorm','Benidorm',1),
 (9,150,'Benidorm','Valencia',35),
 (10,200,'Igualada','Andorra',2),
 (11,195,'Andorra','Estación de Cerler',15),
 (12,220,'Benasque','Zaragoza',12),
 (13,200,'Zaragoza','Pamplona',43),
 (14,172,'Pamplona','Alto de la Cruz de la Demanda',36),
 (15,207,'Santo Domingo de la Calzada','Santander',10),
 (16,160,'Santander','Lagos de Covadonga',5),
 (17,140,'Cangas de Onis','Alto del Naranco',4),
 (18,195,'Ávila','Ávila',8),
 (19,190,'Ávila','Destilerias Dyc',2),
 (20,52,'Segovia','Destilerias Dyc',2),
 (21,170,'Destilerias Dyc','Madrid',27);


DROP TABLE IF EXISTS llevar;
CREATE TABLE llevar (
  dorsal smallint(6) default NULL,
  netapa smallint(6) default NULL,
  codigo varchar(3) default NULL
) ;

INSERT INTO llevar (dorsal,netapa,codigo) VALUES 
 (1,1,'MGE'),
 (1,1,'MMO'),
 (27,1,'MMS'),
 (1,1,'MMV'),
 (1,1,'MRE'),
 (1,1,'MSE'),
 (1,2,'MGE'),
 (25,2,'MMO'),
 (29,2,'MMS'),
 (16,2,'MMV'),
 (27,2,'MRE'),
 (8,2,'MSE'),
 (1,3,'MGE'),
 (25,3,'MMO'),
 (27,3,'MMS'),
 (16,3,'MMV'),
 (27,3,'MRE'),
 (12,3,'MSE'),
 (1,4,'MGE'),
 (24,4,'MMO'),
 (29,4,'MMS'),
 (17,4,'MMV'),
 (27,4,'MRE'),
 (8,4,'MSE'),
 (2,5,'MGE'),
 (25,5,'MMO'),
 (16,5,'MMV'),
 (27,5,'MRE'),
 (12,5,'MSE'),
 (2,6,'MGE'),
 (26,6,'MMO'),
 (16,6,'MMV'),
 (20,6,'MRE'),
 (12,6,'MSE'),
 (2,7,'MGE'),
 (26,7,'MMO'),
 (33,7,'MMV'),
 (20,7,'MRE'),
 (49,7,'MSE'),
 (4,8,'MGE'),
 (26,8,'MMO'),
 (33,8,'MMV'),
 (20,8,'MRE'),
 (49,8,'MSE'),
 (26,9,'MGE'),
 (26,9,'MMO'),
 (48,9,'MMV'),
 (20,9,'MRE'),
 (49,9,'MSE'),
 (26,10,'MGE');


CREATE TABLE maillot (
  codigo varchar(3) default NULL,
  tipo varchar(30) default NULL,
  color varchar(20) default NULL,
  premio int(4) default NULL
) ;

INSERT INTO maillot (codigo,tipo,color,premio) VALUES 
 ('MGE','General','Amarillo',8000000),
 ('MMO','Montaña','Blanco y Rojo',2000000),
 ('MMS','Mas Sufrido','Estrellitas moradas',2000000),
 ('MMV','Metas volantes','Rojo',2000000),
 ('MRE','Regularidad','Verde',2000000),
 ('MSE','Sprints especiales','Rosa',2000000);

CREATE TABLE puerto (
  nompuerto varchar(35) default NULL,
  altura smallint(6) default NULL,
  categoria varchar(1) default NULL,
  pendiente double(8,0) default NULL,
  netapa smallint(6) default NULL,
  dorsal smallint(6) default NULL
) ;


INSERT INTO puerto(nompuerto,altura,categoria,pendiente,netapa,dorsal) VALUES
('Arcalis', 2230, 'E', 5.5  ,10,7),
('Cerler-Circo de Ampriu' ,  2500,'E',5.68   ,11,9),
('Coll de Ordino', 1980,'E',  6.9 ,10,8),
('Cruz de la Demanda',1850,'E', 4.2  ,11,9),
('Lagos de Covadonga',1134,'E',  6.87 ,16,10),
('Sierra Nevada',  2500,'E',  7.9 ,2,26),
('Alto del Naranco'	, 565,'1'  , 5.7  ,10,1),
('Coll de la Comella', 1347,'1'  , 7.9  ,10,31),
('Navacerrada'	, 1858,'1'  , 7.5  ,19,2),
('Puerto de Alisas'	, 674, '1'   , 6.1  ,15,19),
('Puerto de la Morcuera',1776,'2'   , 7  ,19,2),
('Puerto de Mijares',1570	,  '1' , 5.1  ,18,12),
('Puerto de Navalmoral'	, 1062,'2'  , 4.6  ,18,28),
('Puerto de Pedro Bernardo'	, 801  ,'2',  4.5 ,18,13);