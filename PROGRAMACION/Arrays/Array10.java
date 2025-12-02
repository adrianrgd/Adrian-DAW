
import java.util.Scanner;

public class Array10 {
    public static void main(String[] args) {
        int mes = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el mes: ");
        mes = teclado.nextInt();
        mes = mes - 1;
        teclado.close();

        int dias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        arrayDias(mes, dias, meses);
    }   

    public static void arrayDias(int mes, int dias[], String meses[]) {
        for (int i : dias) {
            i = dias[mes];
        }
        System.out.println("El mes " + (mes + 1) + ", que es " + meses[mes] + " tiene " + dias[mes] + " dias.");
    }
}
