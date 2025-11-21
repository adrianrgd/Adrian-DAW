import java.util.Scanner;

/*Escribe un programa que ayude al usuario a calcular la velocidad a la 
que se ha desplazado hasta su centro de trabajo. Se solicita al usuario la distancia 
recorrida (en km) y el tiempo transcurrido (en horas).
Se imprimirá por pantalla “La velocidad es de XXX km/h”, donde XXX es la velocidad 
calculada en función de los datos introducidos: velocidad = distancia/ tiempo */
public class Repaso2 {
    public static void main(String[] args) {
        
        //Solicitamos la distancia (km) y el tiempo (h)
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la distancia (km): ");
        int distancia = teclado.nextInt();

        System.out.println("Introduce el tiempo del trayecto (h): ");
        int horas = teclado.nextInt();

        //Calculamos la velocidad segun distancia/tiempo
        int Resultado = distancia / horas;
        System.out.println("La velocidad es de :" + Resultado);
    }
}
