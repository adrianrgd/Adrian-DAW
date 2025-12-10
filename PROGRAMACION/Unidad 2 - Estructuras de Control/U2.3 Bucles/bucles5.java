/*Diseña una aplicación que muestre la edad máxima y mínima de un grupo de alumnos. 
El usuario introducirá las edades y terminará escribiendo un −1*/

import java.util.Scanner;

public class bucles5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int edadMax = Integer.MIN_VALUE;
        int edadMin = Integer.MAX_VALUE;
        int edad = 0;

        while (edad != -1) {
            System.out.println("Introduce la edad: ");
            edad = teclado.nextInt();
            if (edad < edadMin && edad != -1) {
                edadMin = edad;
            } else if (edadMax < edad && edad != -1) {
                edadMax = edad;
            }
        }
        
        if (edadMin < -1 || edadMax < -1){
            System.out.println("Introduce edades validas");
        //Usuario termina el programa con un -1.
        } else {
            System.out.println("Edad maxima: " + edadMax);
            System.out.println("Edad Minima: " + edadMin);
        }
        
        teclado.close();
    }    
}
