
import java.util.Scanner;

/*Crea un programa que reciba dos números y un operador (+, -, *, /). El programa debe realizar la operación correspondiente 
e imprimir el resultado. Si el operador es inválido, muestra un mensaje de error.*/
public class Switch4 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el primer numero: ");
        double num1 = teclado.nextDouble();

        System.out.println("Ingresa el segundo numero: ");
        double num2 = teclado.nextDouble();

        teclado.close();

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Introduce una operacion (+, -, *, /): ");
        String Operacion = teclado2.nextLine();

        switch (Operacion) {
            case "+":
                double suma = num1 + num2;
                System.out.println("La suma da: " + suma);
                break;
            case "-":
                double resta = num1 - num2;
                System.out.println("La resta da: " + resta);
                break;
            case "*":
                double multiplicacion = num1 * num2;
                System.out.println("La multiplicacion da: " + multiplicacion);
                break;
            case "/":
                double division = num1 / num2;
                System.out.println("La division da: " + division);
                break;
            default:
                System.out.println("Error! Operacion Invalida!");
                break;
        }
        teclado2.close();
    }
}
