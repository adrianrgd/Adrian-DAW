import java.util.Scanner;

public class CargarValoresArray {
    public static void main(String[] args) {

        /*
        System.out.println("¿Cuantos quieres guapo??: ");
        int longitud = teclado.nextInt(); 
        
        Si se quiere pedir el numero de variables que tendra el array al usuario se usa esto.*/

        int longitud = 4; //Longitud no es necesario, se puede poner directamente en el int[longitud], cambiado a un numero.
        int array[] = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce el numero " + (i + 1) + ": ");
            int num = teclado.nextInt();
        }
    }
}

//COPY Y PASTE
//Sirve para cargar valores en un array.
//Sirve en todo.