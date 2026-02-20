package usuarios;

import java.time.LocalDate;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected String contraseña;
    protected LocalDate fechaRegistro;

    private static int contadorUsuarios = 0;

    public Usuario(String nombre, String email, String contraseña, LocalDate fechaRegistro) {
        this.id = generarIdUsuario();
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
    }

    public static String generarIdUsuario() {
        contadorUsuarios++;
        return "USR-" + String.format("%03d", contadorUsuarios);
    }
}
