import java.util.Scanner;

/*Escribe un programa que solicite dos números enteros al usuario. Se 
imprimirá por pantalla “¿Son los números distintos? true/false”. Donde true/false 
será el resultado de evaluar si los números introducidos son distintos. 
Plantea tu solución sin utilizar operador ternario ni estructura ‘if’ o similar.*/
public class Repaso3 {
    public static void main(String[] args) {
        
        //Solicitar dos numeros enteros al usuario
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int num1 = teclado.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int num2 = teclado.nextInt();
        
        //Determinar si son distintos los numeros
        boolean Resultado = num1 == num2;
        System.out.println("¿Son los numeros distintos?: " + Resultado);
    }
}
