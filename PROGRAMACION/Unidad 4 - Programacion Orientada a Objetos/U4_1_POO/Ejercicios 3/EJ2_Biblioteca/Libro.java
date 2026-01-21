public class Libro {
    private String titulo;
    private String isbn;
    private boolean disponibilidad = true;
    private static int totalLibros;

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.disponibilidad = true;
        Libro.totalLibros++;
    }

    public boolean pedirLibro() {
        if (this.disponibilidad) {
            this.disponibilidad = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLibro() {
        if (!this.disponibilidad) {
            this.disponibilidad = true;
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacionLibro() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Disponibilidad: " + this.disponibilidad);
        System.out.println("Total libros: " + Libro.totalLibros);
    }

    @Override
    public String toString() {  
        return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", disponibilidad=" + disponibilidad + ", totalLibros="
                + totalLibros + "]";
    }
}
