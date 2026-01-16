"EJERCICIOS DQL 4" EjerciciosDQL_4.pdf

1. Obtener el nombre y la categoría de los puertos ganados por ciclistas del equipo
‘Banesto’.

SELECT p.nompuerto, p.categoria
FROM puerto p
JOIN llevar l ON p.dorsal = l.dorsal
JOIN ciclista c ON l.dorsal = c.dorsal
WHERE c.nomeq = 'Banesto';

10. Obtener las etapas que empiezan en una ciudad en la que no ha finalizado
ninguna otra etapa.

SELECT *
FROM etapa e1
LEFT JOIN etapa e2 ON e1.salida = e2.llegada
WHERE e2.llegada IS NULL;

11. Obtener las etapas que no empiezan en la misma ciudad que terminó la anterior
etapa. Las etapas están ordenadas por netapa.

