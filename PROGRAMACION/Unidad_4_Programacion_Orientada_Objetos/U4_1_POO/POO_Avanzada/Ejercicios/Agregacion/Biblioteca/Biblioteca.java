public class Biblioteca {
    private Libro[] libros;
    private int contador;

    public Biblioteca() {
        this.libros = new Libro[5];
        this.contador = 0;
    }

    public void agregarLibro(Libro libro) {
        if (contador < libros.length) {
            libros[contador] = libro;
            contador++;
            System.out.println("El libro " + libro.getTitulo() + " ha sido agregado correctamente!");
        } else {
            System.out.println("No se pudo agregar el libro.");
        }
    }

    public void mostrarLibros(){
        System.out.println("Lista de libros:");
        for (int i = 0; i < contador; i++) {
            System.out.println(libros[i]);
        }
    }

    
}
