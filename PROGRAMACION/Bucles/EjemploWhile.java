
import java.util.Scanner;

public class EjemploWhile {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce un numero: ");
            int num = teclado.nextInt();
            
            do {
                System.out.println(num);
            num ++;
            }while (num <= 10); 

            System.out.println("Es mayor a 10!");
        }   
    }
}
