
import java.util.Scanner;

/*Un biólogo está realizando un estudio de distintas especies de invertebrados y 
necesita una aplicación que le ayude a contabilizar el número de patas que 
tienen en total todos los animales capturados durante una jornada de 
trabajo. Para ello, te ha solicitado que escribas una aplicación a la que hay 
que proporcionar: 
• El número de hormigas capturadas (6 patas). 
• El número de arañas capturadas (8 patas). 
• El número de cochinillas capturadas (14 patas). 
La aplicación debe mostrar el número total de patas.*/
public class EJ8 {
    public static void main(String[] args) {
        
        //Solicitar el numero de animales capturados
        Scanner teclado = new Scanner(System.in);
        System.out.println("Hormigas capturadas: ");
        int hormigas = teclado.nextInt();
        System.out.println("Arañas capturadas: ");
        int arañas = teclado.nextInt();
        System.out.println("Cochinillas capturadas: ");
        int cochinillas = teclado.nextInt();

        //Calculamos numero total de patas
        int Resultado = ((hormigas * 6) + (arañas * 8) + (cochinillas * 14));
        System.out.println("En total hay " + Resultado + " patas");
    }
}
