import java.time.LocalDate;

public class Factura {
    static int contador = 1;
    int numeroFactura;
    LocalDate fechaEmision;
    LocalDate fechaPago;
    double importe;

    public Factura(double dinero) {
        numeroFactura = contador;
        contador = contador + 1;
        fechaEmision = LocalDate.now().plusDays(1);
        fechaPago = fechaEmision.plusMonths(3);
        importe = dinero + (dinero * 0.21);
    }

    public void setFechaPago(LocalDate nuevaFecha) {
        if (nuevaFecha.isAfter(fechaEmision)) {
            fechaPago = nuevaFecha;
        } else {
            System.out.println("Error fecha");
        }
    }

    public String toString() {
        return "Factura: " + numeroFactura + " | " + "Fecha Emision: " + fechaEmision + " | "
                + "Fecha Pago: " + fechaPago + " | " + "Importe (IVA incluido): " + importe;
    }
}
