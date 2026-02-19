public class Componente {
    private String tipo; 
    private String modelo; 
    private int capacidad; 

    public Componente(String tipo, String modelo, int capacidad) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return tipo + ": " + modelo + (capacidad > 0 ? " (" + capacidad + " GB)" : "");
    }
}
