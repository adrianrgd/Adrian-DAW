public class AppTienda {
    public static void main(String[] args) {
        Producto p1 = new Producto("Laptop", 101, 1000);

        Cliente c1 = new Cliente("Ana Garcia", "12345678A", 750);

        Compra compra1 = new Compra(c1, p1, 1);
        compra1.procesarCompra();
        System.out.println();
        c1.mostrarInformacionCliente();
    }
}