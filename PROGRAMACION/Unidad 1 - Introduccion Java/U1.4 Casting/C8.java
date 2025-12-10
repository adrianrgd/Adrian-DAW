/*Crea un programa que multiplique un número int y un double, mostrando cómo el int 
se convierte implícitamente a double durante la operación.*/

public class C8 {
    public static void main(String[] args) {
        
        //Variables y conversion de int a double
        int a = 43;
        double b = 13.2;
        double c = a;

        //multiplicacion de variables
        System.out.println("Resultado: " + b * a);
    }
}