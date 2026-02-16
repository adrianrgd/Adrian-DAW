ESQUEMA RELACIONAL:
Director(P·dni, Nombre, prApellido, N·sgApellido, Domicilio, Telefono, N·email) 
Supermercado(P·CodSup, Direccion, Superficie, esAlquiler, Fecha, F·dni → Director) 
Vendedor(P·dni, Nombre, prApellido, N·sgApellido, Domicilio, Telefono, N·email, 
F·CodSup→Supermercado) 
Cliente(P·dni, Nombre, prApellido, N·sgApellido, Domicilio, Telefono, N·email) 
Venta(P·CodVenta, fecha, F·dniVend → Vendedor, F·dniCl → Cliente) 
Producto(P·CodProducto, Descripcion, Familia, Genero, N·descuento, iva) 
LineaVenta(PF·Cod Venta → Venta, P·numLinea, cantidad, F·CodProd, F·fecha → Precio) 
Devolucion(PF·CodVenta, PF numLinea→ LineaVenta, P·fecha, Estado, TipoDev) 
Precio(PF·CodProd → Producto, P·fecha, precio)

BBDD:

CREATE DATABASE BBDD4;
    USE BBDD4;

DIRECTOR:
    CREATE TABLE Director (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        prapellido varchar(30) NOT NULL,
        sgapellido varchar(30),
        domicilio varchar(50) NOT NULL,
        telefono varchar(10) NOT NULL,
        email varchar(20)
    );

SUPERMERCADO:
    CREATE TABLE Supermercado (
        codsup varchar(10) PRIMARY KEY,
        direccion varchar(50) NOT NULL,
        superficie varchar(20) NOT NULL,
        esAlquiler varchar(10) NOT NULL,
        fecha date NOT NULL,
        dni varchar(10) NOT NULL,
        FOREIGN KEY (dni) REFERENCES Director(dni)
    );

VENDEDOR:
    CREATE TABLE Vendedor (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        prapellido varchar(30) NOT NULL,
        sgapellido varchar(30),
        domicilio varchar(50) NOT NULL,
        telefono varchar(10) NOT NULL,
        email varchar(20),
        codsup varchar(10) NOT NULL,
        FOREIGN KEY (codsup) REFERENCES Supermercado(codsup)
    ); 

CLIENTE:
        CREATE TABLE Cliente (
        dni varchar(10) PRIMARY KEY,
        nombre varchar(50) NOT NULL,
        prapellido varchar(30) NOT NULL,
        sgapellido varchar(30),
        domicilio varchar(50) NOT NULL,
        telefono varchar(10) NOT NULL,
        email varchar(20)
    );

PRODUCTO:
    CREATE TABLE Producto (
        codproducto varchar(10) PRIMARY KEY,
        descripcion text NOT NULL,
        familia varchar(20) NOT NULL,
        genero varchar(20) NOT NULL,
        descuento decimal(4,2),
        iva decimal(4,2) NOT NULL
    );

VENTA:
    CREATE TABLE Venta (
        codventa varchar(10) PRIMARY KEY,
        fecha date NOT NULL,
        dnivend varchar(10) NOT NULL,
        dnicl varchar(10) NOT NULL,
        FOREIGN KEY (dnivend) REFERENCES Vendedor(dni),
        FOREIGN KEY (dnicl) REFERENCES Cliente(dni)
    );

PRECIO:
    CREATE TABLE Precio (
        fecha date NOT NULL,
        precio decimal(8,2) NOT NULL,
        codprod varchar(10) NOT NULL,
        PRIMARY KEY (codprod, fecha),
        FOREIGN KEY (codprod) REFERENCES Producto(codproducto)
    );

LINEA VENTA:
    CREATE TABLE LineaVenta (
        codventa varchar(10) NOT NULL,
        numlinea int NOT NULL,
        cantidad decimal(8,2) NOT NULL,
        codprod varchar(10) NOT NULL,
        fecha date NOT NULL,
        PRIMARY KEY (codventa, numlinea),
        FOREIGN KEY (codventa) REFERENCES Venta(codventa),
        FOREIGN KEY (codprod) REFERENCES Producto(codproducto),
        FOREIGN KEY (codprod, fecha) REFERENCES Precio(codprod, fecha)
    );
    
DEVOLUCION:
    CREATE TABLE Devolucion (
        codventa varchar(10) NOT NULL,
        numlinea int NOT NULL,
        fecha date NOT NULL, -- fecha de la devolución
        estado varchar(16) NOT NULL,
        tipodev char(1) NOT NULL,
        PRIMARY KEY (codventa, numlinea, fecha),
        FOREIGN KEY (codventa, numlinea) REFERENCES LineaVenta(codventa, numlinea),
        FOREIGN KEY (codventa) REFERENCES Venta(codventa)
    );