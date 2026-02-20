CREATE DATABASE BDTiendaOnline;
    USE BDTiendaOnline;

CREATE TABLE Cliente (
    cliente_id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50) NOT NULL,
    email varchar(30) NOT NULL,
    fecha_registro date
);

ALTER TABLE Cliente
    ADD CONSTRAINT UQ_cliente_email UNIQUE (email);

CREATE TABLE Producto (
    producto_id int AUTO_INCREMENT PRIMARY KEY,
    nombre_producto varchar(100) NOT NULL,
    precio decimal(10,2) NOT NULL,
    stock int NOT NULL
);

CREATE TABLE Pedido (
    pedido_id int AUTO_INCREMENT PRIMARY KEY,
    cliente_id int NOT NULL,
    fecha_pedido date,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(cliente_id)
);

CREATE TABLE DetallePedido (
    pedido_id int,
    producto_id int NOT NULL,
    cantidad int NOT NULL,
    PRIMARY KEY (pedido_id, producto_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(pedido_id),
    FOREIGN KEY (producto_id) REFERENCES Producto(producto_id)
);

ALTER TABLE Cliente 
    ADD COLUMN telefono varchar(15);

ALTER TABLE Producto
    MODIFY Stock smallint NOT NULL;

ALTER TABLE Cliente
    MODIFY COLUMN telefono varchar(15) NOT NULL;

ALTER TABLE Cliente
    RENAME COLUMN nombre TO nombre_completo;

ALTER TABLE Cliente
    DROP COLUMN fecha_registro;

ALTER TABLE Pedido
    ADD COLUMN metodo_pago int NOT NULL;

CREATE TABLE MetodoPago (
    metodo_id int PRIMARY KEY,
    nombre_metodo varchar(100) NOT NULL
);

ALTER TABLE pedido
    ADD CONSTRAINT FK_Pedido_metodo_pago FOREIGN KEY (metodo_pago) REFERENCES MetodoPago(metodo_id);

ALTER TABLE pedido
    DROP FOREIGN KEY FK_Pedido_metodo_pago;

ALTER TABLE Cliente
    DROP INDEX UQ_cliente_email;

DROP TABLE DetallePedido;