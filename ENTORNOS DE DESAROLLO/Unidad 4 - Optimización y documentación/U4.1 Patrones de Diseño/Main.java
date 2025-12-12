public class Main {
    public static void main(String[] args) {
        
        String tipo = "cliente";
        
        Usuario user = UsuarioFactory.crear(tipo);

        user.mostrarRol();
    }
}
