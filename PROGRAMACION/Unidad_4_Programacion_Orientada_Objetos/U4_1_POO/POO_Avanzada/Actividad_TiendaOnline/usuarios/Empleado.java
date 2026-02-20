package usuarios;

import java.time.LocalDate;
import productos.*;

public class Empleado extends Usuario {
    public Empleado(String nombre, String email, String contraseña, LocalDate fechaRegistro) {
        super(nombre, email, contraseña, fechaRegistro);
    }

    public Alimentacion crearAlimentacion(String id, String nombre, double precio, int stock, String prov,
            LocalDate cad) {
        return new Alimentacion(id, nombre, precio, stock, prov, cad);
    }

    public Electronica crearElectronica(String id, String nombre, double precio, int stock, String prov, int gar,
            String marc) {
        return new Electronica(id, nombre, precio, stock, prov, gar, marc);
    }

    public Ropa crearRopa(String id, String nombre, double precio, int stock, String prov, String talla, String color) {
        return new Ropa(id, nombre, precio, stock, prov, talla, color);
    }

    public void modificarProducto(Producto p, String nombre, double precio) {
        p.setPrecio(precio);
        // Podríamos añadir setNombre si queremos, pero por simplicidad:
    }

    public void modificarStock(Producto p, int nuevoStock) {
        if (nuevoStock >= 0) {
            p.setStock(nuevoStock);
        }
    }

    public void cambiarEstadoProducto(Producto p, boolean activo) {
        p.setActivo(activo);
    }
}
