public class Producto {
    String id;
    String nombre;
    double precio;
    int stock;
    boolean estado; //activo o inactivo
    String proveedor;

    public Producto(String id, String nombre, double precio, int stock, boolean estado, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.proveedor = proveedor;
    }

    
}
