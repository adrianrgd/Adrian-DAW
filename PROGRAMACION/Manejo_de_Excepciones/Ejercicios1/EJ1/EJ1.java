package Ejercicios1.EJ1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int num1, num2;

            System.out.println("Introduce el primer número: ");
            num1 = sc.nextInt();
            System.out.println("Introduce el segundo número: ");
            num2 = sc.nextInt();

            int division = num1 / num2;
            System.out.println("La división de " + num1 + " entre " + num2 + " es: " + division);

            sc.close();
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error al dividir.");
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Solo puedes introducir numeros!");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error Inesperado" + e.getMessage());
        } finally {
            System.out.println("Fin del programa.");
        }
    }
}
