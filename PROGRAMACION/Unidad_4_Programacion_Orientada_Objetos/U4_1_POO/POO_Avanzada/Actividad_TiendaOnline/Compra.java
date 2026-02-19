import java.time.LocalDate;

public class Compra extends Cliente {
    int numCompra;
    Producto[] productos;
    double precioTotalCarrito;
    LocalDate fechaCompra;
    
    public Compra(String id, String nombre, String email, String contraseña, LocalDate fechaRegistro, int conjuntoPedidosRealizados, Carrito[] carrito, int numCompra, Producto[] productos, double precioTotalCarrito, LocalDate fechaCompra) {
        super(id, nombre, email, contraseña, fechaRegistro, conjuntoPedidosRealizados, carrito);
        this.numCompra = numCompra;
        this.productos = productos;
        this.precioTotalCarrito = precioTotalCarrito;
        this.fechaCompra = fechaCompra;
    }
}