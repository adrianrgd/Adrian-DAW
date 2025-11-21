import java.util.Scanner;

public class Clase08 {
    public static void main(String[] args) {
        // OR ||
        // AND &&
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese un numero: ");
        int num2 = sc.nextInt();
        if (num1 == num2) {
            System.out.println("Es el mismo numero");
        } else {
            System.out.println("Son numeros diferentes");
        }
    }
}

