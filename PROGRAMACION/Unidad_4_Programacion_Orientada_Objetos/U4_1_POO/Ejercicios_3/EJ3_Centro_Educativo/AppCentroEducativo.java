public class AppCentroEducativo {
    public static void main(String[] args) {
        Aula aula1 = new Aula("Aula 1", 2, 20);
        Profesor profesor1 = new Profesor("Marta Sánchez", "Matemáticas", 2);

        aula1.mostrarInformacionAula();
        profesor1.mostrarInformacionProfesor();

        Curso curso1 = new Curso("Álgebra", "MAT-101", profesor1, aula1);

        System.out.println("\nActualizando ocupación...");
        aula1.actualizarOcupacion(-6);
        aula1.actualizarOcupacion(25);
        curso1.mostrarInformacionCurso();

        System.out.println("\nEstado final del profesor");
        profesor1.mostrarInformacionProfesor();
    }
}