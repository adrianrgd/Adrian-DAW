/*Bucles II -> Diseña un programa que muestre las tablas de multiplicar del 1 al 10. */
public class bucles16 {
    public static void main(String[] args) {
        
        for (int n = 1; n <= 10; n++) {
            System.out.println("Tabla de multiplicar del " + n);
            
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " * " + i + " = " + (n * i));
            }
            
            System.out.println();
        }
    }
}
