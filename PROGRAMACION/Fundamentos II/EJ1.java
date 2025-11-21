import java.util.Scanner;

/*Un economista te ha encargado un programa para realizar cálculos con el 
IVA. La aplicación debe solicitar la base imponible y el IVA que se debe aplicar. 
Muestra en pantalla el importe correspondiente al IVA y al total.*/
public class EJ1 {
    public static void main(String[] args) {
        
        //Solicitamos los datos necesarios
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la Base Imponible: ");
        double base = teclado.nextDouble();

        System.out.println("Introduce el IVA aplicable: ");
        int IVA = teclado.nextInt();

        //Calculamos el importe de IVA y total
        double ImporteIVA = (double)((base * IVA) / 100);
        System.out.println("Importe IVA: " + ImporteIVA);
        System.out.println("Importe total: " + (double) (ImporteIVA + base));
    }   
}
