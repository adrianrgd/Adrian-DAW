import java.util.Scanner;

public class Funciones18 {
    public static void main(String[] args) {
        IniciarValidacion();
    }

    public static boolean longitudMin(String contraseña) {
        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.length() < 8) {
                return false;
            }
        } 
        return true;
    }

    public static boolean tieneMayuscula(String contraseña) {
        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

        public static boolean tieneMinuscula(String contraseña) {
        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tieneNumero(String contraseña) {
        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contraseñaValida(String contraseña) {
        return longitudMin(contraseña) && tieneMayuscula(contraseña) && tieneMinuscula(contraseña) && tieneNumero(contraseña);
    }

    public static void IniciarValidacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una contraseña: ");
        String contraseña = teclado.nextLine();
        teclado.close();

        System.out.println("Tiene más de 8 caracteres: " + (longitudMin(contraseña) ? "Si!" : "No!"));
        System.out.println("Tiene al menos 1 mayuscula: " + (tieneMayuscula(contraseña) ? "Si!" : "No!"));
        System.out.println("Tiene al menos 1 minuscula: " + (tieneMinuscula(contraseña) ? "Si!" : "No!"));
        System.out.println("Tiene al menos un digito (numero): " + (tieneNumero(contraseña) ? "Si!" : "No!"));
        System.out.println("Tu contraseña " + (contraseñaValida(contraseña) ? "es valida!" : "no es valida!"));
    }
}

