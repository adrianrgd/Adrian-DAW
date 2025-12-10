import java.util.Scanner;

/*Escribe un programa que solicite un carácter al usuario y que identifique si el carácter 
es mayúscula o minúscula. Imprime por pantalla “Mayúscula” o ‘Minúscula” en función 
del resultado del análisis.  */
public class OT9{
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una letra: ");
        char letra = teclado.next().charAt(0);
        String resultado;
        
        resultado = Character.isUpperCase(letra) ? "Mayuscula" : "Minuscula";
        System.out.println(resultado);
    }
}