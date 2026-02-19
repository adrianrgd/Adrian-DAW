//Ejercicio 4

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca librosStock = new Biblioteca();

        Libro libro1 = new Libro("Harry Potter", "J.K. Rowling", 1997);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);
        Libro libro3 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605);

        librosStock.agregarLibro(libro1);
        librosStock.agregarLibro(libro2);
        librosStock.agregarLibro(libro3);
        System.out.println();
        librosStock.mostrarLibros();
    }
}
