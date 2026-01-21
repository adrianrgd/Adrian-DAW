public class Profesores {
    private String nombre;
    private String especialidad;
    private int numCursosAsignados;

    public Profesores(String nombre, String especialidad, int numCursosAsignados) {
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

    @Override
    public String toString() {
        return "Profesores [nombre=" + nombre + ", especialidad=" + especialidad + ", numCursosAsignados=" + numCursosAsignados + "]";
    }
}

