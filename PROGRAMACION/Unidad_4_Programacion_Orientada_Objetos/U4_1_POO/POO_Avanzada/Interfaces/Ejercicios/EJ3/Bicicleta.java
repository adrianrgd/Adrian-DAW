package Ejercicios.EJ3;

public class Bicicleta implements Vehiculo {
    String marca;

    public Bicicleta(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void mover() {
        System.out.println("La bicicleta " + marca + " se mueve");
    }
}
