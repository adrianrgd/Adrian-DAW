public class Ropa extends Producto {
    String talla;
    String color;
    String material;
    
    public Ropa(String id, String nombre, double precio, int stock, boolean estado, String proveedor, String talla, String color, String material) {
        super(id, nombre, precio, stock, estado, proveedor);
        this.talla = talla;
        this.color = color;
        this.material = material;
    }
    
}
