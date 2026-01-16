class Libro {
    String titulo;
    String isbn;
    private Boolean disponibilidad;
    int totalLibros;

    public void crearLibro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.disponibilidad = true;
        this.totalLibros++;
    }

    public void pedirLibro() {
        if (disponibilidad) {
            disponibilidad = false;
        } else {
            System.out.println("El libro no está disponible actualmente.");
        }
    }

    public void devolverLibro() {
        this.disponibilidad = true;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}

class Autor {
    String nombre;
    //se puede consultar pero no cambiar
    private final String email;
    int numLibrosPublicados;

    public Autor(String nombre, String email, int numLibrosPublicados) {
        //siempre tiene un nombre y un email
        this.nombre = nombre;
        this.email = email;
        this.numLibrosPublicados = numLibrosPublicados; 
    }

    public String getEmail() {
        return email;
    }

    void incrementarLibrosPublicados() {
        this.numLibrosPublicados++;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", Email: " + email + ", Libros publicados: " + numLibrosPublicados);
    }

}

public class AppBiblioteca {
    public static void main(String[] args) {
        
    }
}