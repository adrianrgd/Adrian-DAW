-- EJERCICIO 1
DELIMITER //
CREATE PROCEDURE insertar_alumno (
    IN p_dni VARCHAR(8),
    IN p_nombre VARCHAR(30),
    IN p_prapellido VARCHAR(30),
    IN p_sgapellido VARCHAR(30),
    IN p_bilingue CHAR(1),
    OUT insercion_alumno VARCHAR(200)
)
BEGIN


    IF p_bilingue IS NULL OR (p_bilingue != 'N' OR p_bilingue != 'S') THEN
        SET p_bilingue = 'N';
    END IF;

    INSERT INTO alumno
    VALUES (p_dni, p_nombre, p_prapellido, p_sgapellido, p_bilingue);

    SET insercion_alumno = CONCAT ('Alumno ', p_nombre, ' ', p_prapellido, ' ', p_sgapellido, ' con DNI ', p_dni, ' insertado correctamente');

END//

DELIMITER ;

CALL insertar_alumno ('53809653', 'Adrian', 'Rangel', 'Dorrego', 'J', @insercion_alumno);

SELECT @insercion_alumno;

-- =====================================================================================================================
-- EJERCICIO 2

DELIMITER //
CREATE FUNCTION contar_alumnos (
    p_dni VARCHAR(8)
    RETURN INT
)
BEGIN
    DECLARE contador INT;
    SELECT COUNT(*) INTO contador FROM alumno WHERE dni = p_dni;
    RETURN contador;
END //

DELIMITER ;

SELECT contar_alumnos;

-- =====================================================================================================================
-- EJERCICIO 3

DELIMITER //
CREATE PROCEDURE contar_asignaturas_profesor (
    IN p_dni VARCHAR(8),
    OUT contador INT
)
BEGIN
    SELECT COUNT(*) INTO contador FROM imparte WHERE dni = p_dni;
END //

DELIMITER ;

CALL contar_asignaturas_profesor ('90100200', @contador);
SELECT @contador;

-- =====================================================================================================================
-- Ejercicio 4

DELIMITER //

CREATE PROCEDURE contar_profesores_departamento (
    IN p_CodDep INT,
    OUT cantidad_profesores INT
)
BEGIN
    SELECT COUNT(*) INTO cantidad_profesores FROM profesor WHERE CodDep = p_CodDep;
END //

DELIMITER ;

CALL contar_profesores_departamento (1, @cantidad_profesores);
SELECT @cantidad_profesores;

-- =====================================================================================================================
-- Ejercicio 5

DELIMITER //
CREATE PROCEDURE calcular_nota_media (
    IN p_dni VARCHAR(8),
    OUT nota_media DOUBLE
)
BEGIN
    SELECT AVG(nota) INTO nota_media FROM matricula m 
    INNER JOIN lineamatricula l ON m.codmatr = l.codmatr 
    WHERE codmatr = 
    (SELECT codmatr FROM matricula WHERE dni = p_dni);

    IF nota_media IS NULL THEN
        SET nota_media = 0;
    END IF;
END //

DELIMITER ;

CALL calcular_nota_media ('44445555', @nota_media);
SELECT @nota_media;

-- =====================================================================================================================
-- Ejercicio 6

DELIMITER //

CREATE PROCEDURE verificar_contrato_profesor (
    IN p_dni VARCHAR(8),
    OUT contrato_profesor VARCHAR(200)
)
BEGIN
    SELECT COUNT(*) INTO contrato_profesor FROM profesor 
    INNER JOIN contrato ON profesor.dni = contrato.dni
    WHERE profesor.dni = p_dni;

    IF contrato_profesor > 0 THEN
        SET contrato_profesor = 'El profesor tiene contrato';
    ELSE
        SET contrato_profesor = 'El profesor no tiene contrato';
    END IF;
END //

DELIMITER ;

CALL verificar_contrato_profesor ('28900194', @contrato_profesor);
SELECT @contrato_profesor;

-- =====================================================================================================================
-- Ejercicio 7

DELIMITER //

CREATE PROCEDURE actualizar_nota (
    IN p_codmatr INT,
    IN p_codasig INT,
    IN p_nota DECIMAL(5,2),
    OUT mensaje VARCHAR(200)
)
BEGIN
    SELECT codmatr, codasig, nota FROM lineamatricula WHERE codmatr = p_codmatr AND codasig = p_codasig;
    IF p_nota >= 10 THEN
        SET mensaje = 'Error: La nota no puede ser mayor a 10';
    ELSEIF p_nota < 0 THEN
        SET mensaje = 'Error: La nota no puede ser menor a 0';
    ELSE
        UPDATE lineamatricula
        SET nota = p_nota
        WHERE codmatr = p_codmatr AND codasig = p_codasig;
        SET mensaje = 'Nota actualizada correctamente';
        SELECT codmatr, codasig, nota FROM lineamatricula WHERE codmatr = p_codmatr AND codasig = p_codasig;
    END IF;
END //

DELIMITER ;

CALL actualizar_nota (14, 5, 9, @mensaje);
SELECT @mensaje;

-- =====================================================================================================================
-- Ejercicio 8

DELIMITER //

CREATE PROCEDURE eliminar_alumnos_sin_matricula (
    OUT contador INT
)
BEGIN
    DELETE FROM alumno WHERE dni NOT IN (SELECT dni FROM matricula);
    SET contador = ROW_COUNT();
END //

DELIMITER ;

CALL eliminar_alumnos_sin_matricula (@contador);
SELECT @contador;

-- =====================================================================================================================
-- Ejercicio 9

DELIMITER //

CREATE FUNCTION clasificar_alumno (
    p_dni VARCHAR(8),
    p_curso INT
)
RETURNS clasificacion VARCHAR(200)
BEGIN

    DECLARE nota_media DECIMAL(5,2);
    DECLARE clasificacion VARCHAR(200);

    IF nota_media >= 9 THEN
        SET clasificacion = 'Sobresaliente';
    ELSEIF nota_media >= 7 THEN
        SET clasificacion = 'Notable';
    ELSEIF nota_media >= 5 THEN
        SET clasificacion = 'Aprobado';
    ELSEIF nota_media < 5 THEN
        SET clasificacion = 'Suspenso';
    END IF;
    RETURN clasificacion;

    IF p_dni NOT EXISTS

END //

DELIMITER ;

