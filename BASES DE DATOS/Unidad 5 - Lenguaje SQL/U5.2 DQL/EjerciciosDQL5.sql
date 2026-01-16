"EJERCICIOS DQL 5" EjerciciosDQL_5.pdf

1. "Obtener el valor del atributo netapa y la ciudad de salida de aquellas etapas que
no tengan puertos de montaña."

select netapa 
from etapa 
where netapa NOT IN (select distinct netapa from puerto);

2. "Obtener la edad media de los ciclistas que han ganado alguna etapa."

SELECT AVG(edad)
FROM ciclista
WHERE dorsal IN (SELECT DISTINCT dorsal FROM etapa);

3. "Selecciona el nombre de los puertos con una altura superior a la altura media de
todos los puertos."

SELECT nompuerto
FROM puerto
WHERE altura > (SELECT altura FROM puerto);

4. "Obtener el nombre de la ciudad de salida y de llegada de las etapas donde
estén los puertos con mayor pendiente."

SELECT salida, llegada
FROM etapa
WHERE netapa IN (SELECT pendiente FROM puerto ORDER BY altura ASC);

5. "Obtener el dorsal y el nombre de los ciclistas que han ganado los puertos de
mayor altura."

6. "Obtener el nombre del ciclista más joven."

7. "Obtener el nombre del ciclista más joven que ha ganado al menos una etapa."

8. "Obtener el nombre de los ciclistas que han ganado más de un puerto."

9. "Obtener el valor del atributo netapa de aquellas etapas tales que todos los
puertos que están en ellas tienen más de 700 metros de altura."

10. "Obtener el nombre y el director de los equipos tales que todos sus ciclistas son
mayores de 26 años."

11. "Obtener el dorsal y el nombre de los ciclistas tales que todas las etapas que han
ganado tienen más de 170 km (es decir que sólo han ganado etapas de más de
170 km)."

12. "Obtener el nombre de los ciclistas que han ganado todos los puertos de una
etapa y además han ganado esa misma etapa."

13. "Obtener el nombre de los equipos tales que todos sus corredores han llevado
algún maillot o han ganado algún puerto."

14. "Obtener el código y el color de aquellos maillots que sólo han sido llevados por
ciclistas de un mismo equipo."