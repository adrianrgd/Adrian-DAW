package productos;

public class Electronica extends Producto {
    private int garantiaMeses;
    private String marca;
    private double consumoElectrico;

    public Electronica(String id, String nombre, double precio, int stock, String proveedor, int garantiaMeses,
            String marca) {
        super(id, nombre, precio, stock, proveedor);
        this.garantiaMeses = garantiaMeses;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return super.toString() + " [Electrónica: " + marca + ", Garantía: " + garantiaMeses + "m]";
    }
}
