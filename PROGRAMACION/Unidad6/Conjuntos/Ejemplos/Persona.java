import java.util.Objects;

public class Persona {

    private String nombre;
    private int edad;
    String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Persona: " + "[Nombre: " + nombre + ", Edad: " + edad + ", Ciudad: " + ciudad + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, ciudad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(nombre, other.nombre) && edad == other.edad && Objects.equals(ciudad, other.ciudad);
    }

}
