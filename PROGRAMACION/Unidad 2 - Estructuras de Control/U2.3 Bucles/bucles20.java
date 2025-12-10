/*Bucles II -> Implementa una aplicación para calcular datos estadísticos de las edades de los alumnos de un centro educativo. 
Se introducirán edades hasta que una de ellas  sea  negativa. El programa mostrará: 
La suma de todas  las  edades introducidas, la media, el número de alumnos y cuántos son mayores de edad. */

import java.util.Scanner;

public class bucles20 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int edadAlumno = 0;
        int contadorAlumnos = 0;
        int contadorAlumnosMayores = 0;
        int sumaEdades = 0;
        final int VALORSALIDA = -1;

        do {
            System.out.println("Introduce la edad del alumno: ");
            edadAlumno = teclado.nextInt();

            if (edadAlumno == VALORSALIDA) {
                System.out.println("FIN DEL PROGRAMA!");
                break;
            }
            if (edadAlumno <= 0 || edadAlumno >= 100) {
                System.out.println("Error! Introduce una edad valida!");
                continue;
            }
            contadorAlumnos++;
            sumaEdades += edadAlumno;

            if (edadAlumno >= 18) {
                contadorAlumnosMayores++;
            }

        } while (edadAlumno != VALORSALIDA);

        double mediaEdades = (double) sumaEdades / contadorAlumnos;
        System.out.println("Suma de todas las edades: " + sumaEdades);
        System.out.println("La media de edad es: " + mediaEdades);
        System.out.println("Hay " + contadorAlumnos + " alumnos.");
        System.out.println("Hay " + contadorAlumnosMayores + " alumnos mayores de edad.");

        teclado.close();
    }
}
