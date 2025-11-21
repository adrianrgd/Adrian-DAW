ESQUEMA RELACIONAL:
Cliente (P·dni, Nombre, prApellido, N·sgApellido, Domicilio, NumTarjeta)
Alquiler (P·CodAlquiler, Fecha, NumDias, KmActual, KmEntrega, PF·dni -> Cliente, PF·CodVeh 
-> Vehiculo, PF·dniEmpl -> Empleado, F-CodOficinaE -> Oficina, F·CodOficinaR -> Oficina)
Oficina (P·CodOficina, Domicilio, Telefono)
OficinasAlq (PF·CodOficina -> Oficina, PF·CodAlquiler -> Alquiler)
Vehiculo (P·CodVeh, Modelo, Tipo, Color, PF·CodFab -> Fabricante, PF·CodMarca -> Marca)
Fabricante (P·CodFab, Fabricante)
Marca (P·CodMarca, Marca)
Empleado (P·dniEmpl, Nombre, prApellido, N·sgApellido, Domicilio, NumCuenta)
Curso (P·CodCurso, Descripcion, numHoras, Fechas)
CursoEmpl (PF·CodCurso -> Curso, PF·dniEmpl -> Empleado)

BBDD:

CREATE DATABASE BBDD3;
    USE BBDD3;

CLIENTE:
    CREATE TABLE Cliente (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        prapellido varchar(30) NOT NULL,
        sgapellido varchar(30),
        domicilio varchar(50) NOT NULL,
        numtarjeta varchar(20) NOT NULL
    );

EMPLEADO:
    CREATE TABLE Empleado (
        dniempl varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        prapellido varchar(30) NOT NULL, 
        sgapellido varchar(30),
        domicilio varchar(50) NOT NULL,
        numcuenta varchar(12) NOT NULL
    );

CURSO:
    CREATE TABLE Curso (
        codcurso varchar(10) PRIMARY KEY,
        descripcion varchar(50) NOT NULL,
        numhoras int(10) NOT NULL,
        fecha date NOT NULL
    );

OFICINA:
    CREATE TABLE Oficina (
        codoficina varchar(10) PRIMARY KEY,
        domicilio varchar(50) NOT NULL,
        telefono varchar(10) NOT NULL
    );

FABRICANTE:
    CREATE TABLE Fabricante (
        codfab varchar(10) PRIMARY KEY,
        fabricante varchar(50) NOT NULL
    );

MARCA:
    CREATE TABLE Marca (
        codmarca varchar(10) PRIMARY KEY,
        marca varchar(50) NOT NULL
    );

VEHICULO:
    CREATE TABLE Vehiculo (
        codveh varchar(10) PRIMARY KEY,
        modelo varchar(50) NOT NULL,
        tipo char(1) NOT NULL,
        color varchar(16) NOT NULL,
        codfab varchar(10) NOT NULL,
        codmarca varchar(10) NOT NULL,
        FOREIGN KEY (codfab) REFERENCES Fabricante(codfab),
        FOREIGN KEY (codmarca) REFERENCES Marca(codmarca)
    );

ALQUILER:
    CREATE TABLE Alquiler (
        codalquiler varchar(10) PRIMARY KEY,
        fecha date NOT NULL,
        numdias int(5) NOT NULL,
        kmactual int(10) NOT NULL,
        kmentrega int(10) NOT NULL,
        dni varchar (10) NOT NULL,
        codveh varchar(10) NOT NULL,
        dniempl varchar(10) NOT NULL,
        FOREIGN KEY (dni) REFERENCES Cliente(dni),
        FOREIGN KEY (codveh) REFERENCES Vehiculo(codveh),
        FOREIGN KEY (dniempl) REFERENCES Empleado(dniempl)
    );

CURSO EMPL:
    CREATE TABLE CursoEmpl (
        codcurso varchar(10) NOT NULL,
        dniempl varchar(10) NOT NULL,
        PRIMARY KEY (codcurso, dniempl),
        FOREIGN KEY (codcurso) REFERENCES Curso(codcurso),
        FOREIGN KEY (dniempl) REFERENCES Empleado(dniempl)
    );

OFICINAS ALQ:
    CREATE TABLE OficinasAlq (
        codoficina varchar(10) NOT NULL,
        codalquiler varchar(10) NOT NULL,
        PRIMARY KEY (codoficina, codalquiler),
        FOREIGN KEY (codoficina) REFERENCES Oficina(codoficina),
        FOREIGN KEY (codalquiler) REFERENCES Alquiler(codalquiler)
    );