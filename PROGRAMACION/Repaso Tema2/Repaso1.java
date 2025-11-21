import java.util.Scanner;

/*Escribe un programa que ayude a un vendedor a calcular el precio de las 
ventas de 3 de sus productos.*/
public class Repaso1 {
    public static void main(String[] args) {
        
        final int IVA = 1; 
        //Productos
        double Patatas = 2.8;
        double Tomates = 4.7;
        double Lechuga = 2;

        //Solicitamos al usuario cuantos kilos quiere de cada producto
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los kilos de patatas: ");
        int x = teclado.nextInt();
        
        System.out.println("Introduce los kilos de tomates: ");
        int y = teclado.nextInt();
        
        System.out.println("Introduce los kilos de lechuga: ");
        int z = teclado.nextInt();

        //Resultado total
        double Resultado = (Patatas * x) + (Tomates * y) + (Lechuga * z) + IVA;
        System.out.println("“El total de la compra es: " + Resultado);
    }
}