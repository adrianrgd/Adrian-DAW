import java.util.Scanner;

public class EJ9 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Ingrese el radio: ");
        double radio = x.nextFloat();
        double longitud = (2.14) * radio;
        double area = (3.14) * Math.pow(radio,2);

        System.out.println("El area del radio es: "+area);
        System.out.println("El longitud del radio es: "+longitud);
    }
}
