-- 1. Crea un usuario ‘director’, que pueda conectar desde cualquier máquina/IP.

CREATE USER IF NOT EXISTS 'director' @'%' IDENTIFIED BY 'pwd123';

-- 2. Verifica que se ha añadido a la vista mysql.user.

SELECT USER FROM mysql.user;

-- 3. Consulta los permisos que tiene el usuario director.

SHOW GRANTS FOR 'director' @'%';

-- 4. Conectado con el usuario ‘director’, ejecuta una consulta SELECT sobre la tabla profesor.

./mysql -u director -p
USE BDCentroIdiomas;
SELECT * FROM profesor;
-- Da error porque no hay permisos.

-- 5. Añade privilegios totales al usuario director, incluido el de dar permisos a otros usuarios, sobre toda la base de datos.

GRANT ALL PRIVILEGES ON bdcentroidiomas.* TO 'director' @'%'
WITH
GRANT OPTION;

GRANT CREATE USER ON *.* TO 'director'@'%';

-- 6. Consulta los permisos que tiene el usuario director.

SHOW GRANTS FOR 'director' @'%';

+---------------------------------------------------------------------------------+
| Grants for director@%                                                           |
+---------------------------------------------------------------------------------+
| GRANT CREATE USER ON *.* TO `director`@`%`                                      |
| GRANT ALL PRIVILEGES ON `bdcentroidiomas`.* TO `director`@`%` WITH GRANT OPTION |
+---------------------------------------------------------------------------------+

-- 7. Conectado con el usuario ‘director’, ejecuta una consulta SELECT sobre la tabla profesor.

SELECT * FROM profesor;

-- 8. Conectado con el usuario director crea el usuario ‘secretaria’ que accederá desde localhost.

CREATE USER 'secretaria' @'localhost' IDENTIFIED BY 'pwd123';

-- 9. Verifica que el usuario ‘secretaria’ se encuentra en ‘mysql.user’.

SELECT USER FROM mysql.user;

-- 10. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria' @'localhost';

+------------------------------------------------+
| Grants for secretaria@localhost                |
+------------------------------------------------+
| GRANT USAGE ON *.* TO `secretaria`@`localhost` |
+------------------------------------------------+

-- 11. Conectado con el usuario ‘secretaria’ ejecuta una select sobre la tabla matricula.

./mysql -u secretaria -p pwd123
USE BDCentroIdiomas;
SELECT * FROM matricula;
--Acceso denegado porque no hay permisos.

-- ERROR 1044 (42000): Access denied for user 'secretaria'@'localhost' to database 'bdcentroidiomas'

-- 12. Asigna al usuario ‘secretaria’ permisos de SELECT, INSERT, UPDATE sobre las tablas alumno, matricula y lineamatricula.

GRANT SELECT, INSERT, UPDATE ON bdcentroidiomas.alumno TO 'secretaria' @'localhost';
GRANT SELECT, INSERT, UPDATE ON bdcentroidiomas.matricula TO 'secretaria' @'localhost';
GRANT SELECT, INSERT, UPDATE ON bdcentroidiomas.lineamatricula TO 'secretaria' @'localhost';

-- 13. Conectado con el usuario ‘secretaria’ ejecuta una select sobre la tabla matricula.

USE BDCentroIdiomas
SELECT * FROM matricula;
--Ahora si tiene permisos.

-- 14. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria' @'localhost';

+------------------------------------------------------------------------------------------------+
| Grants for secretaria@localhost                                                                |
+------------------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `secretaria`@`localhost`                                                 |
| GRANT SELECT, INSERT, UPDATE ON `bdcentroidiomas`.`alumno` TO `secretaria`@`localhost`         |
| GRANT SELECT, INSERT, UPDATE ON `bdcentroidiomas`.`lineamatricula` TO `secretaria`@`localhost` |
| GRANT SELECT, INSERT, UPDATE ON `bdcentroidiomas`.`matricula` TO `secretaria`@`localhost`      |
+------------------------------------------------------------------------------------------------+

-- 15. Con el usuario ‘secretaria’ ejecuta un insert sobre la tabla matricula (39099100, 2026)

INSERT INTO matricula (dni, curso) VALUES ('39099100', 2026);

-- 16. Revoca el permiso de INSERT para el usuario ‘secretaria’ sobre la tabla matricula.

REVOKE INSERT ON bdcentroidiomas.matricula FROM 'secretaria' @'localhost';

-- 17. Verifica el efecto de la sentencia ejecutada en el punto anterior

INSERT INTO matricula (dni, curso) VALUES ('39099100', 2026);
-- ERROR 1142 (42000): INSERT command denied to user 'secretaria'@'localhost' for table 'matricula'

-- 18. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria' @'localhost';

+------------------------------------------------------------------------------------------------+
| Grants for secretaria@localhost                                                                |
+------------------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `secretaria`@`localhost`                                                 |
| GRANT SELECT, INSERT, UPDATE ON `bdcentroidiomas`.`alumno` TO `secretaria`@`localhost`         |
| GRANT SELECT, INSERT, UPDATE ON `bdcentroidiomas`.`lineamatricula` TO `secretaria`@`localhost` |
| GRANT SELECT, UPDATE ON `bdcentroidiomas`.`matricula` TO `secretaria`@`localhost`              |
+------------------------------------------------------------------------------------------------+

-- 19. Conectado con el usuario ‘director’ crea el usuario ‘jefe’ (conectando desde cualquier IP) con acceso INSERT, UPDATE, SELECT 
-- y DELETE sobre las tablas ciclo, imparte, asignatura, y permisos de SELECT, INSERT y GRANT OPTION sobre la tabla profesor.

CREATE USER 'jefe' @'%' IDENTIFIED BY 'pwd123';

GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.ciclo TO 'jefe' @'%';
GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.imparte TO 'jefe' @'%';
GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.asignatura TO 'jefe' @'%';
GRANT SELECT, INSERT, GRANT OPTION ON BDCentroIdiomas.profesor TO 'jefe' @'%';

-- 20. Conectado con el usuario ‘director’ crea el usuario ‘profesor’ que conecta desde localhost

CREATE USER 'profesor' @'localhost' IDENTIFIED BY 'pwd123';

-- 21. Consulta los permisos asignados a ‘profesor’

SHOW GRANTS FOR 'profesor' @'localhost';

+----------------------------------------------+
| Grants for profesor@localhost                |
+----------------------------------------------+
| GRANT USAGE ON *.* TO `profesor`@`localhost` |
+----------------------------------------------+

-- 22. Ejecuta una SELECT sobre la tabla profesor con el usuario ‘profesor’

SELECT * FROM profesor;
-- ERROR 1044 (42000): Access denied for user 'profesor'@'localhost' to database 'bdcentroidiomas'

-- 23. Conectado con el usuario ‘jefe’ asigna permiso de SELECT e INSERT al usuario ‘profesor’ sobre la tabla profesor

GRANT SELECT, INSERT ON BDCentroIdiomas.profesor TO 'profesor' @'localhost';

-- 24. Ejecuta una SELECT sobre la tabla profesor con el usuario ‘profesor’

SELECT * FROM profesor;

-- 25. Conectado con el usuario ‘jefe’ asigna permiso de UPDATE al usuario ‘profesor’ sobre la tabla profesor.

GRANT UPDATE ON BDCentroIdiomas.profesor TO 'profesor' @'localhost';
-- ERROR 1142 (42000): UPDATE command denied to user 'jefe'@'localhost' for table 'profesor'

-- 26. Consulta los permisos de los usuarios ‘jefe’ y ‘profesor’. ¿pueden actualizar la tabla ‘profesor’?

SHOW GRANTS FOR 'jefe' @'%';

+--------------------------------------------------------------------------------------+
| Grants for jefe@%                                                                    |
+--------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `jefe`@`%`                                                     |
| GRANT SELECT, INSERT, UPDATE, DELETE ON `bdcentroidiomas`.`asignatura` TO `jefe`@`%` |
| GRANT SELECT, INSERT, UPDATE, DELETE ON `bdcentroidiomas`.`ciclo` TO `jefe`@`%`      |
| GRANT SELECT, INSERT, UPDATE, DELETE ON `bdcentroidiomas`.`imparte` TO `jefe`@`%`    |
| GRANT SELECT, INSERT ON `bdcentroidiomas`.`profesor` TO `jefe`@`%` WITH GRANT OPTION |
+--------------------------------------------------------------------------------------+

SHOW GRANTS FOR 'profesor' @'localhost';

+--------------------------------------------------------------------------------+
| Grants for profesor@localhost                                                  |
+--------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `profesor`@`localhost`                                   |
| GRANT SELECT, INSERT ON `bdcentroidiomas`.`profesor` TO `profesor`@`localhost` |
+--------------------------------------------------------------------------------+º

-- No pueden actualizar la tabla profesor porque no tienen permiso UPDATE.

-- 27. Con el usuario ‘root’ crea el rol ‘docente’

CREATE ROLE 'docente';

-- 28. Con el usuario ‘root’ asigna permiso de UPDATE sobre la tabla ‘profesor’ al rol ‘docente’

GRANT UPDATE ON BDCentroIdiomas.profesor TO 'docente';

-- 29. Con el usuario ‘root’ asigna el rol ‘docente’ al usuario ‘jefe’

GRANT 'docente' TO 'jefe' @'%';

-- 30. Con el usuario ‘jefe’ activa el rol ‘docente’

SET DEFAULT ROLE 'docente' TO 'jefe' @'%';

-- 31. Verifica cuál es el rol activo para ‘jefe’

SELECT CURRENT_ROLE();

-- 32. Con el usuario ‘jefe’ actualiza la tabla profesor, cambia el segundo apellido del profesor con dni 28900194, a ‘Català’

UPDATE profesor SET apellido2 = 'Català' WHERE dni = '28900194';

| 28900194 | David        | Negro      | Català     |      1 |

-- 33. Con el usuario ‘root’ asigna el rol ‘docente’ al usuario ‘profesor’

GRANT 'docente' TO 'profesor'@'localhost';

-- 34. Realiza los cambios necesarios para que el usuario ‘profesor’ tenga como rol predeterminado ‘docente’

SET DEFAULT ROLE 'docente' TO 'profesor'@'localhost';

-- 35. Conecta con el usuario ‘profesor’ y consulta el rol activo para dicho usuario.

SELECT CURRENT_ROLE();

-- 36. Con el usuario ‘profesor’ actualiza la tabla profesor, cambia el segundo apellido del profesor con dni 28900194, a ‘Catalán’

UPDATE profesor SET apellido2 = 'Catalán' WHERE dni = '28900194';

| 28900194 | David        | Negro      | Catalán    |      1 |