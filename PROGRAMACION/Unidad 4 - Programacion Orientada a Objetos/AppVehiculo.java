class Vehiculo {
    protected String matricula; 
    public static final String marca = "Toyota";
    private double kilometraje; 

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.kilometraje = 0;
    }

    public void crearVehiculo(String matricula) {
        this.matricula = matricula;
    }

    public void registrarKilometros(double kilometros) {
        this.kilometraje += kilometros;
    }

    public void mostrarDatos() {
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Marca: " + Vehiculo.marca);
        System.out.println("Kilometraje: " + this.kilometraje);
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return Vehiculo.marca;
    }

    public double getKilometraje() {
        return this.kilometraje;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
}

class Vendedor {
    public String nombre;
    final String email = "vendedor@gmail.com";
    private static final int limiteKilometraje = 10000;

    //restricciones vendedores
    private int limite;

    public Vendedor(String nombre, String email) {
        this.nombre = nombre;
        this.limite = 50000;
    }

    public Vendedor(String nombre, String email, int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }

    public String getEmail() {
        return this.email;
    }
}

public class AppVehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("1234ABC");
        vehiculo1.registrarKilometros(150.5);
        vehiculo1.mostrarDatos();

        Vendedor vendedor1 = new Vendedor("Juan Perez", "[EMAIL_ADDRESS]");
        Vendedor vendedor2 = new Vendedor("Ana Gomez", "[EMAIL_ADDRESS]", 60000);

        System.out.println("Vendedor 1: " + vendedor1.nombre + " - Email: " + vendedor1.getEmail());
        System.out.println("Vendedor 2: " + vendedor2.nombre + " - Email: " + vendedor2.getEmail());
    }
}

