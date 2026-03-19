-- 1. Escribe un procedimiento ‘NombreCiclo’ que devuelva el nombre del ciclo, y reciba como parámetro de entrada el código del ciclo.

DELIMITER //
CREATE PROCEDURE NombreCiclo (

    IN p_codcf INT,
    OUT p_nombre VARCHAR(256)
)
BEGIN 

    SELECT nombre
    INTO p_nombre
    FROM ciclo
    WHERE codcf = p_codcf;

END
//

CALL NombreCiclo(1, @nombre);
SELECT @nombre;

+--------------------------------+
| @nombre                        |
+--------------------------------+
| Desarrollo de aplicaciones web |
+--------------------------------+

-- 2. Escribe un procedimiento ‘NombreAsig’ que devuelva el nombre de la asignatura, y reciba como parámetro de 
-- entrada el código de la asignatura.

DELIMITER //
CREATE PROCEDURE NombreAsig (

    IN p_codasig INT,
    OUT p_nombre VARCHAR(128)
)
BEGIN 

    SELECT nombre
    INTO p_nombre
    FROM asignatura
    WHERE codasig = p_codasig;

END
//

CALL NombreAsig(1, @nombre);
SELECT @nombre;
//

+----------------+
| @nombre        |
+----------------+
| Bases de datos |
+----------------+

-- 3. Escribe un procedimiento ‘totalAlumnoCurso’ que reciba como parámetro de entrada un curso y devuelva el 
-- número de alumnos matriculados en dicho curso

DELIMITER //
CREATE PROCEDURE totalAlumnoCurso (

    IN p_curso INT,
    OUT p_NombreAlumno VARCHAR(30)
)
BEGIN 

    SELECT COUNT(NombreAlumno)
    INTO p_NombreAlumno
    FROM alumnosmatriculados
    WHERE curso = p_curso;

END
//

CALL totalAlumnoCurso(2024, @NombreAlumno);
SELECT @NombreAlumno;
//

+---------------+
| @NombreAlumno |
+---------------+
|             3 |
+---------------+

-- 4. Escribe una función ‘MaxNotaAsig’ que calcule la máxima nota obtenida, en cualquier curso, en la asignatura 
-- cuyo código se pasa por parámetro.


-- 5. Escribe una función ‘MinNotaCurso’ que devuelva el dni del alumno que ha tenido la menor nota en el curso que 
-- se pasa como parámetro a la función.