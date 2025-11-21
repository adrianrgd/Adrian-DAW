
import java.util.Scanner;

/*Escribe un programa que valide un inicio de sesión. El programa debe solicitar 
un nombre de usuario (String) y una contraseña (String). Implementa los 
siguientes criterios para la validación:
- Usuario Válido: El nombre de usuario NO debe ser una cadena vacía (ver método .isEmpty() de String) Y debe ser igual 
a la cadena "Admin" O a la cadena "UsuarioPrueba. 
- Contraseña Segura: La contraseña debe tener una longitud de 8 o más caracteres (ver .length() de String) Y NO debe ser igual (ver .equals() de 
String) al nombre de usuario.
El programa debe hacer las comprobaciones anteriores e imprimir: - “Inicio de Sesión Exitoso": Si el usuario es válido Y la contraseña es segura.
- "Error: Credenciales Inválidas": Si el usuario es válido, pero la contraseña no es segura. 
- "Error: Usuario No Encontrado": Si el usuario no es válido.*/
public class CondicionalesII8 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu Usuario: ");
        String User = teclado.nextLine();

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Introduce tu Contraseña: ");
        String Contraseña = teclado2.nextLine();

        if (User.isEmpty() || Contraseña.isEmpty()) {
            System.out.println("Ingrese el Usuario y Contrañeña porfavor.");
        } else if (User.equals("Admin") || User.equals("UsuarioPrueba") && Contraseña.length() > 8 && !Contraseña.equals(User)) {
            System.out.println("Inicio de Sesion Exitoso!");
        } else if (User.equals("Admin") || User.equals("UsuarioPrueba") && Contraseña.length() < 8) {
            System.out.println("Credenciales Invalidas!");
        } else {
            System.out.println("Usuario No Encontrado!");
        }
    }
}
