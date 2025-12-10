/*Diseña  un  programa  que  imprima  los  números  del  1  al  100  exceptuando  los múltiplos de 3.*/

public class bucles7 {
    public static void main(String[] args) {
        
        for (int a = 1; a <= 100; a++) {
            if (a % 3 != 0) {
                System.out.println(a);
            }
        }
    }
}
