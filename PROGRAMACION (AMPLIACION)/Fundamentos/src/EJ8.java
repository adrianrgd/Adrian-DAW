import java.util.Scanner;

public class EJ8 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Ingrese su edad: ");
        int y = x.nextInt();
        boolean r = y >= 18;
        System.out.println("Mayor de edad: " + r);
    }
}
