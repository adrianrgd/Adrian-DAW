import java.util.Scanner;

public class Funciones16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce un texto: ");
        String texto = teclado.nextLine(); 
        System.out.println("Introduce 2 silabas: ");
        String silaba = teclado.nextLine();

        if (silaba.length() > 2) {
            System.out.println("Invalido! Solo 2 silabas.");
            System.out.println("Introduce 2 silabas: ");
            silaba = teclado.nextLine();
        }

        System.out.println("Las silabas '" + silaba + "'" + (buscarSilaba(texto, silaba ) ? " estan" 
        : " no estan") + " en el texto '" + texto + "'.");
    }

    public static boolean buscarSilaba(String texto, String silaba) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.contains(silaba)) {
                return true;
            }            
        }
        return false;
    }
}

