import java.util.Scanner;

/* Escribe un programa que solicite el color del cinturón de un judoka. Si el color 
introducido es ‘blanco’ o ‘amarillo’ el programa imprime “Nivel iniciación” en otro caso 
imprime “Nivel Avanzado” */
public class OT11y12 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el color del cinturon: ");
        String color = teclado.next();
        String resultado;

        resultado = (color.equalsIgnoreCase("blanco") || color.equalsIgnoreCase("amarillo")) ? "Nivel Iniciacion" : "Nivel Avanzado";
        System.out.println(resultado);
    }
}
