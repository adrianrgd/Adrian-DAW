//Ejercicio 3

public class MainUniversidad {
    public static void main(String[] args) {
        Universidad miUniversidad = new Universidad();

        Estudiantes e1 = new Estudiantes("Juan Perez", 20, "A001");
        Estudiantes e2 = new Estudiantes("Maria Lopez", 22, "B002");
        Estudiantes e3 = new Estudiantes("Carlos Ruiz", 21, "C003");

        miUniversidad.agregarEstudiante(e1);
        miUniversidad.agregarEstudiante(e2);
        miUniversidad.agregarEstudiante(e3);
        System.out.println();
        miUniversidad.mostrarEstudiantes();
    }
}
