import java.util.Scanner;

/*Modifica el programa anterior para que, además de los dos números aleatorios, también se proponga la operación que debe 
realizar el jugador: “suma”, “resta” o “multiplicación”.*/
public class CondicionalesII3 {
    public static void main(String[] args) {
        
        //Operacion para los 2 numeros aleatorios
        int n1 = (int) (Math.random() * 101);
        int n2 = (int) (Math.random() * 101);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el tipo de operacion que quieres realizar: ");
        String Operacion = teclado.nextLine();

        switch (Operacion) {
            case "Suma": 
                System.out.println("¿Cual es el resultado de esta suma? " + n1 + " + " + n2 + " : ");
                int ns = teclado.nextInt();

                if (n1 + n2 == ns) {
                    System.out.println("Es correcta la suma!");
                } else {
                    System.out.println("No es correcta!");
                }
                break;
            case "Multiplicacion":
                System.out.println("¿Cual es el resultado de esta multiplicacion? " + n1 + " * " + n2 + " : ");
                double nm = teclado.nextInt();

                if (n1 * n2 == nm) {
                    System.out.println("Es correcta la multiplicacion!");
                } else {
                    System.out.println("No es correcta!");
                }
                break;
            case "Division":
                System.out.println("¿Cual es el resultado de esta division? " + n1 + " / " + n2 + " : ");
                double nd = teclado.nextDouble();

                if (n1 / n2 == nd) {
                    System.out.println("Es correcta la division!");
                } else {
                    System.out.println("No es correcta!");
                }
                break;
        }
    }
}