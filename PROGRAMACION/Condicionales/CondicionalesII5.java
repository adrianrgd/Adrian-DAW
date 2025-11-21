
import java.util.Scanner;

/*Crea una aplicación que solicite al usuario cuántos grados tiene un ángulo y muestre el equivalente en radianes. 
- Si el ángulo introducido por el usuario no se encuentra en el rango de 0° a 360°, hay que transformarlo a dicho rango. 
Utiliza el operador módulo para convertir un ángulo (> 360) a su equivalente en el rango comprendido de 0° a 360°
- Para convertir de grados a radianes ten en cuenta esta relación: radianes = grados * PI/180*/
public class CondicionalesII5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el angulo en grados: ");
        int grados = teclado.nextInt();
        
        double radianes = (grados * (3.14 / 180));
        
        if (grados > 360) {
            int gradosAjustado = grados % 360;
            System.out.println("Angulo fuera de rango! Angulo ajustado a: " + gradosAjustado + "°" );
            double radianesAjustados = (gradosAjustado * (3.14 / 180));
            System.out.println(radianesAjustados + " radianes.");
        } else if (grados < 0 && grados > -360) {
            int gradosNegativos = grados += 360;
            System.out.println("Angulo negativo! Angulo ajustado: " + gradosNegativos + "°");
            double radianesNegativos = (gradosNegativos * (3.14 / 180));
            System.out.println(radianesNegativos + " radianes.");
        } else if (grados < -360) {
            System.out.println("Error!");
        } else {
            System.out.println(radianes + " radianes.");
        }
    }
}