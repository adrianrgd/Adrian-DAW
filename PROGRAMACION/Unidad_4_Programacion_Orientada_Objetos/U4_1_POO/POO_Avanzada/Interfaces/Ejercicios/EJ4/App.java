package Ejercicios.EJ4;

public class App {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        Operacion suma = new Suma();
        Operacion multiplicacion = new Multiplicacion();

        System.out.println("La suma de " + a + " y " + b + " es " + suma.calcular(a, b));
        System.out.println("La multiplicación de " + a + " y " + b + " es " + multiplicacion.calcular(a, b));
    }
}
