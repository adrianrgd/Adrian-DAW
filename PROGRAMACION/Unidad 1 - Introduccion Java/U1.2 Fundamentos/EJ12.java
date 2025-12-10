
import java.util.Scanner;

/* La FILA (Federación Internacional de Lanzamiento de Algoritmo) realiza una competición donde cada participante escribe un 
algoritmo en un papel y lo lanza, ganando quien consiga lanzarlo más lejos. La peculiaridad del concurso es que la longitud 
del lanzamiento se mide en metros (con tantos decimales como se desee), pero para el ranking solo se tiene en cuenta la 
longitud en centímetros (sin decimales). Por ejemplo, para un lanzamiento de 12,3456 m (que son 1234,56 cm) solo se contabilizarán 1234 cm. 
Realiza un programa que solicite la longitud (en metros) de un lanzamiento y muestre la parte entera correspondiente en centímetros.*/
public class EJ12 {
    public static void main(String[] args) {
        
        //solicitar longitud del lanzamiento en metros
        Scanner teclado = new Scanner(System.in);
        System.out.println("Longitud del lanzamiento: ");
        double longm = teclado.nextDouble();

        //Conversion de la longitud de m a cm
        double resultado = (longm * 100);
        int longcm = (int)resultado;

        //resultado en cm
        System.out.println("Longitud en cm: " + longcm);
    }
}
