/* 

CREAR BASE DE DATOS PromeCamping

Javier San Juan y Andrian Rangel - DAW

*/

-- CREACIÓN BASE DE DATOS

CREATE DATABASE PromeCamping;

-- USO DE LA BASE DE DATOS

USE PromeCamping;

-- CREACIÓN TABLAS

CREATE TABLE
    persona (
        dni VARCHAR(9) UNIQUE,
        ap1 VARCHAR(33) NOT NULL,
        ap2 VARCHAR(33),
        fechanacimiento DATE NOT NULL,
        telefono INT(13) NOT NULL,
        email VARCHAR(90) NOT NULL,
        PRIMARY KEY (dni)
    );

CREATE TABLE
    alojamiento (
        codalojamiento int(5),
        ubicacion varchar(255) NOT NULL,
        capacidadmax int(10) NOT NULL,
        PRIMARY KEY (codalojamiento)
    );

CREATE TABLE
    estadofactura (
        codestado INT(5),
        descripcion VARCHAR(45) NOT NULL,
        PRIMARY KEY (codestado)
    );

CREATE TABLE
    estadoreserva (
        codestadoreserva INT(5) PRIMARY KEY,
        estado VARCHAR(50) NOT NULL
    );

CREATE TABLE
    temporada (
        codtemporada int(5),
        temporada varchar(255) NOT NULL,
        fechainicio DATE NOT NULL,
        fechafin DATE NOT NULL,
        PRIMARY KEY (codtemporada)
    );

CREATE TABLE
    servicio (
        idservicio int(5),
        PRIMARY KEY (idservicio)
    );

CREATE TABLE
    hojamantenimiento (
        idhoja int(5),
        fechamto DATE NOT NULL,
        descripcion VARCHAR(255) NOT NULL,
        PRIMARY KEY (idhoja)
    );

CREATE TABLE
    cliente (
        dni VARCHAR(9) UNIQUE,
        domicilio VARCHAR(33) NOT NULL,
        provincia VARCHAR(9) NOT NULL,
        codalojamiento INT(5) NOT NULL,
        PRIMARY KEY (dni),
        FOREIGN KEY (dni) REFERENCES persona (dni),
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento)
    );

CREATE TABLE
    ocupante (
        dni VARCHAR(9) UNIQUE,
        PRIMARY KEY (dni),
        FOREIGN KEY (dni) REFERENCES persona (dni)
    );

CREATE TABLE
    empleado (
        dni VARCHAR(9),
        nss INT(15) UNIQUE,
        PRIMARY KEY (dni),
        FOREIGN KEY (dni) REFERENCES persona (dni)
    );

CREATE TABLE
    tarifa (
        idtarifa INT(5) PRIMARY KEY,
        tipo VARCHAR(50) NOT NULL,
        importebase decimal(10, 2) NOT NULL,
        impuesto decimal(10, 2) NOT NULL,
        descuento decimal(10, 2),
        codtemporada INT(5) NOT NULL,
        FOREIGN KEY (codtemporada) REFERENCES temporada (codtemporada)
    );

CREATE TABLE
    comentario (
        codcomentario int(5),
        fechacomentario DATE NOT NULL,
        comentario varchar(255) NOT NULL,
        dni VARCHAR(9) NOT NULL,
        PRIMARY KEY (codcomentario),
        FOREIGN KEY (dni) REFERENCES cliente (dni)
    );

CREATE TABLE
    iban (
        codiban VARCHAR(24),
        dni VARCHAR(9) NOT NULL,
        codpais VARCHAR(2) NOT NULL,
        dc VARCHAR(2) NOT NULL,
        entidad VARCHAR(4) NOT NULL,
        csucursal VARCHAR(4) NOT NULL,
        dccta VARCHAR(2) NOT NULL,
        cnumcuenta VARCHAR(10) NOT NULL,
        PRIMARY KEY (codiban)
    );

CREATE TABLE
    reserva (
        codreserva int(5),
        fechareserva DATE NOT NULL,
        fechaentrada DATE NOT NULL,
        fechasalida DATE NOT NULL,
        numvehiculos INT NOT NULL,
        importetotal DECIMAL(10, 2) NOT NULL,
        dni VARCHAR(9) NOT NULL,
        codestadoreserva INT(5) NOT NULL,
        codtemporada INT(5) NOT NULL,
        PRIMARY KEY (codreserva),
        FOREIGN KEY (dni) REFERENCES cliente (dni),
        FOREIGN KEY (codestadoreserva) REFERENCES estadoreserva (codestadoreserva),
        FOREIGN KEY (codtemporada) REFERENCES temporada (codtemporada)
    );

CREATE TABLE
    ocupantereserva (
        codreserva INT(5),
        dni VARCHAR(9),
        PRIMARY KEY (codreserva, dni),
        FOREIGN KEY (codreserva) REFERENCES reserva (codreserva),
        FOREIGN KEY (dni) REFERENCES ocupante (dni)
    );

CREATE TABLE
    reservaalojamiento (
        codreserva INT(5),
        codalojamiento INT(5),
        PRIMARY KEY (codreserva, codalojamiento),
        FOREIGN KEY (codreserva) REFERENCES reserva (codreserva),
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento)
    );

CREATE TABLE
    reservaservicio (
        codreserva INT(5),
        idservicio INT(5),
        PRIMARY KEY (codreserva, idservicio),
        FOREIGN KEY (codreserva) REFERENCES reserva (codreserva),
        FOREIGN KEY (idservicio) REFERENCES servicio (idservicio)
    );

CREATE TABLE
    factura (
        idfactura INT(5) PRIMARY KEY,
        numfactura int NOT NULL,
        fechafactura DATE NOT NULL,
        baseimponible DECIMAL(10, 2) NOT NULL,
        iva DECIMAL(4, 2) NOT NULL,
        importetotal DECIMAL(10, 2) NOT NULL,
        dni VARCHAR(9) NOT NULL,
        codreserva INT(5) NOT NULL,
        codestado INT(5) NOT NULL,
        FOREIGN KEY (dni) REFERENCES cliente (dni),
        FOREIGN KEY (codreserva) REFERENCES reserva (codreserva),
        FOREIGN KEY (codestado) REFERENCES estadofactura (codestado)
    );

CREATE TABLE
    lineafactura (
        iddetalle INT(5),
        concepto VARCHAR(255) NOT NULL,
        preciounitario DECIMAL(10, 2) NOT NULL,
        cantidad INT NOT NULL,
        importebaselinea DECIMAL(10, 2) NOT NULL,
        importeivalinea DECIMAL(4, 2) NOT NULL,
        idfactura INT(5) NOT NULL,
        idtarifa INT(5) NOT NULL,
        PRIMARY KEY (iddetalle),
        FOREIGN KEY (idfactura) REFERENCES factura (idfactura),
        FOREIGN KEY (idtarifa) REFERENCES tarifa (idtarifa)
    );

CREATE TABLE
    alojamientotarifa (
        codalojamiento int(5),
        idtarifa int(5),
        PRIMARY KEY (codalojamiento, idtarifa),
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento),
        FOREIGN KEY (idtarifa) REFERENCES tarifa (idtarifa)
    );

CREATE TABLE
    serviciotarifa (
        idservicio INT(5) NOT NULL,
        idtarifa INT(5) NOT NULL,
        PRIMARY KEY (idservicio, idtarifa),
        FOREIGN KEY (idservicio) REFERENCES servicio (idservicio),
        FOREIGN KEY (idtarifa) REFERENCES tarifa (idtarifa)
    );

CREATE TABLE
    empmtoalojamiento (
        dni varchar(9),
        idhoja int(5),
        codalojamiento int(5),
        PRIMARY KEY (dni, idhoja, codalojamiento),
        FOREIGN KEY (dni) REFERENCES empleado (dni),
        FOREIGN KEY (idhoja) REFERENCES hojamantenimiento (idhoja),
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento)
    );

CREATE TABLE
    bungalow (
        numhabitaciones INT(5) NOT NULL,
        numcamas INT(5) NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        calefaccion BOOLEAN NOT NULL,
        a_a BOOLEAN NOT NULL,
        codalojamiento INT(5) NOT NULL,
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento)
    );

CREATE TABLE
    parcela (
        codalojamiento INT(5) NOT NULL,
        metros2 DECIMAL(10, 2) NOT NULL,
        tienesombra BOOLEAN NOT NULL,
        PRIMARY KEY (codalojamiento),
        FOREIGN KEY (codalojamiento) REFERENCES alojamiento (codalojamiento)
    );