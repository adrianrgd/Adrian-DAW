
import java.util.Scanner;

/*Solicita al usuario tres distancias: 
• La primera, medida en milímetros. 
• La segunda, medida en centímetros. 
• La última, medida en metros. 
Diseña un programa que muestre la suma de las tres longitudes introducidas 
(medida en centímetros).*/
public class EJ7 {
    public static void main(String[] args) {
        
        //Solicitamos las distancias
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un valor en milimetros: ");
        double mm = teclado.nextDouble();
        System.out.println("Introduce un valor en centimetros: ");
        double cm = teclado.nextDouble();
        System.out.println("Introduce un valor en metros: ");
        double m = teclado.nextDouble();

        //Sumar las medidas en cm
        double mm2 = mm / 10;
        double m2 = m * 100;

        double Resultado = (mm2 + cm + m2);
        System.out.println("El resultado de la suma es: " + Resultado);
    }
}
