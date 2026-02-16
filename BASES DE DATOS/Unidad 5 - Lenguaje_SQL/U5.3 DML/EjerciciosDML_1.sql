'EJERCICIOS DML 1' "EjerciciosDML_1.pdf"

1. "Inserta registros en la tabla ALUMNO con los siguientes datos."

INSERT INTO ALUMNO (dni, nombre, prApellido, sgApellido, Bilingue)
VALUES ('98765432', 'Luis', 'Sánchez', 'Hernández', 'N'),
('45678901', 'Elena', 'Ramírez', 'Díaz', 'S'),
('56789012', 'Javier', 'Moreno', 'Ruiz', 'N'),
('11112222', 'Fernando', 'García', 'Pérez', 'N'),
('22223333', 'Lucía', 'Martínez', 'Santos', 'S'),
('33334444', 'Roberto', 'Hernández', 'López', 'N'),
('44445555', 'Paula', 'Díaz', 'Morales', 'S'),
('55556666', 'Andrea', 'Ruiz', 'Gómez', 'N'),
('66667777', 'Manuel', 'Fernández', 'Torres', 'S'),
('77778888', 'Beatriz', 'Jiménez', 'Vargas', 'N'),
('88889999', 'Alberto', 'Castro', 'Ramos', 'S');

2. "Modifica la tabla matricula para que su PK sea de tipo autonumérico."

ALTER TABLE lineamatricula 
DROP FOREIGN KEY lineamatricula_ibfk_1;
--ELIMINAMOS RESTRICCION CAUSADA POR LA CLAVE FORANEA

ALTER TABLE matricula 
MODIFY codMatr INT AUTO_INCREMENT;
--MODIFICAMOS LA COLUMNA PARA QUE SEA AUTOINCREMENTAL

ALTER TABLE lineamatricula 
ADD CONSTRAINT lineamatricula_ibfk_1 
FOREIGN KEY (codMatr) REFERENCES matricula(codMatr);
--VOLVEMOS A ESTABLECER LA RESTRICCION

3. "Inserta registros para matricular a todos los nuevos alumnoS en el curso 2025. Utiliza un INSERT.. SELECT"

INSERT INTO matricula (codMatr, dni, curso)
SELECT NULL, dni, 2025 FROM alumno;

4. "Añade los siguientes registros a la tabla PROFESOR. 
Utiliza la opción 'Multi-row Insert'"

INSERT INTO profesor (dni, Nombre, prApellido, sgApellido, CodDep)
VALUES
('12345678', 'Carlos', 'Pérez', 'Gómez', 1),
('87654321', 'María', 'López', 'Martínez', 2),
('11223344', 'Ana', 'González', 'Fernández', 2);

5. "Crea una tabla ALUMNO_bck con el contenido de la tabla Alumno, añadiendo
una columna más 'YEARMONTH' con valor 0 para todos los registros. 
Utiliza un CREATE TABLE AS SELECT..."

CREATE TABLE alumno_bck AS
SELECT * FROM alumno;

ALTER TABLE alumno_bck
ADD COLUMN YEARMONTH varchar(10) DEFAULT 0;

6. "Actualiza la columna ALUMNO_BCK.YEARMONTH con el valor 'ENE2026' para
todos los registros."

UPDATE alumno_bck
SET YEARMONTH = 'ENE2026';

7. "Crea una clave primaria para la tabla ALUMNO_BCK (sin añadir columnas)"

ALTER TABLE ALUMNO_BCK
ADD PRIMARY KEY (dni);

8. "Inserta en ALUMBIL los alumnos que tienen en la tabla alumno el campo
'bilingüe' a 'S' y todavía no se encuentran en la tabla. Todos con la fecha
actual (CURRENT_DATE()) y sin 'lugar'. Utiliza un INSERT SELECT."



9. "Modifica la tabla contrato para que su campo codcont sea autonumérico."



10. "Utilizando un INSERT..SELECT, añade un registro en la tabla CONTRATO para
cada profesor, teniendo en cuenta que CONTRATO.curso debe corresponder
con el primer curso en el que cada profesor impartió alguna asignatura."
