-- La empresa Chinook Music Store ha detectado accesos indebidos a su base de datos.
-- Tú eres el nuevo Administrador de Seguridad y debes rediseñar el control de accesos.
-- • Solo puedes usar instrucciones DCL.
-- • Cada reto debe verificarse con SHOW GRANTS, CURRENT_ROLE() o prueba real.
-- • No avances si el objetivo no se cumple.
-- • Aplica el principio de mínimo privilegio.
-- • Si una verificación falla, debes corregir antes de avanzar.

-- A)
-- 1. Verifica que existe la base de datos Chinook.

    SHOW DATABASES;

    +-----------------------+
    | Database              |
    +-----------------------+
    | bbdd2                 |
    | bbdd3                 |
    | bbdd4                 |
    | bdcentroidiomas       |
    | bdcines               |
    | bdhoteles             |
    | bdtiendaonline        |
    | chinook_autoincrement |
    | ciclismo              |
    | information_schema    |
    | mysql                 |
    | performance_schema    |
    | promecamping          |
    | sakila                |
    | sys                   |
    | test                  |
    | world                 |
    +-----------------------+

-- 2. Explora sus tablas.

    SHOW TABLES;

    +---------------------------------+
    | Tables_in_chinook_autoincrement |
    +---------------------------------+
    | album                           |
    | artist                          |
    | customer                        |
    | employee                        |
    | genre                           |
    | invoice                         |
    | invoiceline                     |
    | mediatype                       |
    | playlist                        |
    | playlisttrack                   |
    | track                           |
    +---------------------------------+

-- 3. Descubre tus privilegios actuales. Si tienes privilegios administrativos, puedes continuar.

    SHOW GRANTS FOR CURRENT_USER() \G;

    *************************** 1. row ***************************
    Grants for root@localhost: GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, RELOAD, SHUTDOWN, PROCESS, FILE, REFERENCES, INDEX, ALTER, SHOW DATABASES, SUPER, CREATE TEMPORARY TABLES, LOCK TABLES, EXECUTE, REPLICATION SLAVE, REPLICATION CLIENT, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, CREATE USER, EVENT, TRIGGER, CREATE TABLESPACE, CREATE ROLE, DROP ROLE ON *.* TO `root`@`localhost` WITH GRANT OPTION
    *************************** 2. row ***************************
    Grants for root@localhost: GRANT APPLICATION_PASSWORD_ADMIN,AUDIT_ABORT_EXEMPT,AUDIT_ADMIN,AUTHENTICATION_POLICY_ADMIN,BACKUP_ADMIN,BINLOG_ADMIN,BINLOG_ENCRYPTION_ADMIN,CLONE_ADMIN,CONNECTION_ADMIN,ENCRYPTION_KEY_ADMIN,FIREWALL_EXEMPT,FLUSH_OPTIMIZER_COSTS,FLUSH_STATUS,FLUSH_TABLES,FLUSH_USER_RESOURCES,GROUP_REPLICATION_ADMIN,GROUP_REPLICATION_STREAM,INNODB_REDO_LOG_ARCHIVE,INNODB_REDO_LOG_ENABLE,PASSWORDLESS_USER_ADMIN,PERSIST_RO_VARIABLES_ADMIN,REPLICATION_APPLIER,REPLICATION_SLAVE_ADMIN,RESOURCE_GROUP_ADMIN,RESOURCE_GROUP_USER,ROLE_ADMIN,SENSITIVE_VARIABLES_OBSERVER,SERVICE_CONNECTION_ADMIN,SESSION_VARIABLES_ADMIN,SET_USER_ID,SHOW_ROUTINE,SYSTEM_USER,SYSTEM_VARIABLES_ADMIN,TABLE_ENCRYPTION_ADMIN,TELEMETRY_LOG_ADMIN,XA_RECOVER_ADMIN ON *.* TO `root`@`localhost` WITH GRANT OPTION
    *************************** 3. row ***************************
    Grants for root@localhost: GRANT PROXY ON ``@`` TO `root`@`localhost` WITH GRANT OPTION

-- B)
-- 4. Crea el usuario agente_lectura que accederá desde localhost

    CREATE USER 'agente_lectura'@'localhost' IDENTIFIED BY 'pwd123';

    SELECT USER, HOST FROM mysql.user;
    | agente_lectura   | localhost |

-- 5. Sin otorgar permisos, intenta hacer SELECT desde otra sesión.

    ./mysql -u agente_lectura -p --Para logear en la base de datos con el usuario agente_lectura


    SELECT * FROM chinook_autoincrement.album; --Intentamos seleccionar la tabla album.
    -- ERROR 1142 (42000): SELECT command denied to user 'agente_lectura'@'localhost' for table 'album'
    -- No podemos acceder porque solo tenemos permiso para acceder a mysql, no a la base de datos chinook_autoincrement.

-- 6. Otorga solo SELECT sobre Chinook.

    GRANT SELECT ON chinook_autoincrement.* TO 'agente_lectura'@'localhost';

-- 7. Verifica los privilegios

    SHOW GRANTS FOR 'agente_lectura'@'localhost';

    +---------------------------------------------------------------------------+
    | Grants for agente_lectura@localhost                                       |
    +---------------------------------------------------------------------------+
    | GRANT USAGE ON *.* TO `agente_lectura`@`localhost`                        |
    | GRANT SELECT ON `chinook_autoincrement`.* TO `agente_lectura`@`localhost` |
    +---------------------------------------------------------------------------+

-- 8. Comprueba que INSERT falla.

    INSERT INTO chinook_autoincrement.album (Title, ArtistId) VALUES ('Album 1', 1);
    -- ERROR 1142 (42000): INSERT command denied to user 'agente_lectura'@'localhost' for table 'album'

-- C)
-- 9. Crea el usuario ventas_user
-- 10. Otorga a ventas_user: SELECT e INSERT sobre INVOICE. SELECT sobre CUSTOMER
-- 11. Verifica los privilegios
-- 12. Comprueba que no puede consultar EMPLOYEE
-- 13. ¿Qué diferencia observas entre privilegios a nivel base de datos y a nivel tabla?

-- D)
-- 14. Crea el rol auditor.
-- 15. Otórgale SELECT sobre toda la base.
-- 16. Crea usuario rrhh.
-- 17. Asigna el rol auditor a rrhh
-- 18. Activa el rol auditor a rrhh por defecto
-- 19. Comprueba privilegios efectivos y explica el comportamiento.

-- E)
-- 20. Crea el rol admin_ventas.
-- 21. Otorga los privilegios SELECT, INSERT, UPDATE, DELETE sobre INVOICE al rol admin_ventas
-- 22. Asigna el rol admin_ventas a ventas_user
-- 23. Activa el rol y comprueba que se ha activado para el usuario
-- 24. ¿Puede un usuario tener múltiples roles activos simultáneamente?

-- F)
-- 25. Revoca el privilegio DELETE de admin_ventas
-- 26. Verifica con SHOW GRANTS
-- 27. Comprueba que efectivamente no puede ejecutar DELETE