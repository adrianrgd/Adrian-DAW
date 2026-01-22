public class AppBiblioteca {
    public static void main(String[] args) {
        Autor Autor1 = new Autor("J.R.R. Tolkien", "jrrtolkien@gmail.com", 4); 
        Libro Libro1 = new Libro("El señor de los anillos", "#0405030", false, Autor1, 1);
        Libro Libro2 = new Libro("El hobbit", "#0405031", true, Autor1, 1);
        
        Libro1.pedirLibro();
        Libro1.devolverLibro();
        Libro2.pedirLibro();
        Libro2.devolverLibro();
    }
}
