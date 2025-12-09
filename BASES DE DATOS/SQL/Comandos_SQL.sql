1. ENTRAR A MYSQL VIA TERMINAL:

cd "C:\Program Files\MySQL\MySQL Workbench 8.0"
.\mysql.exe -u root -p
Contraseña: mysql

2. COMANDOS DDL SQL:

SHOW DATABASE; -- Mostrar bases de datos.
SHOW TABLES; -- Mostrar tablas de la base de datos actual.
CREATE DATABASE (nombre); -- Crear base de datos.
CREATE TABLE (nombre); -- Crear tabla.
ALTER TABLE (tabla); -- Editar tabla / Añadir a una tabla.
USE (tabla); -- Seleccionar base de datos.
DESC (tabla); -- Describir tabla.

3. COMANDOS DQL SQL:

SELECT (columnas) FROM (tabla); -- Seleccionar columnas de una tabla.
SELECT * FROM (tabla); -- Seleccionar todas las columnas de una tabla.
WHERE (condición); -- Filtrar resultados según una condición.
ORDER BY (columna) ASC/DESC; -- Ordenar resultados por una columna en orden ascendente o descendente.
SELECT COUNT(*) FROM (tabla); -- Contar el número de filas en una tabla.
SELECT AVG(columna) FROM (tabla); -- Calcular el promedio de una columna.
SELECT SUM(columna) FROM (tabla); -- Calcular la suma de una columna.
SELECT DISTINCT (columna) FROM (tabla); -- Seleccionar valores únicos de una columna.
SELECT MAX(columna) FROM (tabla); -- Obtener el valor máximo de una columna.
SELECT MIN(columna) FROM (tabla); -- Obtener el valor mínimo de una columna.

-- Ejemplo de consultas DQL:
SELECT nombrecine 
FROM cine 
WHERE poblacioncine='Valencia';
