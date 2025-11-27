import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cuantas quieres guapo??");
        int longitud = teclado.nextInt();

        int guardarNumPositvos[] = new int[longitud];
        int guardarNumNegativos[] = new int[longitud];
        int guardarNumCero[] = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.println("Introduce el numero " + (i + 1) + ": ");
            int num = teclado.nextInt();
            guardarNumPositvos[i] = num;
            guardarNumNegativos[i] = num;
            guardarNumCero[i] = num;
        }

        int mediaPositivos = 0;
        int mediaNegativos = 0;
        int mediaCeros = 0;
        //calcular medias de cuantas veces hay de cada uno

    }
}
