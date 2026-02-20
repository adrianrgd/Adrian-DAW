package productos;

import java.time.LocalDate;

import usuarios.Cliente;

public class Compra {
    private Cliente cliente;
    private int numCompra;
    private Producto[] productos;
    private int[] cantidades;
    private int numProductos;
    private double total;
    private LocalDate fecha;

    private static int contadorCompras = 0;

    public Compra(Cliente cliente) {
        this.cliente = cliente;
        this.numCompra = generarNumCompra();
        this.fecha = LocalDate.now();

        Producto[] carritoCliente = cliente.getCarrito();
        int[] cantidadesCliente = cliente.getCantidades();
        this.numProductos = cliente.getNumProductosCarrito();
        this.productos = new Producto[numProductos];
        this.cantidades = new int[numProductos];

        for (int i = 0; i < numProductos; i++) {
            this.productos[i] = carritoCliente[i];
            this.cantidades[i] = cantidadesCliente[i];
        }

        this.total = calcularTotal();
    }

    public void confirmarCompra() throws Exception {
        for (int i = 0; i < numProductos; i++) {
            Producto p = productos[i];
            int cant = cantidades[i];

            if (!p.isActivo())
                throw new Exception("Producto inactivo: " + p.getNombre());
            if (p.getStock() < cant)
                throw new Exception("Stock insuficiente para: " + p.getNombre() + " (Solicitado: " + cant
                        + ", Disponible: " + p.getStock() + ")");

            if (p instanceof Alimentacion) {
                Alimentacion a = (Alimentacion) p;
                if (a.getFechaCaducidad().isBefore(LocalDate.now())) {
                    throw new Exception("Producto caducado: " + p.getNombre());
                }
            }
        }

        for (int i = 0; i < numProductos; i++) {
            Producto p = productos[i];
            p.setStock(p.getStock() - cantidades[i]);
        }
        cliente.añadirCompra(this);
        cliente.vaciarCarrito();
    }

    private double calcularTotal() {
        double t = 0;
        for (int i = 0; i < numProductos; i++) {
            t += productos[i].getPrecio() * cantidades[i];
        }
        return t;
    }

    public static int generarNumCompra() {
        return ++contadorCompras;
    }
}
