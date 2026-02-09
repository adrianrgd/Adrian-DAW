public class moto extends vehiculo {
    int cilindrada;

    public moto(String marca, String modelo, int cilindrada) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
    }

    public void acelerar() {
        System.out.println("La moto acelera agilmente!");
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto -> Marca: " + marca + " | Modelo: " + modelo + " | Cilindrada: " + cilindrada;
    }
}
