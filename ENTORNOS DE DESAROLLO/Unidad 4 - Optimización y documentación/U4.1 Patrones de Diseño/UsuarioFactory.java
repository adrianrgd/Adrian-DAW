public class UsuarioFactory {
    
    public static Usuario crear(String tipo) {
        
        if (tipo.equals("admin")) {
            return new Admin();
        }
        else if (tipo.equals("cliente")) {
            return new Cliente();
        }
        else {
            return new Invitado();
        }
    }
}
