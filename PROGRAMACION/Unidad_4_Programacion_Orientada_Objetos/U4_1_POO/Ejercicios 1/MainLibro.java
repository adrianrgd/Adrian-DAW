//Ejercicio 7 POO_1
class Libro {
    String titulo;
    String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void cambiarTitulo(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
    }
    
    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " por " + autor);
    }
}

public class MainLibro {
    public static void main(String[] args) {
        Libro libro = new Libro("Don Quijote", "Cervantes");
        libro.mostrarInfo();
        
        libro.cambiarTitulo("Don Quijote de la Mancha");
        libro.mostrarInfo();
    }
}