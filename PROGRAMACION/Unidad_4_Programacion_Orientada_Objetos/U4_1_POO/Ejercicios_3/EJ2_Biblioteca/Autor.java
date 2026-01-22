public class Autor {
    private String nombre;
    private String email;
    int numLibros;

    public Autor(String nombre, String email, int numLibros) {
        this.nombre = nombre;
        this.email = email;
        this.numLibros = numLibros;
    }

    public String setEmail() {
        return email;
    }
}
