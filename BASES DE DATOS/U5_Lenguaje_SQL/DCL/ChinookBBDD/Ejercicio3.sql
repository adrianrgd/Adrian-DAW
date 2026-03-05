--1. Crea los siguientes usuarios, que conectarán desde localhost: admin_lab, analista, auditor.

CREATE USER 'admin_lab'@'localhost' IDENTIFIED BY 'pwd123';
CREATE USER 'analista'@'localhost' IDENTIFIED BY 'pwd123';
CREATE USER 'auditor'@'localhost' IDENTIFIED BY 'pwd123';

--2. Otorga los siguientes permisos a los usuarios:
--a. admin_lab: todos los privilegios sobre la bd chinook 
GRANT ALL PRIVILEGES ON chinook_autoincrement.* TO 'admin_lab'@'localhost';
--b. analista: SELECT sobre las tablas ‘customer’ e ‘invoice’
GRANT SELECT ON chinook_autoincrement.customer TO 'analista'@'localhost';
GRANT SELECT ON chinook_autoincrement.invoice TO 'analista'@'localhost';
--c. auditor: SELECT sobre la tabla ‘customer’
GRANT SELECT ON chinook_autoincrement.customer TO 'auditor'@'localhost';

--3. Con el usuario admin_lab, crea la vista ‘facturas_clientes_vw’ que muestra nombre y apellidos de los clientes y el id y 
--total de sus facturas. La vista se tiene que crear de forma que se ejecute con los privilegios de admin_lab (DEFINER)

CREATE SQL SECURITY DEFINER
VIEW facturas_clientes_vw AS
SELECT DISTINCT c.FirstName, c.LastName, i.InvoiceId, i.Total
FROM customer c
JOIN invoice i ON c.CustomerId = i.CustomerId;

--4. Otorga el permiso SELECT sobre la vista al usuario auditor.

GRANT SELECT ON facturas_clientes_vw TO 'auditor'@'localhost';

+-----------------------------------------------------------------------------------------+
| Grants for auditor@localhost                                                            |
+-----------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `auditor`@`localhost`                                             |
| GRANT SELECT ON `chinook_autoincrement`.`customer` TO `auditor`@`localhost`             |
| GRANT SELECT ON `chinook_autoincrement`.`facturas_clientes_vw` TO `auditor`@`localhost` |
+-----------------------------------------------------------------------------------------+

--5. Con el usuario auditor ejecuta SELECT * FROM facturas_clientes_vw.

SELECT * FROM facturas_clientes_vw;

SELECT * FROM invoice;

--a. ¿Funciona la consulta? Si, funciona porque tiene permisos sobre la vista.
--b. ¿Puede auditor hacer SELECT sobre Invoice? No, no puede hacer SELECT. A traves de la vista si puede.
--c. Comenta los resultados obtenidos.

mysql> SELECT * FROM facturas_clientes_vw;
+-----------+--------------+-----------+-------+
| FirstName | LastName     | InvoiceId | Total |
+-----------+--------------+-----------+-------+
| Luís      | Gonçalves    |        98 |  3.98 |
| Luís      | Gonçalves    |       121 |  3.96 |
| Luís      | Gonçalves    |       143 |  5.94 |
+-----------+--------------+-----------+-------+

ERROR 1142 (42000): SELECT command denied to user 'auditor'@'localhost' for table 'invoice'

--6. Revoca el permiso de SELECT del admin_lab sobre la tabla Invoice.

REVOKE SELECT ON chinook_autoincrement.* FROM 'admin_lab'@'localhost';

--7. Con el usuario auditor ejecuta SELECT * FROM facturas_clientes_vw.

SELECT * FROM facturas_clientes_vw;

--a. ¿Qué ocurre y por qué? -- No funciona porque el admin_lab no tiene permisos sobre la tabla invoice, por lo que 
--la vista no se puede ejecutar, ya que se ejecuta con los privilegios del admin_lab.

--8. Otorga al usuario admin_lab el permiso de SELECT sobre invoice

GRANT SELECT ON chinook_autoincrement.* TO 'admin_lab'@'localhost';

--9. Con el usuario admin_lab crea la vista ‘facturas_clientes_invoker_vw’ que muestra nombre y apellidos de los clientes y el id y 
-- total de sus facturas. La vista se tiene que crear de forma que se ejecute con los privilegios del usuario que la utilice.

CREATE SQL SECURITY INVOKER
VIEW facturas_clientes_invoker_vw AS
SELECT DISTINCT c.FirstName, c.LastName, i.InvoiceId, i.Total
FROM customer c
JOIN invoice i ON c.CustomerId = i.CustomerId;

SELECT * FROM facturas_clientes_invoker_vw LIMIT 15;

--10. Otorga el permiso de SELECT sobre la vista al usuario auditor.

GRANT SELECT ON chinook_autoincrement.facturas_clientes_invoker_vw TO 'auditor'@'localhost';

--11. Con el usuario auditor ejecuta : SELECT * FROM facturas_clientes_invoker_vw;

SELECT * FROM facturas_clientes_invoker_vw LIMIT 15;

--a. ¿Qué resultado se obtiene? ¿Por qué? 

ERROR 1143 (42000): SELECT command denied to user 'auditor'@'localhost' for column 'CustomerId' in table 'invoice'

+-------------------------------------------------------------------------------------------------+
| Grants for auditor@localhost                                                                    |
+-------------------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `auditor`@`localhost`                                                     |
| GRANT SELECT ON `chinook_autoincrement`.`customer` TO `auditor`@`localhost`                     |
| GRANT SELECT ON `chinook_autoincrement`.`facturas_clientes_invoker_vw` TO `auditor`@`localhost` |
| GRANT SELECT ON `chinook_autoincrement`.`facturas_clientes_vw` TO `auditor`@`localhost`         |
+-------------------------------------------------------------------------------------------------+

--No funciona porque el auditor no tiene permisos sobre la tabla invoice, por lo que la vista no se puede ejecutar, ya que 
--se ejecuta con los privilegios del auditor.

--12. Otorga el permiso de SELECT sobre la tabla invoice al auditor. Prueba de nuevo la consulta del punto anterior.

GRANT SELECT ON chinook_autoincrement.invoice TO 'auditor'@'localhost';

SELECT * FROM facturas_clientes_invoker_vw LIMIT 5;

--a. ¿Qué resultado se obtiene? ¿Por qué? 

mysql> SELECT * FROM facturas_clientes_invoker_vw LIMIT 5;
+-----------+-----------+-----------+-------+
| FirstName | LastName  | InvoiceId | Total |
+-----------+-----------+-----------+-------+
| Luís      | Gonçalves |        98 |  3.98 |
| Luís      | Gonçalves |       121 |  3.96 |
| Luís      | Gonçalves |       143 |  5.94 |
| Luís      | Gonçalves |       195 |  0.99 |
| Luís      | Gonçalves |       316 |  1.98 |
+-----------+-----------+-----------+-------+

-- Funciona porque el auditor tiene permisos sobre la tabla invoice, por lo que la vista se puede ejecutar.

--13. Con el usuario admin_lab crea la vista ‘clientes_europa_vw’ que devuelva los datos (CustomerId, FirstName, LastName, Country) 
-- de los clientes de Portugal, France, Germany y Spain, y que se ejecute con los permisos del DEFINER.

CREATE SQL SECURITY DEFINER
VIEW clientes_europa_vw AS
SELECT CustomerId, FirstName, LastName, Country
FROM customer
WHERE Country IN ('Portugal', 'France', 'Germany', 'Spain');

--14. Con el usuario admin_lab crea la vista ‘resumen_europa_vw’ que, basándose en la anterior, muestre por país el número 
-- total de facturas y la suma de los importes de dichas facturas.
--15. Otorga al usuario ‘analista’ permiso de SELECT sobre la vista ‘resumen_europa_vw’
--16. Revoca al usuario ‘analista’ el permiso de SELECT sobre la tabla ‘invoice’
--17. Prueba con el usuario analista : SELECT * FROM resumen_europa_vw;
--a. ¿Qué resultado se obtiene? ¿Por qué?
--b. ¿Puede el analista consultar Invoice directamente?
--c. ¿Qué ocurriría si la vista ‘clientes_europa_vw’ fuera INVOKER?
--d. ¿Qué pasa si cambias solo la vista ‘resumen_europa_vw’ a INVOKER?