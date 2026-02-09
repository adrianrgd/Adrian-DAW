public class Utensilio {
    //Atributos
    private int stock;
    private String nombre;

    //Constructor
    public Utensilio(int inventario, String nombre) {
        this.stock = inventario;
        this.nombre = nombre;
    }

    //Getters y Setters
    public int getStock() {
        return stock; //Devuelve el stock
    }

    public void setStock(int inventario) {
        this.stock = inventario; //Establece el stock.
    }

    public String getNombre() {
        return nombre; //Devuelve el nombre.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; //Establece el nombre.
    }

    public void gastarUtensilios(int gasto) {
        setStock(stock - gasto);
    }

    @Override
    public String toString() {
        return String.format("Stock: %s - Nombre: %s", stock, nombre); //Devuelve el stock y el nombre.
    }

}
