import java.util.Scanner;

/*Escribe un programa que solicite 3 números al usuario y utilice el operador ternario 
para encontrar el de menor valor.*/
public class OT2 {
    public static void main(String[] args) {
        
        /*declarar variables*/
        int numero1;
        int numero2;
        int numero3;
        String resultado;

        /*Solicitar numeros al usuario*/
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        numero1 = teclado.nextInt();
        System.out.println("Introduce el segudno numero: ");
        numero2 = teclado.nextInt();
        System.out.println("Introduce el tercer numero: ");
        numero3 = teclado.nextInt();

        /*Operador Terciario
        Resultado para elejir cual numero es el de menor valor de los 3*/
        resultado = (numero1 < numero2 && numero1 < numero3) ? "El número " + numero1 + " es el menor."
        : (numero2 < numero1 && numero2 < numero3) ? "El número " + numero2 + " es el menor."
        : "El número " + numero3 + " es el menor.";

        System.out.println(resultado);
    }
}
