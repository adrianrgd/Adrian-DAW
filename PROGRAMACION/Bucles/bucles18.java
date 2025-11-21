/*Bucles II -> Diseña un programa que solicite la nota de los alumnos de la asignatura de programación. 
El usuario tiene que introducir -1 para indicar que ya no hay más notas. 
El programa devuelve entonces la media de todas las notas y el número de aprobados (>=5).
Se debe controlar que el usuario introduce números positivos o (-1). 
Si el usuario introduce un número negativo distinto a -1 o un número > 10 el programa informa del dato erróneo y solicita 
una nueva nota hasta que esta sea válida.  
Las notas no válidas no se consideran para el cálculo de la media.*/

import java.util.Scanner;

public class bucles18 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int contadorNotas = 0;
        int sumaNotas = 0;
        int nota = 0;
        final int NOTAIGNORAR = -1;

        do {
            System.out.println("Introduce la nota del alumno: ");
            nota = teclado.nextInt();
            if (nota == NOTAIGNORAR) {
                break;
            }

            if (nota < 0 || nota > 10) {
                System.out.println("Error! La nota no puede ser Negativa ni mayor a 10!");
                continue;
            }
            sumaNotas += nota;
            contadorNotas++;
        } while (nota != NOTAIGNORAR);

        double mediaNotas = (double)sumaNotas / contadorNotas;
        System.out.println("La media de todas las notas es: " + mediaNotas);
        teclado.close();
    }
}
