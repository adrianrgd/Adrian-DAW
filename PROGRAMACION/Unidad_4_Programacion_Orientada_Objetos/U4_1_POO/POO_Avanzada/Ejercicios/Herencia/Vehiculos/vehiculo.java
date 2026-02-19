public class vehiculo {
    String marca;
    String modelo;

    public vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void acelerar() {
        System.out.println("El vehiculo esta acelerando!");
    }

    public void arrancar() {
        System.out.println("El vehiculo esta arrancando!");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo -> Marca: " + marca + " | Modelo: " + modelo;
    }
}
