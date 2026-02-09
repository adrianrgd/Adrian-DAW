public class Peso {
    //Atributos
    private float cantidad;
    private String medida;

    //Constructor
    public Peso(float cantidad, String medida) {
        this.cantidad = cantidad;
        this.medida = medida;
    }

    //Getters y Setters
    public float getCantidad() {
        return cantidad; //Devuelve la cantidad
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad; //Establece la cantidad.
    }

    public String getMedida() {
        return medida; //Devuelve la medida.
    }

    public void setMedida(String medida) {
        this.medida = medida; //Establece la medida.
    }

    @Override
    public String toString() {
        return String.format("Cantidad: %s - Medida: %s", cantidad, medida); //Devuelve la cantidad y la medida.
    }
}
