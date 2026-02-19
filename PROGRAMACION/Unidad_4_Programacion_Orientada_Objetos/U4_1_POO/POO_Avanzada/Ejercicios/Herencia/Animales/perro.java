public class perro extends animal {
    String raza;

    public perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public void hacerSonido() {
        System.out.println("El perro hace... ¡Woof Woof!");
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro -> Nombre: " + nombre + " | Raza: " + raza + " | Edad: " + edad;
    }
}