//Ejercicio 2 POO_3
class Autor {
    public String nombre;
    private String email;
    int numLibrosPublicados;

    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.numLibrosPublicados = 0;
    }

    public String getEmail() {
        return email;
    }

    void incrementarLibros() {
        this.numLibrosPublicados++;
    }

    public void mostrarAutor() {
        System.out.println("AUTOR -> Nombre: " + nombre + " | Email: " + email + 
                           " | Libros: " + numLibrosPublicados);
    }
}

class Libro {
    public String titulo;
    String isbn;
    private boolean disponibilidad;
    private static int totalLibros = 0;
    private Autor autor; 

    public Libro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.disponibilidad = true;
        totalLibros++;
        autor.incrementarLibros(); 
    }

    public void pedirLibro() {
        if (disponibilidad) {
            disponibilidad = false;
            System.out.println("Éxito: '" + titulo + "' prestado.");
        } else {
            System.out.println("Error: '" + titulo + "' ya está ocupado.");
        }
    }

    public void devolverLibro() {
        disponibilidad = true;
        System.out.println("'" + titulo + "' ha sido devuelto.");
    }

    public void mostrarInformacion() {
        System.out.println("LIBRO -> Título: " + titulo + " | ISBN: " + isbn + 
                           " | Autor: " + autor.nombre + " | Disponible: " + (disponibilidad ? "Sí" : "No"));
    }

    public static int getTotalLibros() {
        return totalLibros;
    }
}

// Clase de Prueba
public class AppBiblioteca {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Gabriel García Márquez", "gabo@mail.com");

        Libro libro1 = new Libro("Cien Años de Soledad", "978-3161484100", autor1);
        Libro libro2 = new Libro("El Coronel no tiene quien le escriba", "978-1566199094", autor1);

        libro1.mostrarInformacion();
        libro1.pedirLibro();
        libro1.pedirLibro();

        System.out.println("\n--- Resumen ---");
        autor1.mostrarAutor();
        System.out.println("Total libros en biblioteca: " + Libro.getTotalLibros());
    }
}