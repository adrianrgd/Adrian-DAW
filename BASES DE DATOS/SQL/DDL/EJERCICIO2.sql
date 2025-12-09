ESQUEMA RELACIONAL:
Profesor(P·dni, Nombre, Ap1, N•Ap2, Direccion, Cuenta, Telefono) 
CicloForm(P·CodCiclo, U·Nombre, Tipo) 
Asignatura(P·CodAsig, Nombre, NumHoras, F·dni → Profesor, F·CodCiclo → CicloForm) 
Idioma(P·Codidioma, U·Descripcion) 
Alumno(P·dni, Nombre, Ap1, N•Ap2, Direccion, Email, Telefono, FN·Codidioma → Idioma) 
Matricula(PF·dni → Alumno, PF·CodAsig → Asignatura)  
IdiomasProf(PF·Codidioma → Idioma, PF·dni → Profesor)

BBDD:

CREATE DATABASE BBDD2;
    USE BBDD2;

PROFESOR:
    CREATE TABLE Profesor (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        ap1 varchar(50) NOT NULL,
        ap2 varchar(50),
        direccion varchar(70) NOT NULL,
        cuenta varchar(50) NOT NULL,
        telefono varchar(10) NOT NULL
    );

CICLOFORM:
    CREATE TABLE CicloForm (
        codciclo varchar(4) PRIMARY KEY,
        nombre varchar(50) NOT NULL UNIQUE,
        tipo char(1) NOT NULL
    );

ASIGNATURA:
    CREATE TABLE Asignatura (
        codasig varchar(4) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        numhoras int(11),
        dni varchar(10),
        codciclo varchar(4),
        CONSTRAINT fkprofesor FOREIGN KEY (dni) REFERENCES Profesor(dni),
        CONSTRAINT fkcicloform FOREIGN KEY (codciclo) REFERENCES CicloForm(codciclo)
    );

IDIOMA:
    CREATE TABLE Idioma (
        codidioma varchar(4) PRIMARY KEY,
        descripcion varchar(40) NOT NULL UNIQUE
    );

ALUMNO:
    CREATE TABLE Alumno (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        ap1 varchar(50) NOT NULL,
        ap2 varchar(50), 
        direccion varchar(70) NOT NULL,
        email varchar(20) NOT NULL,
        telefono varchar(10) NOT NULL,
        codidioma varchar(4),
        CONSTRAINT fkidioma FOREIGN KEY (codidioma) REFERENCES Idioma(codidioma)
    );

MATRICULA:
    CREATE TABLE Matricula (
        dni varchar(10),
        codasig varchar(4),
        PRIMARY KEY (dni, codasig),
        CONSTRAINT fkalumno FOREIGN KEY (dni) REFERENCES Alumno(dni),
        CONSTRAINT fkasignatura FOREIGN KEY (codasig) REFERENCES Asignatura(codasig)
    );
    
IDIOMASPROF:
    CREATE TABLE IdiomasProf (
        codidioma varchar(4),
        dni varchar(10),
        CONSTRAINT fkidiomasprof FOREIGN KEY (codidioma) REFERENCES Idioma(codidioma),
        CONSTRAINT fkidiomasprofdni FOREIGN KEY (dni) REFERENCES Profesor(dni)
    );