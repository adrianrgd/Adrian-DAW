import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int n = sc.nextInt();
        System.out.println("El numero que has introducido es: " + n);
        System.out.println("Ingrese un texto: ");
        Scanner sc2 = new Scanner(System.in);
        String texto = sc2.nextLine();
        System.out.println("El texto es: " + texto);
    }
}

