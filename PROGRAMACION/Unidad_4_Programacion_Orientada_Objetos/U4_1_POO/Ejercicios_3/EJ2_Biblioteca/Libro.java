public class Libro {
    public String titulo;
    String isbn;
    private boolean disponibilidad = true;
    static int totalLibros = 0;
    private Autor autor;

    public Libro(String titulo, String isbn, boolean disponibilidad, Autor autor, int totalLibros) {
        this.titulo = titulo;
        this.isbn = isbn;
        disponibilidad = true;
        this.autor = autor;
        totalLibros++;
    }

    public void pedirLibro() {
        if (!disponibilidad) {
            System.out.println("No disponible.");
        } else {
            disponibilidad = false;
        }
    }

    public void devolverLibro() {
        disponibilidad = true;
    }
}
