public class Autor {
    private String nombre;
    private String email;
    private int numLibrosPublicados;

    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void mostrarInformacionAutor() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email); 
        System.out.println("Num libros publicados: " + this.numLibrosPublicados);
    }

    @Override
    public String toString() {
        return "Autor [nombre=" + nombre + ", email=" + email + ", numLibrosPublicados=" + numLibrosPublicados + "]";
    }
}
