'EJERCICIOS DQL 1' EjerciciosDQL_1.pdf

1.
SELECT nombrecine 
FROM cine 
WHERE poblacioncine='Valencia';

2.
SELECT nombrecine, idcine 
FROM cine 
WHERE poblacioncine='Cullera' 
OR poblacioncine='Gandia';

3.
SELECT nombrecine, poblacioncine 
FROM cine 
WHERE idcine > 10 
AND idcine < 30;

4.
SELECT nombrecine, poblacioncine 
FROM cine 
WHERE nombrecine LIKE 'C%' 
ORDER BY poblacioncine;

5.
SELECT poblacioncine 
FROM cine 
WHERE nombrecine LIKE '%a' 
ORDER BY poblacioncine DESC;

6.
SELECT * 
FROM cine 
WHERE idcine BETWEEN 8 AND 15;

7.
SELECT nombrecine, poblacioncine
FROM cine 
WHERE idcine > 32 AND poblacioncine LIKE '%o%' AND nombrecine LIKE '%e%e%'
ORDER BY poblacioncine DESC, nombrecine ASC;

8.
SELECT DISTINCT poblacioncine
FROM cine
WHERE nombrecine LIKE '%u_a%'
LIMIT 2;

9.
SELECT poblacioncine, nombrecine, idcine
FROM cine
WHERE idcine < 30 (AND poblacioncine = 'Sagunto' OR nombrecine) LIKE '%ca%'
ORDER BY poblacioncine, nombrecine ASC; 

10.
SELECT COUNT(nombrecine)
FROM cine
WHERE poblacioncine = 'Valencia';

11.
SELECT nombrecine, poblacioncine
FROM cine
WHERE nombrecine LIKE 'Cine%'
ORDER BY idcine
LIMIT 5;

12.
SELECT nombrecine, poblacioncine
FROM cine
WHERE nombrecine LIKE 'Cine%'
ORDER BY poblacioncine DESC
LIMIT 5;

13.
SELECT nombrecine, idcine
FROM cine
ORDER BY nombrecine DESC
LIMIT 8;

14.
SELECT nombrecine, poblacioncine
FROM cine
WHERE nombrecine LIKE '%ABC%' AND poblacioncine = 'Gandia';

15.
SELECT COUNT(*)
FROM cine
WHERE nombrecine LIKE '%o';