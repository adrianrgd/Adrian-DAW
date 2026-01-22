package EJ9_Estudiante;

class Estudiante {
    String nombre;
    double nota1;
    double nota2;
    double nota3;

    public Estudiante(String nombre, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public void calcPromedio() {
        double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Promedio de las notas: " + promedio);
    }
}
