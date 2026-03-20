CREATE DATABASE NEWCENTROIDIOMAS;
use newcentroidiomas; 

CREATE TABLE NewDepartamento(
    CodDep INT auto_increment,
    Nombre VARCHAR(100) NOT NULL,
    dni varchar(8) , 
    PRIMARY KEY (CodDep)
);

CREATE TABLE NewProfesor(
    dni varchar(8) ,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    CodDep INT  NOT NULL,
    PRIMARY KEY (dni),
    FOREIGN KEY (CodDep) REFERENCES NewDepartamento(CodDep)
);


ALTER TABLE NewDepartamento ADD CONSTRAINT fk_prof_Dep FOREIGN KEY (dni) REFERENCES NewProfesor(dni); 

CREATE TABLE NewAlumno(
    dni varchar(8) ,
    Nombre VARCHAR(30) NOT NULL,
    prApellido VARCHAR(30) NOT NULL,
    sgApellido VARCHAR(30),
    Bilingue CHAR(1) NOT NULL,
    PRIMARY KEY (dni)
);

CREATE TABLE NewCiclo(
    CodCF INT auto_increment,
    Nombre VARCHAR(256) NOT NULL,
    Siglas VARCHAR(10) NOT NULL,
    PRIMARY KEY (CodCF)
);

CREATE TABLE NewAsignatura(
    codAsig INT auto_increment,
    Nombre VARCHAR(128) NOT NULL,
    numHoras INT  NOT NULL,
    Bilingue CHAR(1) NOT NULL, 
    codCF INT  NOT NULL,
    PRIMARY KEY (codAsig),
    FOREIGN KEY (codCF) REFERENCES NewCiclo(codCF)
);

CREATE TABLE NewMatricula(
    codMatr INT auto_increment,
    dni varchar(8)  NOT NULL,
    curso INT  NOT NULL,
    PRIMARY KEY (codMatr),
    FOREIGN KEY (dni) REFERENCES NewAlumno(dni)
);

CREATE TABLE NewImparte(
    codAsig INT not null  ,
    curso INT  NOT NULL,
    dni varchar(8)  NOT NULL,
    PRIMARY KEY (codAsig,curso,dni),
    FOREIGN KEY (dni) REFERENCES NewProfesor(dni),
    FOREIGN KEY (codAsig) REFERENCES NewAsignatura(codAsig)
);

CREATE TABLE NewLineaMatricula(
    codMatr INT,
    codAsig INT ,
    nota DECIMAL(3,1), 
    PRIMARY KEY (codMatr,codAsig),
    FOREIGN KEY (codMatr) REFERENCES NewMatricula(codMatr),
    FOREIGN KEY (codAsig) REFERENCES NewAsignatura(codAsig)
);

CREATE TABLE NewContrato(
    codCont INT auto_increment,
    dni varchar(8)  NOT NULL,
    curso INT  NOT NULL,
    PRIMARY KEY (codCont),
    FOREIGN KEY (dni) REFERENCES NewProfesor(dni)
);

CREATE TABLE NewLineaContrato(
    codCont INT ,
    codAsig INT ,
    PRIMARY KEY (codCont,codAsig),
    FOREIGN KEY (codCont) REFERENCES NewContrato(codCont),
    FOREIGN KEY (codAsig) REFERENCES NewAsignatura(codAsig)
);

CREATE TABLE NewAlumBil(
    dni varchar(8) ,
    fecha DATE NOT NULL,
    lugar VARCHAR(20),
    PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES NewAlumno(dni)
);

-- Crea una vista en centroidiomas ‘AsignaturasJefe’ que muestre las asignaturas que imparten o han impartido los actuales jefes de los distintos departamentos. La vista muestra las siguientes columnas (con estos nombres) ordenadas por dniJefeDpto,cicloAsig , curso y asignatura: dniJefeDpto – CodDpto – NombreDpto – Curso – Asignatura – CicloAsig


