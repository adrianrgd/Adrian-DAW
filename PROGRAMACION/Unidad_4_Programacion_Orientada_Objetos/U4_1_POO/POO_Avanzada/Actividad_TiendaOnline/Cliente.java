public class Cliente extends Usuario {
    int ConjuntoPedidosRealizados;
    Carrito[] carrito;
    
    public Cliente(String id, String nombre, String email, String contraseña, localDate fechaRegistro, int conjuntoPedidosRealizados, Carrito[] carrito) {
        super(id, nombre, email, contraseña, fechaRegistro);
        ConjuntoPedidosRealizados = conjuntoPedidosRealizados;
        this.carrito = carrito;
    }

    public void agregarProductoAlCarrito(Producto producto) {
        
    }
    

}
