public class AppBiblioteca {
    public static void main(String[] args) {
        Autor Autor1 = new Autor("J.R.R. Tolkien", "jrrtolkien@gmail.com"); 
        Autor Autor2 = new Autor("David Bisesto", "davbisesto@gmail.com"); 
        Libro Libro1 = new Libro("El señor de los anillos", "#0405030");
        Libro Libro2 = new Libro("El hobbit", "#0405031");
        
        Libro1.devolverLibro();
        Libro1.pedirLibro();
        Libro1.mostrarInformacionLibro();
        Autor1.mostrarInformacionAutor();

        System.out.println();
        Libro2.devolverLibro();
        Libro2.pedirLibro();
        Libro2.mostrarInformacionLibro();
        Autor2.mostrarInformacionAutor();
    }
}
