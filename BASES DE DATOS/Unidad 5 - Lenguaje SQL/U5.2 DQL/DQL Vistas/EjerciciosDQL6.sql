'EJERCICIOS DQL 6' "EjerciciosDQL6-Vistas.pdf"

1. "Alumnos aprobados por curso (curso, nº alumnos aprobados)"

CREATE VIEW alumnos_aprobados_por_curso (curso, NumAprobados) AS
SELECT m.curso, COUNT(DISTINCT a.dni)
FROM alumno a 
INNER JOIN matricula m
ON a.dni = m.dni
INNER JOIN lineamatricula l
ON m.codmatr = l.codmatr
WHERE l.nota >= 5
GROUP BY m.curso
ORDER BY curso;

SELECT * FROM alumnos_aprobados_por_curso;

2. "Alumnos aprobados por curso y asignatura (curso, asignatura, nº alumnos
aprobados)"

CREATE VIEW AprobadosCursoAsig AS
SELECT m.curso, aa.nombre, COUNT(DISTINCT a.dni)
FROM alumno a 
INNER JOIN matricula m
ON a.dni = m.dni
INNER JOIN lineamatricula l
ON m.codmatr = l.codmatr
INNER JOIN asignatura aa
ON aa.codasig = l.codasig
WHERE l.nota >= 5
GROUP BY m.curso, aa.nombre
ORDER BY curso;

SELECT * FROM AprobadosCursoAsig;

3. "Alumnos matriculados (dni, nombre, apellidos, curso, asignatura, ciclo)"

CREATE VIEW AlumnosMatriculados AS
SELECT a.dni, a.nombre AS NombreAlumno, a.prApellido, a.sgApellido, m.curso, aa.nombre AS NombreAsignatura, c.nombre AS NombreCiclo
FROM alumno a
INNER JOIN matricula m
ON a.dni = m.dni
INNER JOIN lineamatricula l
ON m.codmatr = l.codmatr
INNER JOIN asignatura aa
ON l.codasig = aa.codasig
INNER JOIN ciclo c
ON aa.codcf = c.codcf
ORDER BY a.dni;

SELECT * FROM AlumnosMatriculados;

4. "Profesores (dni, nombre, apellidos, departamento)"

CREATE VIEW Profesores AS
SELECT p.dni, p.nombre, p.prApellido, p.sgApellido, d.nombre AS departamento
FROM profesor p
INNER JOIN departamento d
ON p.coddep = d.coddep;

SELECT * FROM Profesores;

5. "Jefes de Departamento (departamento, nombre y apellidos del jefe)"

CREATE VIEW JefesDepartamento AS
SELECT d.nombre AS departamento, p.nombre, p.prApellido, p.sgApellido
FROM departamento d
INNER JOIN profesor p
ON d.dni = p.dni;

SELECT * FROM JefesDepartamento;

6. "Asignaturas que imparte actualmente (en el último curso) cada profesor (dni,
nombre y apellidos del profesor, nombre asignatura)"

CREATE VIEW AsignaturasImparteActual AS
SELECT p.dni, p.nombre, p.prapellido, p.sgapellido, a.nombre AS nombreAsignatura
FROM profesor p
INNER JOIN imparte i
ON p.dni = i.dni
INNER JOIN asignatura a
ON i.codasig = a.codasig
WHERE i.curso = (SELECT MAX(curso) FROM imparte WHERE dni = p.dni);

SELECT * FROM AsignaturasImparteActual;

7. "Asignaturas por departamento (departamento, nombre del profesor, curso en el
que imparte, asignatura)"

CREATE VIEW AsignaturasPorDepartamento AS
SELECT d.nombre AS NombreDepartamento, p.nombre AS NombreProfesor, i.curso, aa.nombre AS nombreAsignatura
FROM departamento d
INNER JOIN profesor p
ON p.coddep = d.coddep
INNER JOIN imparte i
ON p.dni = i.dni
INNER JOIN asignatura aa
ON i.codasig = aa.codasig
ORDER BY d.nombre;

SELECT * FROM AsignaturasPorDepartamento;

8. "Alumnos sin matrícula en el curso actual (dni, nombre, apellidos)"

CREATE VIEW AlumnosSinMatricula AS
SELECT a.dni, a.nombre, a.prapellido, a.sgapellido, m.curso
FROM alumno a
LEFT JOIN matricula m
ON a.dni = m.dni
AND m.curso = (SELECT MAX(curso) FROM matricula)
WHERE m.curso IS NULL;

SELECT * FROM AlumnosSinMatricula;

9. "Profesores que no imparten asignaturas (dni, nombre, apellidos)"

SELECT p.dni, p.nombre, p.prapellido, p.sgapellido
FROM profesor p
LEFT JOIN imparte i
ON p.dni = i.dni
WHERE i.codasig IS NULL;

10. "Media de las notas obtenidas por ciclo ( ciclo, asignatura, curso matrícula, nota
media)"

CREATE VIEW MediaNotasPorCiclo AS
SELECT AVG(l.nota), c.nombre AS nombreCiclo, aa.nombre AS nombreAsignatura, m.curso
FROM matricula m
INNER JOIN lineamatricula l
ON m.codmatr = l.codmatr
INNER JOIN asignatura aa
ON l.codasig = aa.codasig
INNER JOIN ciclo c
ON aa.codcf = c.codcf
GROUP BY c.nombre, aa.nombre, m.curso;

SELECT * FROM MediaNotasPorCiclo;   
