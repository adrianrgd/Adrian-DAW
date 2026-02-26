-- 1. Crea un usuario ‘director’, que pueda conectar desde cualquier máquina/IP.

CREATE USER IF NOT EXISTS 'director'@'%' IDENTIFIED BY 'pwd123';

-- 2. Verifica que se ha añadido a la vista mysql.user.

SELECT USER FROM mysql.user;

-- 3. Consulta los permisos que tiene el usuario director.

SHOW GRANTS FOR 'director'@'%';

-- 4. Conectado con el usuario ‘director’, ejecuta una consulta SELECT sobre la tabla profesor.

./mysql -u director -p pwd123

USE BDCentroIdiomas;

SELECT * FROM profesor; -- Da error porque no hay permisos.

-- 5. Añade privilegios totales al usuario director, incluido el de dar permisos a otros usuarios, sobre toda la base de datos.

GRANT ALL PRIVILEGES ON *.* TO 'director'@'%';
GRANT ALL PRIVILEGES ON BDCentroIdiomas.* TO 'director'@'%' WITH GRANT OPTION;

-- 6. Consulta los permisos que tiene el usuario director.

SHOW GRANTS FOR 'director'@'%';

-- 7. Conectado con el usuario ‘director’, ejecuta una consulta SELECT sobre la tabla profesor.

./mysql -u director -p pwd123

USE BDCentroIdiomas;

SELECT * FROM profesor;

-- 8. Conectado con el usuario director crea el usuario ‘secretaria’ que accederá desde localhost.

CREATE USER IF NOT EXISTS 'secretaria'@'localhost' IDENTIFIED BY 'pwd123';

-- 9. Verifica que el usuario ‘secretaria’ se encuentra en ‘mysql.user’.

SELECT USER FROM mysql.user;

-- 10. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria'@'localhost';

-- 11. Conectado con el usuario ‘secretaria’ ejecuta una select sobre la tabla matricula.

./mysql -u secretaria -p pwd123

USE BDCentroIdiomas;

SELECT * FROM matricula; --Acceso denegado porque no hay permisos.

-- ERROR 1044 (42000): Access denied for user 'secretaria'@'localhost' to database 'bdcentroidiomas'

-- 12. Asigna al usuario ‘secretaria’ permisos de SELECT, INSERT, UPDATE sobre las tablas alumno, matricula y lineamatricula.

GRANT SELECT, INSERT, UPDATE ON BDCentroIdiomas.alumno  TO 'secretaria'@'localhost';
GRANT SELECT, INSERT, UPDATE ON BDCentroIdiomas.matricula TO 'secretaria'@'localhost';
GRANT SELECT, INSERT, UPDATE ON BDCentroIdiomas.lineamatricula TO 'secretaria'@'localhost';

-- 13. Conectado con el usuario ‘secretaria’ ejecuta una select sobre la tabla matricula.

./mysql -u secretaria -p pwd123

USE BDCentroIdiomas;

SELECT * FROM matricula; --Ahora si tiene permisos.

-- 14. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria'@'localhost';

-- 15. Con el usuario ‘secretaria’ ejecuta un insert sobre la tabla matricula (39099100, 2026)

INSERT INTO matricula (dni, curso) VALUES ('39099100', 2026);

-- 16. Revoca el permiso de INSERT para el usuario ‘secretaria’ sobre la tabla matricula.

REVOKE INSERT ON BDCentroIdiomas.matricula FROM 'secretaria'@'localhost';

-- 17. Verifica el efecto de la sentencia ejecutada en el punto anterior

INSERT INTO matricula (dni, curso) VALUES ('39099100', 2026);

-- ERROR 1142 (42000): INSERT command denied to user 'secretaria'@'localhost' for table 'matricula' 

-- 18. Consulta los permisos asignados a ‘secretaria’

SHOW GRANTS FOR 'secretaria'@'localhost';

-- 19. Conectado con el usuario ‘director’ crea el usuario ‘jefe’ (conectando desde cualquier IP) con acceso INSERT, UPDATE, SELECT y DELETE sobre las tablas ciclo, imparte, asignatura. Y permisos de SELECT, INSERT y GRANT OPTION sobre la tabla profesor.

CREATE USER IF NOT EXISTS 'jefe'@'%' IDENTIFIED BY 'pwd123';

GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.ciclo TO 'jefe'@'%';
GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.imparte TO 'jefe'@'%';
GRANT INSERT, UPDATE, SELECT, DELETE ON BDCentroIdiomas.asignatura TO 'jefe'@'%';
GRANT INSERT, UPDATE, SELECT, GRANT OPTION ON BDCentroIdiomas.profesor TO 'jefe'@'%';

-- 20. Conectado con el usuario ‘director’ crea el usuario ‘profesor’ que conecta desde localhost

CREATE USER IF NOT EXISTS 'profesor'@'localhost' IDENTIFIED BY 'pwd123';

-- 21. Consulta los permisos asignados a ‘profesor’

SHOW GRANTS FOR 'profesor'@'localhost';

-- 22. Ejecuta una SELECT sobre la tabla profesor con el usuario ‘profesor’

SELECT * FROM profesor;

-- ERROR 1044 (42000): Access denied for user 'profesor'@'localhost' to database 'bdcentroidiomas'

-- 23. Conectado con el usuario ‘jefe’ asigna permiso de SELECT e INSERT al usuario ‘profesor’ sobre la tabla profesor

GRANT SELECT, INSERT ON BDCentroIdiomas.profesor TO 'profesor'@'localhost';

-- 24. Ejecuta una SELECT sobre la tabla profesor con el usuario ‘profesor’

SELECT * FROM profesor;

-- 25. Conectado con el usuario ‘jefe’ asigna permiso de UPDATE al usuario ‘profesor’ sobre la tabla profesor.

GRANT UPDATE ON BDCentroIdiomas.profesor TO 'profesor'@'localhost';

-- 26. Consulta los permisos de los usuarios ‘jefe’ y ‘profesor’. ¿pueden actualizar la tabla ‘profesor’?

SHOW GRANTS FOR 'jefe'@'%';
SHOW GRANTS FOR 'profesor'@'localhost';

-- 27. Con el usuario ‘director’ crea el rol ‘docente’
-- 28. Con el usuario ‘director’ asigna permiso de UPDATE sobre la tabla ‘profesor’ al rol ‘docente’
-- 29. Con el usuario ‘director’ asigna el rol ‘docente’ al usuario ‘jefe’
-- 30. Con el usuario ‘jefe’ activa el rol ‘docente’
-- 31. Verifica cuál es el rol activo para ‘jefe’
-- 32. Con el usuario ‘jefe’ actualiza la tabla profesor, cambia el segundo apellido del profesor con dni 28900194, a ‘Català’
-- 33. Con el usuario ‘director’ asigna el rol ‘docente’ al usuario ‘profesor’
-- 34. Realiza los cambios necesarios para que el usuario ‘profesor’ tenga como rol predeterminado ‘docente’
-- 35. Conecta con el usuario ‘profesor’ y consulta el rol activo para dicho usuario.
-- 36. Con el usuario ‘profesor’ actualiza la tabla profesor, cambia el segundo apellido del profesor con dni 28900194, a ‘Catalán’