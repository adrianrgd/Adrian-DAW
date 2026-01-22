public class Compra {
    private Cliente cliente;
    private Producto producto;
    private int unidades;

    public Compra(Cliente cliente, Producto producto, int unidades) {
        this.cliente = cliente;
        this.producto = producto;
        this.unidades = unidades;
    }

    public void procesarCompra() {
        int precioUnitario = producto.getPrecio();
        int total = precioUnitario * unidades;

        System.out.println("Procesando compra de " + unidades + " unidades de " + producto.nombre + "...");
        System.out.println("Total a pagar: " + total);

        boolean compraExitosa = cliente.pagar(total);

        if (compraExitosa) {
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("La compra no se pudo realizar.");
        }
    }

    public void mostrarDetalleCompra() {
        System.out.println("Cliente: " + cliente.nombre + " (DNI: " + cliente.getDni() + ")");
        System.out.println("Producto: " + producto.nombre);
        System.out.println("Unidades: " + unidades);
    }
}
