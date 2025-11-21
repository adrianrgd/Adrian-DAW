
import java.util.Scanner;

/*Pide dos números al usuario: a y b. Deberán mostrarse true si ambos números 
son iguales y false en caso contrario.*/
public class EJ11 {
    public static void main(String[] args) {
        
        //Pedimos dos numeros
        Scanner teclado = new Scanner(System.in);
        System.out.println("Primer numero: ");
        int a = teclado.nextInt();
        System.out.println("Segundo numero: ");
        int b = teclado.nextInt();

        //Mostrar si son iguales o no
        boolean resultado = (a == b);
        System.out.println(resultado);
    }
}
