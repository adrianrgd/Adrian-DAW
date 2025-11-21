import java.util.Scanner;

public class Funciones2 {
    public static double calcularTotal(double Factura, double IVA) {
        double resultado;
        resultado = Factura*IVA/100;
        return resultado+Factura;
    }
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce el total de la factura: ");
            double Factura = teclado.nextDouble();
            
            System.out.println("Introduce el impuesto (%) a aplicar: ");
            double IVA = teclado.nextDouble();
            
            System.out.println("El valor total de la factura es: " + calcularTotal(Factura, IVA));
        }
    }
}
