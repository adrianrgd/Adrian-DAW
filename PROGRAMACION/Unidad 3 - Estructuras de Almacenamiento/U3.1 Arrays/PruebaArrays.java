import java.util.Arrays;

public class PruebaArrays {
    public static void main(String[] args) {

        //Declaracion de la variable que referenciará al array y lo crea.
        int [] edad = {12, 56, 8, 23};

        //Declara otra variable para el mismo array.
        int nuevaEdad[];

        System.out.println("Valor 0: " + edad[0]);
        System.out.println("Valor 1: " + edad[1]);
        edad[0] = 32;//Asignar valor cambia el original.
        System.out.println("Valor 0 Modificado: " + edad[0]);

        nuevaEdad = edad;//Dos variables referencian al mismo array (Edad). 
        nuevaEdad[1] = 88;
        System.out.println("\nValor 1 nuevaEdad: " + nuevaEdad[1]);
        System.out.println("Valor 1 edad Modificado: " + edad[1]);
        System.out.println("Longitud del array: " + edad.length);
        System.out.println("Lista de datos de edad: " + Arrays.toString(edad));

        //declarando array con NEW INT
        int numeros[] = new int[3];
        System.out.println("\nArray vacio: " + Arrays.toString(numeros));//Inicializado con valores a 0.

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i+1;//llenamos el array con un bucle (1,2,3).
        }

        System.out.println("Array lleno: " + Arrays.toString(numeros));
    }
}