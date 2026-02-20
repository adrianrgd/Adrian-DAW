package productos;

public class Ropa extends Producto {
    private String talla;
    private String color;
    private String material;

    public Ropa(String id, String nombre, double precio, int stock, String proveedor, String talla, String color) {
        super(id, nombre, precio, stock, proveedor);
        this.talla = talla;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " [Ropa: Talla " + talla + ", Color " + color + "]";
    }
}
