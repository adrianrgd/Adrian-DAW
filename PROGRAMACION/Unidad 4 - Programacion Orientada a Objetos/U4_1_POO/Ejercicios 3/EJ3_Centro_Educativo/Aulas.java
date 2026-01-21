public class Aulas {
    private String nombre;
    private int planta;
    private int ocupacion;

    public Aulas(String nombre, int planta, int ocupacion) {
        this.nombre = nombre;
        this.planta = planta;
        this.ocupacion = ocupacion;
    }

    public void actualizarOcupacion(int ocupacion) {
        this.ocupacion += ocupacion;

        if (this.ocupacion < 0) {
            this.ocupacion = 0;
        }
    }

    public void mostrarInformacionAulas() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Planta: " + this.planta);
        System.out.println("Ocupacion: " + this.ocupacion);
    }

    @Override
    public String toString() {
        return "Aulas [nombre=" + nombre + ", planta=" + planta + ", ocupacion=" + ocupacion + "]";
    }
}
