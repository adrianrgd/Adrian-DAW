import java.util.Scanner;

/*Escribe un programa que solicite al usuario dos cadenas de texto e identifique si las 
cadenas son iguales. Imprime por pantalla “Las cadenas son iguales” o “Las cadenas son 
diferentes”.  */
public class OT10 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer texto: ");
        String text1 = teclado.nextLine();
        System.out.println("Introduce el segundo texto: ");
        String text2 = teclado.nextLine();
        String resultado;

        resultado = (text1.equals(text2)) ? "Son iguales." : "No son iguales.";
        System.out.println(resultado);
    }
}
