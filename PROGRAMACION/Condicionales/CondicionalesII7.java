
import java.util.Scanner;

/* Escribe un programa que evalúe si una persona es elegible para un préstamo, 
basándose en dos variables de entrada:  
- el Salario Anual (un número real)
- la Antigüedad Laboral en años (un número entero).
Y en las siguientes reglas: 
- Elegible: Si el Salario Anual es mayor o igual a 30.000 euros Y tiene una Antigüedad Laboral de 5 años o más.
- Revisión Especial: Si el Salario Anual es menor a 30.000 euros pero la Antigüedad Laboral es de 10 años o más. 
- No Elegible: En cualquier otro caso. 
El programa debe imprimir, dependiendo de qué reglas de las anteriores se 
cumplan: "Préstamo Aprobado", "Revisión Especial Requerida" o "Préstamo 
Denegado"*/
public class CondicionalesII7 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu salario anual: ");
        int Salario = teclado.nextInt();
        System.out.println("Introduce tus años de trabajo: ");
        int Años = teclado.nextInt();

        if (Salario >= 30000 && Años >= 5) {
            System.out.println("Prestamo Aprobado!");
        } else if (Salario <= 30000 && Años >= 10) {
            System.out.println("Revision Especial Requerida!");
        } else {
            System.out.println("Prestamo Denegado!");
        }
    }
}
