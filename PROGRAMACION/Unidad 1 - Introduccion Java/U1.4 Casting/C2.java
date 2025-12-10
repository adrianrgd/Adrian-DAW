/*Escribe un programa que reciba un número de tipo double y lo convierta 
explícitamente a int. Muestra ambos valores por pantalla. */

public class C2 {
    public static void main(String[] args) {
        
        //Convertir double en int
        double a = 6.43;
        int b = (int) a;

        //Imprimimos el resultado
        System.out.println("Conversion: " + (int)b);
    }
}
