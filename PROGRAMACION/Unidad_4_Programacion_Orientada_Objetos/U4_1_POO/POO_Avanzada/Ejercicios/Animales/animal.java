public class animal {
    String nombre;
    int edad;

    public animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }

    @Override
    public String toString() {
        return "Animal -> Nombre: " + nombre + " | Edad: " + edad;
    }
}
