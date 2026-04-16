CREATE PROCEDURE p_existeAlumnoCurso (
    IN p_dni varchar(8),
    IN p_curso int
    OUT p_existe varchar(20)
)
BEGIN
    SELECT dni, curso
    

CALL p_existeAlumnoCurso('12345678', 2025);