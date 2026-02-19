public class Ruedas {
    private String marca;
    private int tamaño;
    
    public Ruedas(String marca, int tamaño) {
        this.marca = marca;
        this.tamaño = tamaño;
    }

    public String getMarca() {
        return marca;
    }

    public int getTamaño() {    
        return tamaño;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Tamaño: " + tamaño;
    }
}
