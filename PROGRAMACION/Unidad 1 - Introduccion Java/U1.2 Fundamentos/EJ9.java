
import java.util.Scanner;

/**Una empresa que gestiona un parque acuático te solicita una aplicación que les ayude a calcular el importe que hay que cobrar en la taquilla 
por la compra de una serie de entradas (cuyo número será introducido por el usuario). 
Existen dos tipos de entrada: 
infantiles, que cuestan 15,50€; y de adultos, que cuestan 20€. 
En el caso de que el importe total sea igual o superior a 100€, se aplicará automáticamente un bono descuento del 5%.  */
public class EJ9 {
    public static void main(String[] args) {
        
        //Introducir numero de entradas
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero de entradas adultas que desea: ");
        int EntradaAdulto = teclado.nextInt();
        System.out.println("Introduce el numero de entradas infantiles que desea: ");
        int EntradaInfantil = teclado.nextInt();

        //Calcular total de importe
        final int Adulto = 20;
        final double Infantil = 15.50;
        double Resultado = ((EntradaAdulto * Adulto) + (EntradaInfantil * Infantil));
        System.out.println("Total a pagar: " + Resultado);
        if (Resultado >= 100) {
            double descuento = Resultado * 0.05;
            System.out.println("Total a pagar: " + (Resultado - descuento ));
        }
    }
}
