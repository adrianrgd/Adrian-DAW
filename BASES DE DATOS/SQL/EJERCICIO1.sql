alumno (PK·dni, Nombre, ap1, N·Ap2)
Asignatura (PKFK·CodAsig, Nombre, NumHoras)
Inscripcion (PKFK·dni -> alumno, PKFK·CodAsig -> Asignatura, calificacion)

Crear bd: CREATE database BBDD1;
            USE BBDD1;

ALUMNO:
    CREATE TABLE Alumno (
        dni varchar(10) PRIMARY KEY, 
        nombre varchar(50) NOT NULL,
        ap1 varchar(50) NOT NULL,
        ap2 varchar(50)
);

ASIGNATURA:
    CREATE TABLE Asignatura (
        codasig varchar(4) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        numhoras int NOT NULL
    );

INSCRIPCION:
    CREATE TABLE Inscripcion (
        dni varchar(10) ,
        codasig varchar(4) ,
        calificacion decimal(2,1) ,
        PRIMARY KEY (dni, codasig),
        FOREIGN KEY (dni) REFERENCES Alumno(dni),
        FOREIGN KEY (codasig) REFERENCES Asignatura(codasig)
    );

INSCRIPCION2:
    CREATE TABLE Inscripcion2 (
        dni varchar(10) ,
        codasig varchar(4) ,
        calificacion decimal(2,1) ,
        PRIMARY KEY (dni, codasig)
    );

    ALTER TABLE Inscripcion2
        add constraint fkalumno
            FOREIGN KEY (dni) REFERENCES alumno(dni);

    ALTER TABLE Inscripcion2
        add constraint fkasignatura
            FOREIGN KEY (codasig) REFERENCES asignatura(codasig);