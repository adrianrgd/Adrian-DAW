public class Cursos {
    private String nombre;
    private int codCurso;
    private String profesor;
    private int aula;

    public Cursos(String nombre, int codCurso, String profesor, int aula) {
        this.nombre = nombre;
        this.codCurso = codCurso;
        this.profesor = profesor;
        this.aula = aula;
    }

    public void asignarProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void asignarAulaCurso(int aula) {
        this.aula = aula;
    }

    public void mostrarInformacionCursos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("CodCurso: " + this.codCurso);
        System.out.println("Profesor: " + this.profesor);
        System.out.println("Aula: " + this.aula);
    }

    @Override
    public String toString() {
        return "Cursos [nombre=" + nombre + ", codCurso=" + codCurso + ", profesor=" + profesor + ", aula=" + aula + "]";
    }
}
