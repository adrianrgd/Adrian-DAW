package productos;

import java.time.LocalDate;

public class Alimentacion extends Producto {
    private LocalDate fechaCaducidad;
    private double peso;
    private boolean esPerecedero;

    public Alimentacion(String id, String nombre, double precio, int stock, String proveedor,
            LocalDate fechaCaducidad) {
        super(id, nombre, precio, stock, proveedor);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + " [Alimentación: Caduca " + fechaCaducidad + "]";
    }
}
