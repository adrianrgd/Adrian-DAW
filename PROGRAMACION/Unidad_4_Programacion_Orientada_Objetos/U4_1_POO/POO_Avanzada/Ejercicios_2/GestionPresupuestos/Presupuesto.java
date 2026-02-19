import java.time.LocalDate;

public class Presupuesto {
    String estado;
    double importe;
    LocalDate fecha;
    Factura factura;

    public Presupuesto(double dinero) {
        estado = "CREADO";
        importe = dinero;
        fecha = LocalDate.now();
    }

    public void confirmarPresupuesto() {
        if (estado == "CANCELADO") {
            System.out.println("No se puede confirmar porque esta cancelado.");
        } else {
            if (estado == "CONFIRMADO") {
                System.out.println("Ya esta confirmado.");
            } else {
                estado = "CONFIRMADO";
                factura = new Factura(importe);
            }
        }
    }

    public void cancelarPresupuesto() {
        if (estado == "CONFIRMADO") {
            System.out.println("No se puede cancelar porque esta confirmado.");
        } else {
            estado = "CANCELADO";
        }
    }

    public Factura getFactura() {
        if (estado == "CONFIRMADO") {
            return factura;
        } else {
            return null;
        }
    }

    public String toString() {
        return "Presupuesto -> " + "Estado: " + estado + " | " + "Importe: " + importe + " | " + "Fecha: " + fecha;
    }
}
