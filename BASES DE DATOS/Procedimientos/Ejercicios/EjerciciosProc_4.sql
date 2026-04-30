-- EJERCICIO 3
    DROP PROCEDURE IF EXISTS contar_alumnos_bilingues;
    DELIMITER //

    CREATE PROCEDURE contar_alumnos_bilingues (OUT numBil Int)
    BEGIN
        DECLARE numAlumnos INT;
        DECLARE nomAlum VARCHAR(30);
        DECLARE esBilin CHAR(1);
        DECLARE contador INT DEFAULT 0;

        SET numBil = 0;

        SELECT count(dni) INTO numAlumnos FROM alumno;

        IF numAlumnos > 0 THEN
            REPEAT
                SELECT nombre, bilingue
                FROM alumno
                LIMIT contador, 1;

                IF esBilin = 'S' THEN
                    SET numBil = numBil + 1;
                    SELECT concat('El alumno ', nomAlum, ' es bilingüe.');
                END IF;

                SET contador = contador + 1;
            UNTIL numAlumnos = contador
            END REPEAT;
        ELSE
            SET numBil = 0;
        END IF;

    END //

DELIMITER ;

CALL contar_alumnos_bilingues(@numBil);

--EJERCICIO 4

DELIMITER //
CREATE FUNCTION nota_media_alumno (
    IN p_dni VARCHAR(8)
    IN p_curso INT
) 
RETURNS decimal(3,1)
BEGIN       
    DECLARE v_numNotas INT;
    DECLARE v_contador INT;
    DECLARE v_sumaNotas DECIMAL(3,1);
    DECLARE v_notaAux DECIMAL(3,1);
    DECLARE v_notaMedia DECIMAL(3,1);

    SET v_contador = 0;
    SET v_sumaNotas = 0;

    SELECT count(dni) INTO v_numNotas FROM alumno;

    WHILE v_contador < v_numNotas DO
        SELECT nota INTO v_notaAux FROM matricula m 
        INNER JOIN lineamatricula l ON m.codmatr = l.codmatr 
        WHERE codmatr = (SELECT codmatr FROM matricula WHERE dni = p_dni);
        SET v_sumaNotas = v_sumaNotas + v_notaAux;
        SET v_contador = v_contador + 1;
    END WHILE;

    SET v_notaMedia = v_sumaNotas / v_numNotas;
    RETURN v_notaMedia;


END //

DELIMITER ;

CALL nota_media_alumno('11112222', 2);


