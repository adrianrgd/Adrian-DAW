
/*Escribe  un  programa  que  utilice  una  función  sobrecargada  para  realizar 
operaciones aritméticas. 
• Si se invoca con 2 parámetros (numéricos) devuelve la suma de ambos valores  
• Si  se  invoca  con  3  parámetros  (2  numéricos  y  el  tercero  un  operador 
aritmético:  +,  -  ,  /  o  *)  devuelve  el  resultado  de  la  operación  pasada 
como tercer parámetro.  */
import java.util.Scanner;

public class Funciones6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos parámetros usarás (2 o 3)? ");
        int parametros = teclado.nextInt();

        if (parametros == 2) {
            System.out.print("Introduce el primer número: ");
            int a = teclado.nextInt();
            System.out.print("Introduce el segundo número: ");
            int b = teclado.nextInt();
            System.out.println("La suma da: " + suma(a, b));
        } else if (parametros == 3) {
            System.out.print("Introduce el primer número: ");
            int a = teclado.nextInt();
            System.out.print("Introduce el segundo número: ");
            int b = teclado.nextInt();
            System.out.print("Elije una operación (+, -, /, *): ");
            char operacion = teclado.next().charAt(0);
            System.out.println("El resultado es: " + suma(a, b, operacion));
        } else {
            System.out.println("Número de parámetros no válido.");
        }

        teclado.close();
    }

    public static int suma(int a, int b) {
        return a + b;
    }

    public static int suma(int a, int b, char operacion) {
        return switch (operacion) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '/' -> (b != 0) ? a / b : 0;
            case '*' -> a * b;
            default -> 0;
        };
    }
}