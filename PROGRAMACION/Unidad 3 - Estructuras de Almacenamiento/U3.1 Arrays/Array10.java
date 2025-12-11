
import java.util.Scanner;

public class Array10 {
    public static void main(String[] args) {
        int mes = 0;
        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce el mes: ");
            mes = teclado.nextInt();
            mes = mes - 1;

            if (mes <= 0) {
                System.out.println("Mes invalido!! No existen meses negativos o  un mes 0.");
            } 

            if (mes > 12) {
                System.out.println("Mes invalido!! No existen más de 12 meses.");
            }

        } while (mes <= 0 || mes > 12);

        int dias[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre" };
        arrayDias(mes, dias, meses);
        meses[0] = "hola";
    }

    public static String arrayDias(int mes, int dias[], String meses[]) {
        for (int i = 0; i < 12; i++) {
            i = dias[mes];
        }
        String resultado = "Hola";
        System.out.println("El mes " + (mes + 1) + ", que es " + meses[mes] + " tiene " + dias[mes] + " dias.");
        return resultado;
    }
}
