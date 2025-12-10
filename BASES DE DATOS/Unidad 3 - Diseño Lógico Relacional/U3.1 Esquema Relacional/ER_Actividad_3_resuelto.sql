/*
  ER_Actividad_3_resuelto.sql
  Esquema relacional generado a partir de tu listado en `ER Actividad 3.sql`.

  Suposiciones importantes:
  - No se especificaron tipos de datos ni relaciones exactas en el ER original, así que he inferido claves primarias y posibles FKs razonables.
  - Campos marcados como derivados (D·) no es necesario almacenarlos, pero los incluyo opcionalmente (NumNoches) y se recomienda calcularlos desde FechaEntrada/FechaSalida.
  - Se crea una tabla intermedia `Reserva_Servicio` para modelar la posible relación N:M entre reservas y servicios.
  - Tipos elegidos: INT para claves, DATE para fechas, DECIMAL(10,2) para importes, VARCHAR para textos. BOOLEAN para banderas.

  Si quieres que adapte tipos a un motor concreto (MySQL, PostgreSQL, SQL Server) dímelo y lo ajusto.
*/

-- ---------------------------------------------------
-- Tabla: Estado_Reserva
-- ---------------------------------------------------
CREATE TABLE Estado_Reserva (
  CodEstadoReserva INT PRIMARY KEY,
  Estado VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------
-- Tabla: Tarifa
-- ---------------------------------------------------
CREATE TABLE Tarifa (
  IdTarifa INT PRIMARY KEY,
  Tipo VARCHAR(50) NOT NULL,
  ImporteBase DECIMAL(10,2) NOT NULL,
  Impuesto DECIMAL(5,2) NOT NULL, -- porcentaje (ej. 21.00)
  Descuento DECIMAL(5,2) DEFAULT 0.00 -- porcentaje, puede ser NULL o 0
);

-- ---------------------------------------------------
-- Tabla: Temporada
-- ---------------------------------------------------
CREATE TABLE Temporada (
  CodTemporada INT PRIMARY KEY,
  NombreTemporada VARCHAR(50) NOT NULL,
  FechaInicio DATE NOT NULL,
  FechaFin DATE NOT NULL,
  CHECK (FechaInicio <= FechaFin)
);

-- ---------------------------------------------------
-- Tabla: Bungalow
-- ---------------------------------------------------
CREATE TABLE Bungalow (
  IdBungalow INT PRIMARY KEY,
  NumHabitaciones INT NOT NULL,
  NumCamas INT NOT NULL,
  Nombre VARCHAR(100),
  Calefaccion BOOLEAN DEFAULT FALSE,
  A_A BOOLEAN DEFAULT FALSE -- aire acondicionado
);

-- ---------------------------------------------------
-- Tabla: Parcela
-- ---------------------------------------------------
CREATE TABLE Parcela (
  IdParcela INT PRIMARY KEY,
  Metros2 DECIMAL(8,2) NOT NULL,
  TieneSombra BOOLEAN DEFAULT FALSE
);

-- ---------------------------------------------------
-- Tabla: Servicio
-- ---------------------------------------------------
CREATE TABLE Servicio (
  IdServicio INT PRIMARY KEY,
  NombreServicio VARCHAR(100) NOT NULL
);

-- ---------------------------------------------------
-- Tabla: Reserva
-- ---------------------------------------------------
CREATE TABLE Reserva (
  CodReserva INT PRIMARY KEY,
  FechaReserva DATE NOT NULL,
  FechaEntrada DATE NOT NULL,
  FechaSalida DATE NOT NULL,
  NumNoches INT GENERATED ALWAYS AS (CAST(julianday(FechaSalida) - julianday(FechaEntrada) AS INTEGER)) STORED,
  NumVehiculos INT DEFAULT 0,
  ImporteTotal DECIMAL(10,2) DEFAULT 0.00,
  IdTarifa INT, -- tarifa aplicada a la reserva
  CodTemporada INT,
  CodEstadoReserva INT,
  IdBungalow INT,
  IdParcela INT,
  CONSTRAINT fk_reserva_tarifa FOREIGN KEY (IdTarifa) REFERENCES Tarifa(IdTarifa),
  CONSTRAINT fk_reserva_temporada FOREIGN KEY (CodTemporada) REFERENCES Temporada(CodTemporada),
  CONSTRAINT fk_reserva_estado FOREIGN KEY (CodEstadoReserva) REFERENCES Estado_Reserva(CodEstadoReserva),
  CONSTRAINT fk_reserva_bungalow FOREIGN KEY (IdBungalow) REFERENCES Bungalow(IdBungalow),
  CONSTRAINT fk_reserva_parcela FOREIGN KEY (IdParcela) REFERENCES Parcela(IdParcela),
  CHECK (FechaEntrada <= FechaSalida)
);

-- Nota: La cláusula GENERADA para NumNoches usa la función julianday (SQLite). Si usas otro SGBD, reemplaza por la expresión apropiada
-- (por ejemplo, DATEDIFF en SQL Server o AGE/EXTRACT en PostgreSQL) o elimina esa columna y calcula NumNoches en la aplicación.

-- ---------------------------------------------------
-- Tabla intermedia: Reserva_Servicio (relación N:M)
-- ---------------------------------------------------
CREATE TABLE Reserva_Servicio (
  CodReserva INT NOT NULL,
  IdServicio INT NOT NULL,
  Cantidad INT DEFAULT 1,
  PrecioUnitario DECIMAL(10,2) DEFAULT 0.00,
  PRIMARY KEY (CodReserva, IdServicio),
  CONSTRAINT fk_rs_reserva FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva),
  CONSTRAINT fk_rs_servicio FOREIGN KEY (IdServicio) REFERENCES Servicio(IdServicio)
);

-- ---------------------------------------------------
-- Tabla: Factura
-- ---------------------------------------------------
CREATE TABLE Factura (
  IdFactura INT PRIMARY KEY,
  NumFactura VARCHAR(50) UNIQUE NOT NULL,
  FechaFactura DATE NOT NULL,
  BaseImponible DECIMAL(12,2) NOT NULL,
  IVA DECIMAL(5,2) NOT NULL, -- porcentaje
  ImporteTotal DECIMAL(12,2) NOT NULL,
  EstadoFactura VARCHAR(20) NOT NULL CHECK (EstadoFactura IN ('Pendiente','Pagada','Anulada')),
  CodReserva INT,
  CONSTRAINT fk_factura_reserva FOREIGN KEY (CodReserva) REFERENCES Reserva(CodReserva)
);

-- ---------------------------------------------------
-- Tabla: Linea_Factura
-- ---------------------------------------------------
CREATE TABLE Linea_Factura (
  IdDetalle INT PRIMARY KEY,
  IdFactura INT NOT NULL,
  Concepto VARCHAR(255) NOT NULL,
  PrecioUnitario DECIMAL(10,2) NOT NULL,
  Cantidad INT NOT NULL DEFAULT 1,
  ImporteBaseLinea DECIMAL(12,2) NOT NULL,
  ImporteIVALinea DECIMAL(12,2) NOT NULL,
  ImporteTotalLinea DECIMAL(12,2) NOT NULL,
  CONSTRAINT fk_linea_factura_factura FOREIGN KEY (IdFactura) REFERENCES Factura(IdFactura)
);

-- Indices sugeridos (mejoran consultas frecuentes)
CREATE INDEX idx_reserva_fechaentrada ON Reserva(FechaEntrada);
CREATE INDEX idx_factura_fecha ON Factura(FechaFactura);

/*
  Fin del esquema relacional para tu parte.

  Siguientes pasos recomendados:
  - Si tu SGBD no soporta la sintaxis "GENERATED ... AS" mostrada, modifica NumNoches o elimínala y calcula en la aplicación.
  - Añadir datos de ejemplo y ejecutar en tu motor (MySQL/Postgres/SQLite) para verificar tipos y constraints.
  - Confirmar qué relaciones exactas (por ejemplo, si Bungalow o Parcela son obligatorias en Reserva) deben ser NOT NULL.
*/
