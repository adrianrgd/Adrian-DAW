import java.util.Scanner;

/*Escribe un programa que pida un número al usuario e indique mediante un literal
booleano si el número es par*/
public class EJ10 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int n = x.nextInt();
        boolean Par = (n % 2 == 0);

        if (Par) {
            System.out.println("El numero es par");
        } else {
            System.out.println("El numero es impar");
        }
    }
}
