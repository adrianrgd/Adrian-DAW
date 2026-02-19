public class gato extends animal {
    String peso;

    public gato(String nombre, int edad, String peso) {
        super(nombre, edad);
        this.peso = peso;
    }

    public void hacerSonido() {
        System.out.println("El gato hace... ¡miau miau!");
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Peso: " + peso + " | Edad: " + edad;
    }
}
