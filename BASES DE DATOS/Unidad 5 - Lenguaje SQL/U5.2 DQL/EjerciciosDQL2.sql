'EJERCICIOS DQL 2' EjerciciosDQL_2.pdf

-- BDCINES

1.
SELECT COUNT(DISTINCT poblacioncine) AS 'Poblaciones con cine'
FROM cine;

2. 
SELECT COUNT(idsala) AS 'Número de salas'
FROM sala;

3. 
SELECT COUNT(idsala) AS 'Número de salas'
FROM sala
WHERE idcine = 1
GROUP BY idcine;

4.
SELECT idcine, COUNT(idsala) AS 'Número de salas'
FROM sala
GROUP BY idcine;

5.
SELECT poblacioncine AS 'Población', COUNT(idcine) AS 'Número de cines'
FROM cine
GROUP BY poblacioncine;

6.
SELECT nombrecine AS 'Cines que contienen e_'
FROM cine
WHERE nombrecine LIKE '%e_';

7.
SELECT idcine, MAX(butacasSala) AS 'Sala con más butacas'
FROM sala
GROUP BY idcine;

8.
SELECT idsala AS 'Sala con menos butacas'
FROM sala
WHERE butacasSala = (SELECT MIN(butacasSala) FROM sala)
GROUP BY idsala;

9.
SELECT idcine, AVG(butacasSala) AS 'Media de butacas'
FROM sala
GROUP BY idcine;

10.
SELECT idcine, SUM(butacasSala) AS 'Total de butacas'
FROM sala
GROUP BY idcine;

11.
SELECT idcine, AVG(butacasSala) AS 'Media de butacas por cine'
FROM sala
GROUP BY idcine;

12.
SELECT idcine, AVG(butacasSala) AS 'Media de butacas por cine'
FROM sala
WHERE butacasSala >= 110
GROUP BY idcine;

-- BDHOTELES

13.
SELECT *, m2 + 10 AS 'Metros incrementados'
FROM habitacion;


14.
SELECT *
FROM habitacion
WHERE (m2 / 2) > 15;

15.
SELECT idhabitacion, camas
FROM habitacion
WHERE idhotel > 2;

16.
SELECT camas, precio, precio / 0.1 AS 'Precio Descuento'
FROM habitacion
WHERE camas >= 2;

17.
SELECT idhabitacion, m2
FROM habitacion
WHERE (m2 > 35);