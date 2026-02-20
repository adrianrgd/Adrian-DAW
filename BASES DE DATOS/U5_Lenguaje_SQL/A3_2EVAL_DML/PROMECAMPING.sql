CREATE DATABASE PromeCamping;
USE PromeCamping;


CREATE TABLE Persona (
    dni VARCHAR(15) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Ap1 VARCHAR(50) NOT NULL,
    Ap2 VARCHAR(50),
    FechaNacimiento DATE NOT NULL,
    Telefono VARCHAR(20) NOT NULL, 
    Email VARCHAR(100) NOT NULL
) ENGINE=InnoDB;


CREATE TABLE Alojamiento (
    CodAlojamiento INT PRIMARY KEY AUTO_INCREMENT,
    Ubicacion VARCHAR(100) NOT NULL,
    CapacidadMax INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Cliente (
    DNI VARCHAR(15) PRIMARY KEY,
    Domicilio VARCHAR(150) NOT NULL,
    Provincia VARCHAR(100) NOT NULL,
    CodAlojamiento INT,
    FOREIGN KEY (DNI) REFERENCES Persona(dni),
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento)
) ENGINE=InnoDB;

CREATE TABLE Ocupante (
    DNI VARCHAR(15) PRIMARY KEY,
    FOREIGN KEY (DNI) REFERENCES Persona(dni)
) ENGINE=InnoDB;

CREATE TABLE Empleado (
    DNI VARCHAR(15) PRIMARY KEY,
    NSS VARCHAR(20) UNIQUE NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Persona(dni)
) ENGINE=InnoDB;

CREATE TABLE EstadoFactura (
    CodEstado INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE EstadoReserva (
    CodEstadoReserva INT PRIMARY KEY AUTO_INCREMENT,
    Estado VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Temporada (
    CodTemporada INT PRIMARY KEY AUTO_INCREMENT,
    Temporada VARCHAR(100) NOT NULL,
    FechaInicio DATE  NOT NULL,
    FechaFin DATE  NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Tarifa (
    IdTarifa INT PRIMARY KEY AUTO_INCREMENT,
    Tipo VARCHAR(100) NOT NULL,
    ImporteBase DECIMAL(10,2) NOT NULL,
    Impuesto DECIMAL(5,2) NOT NULL,
    Descuento DECIMAL(5,2),
    CodTemporada INT NOT NULL,
    FOREIGN KEY (CodTemporada) REFERENCES Temporada(CodTemporada)
) ENGINE=InnoDB;

CREATE TABLE Servicio (
    IdServicio INT PRIMARY KEY AUTO_INCREMENT,
    Servicio VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Reserva (
    CodReserva INT PRIMARY KEY AUTO_INCREMENT,
    FechaReserva DATE NOT NULL,
    FechaEntrada DATE NOT NULL,
    FechaSalida DATE NOT NULL,
    NumVehiculos INT NOT NULL,
    ImporteTotal DECIMAL(10,2) NOT NULL,
    DNI VARCHAR(15) NOT NULL,
    CodEstadoReserva INT NOT NULL,
    CodTemporada INT NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Cliente(DNI),
    FOREIGN KEY (CodEstadoReserva) REFERENCES EstadoReserva(CodEstadoReserva),
    FOREIGN KEY (CodTemporada) REFERENCES Temporada(CodTemporada)
) ENGINE=InnoDB;

CREATE TABLE Factura (
    IdFactura INT PRIMARY KEY AUTO_INCREMENT,
    NumFactura VARCHAR(50) NOT NULL,
    FechaFactura DATE NOT NULL,
    BaseImponible DECIMAL(10,2) NOT NULL,
    IVA DECIMAL(10,2) NOT NULL,
    ImporteTotal DECIMAL(10,2),
    DNI VARCHAR(15) NOT NULL,
    CodReserva INT NOT NULL,
    CodEstado INT NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Cliente(DNI),
    FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva),
    FOREIGN KEY (CodEstado) REFERENCES EstadoFactura(CodEstado)
) ENGINE=InnoDB;

CREATE TABLE LineaFactura (
    IdDetalle INT PRIMARY KEY AUTO_INCREMENT,
    Concepto VARCHAR(150) NOT NULL,
    PrecioUnitario DECIMAL(10,2) NOT NULL,
    Cantidad INT NOT NULL,
    ImporteBaseLinea DECIMAL(10,2) NOT NULL,
    ImporteIVALinea DECIMAL(10,2) NOT NULL,
    ImporteTotalLinea DECIMAL(10,2) NOT NULL,
    IdFactura INT NOT NULL,
    IdTarifa INT NOT NULL,
    FOREIGN KEY (IdFactura) REFERENCES Factura(IdFactura),
    FOREIGN KEY (IdTarifa) REFERENCES Tarifa(IdTarifa)
) ENGINE=InnoDB;

CREATE TABLE Comentario (
    codComentario INT PRIMARY KEY AUTO_INCREMENT,
    FechaComentario DATE NOT NULL,
    comentario VARCHAR(250) NOT NULL,
    DNI VARCHAR(15) NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Cliente(DNI)
) ENGINE=InnoDB;

CREATE TABLE IBAN (
    codIban INT PRIMARY KEY AUTO_INCREMENT,
    DNI VARCHAR(15) NOT NULL,
    CodPais VARCHAR(5) NOT NULL,
    DC VARCHAR(5) NOT NULL,
    Entidad VARCHAR(10) NOT NULL,
    cSucursal VARCHAR(10) NOT NULL,
    cDCCta VARCHAR(5) NOT NULL,
    cnumCuenta VARCHAR(20) NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Empleado(DNI)
) ENGINE=InnoDB;

CREATE TABLE OcupanteReserva (
    CodReserva INT ,
    DNI VARCHAR(15) ,
    PRIMARY KEY (CodReserva, DNI),
    FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva),
    FOREIGN KEY (DNI) REFERENCES Ocupante(DNI)
) ENGINE=InnoDB;

CREATE TABLE AlojamientoTarifa (
    CodAlojamiento INT,
    IdTarifa INT,
    PRIMARY KEY (CodAlojamiento, IdTarifa),
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento),
    FOREIGN KEY (IdTarifa) REFERENCES Tarifa(IdTarifa)
) ENGINE=InnoDB;

CREATE TABLE ReservaAlojamiento (
    CodReserva INT,
    CodAlojamiento INT,
    PRIMARY KEY (CodReserva, CodAlojamiento),
    FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva),
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento)
) ENGINE=InnoDB;

CREATE TABLE ReservaServicio (
    IdServicio INT,
    CodReserva INT,
    PRIMARY KEY (IdServicio, CodReserva),
    FOREIGN KEY (IdServicio) REFERENCES Servicio(IdServicio),
    FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva)
) ENGINE=InnoDB;

CREATE TABLE ServicioTarifa (
    IdServicio INT,
    IdTarifa INT,
    PRIMARY KEY (IdServicio, IdTarifa),
    FOREIGN KEY (IdServicio) REFERENCES Servicio(IdServicio),
    FOREIGN KEY (IdTarifa) REFERENCES Tarifa(IdTarifa)
) ENGINE=InnoDB;

CREATE TABLE HojaMantenimiento (
    IdHoja INT PRIMARY KEY AUTO_INCREMENT,
    FechaMto DATE NOT NULL,
    Descripcion VARCHAR(250)
) ENGINE=InnoDB;

CREATE TABLE EmpMtoAlojamiento (
    DNI VARCHAR(15),
    IdHoja INT NOT NULL,
    CodAlojamiento INT NOT NULL,
    PRIMARY KEY (DNI, IdHoja, CodAlojamiento),
    FOREIGN KEY (DNI) REFERENCES Empleado(DNI),
    FOREIGN KEY (IdHoja) REFERENCES HojaMantenimiento(IdHoja),
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento)
) ENGINE=InnoDB;

CREATE TABLE Bungalow (
    CodAlojamiento INT PRIMARY KEY,
    numHabitaciones INT NOT NULL,
    numCamas INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    Calefaccion BOOLEAN NOT NULL,
    A_A BOOLEAN NOT NULL,
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento)
) ENGINE=InnoDB;

CREATE TABLE Parcela (
    CodAlojamiento INT PRIMARY KEY,
    Metros2 INT NOT NULL,
    TieneSombra BOOLEAN NOT NULL,
    FOREIGN KEY (CodAlojamiento) REFERENCES Alojamiento(CodAlojamiento)
) ENGINE=InnoDB;

