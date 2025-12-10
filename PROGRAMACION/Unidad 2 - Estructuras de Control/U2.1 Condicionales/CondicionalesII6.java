
import java.util.Scanner;

/*Escribe un programa que solicite al usuario las longitudes de los tres lados de un triángulo (a, b, c), y que determine qué tipo de triángulo es: 
- Equilátero: si los tres lados son iguales. 
- Isósceles: si exactamente dos lados son iguales 
- Escaleno: si ningún lado es igual*/
public class CondicionalesII6 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("1ª Longitud: ");
        double a = teclado.nextDouble();

        System.out.println("2ª Longitud: ");
        double b = teclado.nextDouble();
        
        System.out.println("3ª Longitud: ");
        double c = teclado.nextDouble();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("No se pueden introducir numeros negativos o 0!");
        } else if (a == b && a == c) {
            System.out.println("Es un triangulo Equilatero!");
        } else if (a == b || a == c || b == c || a == c) {
            System.out.println("Es un triangulo Isosceles!");
        } else if (a != b && a != c) {
            System.out.println("Es un triangulo Escaleno!");
        }
    }
}
