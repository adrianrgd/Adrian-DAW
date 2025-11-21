import java.util.Scanner;

/*Escribe un programa java que pida un número al usuario y muestre su valor absoluto. 
Utiliza el operador ternario*/

public class EJ12{
    public static void main(String[] args) {
        //declaracion de variables
        int numero; //recoge dato del usuario
        int resultado;
        Scanner teclado = new Scanner(System.in); //necesario para leer lo que el usuario escriba

        System.out.println("Introduce un numero entero: ");

        numero= teclado.nextInt(); //vuelca lo que ponga el usuario en la variable 'numero'
        
        /*Usamos Operador Terciario
        Sintaxis:
            Resultado = condicion ? valorSiVerdadero : valorSiFalso;
        */

        resultado = numero<0 ? numero*(-1) : numero;

        System.out.println("El valor absoluto de " +numero+ " es "+resultado);
    }
}
