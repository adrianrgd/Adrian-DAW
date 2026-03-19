-- Procedimiento que devuelve el nombre de un alumno a partir de su DNI
DELIMITER //
CREATE PROCEDURE obtenerNombreAlumno (
    IN p_dni varchar(8),
    OUT p_nombre varchar(30)
)
BEGIN

    SELECT nombre 
    INTO p_nombre -- Se almacena el nombre en la variable p_nombre
    FROM alumno
    WHERE dni = p_dni;

END
//

CALL obtenerNombreAlumno('11112222', @nombre);
SELECT @nombre;

+---------+
| @nombre |
+---------+
| Josefa  |
+---------+

-- Procedimiento que devuelve el nombre y si es bilingue de un alumno a partir de su DNI
DELIMITER //
CREATE PROCEDURE obtenerNombreAlumnoBil (
    IN p_dni varchar(8),
    OUT p_nombre varchar(30),
    OUT p_bilingue char(1)
)
BEGIN

    SELECT nombre, bilingue
    INTO p_nombre, p_bilingue
    FROM alumno
    WHERE dni = p_dni;

END
//

CALL obtenerNombreAlumnoBil('11112222', @nombre, @bilingue);
SELECT @nombre, @bilingue;

-- Procedimiento que devuelve el nombre de un profesor a partir de su DNI
DELIMITER //
CREATE PROCEDURE obtenerNombreProfesor (p_dni varchar(8)) RETURNS varchar(30) DETERMINISTIC

BEGIN

    DECLARE v_nombre varchar(30);

    SELECT nombre 
    INTO v_nombre 
    FROM profesor 
    WHERE dni = p_dni;

    RETURN v_nombre;

END
//

SELECT obtenerNombreProfesor('11112222');