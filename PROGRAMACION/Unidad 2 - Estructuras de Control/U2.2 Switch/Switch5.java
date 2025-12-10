
import java.util.Scanner;

/*Escribe un programa que solicite una medida en ‘metros’ y a continuación solicite a  qué  unidad  de  medida  se  quiere convertir.  
Valores  posibles  : km,  cm, mm. Los literales de la medida a convertir no son sensibles a mayúscula/minúscula.  
El programa devuelve el valor convertido. Muestra un mensaje de error si la opción es inválida. Utiliza la estructura switch ‘nueva’*/
public class Switch5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un valor en metros: ");
        double m = teclado.nextDouble();

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("A que medida quiere convetir el dato (km / cm / mm): ");
        String medida = teclado2.nextLine();

        switch (medida.toLowerCase()) {
            case "km" -> {
                double km = m / 1000;
                System.out.println(m + " son " + km + " km");
            }
            case "cm" -> {
                double cm = m * 100;
                System.out.println(m + " son " + cm + " cm");
            }
            case "mm" -> {
                double mm = m * 1000;
                System.out.println(m + " son " + mm + " mm");
            }
            default -> {
                System.out.println("Error! Elije entre km, cm o mm!");
            }
        }
        teclado2.close();
    }
}
