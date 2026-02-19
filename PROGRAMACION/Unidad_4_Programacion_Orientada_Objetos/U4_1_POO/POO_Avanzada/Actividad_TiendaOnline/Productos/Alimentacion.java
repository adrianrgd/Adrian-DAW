public class Alimentacion extends Producto {
    int diasCaducidad;
    int peso;
    boolean esPerecedero;
    
    public Alimentacion(String id, String nombre, double precio, int stock, boolean estado, String proveedor, int diasCaducidad, int peso, boolean esPerecedero) {
        super(id, nombre, precio, stock, estado, proveedor);
        this.diasCaducidad = diasCaducidad;
        this.peso = peso;
        this.esPerecedero = esPerecedero;
    }
    
}
