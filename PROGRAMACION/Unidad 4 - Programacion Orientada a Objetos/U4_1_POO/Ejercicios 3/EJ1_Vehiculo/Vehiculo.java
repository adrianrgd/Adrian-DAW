public class Vehiculo {
    private String matricula;
    private String marca;
    private static String empresa = "CarCo Jhones";
    private int kilometraje;

    public Vehiculo(String matricula, String marca, int kilometraje) {
        this.matricula = matricula;
        this.marca = marca;
        this.kilometraje = kilometraje;
    }

    public void registrarKilometros(int kilometros) {
        this.kilometraje += kilometros;
    }

    public void mostrarInformacionVehiculo() {
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Marca: " + this.marca);
        System.out.println("Empresa: " + empresa);
        System.out.println("Kilometraje: " + this.kilometraje);
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", empresa=" + Vehiculo.empresa + ", kilometraje=" + kilometraje + "]";
    }
}
