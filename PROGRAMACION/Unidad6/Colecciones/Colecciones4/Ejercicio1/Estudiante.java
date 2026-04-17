package Colecciones4.Ejercicio1;

public class Estudiante implements Comparable<Estudiante> {
    String nombre;
    String apellido;
    double nota;

    public Estudiante(String nombre, String apellido, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    @Override
    public int compareTo(Estudiante o) {
        int comp = this.apellido.compareTo(o.apellido);
        if (comp == 0) {
            return this.nombre.compareTo(o.nombre);
        }
        return comp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Estudiante: Nombre:" + nombre + " | Apellido:" + apellido + " | Nota:" + nota;
    }

}
