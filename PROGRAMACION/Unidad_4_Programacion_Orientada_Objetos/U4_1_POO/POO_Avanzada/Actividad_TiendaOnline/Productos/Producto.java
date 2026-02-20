package productos;

public abstract class Producto {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean activo;
    protected String proveedor;

    public Producto(String id, String nombre, double precio, int stock, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - " + precio + "€ (Stock: " + stock + (activo ? "" : " - INACTIVO") + ")";
    }
}
