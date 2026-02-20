"EJERCICIOS DQL 4" EjerciciosDQL_4.pdf

1. "Obtener el nombre y la categoría de los puertos ganados por ciclistas del equipo
‘Banesto’."

SELECT p.nompuerto, p.categoria
FROM puerto p
JOIN llevar l ON p.dorsal = l.dorsal
JOIN ciclista c ON l.dorsal = c.dorsal
WHERE c.nomeq = 'Banesto';

2. "Obtener el nombre de cada puerto indicando el número (netapa) y los kilómetros
de la etapa en la que se encuentra el puerto."

SELECT nompuerto, netapa, km
FROM puerto;


3. Obtener el ciclista y edad de los ciclistas que han llevado el maillot Rosa
4. Obtener el nombre de los equipos que tienen ciclistas que hayan ganado el
premio de 8.000.000
5. Obtener el nombre de los ciclistas que han ganado los puertos de categoría E.
6. Obtener la ciudad de salid de las etapas que tienen puerto
7. Obtener el nombre y el director de los equipos a los que pertenezca algún ciclista
mayor de 33 años.
8. Obtener el nombre de los ciclistas con el color de cada maillot que hayan llevado.
9. Obtener pares de nombre de ciclista y número de etapa tal que ese ciclista haya
ganado esa etapa habiendo llevado el maillot de color ‘Amarillo’ al menos una
vez.

10. Obtener las etapas que empiezan en una ciudad en la que no ha finalizado
ninguna otra etapa.

SELECT *
FROM etapa e1
LEFT JOIN etapa e2 ON e1.salida = e2.llegada
WHERE e2.llegada IS NULL;

11. Obtener las etapas que no empiezan en la misma ciudad que terminó la anterior
etapa. Las etapas están ordenadas por netapa.

