public class Ingrediente { 
    //Atributos
    private Peso inventario;
    private String nombre;

    //Constructor
    public Ingrediente(Peso inventario, String nombre) {
        this.inventario = inventario;
        this.nombre = nombre;
    }

    //Metodo para gastar los ingredientes.
    public void gastarIngrediente(float gasto) {
        inventario.setCantidad(inventario.getCantidad() - gasto);
    }

    //Getters y Setters
    public Peso getInventario() {
        return inventario; //Devuelve el inventario
    }

    public void setInventario(Peso inventario) {
        this.inventario = inventario; //Establece el inventario
    }

    public String getNombre() {
        return nombre; //Devuelve el nombre.
    }   

    public void setNombre(String nombre) {
        this.nombre = nombre; //Establece el nombre.
    }

    //toString
    @Override
    public String toString() {
        return String.format("Inventario: %s - Nombre: %s", inventario.toString(), nombre);
    }
}
