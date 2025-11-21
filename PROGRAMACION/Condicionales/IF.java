
import java.util.Scanner;

public class IF {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num = teclado.nextInt();

        if (num >= 0) {
            System.out.println("Es positivo");
        } else {
            System.out.println("Es negativo");
        }

        teclado.close();
    }
}

