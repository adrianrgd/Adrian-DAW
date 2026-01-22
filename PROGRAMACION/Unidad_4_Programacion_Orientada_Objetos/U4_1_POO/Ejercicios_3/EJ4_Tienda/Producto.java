public class Producto {
    public String nombre;
    int codProducto;
    private int precio;

    public Producto(String nombre, int codProducto, int precio) {
        this.nombre = nombre;
        this.codProducto = codProducto;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void mostrarInformacionProducto() {
        System.out.println("--- Datos Producto ---");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Código: " + this.codProducto);
        System.out.println("Precio: " + this.precio);
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", codProducto=" + codProducto + ", precio=" + precio + "]";
    }
}
