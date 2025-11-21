import java.util.Scanner;

/* Crea un programa que pida la base y la altura de un triángulo y muestre su 
área.*/
public class EJ4 {
    public static void main(String[] args) {
        
        //Pedimos base y altura
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la base: ");
        double base = teclado.nextDouble();

        System.out.println("Introduzca la altura: ");
        double altura = teclado.nextDouble();

        //Calculamos el área
        Double Resultado = (base * altura) / 2;
        
        //Resultado
        System.out.println("El área es: " + Resultado);
    }
}
