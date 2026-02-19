public class coche extends vehiculo {
    int numPuertas;

    public coche(String marca, String modelo, int numPuertas) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
    }

    public void acelerar() {
        System.out.println("El coche acelera rapidamente!");
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Coche -> Marca: " + marca + " | Modelo: " + modelo + " | Numero de puertas: " + numPuertas;
    }
}
