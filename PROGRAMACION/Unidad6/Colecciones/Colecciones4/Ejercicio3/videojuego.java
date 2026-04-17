package Colecciones4.Ejercicio3;

public class videojuego implements Comparable<videojuego> {
    String titulo;
    int puntuacion;
    int anyo;

    public videojuego(String titulo, int puntuacion, int anyo) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.anyo = anyo;
    }

    @Override
    public int compareTo(videojuego o) {
        return Integer.compare(o.puntuacion, this.puntuacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public String toString() {
        return "Videojuego: " +
                "Titulo: " + titulo +
                " | Puntuacion: " + puntuacion +
                " | Año: " + anyo;
    }
}
