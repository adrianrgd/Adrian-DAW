package Ejercicios.EJ3;

public class Coche implements Vehiculo {
    String marca;

    public Coche(String marca) {
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
        System.out.println("El coche " + marca + " se mueve");
    }
}
