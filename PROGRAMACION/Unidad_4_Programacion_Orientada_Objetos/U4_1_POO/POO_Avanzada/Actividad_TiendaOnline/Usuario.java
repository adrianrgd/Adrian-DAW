import java.time.localDate;

public class Usuario {
    String id;
    String nombre;
    String email;
    String contraseña;
    localDate fechaRegistro;
    
    public Usuario(String id, String nombre, String email, String contraseña, localDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
    }  
}
