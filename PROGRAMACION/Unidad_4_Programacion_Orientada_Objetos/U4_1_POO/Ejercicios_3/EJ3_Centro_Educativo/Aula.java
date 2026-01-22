public class Aula {
    public String nombre;
    int planta;
    private int ocupacion;

    public Aula(String nombre, int planta, int ocupacion) {
        this.nombre = nombre;
        this.planta = planta;
        this.ocupacion = ocupacion;
    }

    public void actualizarOcupacion(int nuevaOcupacion) {
        if (nuevaOcupacion > 0) {
            this.ocupacion = nuevaOcupacion;
            System.out.println("Ocupación actualizada a: " + this.ocupacion);
        } else {
            System.out.println("La ocupación debe ser un número positivo.");
        }
    }

    public void mostrarInformacionAula() {
        System.out.println("Aula: " + nombre);
        System.out.println("Planta: " + planta);
        System.out.println("Ocupación actual: " + ocupacion);
    }
}
