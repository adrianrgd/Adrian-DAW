public class Vendedores {
    private String nombre;
    private static String email;
    private int limiteKilometraje;  
    
    public Vendedores(String nombre, String email, int limiteKilometraje) {
        this.nombre = nombre;
        Vendedores.email = "carco@jhones.com";
        this.limiteKilometraje = limiteKilometraje;
    }

    public void mostrarInformacionVendedores() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + Vendedores.email);
        System.out.println("Limite kilometraje: " + this.limiteKilometraje);
    }

    public void setLimiteKilometraje(int limiteKilometraje) {
        if (limiteKilometraje > 0) {
            this.limiteKilometraje = limiteKilometraje;
        }
    }
    
    public int getLimiteKilometraje() {
        return this.limiteKilometraje;
    }
    
    @Override
    public String toString() {
        return "Vendedores [nombre=" + nombre + ", email=" + email + ", limiteKilometraje=" + limiteKilometraje + "]";
    }
}
