import java.util.Scanner;

/*Escribe un programa que transforme la calificación que indica el usuario por teclado a 
calificación cualitativa teniendo en cuenta esta tabla de correspondencia: */
public class OT8{
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu nota: ");
        int nota = teclado.nextInt();
        String resultado;

        resultado = (nota >= 9 && nota == 10) ? "A" :
            (nota >= 8) ? "B" :
            (nota >= 7) ? "C" :
            (nota >= 6) ? "D" : "F";

        System.out.println(resultado);
    }
}
