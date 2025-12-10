Bungalow (NumHabitaciones, NumCamas, Nombre, Calefaccion, A_A)
Parcela (Metrso2, TieneSombre)

Reserva (P·CodReserva, FechaReserva, FechaEntrada, FechaSalida, D·NumNoches, NumVehiculos, ImporteTotal, F·CodEstadoReserva -> Estado_Reservas)
Tarifa (P·IdTarifa, Tipo, ImporteBase, Impuesto, N·Descuento, PF·IdServicio -> Servicio)
Temporada (P·CodTemporada, Temporada, FechaInicio, FechaFin)
Servicio (P·IdServicio, Servicio)

Estado_Reserva (P·CodEstadoReserva, Estado)
Factura (P·IdFactura, NumFactura, FechaFactura, BaseImponible, IVA, ImporteTotal, C·EstadoFact)
Linea_Factura (P·IdDetalle, Concepto, PrecioUnitario, Cantidad, ImporteBaseLinea, ImporteIVALinea, ImporteTotalLinea, F·IdFactura -> Factura)

