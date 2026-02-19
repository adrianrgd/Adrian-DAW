public class Universidad {
    private Estudiantes[] estudiantes;
    private int contador;

    public Universidad() {
        this.estudiantes = new Estudiantes[5];
        this.contador = 0;
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = estudiante;
            contador++;
            System.out.println("Estudiante " + estudiante.getNombre() + " registrado exitosamente.");
        } else {
            System.out.println("No se puede registrar más estudiantes. La universidad está llena.");
        }
    }

    public void mostrarEstudiantes() {
        System.out.println("Lista de Estudiantes en la Universidad:");
        for (int i = 0; i < contador; i++) {
            System.out.println(estudiantes[i]);
        }
    }
}
