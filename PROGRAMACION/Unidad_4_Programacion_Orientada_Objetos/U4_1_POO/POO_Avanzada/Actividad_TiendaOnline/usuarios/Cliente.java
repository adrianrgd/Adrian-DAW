package usuarios;

import java.time.LocalDate;

import productos.Producto;
import productos.Compra;

public class Cliente extends Usuario {
    private Producto[] carrito;
    private int[] cantidades;
    private int numProductosCarrito;
    private Compra[] historialCompras;
    private int numCompras;

    public Cliente(String nombre, String email, String contraseña, LocalDate fechaRegistro) {
        super(nombre, email, contraseña, fechaRegistro);
        this.carrito = new Producto[10];
        this.cantidades = new int[10];
        this.numProductosCarrito = 0;
        this.historialCompras = new Compra[50];
        this.numCompras = 0;
    }

    public void añadirAlCarrito(Producto p) {
        // Buscar si ya está
        for (int i = 0; i < numProductosCarrito; i++) {
            if (carrito[i].equals(p)) {
                cantidades[i]++;
                return;
            }
        }
        // Si no está, añadir nuevo
        if (numProductosCarrito < carrito.length && p.isActivo() && p.getStock() > 0) {
            carrito[numProductosCarrito] = p;
            cantidades[numProductosCarrito] = 1;
            numProductosCarrito++;
        }
    }

    public void modificarCantidad(int indice, int nuevaCantidad) {
        if (indice >= 0 && indice < numProductosCarrito) {
            if (nuevaCantidad <= 0) {
                eliminarDelCarrito(indice);
            } else if (nuevaCantidad <= carrito[indice].getStock()) {
                cantidades[indice] = nuevaCantidad;
            }
        }
    }

    public void añadirCompra(Compra c) {
        if (numCompras < historialCompras.length) {
            historialCompras[numCompras++] = c;
        }
    }

    public Producto[] getCarrito() {
        return carrito;
    }

    public int[] getCantidades() {
        return cantidades;
    }

    public int getNumProductosCarrito() {
        return numProductosCarrito;
    }

    public Compra[] getHistorialCompras() {
        return historialCompras;
    }

    public int getNumCompras() {
        return numCompras;
    }

    public void eliminarDelCarrito(int indice) {
        if (indice >= 0 && indice < numProductosCarrito) {
            for (int i = indice; i < numProductosCarrito - 1; i++) {
                carrito[i] = carrito[i + 1];
                cantidades[i] = cantidades[i + 1];
            }
            carrito[numProductosCarrito - 1] = null;
            cantidades[numProductosCarrito - 1] = 0;
            numProductosCarrito--;
        }
    }

    public double calcularTotalCarrito() {
        double total = 0;
        for (int i = 0; i < numProductosCarrito; i++) {
            total += carrito[i].getPrecio() * cantidades[i];
        }
        return total;
    }

    public void vaciarCarrito() {
        for (int i = 0; i < numProductosCarrito; i++) {
            carrito[i] = null;
            cantidades[i] = 0;
        }
        numProductosCarrito = 0;
    }
}
