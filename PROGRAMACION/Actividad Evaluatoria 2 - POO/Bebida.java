public class Bebida { 
    //Atributos
    private static int cantidadTotalBebidas = 0;
    private String nombre;
    private float[] gastosIngredientes;
    private Ingrediente[] ingredientes;
    private Utensilio[] utensilios;
    private int[] gastosUtensilios;
    private float precio;

    //Constructor
    public Bebida(String nombre, float[] gastosIngredientes, Ingrediente[] ingredientes, Utensilio[] utensilios, int[] gastosUtensilios, float precio) {
        this.nombre = nombre;
        this.gastosIngredientes = gastosIngredientes;
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.gastosUtensilios = gastosUtensilios;
        this.precio = precio;
    }

    //Getters and Setters
    public static int getCantidadTotalBebidas() {
        return cantidadTotalBebidas;
    }

    public static void setCantidadTotalBebidas(int cantidadTotalBebidas) {
        Bebida.cantidadTotalBebidas = cantidadTotalBebidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getGastosIngredientes() {
        return gastosIngredientes;
    }

    public void setGastosIngredientes(float[] gastosIngredientes) {
        this.gastosIngredientes = gastosIngredientes;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public Utensilio[] getUtensilios() {
        return utensilios;
    }

    public void setUtensilios(Utensilio[] utensilios) {
        this.utensilios = utensilios;
    }

    public int[] getGastosUtensilios() {
        return gastosUtensilios;
    }

    public void setGastosUtensilios(int[] gastosUtensilios) {
        this.gastosUtensilios = gastosUtensilios;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
}
