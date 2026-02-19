public class Electronica extends Producto{
    int garantia;
    String marca;
    int consumoEnergetico;

    public Electronica(String id, String nombre, double precio, int stock, boolean estado, String proveedor, int garantia, String marca, int consumoEnergetico) {
        super(id, nombre, precio, stock, estado, proveedor);
        this.garantia = garantia;
        this.marca = marca;
        this.consumoEnergetico = consumoEnergetico;
    }
    
    
}
