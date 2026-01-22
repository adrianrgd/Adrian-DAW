public class Curso {
    private String nombre;
    private String codigo;
    private Profesor profesor;
    private Aula aula;

    public Curso(String nombre, String codigo, Profesor profesor, Aula aula) {
        this.nombre = nombre;
        this.codigo = codigo;
        asignarProfesor(profesor); 
        asignarAula(aula);
    }

    public void asignarProfesor(Profesor nuevoProfesor) {
        this.profesor = nuevoProfesor;
        this.profesor.anotarCurso(); 
    }

    public void asignarAula(Aula nuevaAula) {
        this.aula = nuevaAula;
    }

    public void mostrarInformacionCurso() {
        System.out.println("\nDatos del Curso: " + nombre + " (" + codigo + ")");
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.nombre + " (" + profesor.especialidad + ")");
        }
        if (aula != null) {
            System.out.println("Aula asignada: " + aula.nombre);
        }
    }
}