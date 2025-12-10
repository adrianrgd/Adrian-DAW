
import java.util.Scanner;

/*Diseña una aplicación que solicite al usuario que introduzca una cantidad de 
segundos. 
La aplicación debe mostrar cuántas horas, minutos y segundos hay en el número de 
segundos introducidos por el usuario.*/
public class EJ6 {
    public static void main(String[] args) {
        
        //Solicitar cantidad de segundos
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la cantidad de segundos: ");
        int seg = teclado.nextInt();

        //Mostrar horas/minutos/segundos en el numero de segundos introducido
        int segundos =  seg % 60;
        int minutos = (seg / 60) % 60;
        int horas = seg / 3600;

        //Mostrar resultado
        System.out.println(horas + "h: " + minutos + "m: " + segundos + "s");
    }
}
