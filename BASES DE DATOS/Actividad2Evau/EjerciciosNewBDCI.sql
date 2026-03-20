-- 1
INSERT INTO newalumno (dni, nombre, prApellido, sgApellido, Bilingue) VALUES
('1235678A', 'Carlos', 'Martínez', 'López', 'S'),
('2346789B', 'Ana', 'González', 'Ruiz', 'S'),
('3457890C', 'Lucía', 'Fernández', 'Morales', 'N'),
('4568901D', 'David', 'Gómez', 'Navarro', 'N'),
('5679012E', 'María', 'Díaz', 'Santos', 'S');

-- 2
INSERT INTO newciclo (nombre, siglas) VALUES
('Desarrollo de aplicaciones web', 'DAW');

-- 3
UPDATE newalumno 
SET bilingue = 'S'
WHERE sgapellido LIKE '%s' OR sgapellido LIKE '%e';

-- 4
INSERT INTO newasignatura (nombre, numhoras, bilingue, codcf) VALUES
('Sistemas Informáticos', '205', 'N', '1'),
('Bases de Datos', '205', 'N', '1'),
('Programacion', '270', 'N', '1'),
('Lenguaje de Marcas y Sistemas de gestion de informacion', '140', 'N', '1'),
('Entornos de Desarrollo', '90', 'N', '1'),
('Formacion y Orientacion Laboral', '90', 'N', '1');

-- 5
INSERT INTO newalumbil (dni, fecha, lugar)
SELECT a.dni, CURRENT_DATE(), NULL
FROM newalumno a
WHERE a.bilingue = 'S';

-- 7
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM newalumno
WHERE dni LIKE '%A';
DELETE FROM newalumbil
WHERE dni LIKE '%A';
SET FOREIGN_KEY_CHECKS = 1;


-- 8
CREATE VIEW AsignaturasJefe AS
SELECT
    d.dni AS dniJefeDpto,
    d.CodDep AS CodDpto,
    d.Nombre AS NombreDpto,
    i.curso AS Curso,
    a.Nombre AS Asignatura,
    c.Siglas AS CicloAsig
FROM Departamento d
JOIN Imparte i ON d.dni = i.dni
JOIN Asignatura a ON i.codAsig = a.codAsig
JOIN Ciclo c ON a.codCF = c.CodCF
ORDER BY dniJefeDpto, CicloAsig, Curso, Asignatura;


