
import java.util.Scanner;

/*En una granja se compra diariamente una cantidad (comidaDiaria) de comida para los animales. El número de animales que 
alimentar (todos de la misma especie) es numAnimales, y sabemos que cada animal come una media de kilosPorAnimal. 
Diseña un programa que solicite al usuario los valores anteriores y determine si disponemos de alimento suficiente para cada animal. 
En caso negativo, ha de calcular cuál es la ración que corresponde a cada uno de los animales. 
Nota:  Evitar que la aplicación realice divisiones por cero.*/
public class CondicionalesII4 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cantidad de comida comprada: ");
        int comidaDiaria = teclado.nextInt();

        System.out.println("Numero de animales: ");
        int numAnimales = teclado.nextInt();

        System.out.println("Kilos por animal: ");
        double KilosAnimal = teclado.nextInt();
        
        if (numAnimales <= 0) {
            System.out.println("Error; El numero de animales no puede ser 0 o negativo!");
        } else {
        double comidaNecesaria = (numAnimales * KilosAnimal);

            if (comidaDiaria >= comidaNecesaria) {
                System.out.println("Hay suficiente comida para todos los animales.");
            } else {
                double racionAnimal = comidaDiaria / numAnimales;
                System.out.println("No hay suficiente comida.");
                System.out.printf("Cada animal recibirá %.2f kg de comida.%n", racionAnimal);
            }
        }
    }
}
