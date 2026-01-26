USE bdcentroidiomas;

-- 1. "Alumnos aprobados por curso (curso, nº alumnos aprobados)"
CREATE OR REPLACE VIEW alumnos_aprobados_por_curso AS
SELECT m.curso, COUNT(DISTINCT m.dni) AS NumAprobados
FROM
    Matricula m
    JOIN LineaMatricula lm ON m.codMatr = lm.codMatr
WHERE
    lm.nota >= 5
GROUP BY
    m.curso
ORDER BY m.curso;

-- 2. "Alumnos aprobados por curso y asignatura (curso, asignatura, nº alumnos aprobados)"
CREATE OR REPLACE VIEW alumnos_aprobados_curso_asig AS
SELECT m.curso, a.Nombre AS asignatura, COUNT(DISTINCT m.dni) AS NumAprobados
FROM
    Matricula m
    JOIN LineaMatricula lm ON m.codMatr = lm.codMatr
    JOIN Asignatura a ON lm.codAsig = a.codAsig
WHERE
    lm.nota >= 5
GROUP BY
    m.curso,
    a.Nombre;

-- 3. "Alumnos matriculados (dni, nombre, apellidos, curso, asignatura, ciclo)"
CREATE OR REPLACE VIEW alumnos_matriculados AS
SELECT
    al.dni,
    al.Nombre,
    CONCAT(
        al.prApellido,
        ' ',
        COALESCE(al.sgApellido, '')
    ) AS apellidos,
    m.curso,
    asig.Nombre AS asignatura,
    c.Nombre AS ciclo
FROM
    Alumno al
    JOIN Matricula m ON al.dni = m.dni
    JOIN LineaMatricula lm ON m.codMatr = lm.codMatr
    JOIN Asignatura asig ON lm.codAsig = asig.codAsig
    JOIN Ciclo c ON asig.codCF = c.CodCF;

-- 4. "Profesores (dni, nombre, apellidos, departamento)"
CREATE OR REPLACE VIEW vista_profesores AS
SELECT p.dni, p.Nombre, CONCAT(
        p.prApellido, ' ', COALESCE(p.sgApellido, '')
    ) AS apellidos, d.Nombre AS departamento
FROM Profesor p
    JOIN Departamento d ON p.CodDep = d.CodDep;

-- 5. "Jefes de Departamento (departamento, nombre y apellidos del jefe)"
CREATE OR REPLACE VIEW jefes_departamento AS
SELECT d.Nombre AS departamento, CONCAT(
        p.Nombre, ' ', p.prApellido, ' ', COALESCE(p.sgApellido, '')
    ) AS jefe
FROM Departamento d
    JOIN Profesor p ON d.dni = p.dni;

-- 6. "Asignaturas que imparte actualmente (en el último curso) cada profesor (dni, nombre y apellidos del profesor, nombre asignatura)"
CREATE OR REPLACE VIEW asignaturas_profesor_actual AS
SELECT p.dni, CONCAT(
        p.Nombre, ' ', p.prApellido, ' ', COALESCE(p.sgApellido, '')
    ) AS profesor, a.Nombre AS asignatura
FROM
    Profesor p
    JOIN Imparte i ON p.dni = i.dni
    JOIN Asignatura a ON i.codAsig = a.codAsig
WHERE
    i.curso = (
        SELECT MAX(curso)
        FROM Imparte
    );

-- 7. "Asignaturas por departamento (departamento, nombre del profesor, curso en el que imparte, asignatura)"
CREATE OR REPLACE VIEW asignaturas_por_departamento AS
SELECT
    d.Nombre AS departamento,
    CONCAT(
        p.Nombre,
        ' ',
        p.prApellido,
        ' ',
        COALESCE(p.sgApellido, '')
    ) AS profesor,
    i.curso,
    a.Nombre AS asignatura
FROM
    Departamento d
    JOIN Profesor p ON d.CodDep = p.CodDep
    JOIN Imparte i ON p.dni = i.dni
    JOIN Asignatura a ON i.codAsig = a.codAsig;

-- 8. "Alumnos sin matrícula en el curso actual (dni, nombre, apellidos)"
CREATE OR REPLACE VIEW alumnos_sin_matricula_actual AS
SELECT dni, Nombre, CONCAT(
        prApellido, ' ', COALESCE(sgApellido, '')
    ) AS apellidos
FROM Alumno
WHERE
    dni NOT IN(
        SELECT dni
        FROM Matricula
        WHERE
            curso = (
                SELECT MAX(curso)
                FROM Matricula
            )
    );

-- 9. "Profesores que no imparten asignaturas (dni, nombre, apellidos)"
CREATE OR REPLACE VIEW profesores_sin_asignaturas AS
SELECT dni, Nombre, CONCAT(
        prApellido, ' ', COALESCE(sgApellido, '')
    ) AS apellidos
FROM Profesor
WHERE
    dni NOT IN(
        SELECT DISTINCT
            dni
        FROM Imparte
    );

-- 10. Media de las notas obtenidas por ciclo ( ciclo, asignatura, curso matrícula, nota media)
CREATE OR REPLACE VIEW media_notas_ciclo AS
SELECT
    c.Nombre AS ciclo,
    a.Nombre AS asignatura,
    m.curso,
    AVG(lm.nota) AS nota_media
FROM
    Ciclo c
    JOIN Asignatura a ON c.CodCF = a.codCF
    JOIN LineaMatricula lm ON a.codAsig = lm.codAsig
    JOIN Matricula m ON lm.codMatr = m.codMatr
GROUP BY
    c.Nombre,
    a.Nombre,
    m.curso;