import java.util.Scanner;

public class Array9 {
    public static void main(String[] args) {
        int t[] = {0,1,2,3,4,5,6,7,8,9};
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el valor a buscar: ");
        int clave = teclado.nextInt();
        teclado.close();
        buscar(t, clave);
    }

    public static int buscar(int t[], int clave) {
        int posicion = 0;
        while (posicion < t.length && t[posicion] != clave) {
            posicion++;
        }
        
        if (posicion < t.length) {
            System.out.println("El valor " + clave + " se encuentra en la posicion " + posicion);
        } else {
            System.out.println("No se encontro el valor.");
        }
        return posicion;
    }
}
