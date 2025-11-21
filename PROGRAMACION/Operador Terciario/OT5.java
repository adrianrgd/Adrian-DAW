import java.util.Scanner;

/*Escribe un programa que determine si un número está entre 100 y 200 inclusive. Si se 
encuentra en el rango se imprime “Dentro del rango”, en otro caso “Fuera del rango” */
public class OT5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        String resultado;

        resultado = (numero >=100 && numero <=200) ? "El numero esta dentro del rango." : "El numero esta fuera del rango.";
        System.out.println(resultado);
    }
}
