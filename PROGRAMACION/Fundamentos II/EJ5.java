
import java.util.Scanner;


/*Dado el polinomio y=ax2+bx+c crea un programa que pida los coeficientes a, b y c, así como el valor de x, y calcula 
el valor correspondiente de y.*/
public class EJ5 {
    public static void main(String[] args) {
        
        //Solicitamos los coeficientes y el valor x
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el valor a: ");
        double a = teclado.nextDouble();
        System.out.println("Introduce el valor b: ");
        double b = teclado.nextDouble();
        System.out.println("Introduce el valor c: ");
        double c = teclado.nextDouble();
        System.out.println("Introduce el valor x: ");
        double x = teclado.nextDouble();

        //Calculamos el valor de y
        double y = (a * Math.pow(x,2)) + (b * x) + c;

        //Resultado
        System.out.println("Resultado: " + y);
    }
}
