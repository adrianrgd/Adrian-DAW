import java.util.Scanner;

public class Funciones3 {
    public static void main(String[] args) {

        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce el total de la factura: ");
            double Factura = teclado.nextDouble();

            System.out.println("Tipo de impuesto (D para descuento, I para añadir): ");
            char Tipo = teclado.next().charAt(0);

            if (Tipo == 'I' || Tipo == 'i') {
                System.out.println("Introduce el impuesto (%) a aplicar: ");
                double porcentaje = teclado.nextDouble();
            } else if (Tipo == 'D' || Tipo == 'd') {
                System.out.println("Introduce el descuento (%) a aplicar: ");
                double porcentaje = teclado.nextDouble();
            }

            System.out.println("El valor total de la factura es: " + calcularTotal(Factura, Factura, Tipo));
        }
    }

    public static double calcularTotal(double Factura, double porcentaje, char Tipo) {

        switch (Tipo) {
            case 'I', 'i' -> {
                double resultado;
                resultado = Factura + (Factura * porcentaje / 100);
                return resultado;
            }
            case 'D', 'd' -> {
                double resultadoDesc;
                resultadoDesc = Factura - (Factura * porcentaje / 100);
                return resultadoDesc;
            }
            default -> {
                System.out.println("Los datos para el calculo no son correctos.");
                return -999;
            }
        }
    }
}
