import java.util.Scanner;

/*Escribe un programa que solicite al usuario la calificación obtenida en la 
prueba (número entero positivo). Si el número es >= 5, se imprime por pantalla “Se 
ha aprobado la prueba”, en otro caso se imprime “No se ha aprobado la prueba”. 
Utiliza el operador ternario.*/
public class Repaso4 {
    public static void main(String[] args) {
        
        //Solicitamos numero entero positivo al usuario
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero entero positivo: ");
        int num = teclado.nextInt();

        //Comprobamos el numero con Operador Terciario para ver si ha aprobado o no
        String Resultado = (num >= 5) ? "Se ha aprobado la prueba!" : (num < 0) ? "Numero invalido." : "No se ha aprobado la prueba.";
        System.out.println(Resultado);
    }
}
