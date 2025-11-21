import java.util.Scanner;

/*Escribe un programa que pida una temperatura en grados Celsius. Si la temperatura es 
mayor o igual a 30°C, el programa debe imprimir "Hace calor", de lo contrario "Hace 
frío". */
public class OT3 {
    public static void main(String[] args) {
        
        /*Declarar variables */
        String resultado;
      
        /*Introducir temperatura en grados celsius */
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la temperatura en grados celsius: ");
        int temp = teclado.nextInt();

        /*Operador Terciario
        Determinar si la temperatura es menor a 30°C*/
        resultado = (temp >= 30) ? "Hace Calor" : "Hace frio.";
        
        /*Imprimir resultado */
        System.out.println(resultado);
    }
}
