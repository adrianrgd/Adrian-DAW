
import java.util.Scanner;

/*Desarrolla un programa para uso en la caja de una pizzería, y que 
calcula el total de los pedidos, teniendo en cuenta que cada pizza 
cuesta 9€.*/
public class Condicionales1 {
   public static void main(String[] args) {
       
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cuantas pizzas quiere: ");//Preguntar el numero de pizzas
        int pizzas = teclado.nextInt();

        System.out.println("¿Eres socio? (True/False): ");//Si es socio se aplicara un descuento
        boolean socio = teclado.nextBoolean();

        //total pedido
        int precio = 9;
        int resultado = (pizzas * precio);
        System.out.println("Precio total: " + resultado);

        if (socio) {
            int descuento = 3;
            int descuentototal = (resultado - descuento);
            System.out.println("Precio descuento por ser socio: " + descuentototal);
        }
        teclado.close();
   } 
}
