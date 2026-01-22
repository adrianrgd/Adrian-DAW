public class Profesor {
    public String nombre;
    public String especialidad;
    private int numCursosAsignados;

    public Profesor(String nombre, String especialidad, int numCursosAsignados) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numCursosAsignados = numCursosAsignados;
    }

    public void asignarCursoProfesor(int numCursosAsignados) {
        this.numCursosAsignados += numCursosAsignados;
    }

    public void mostrarInformacionProfesores() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("NumCursosAsignados: " + this.numCursosAsignados);
    }

    public void anotarCurso() {
        this.numCursosAsignados++;
    }

    public void mostrarInformacionProfesor() {  
        System.out.println("Profesor: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cursos asignados: " + numCursosAsignados);
    }
}

