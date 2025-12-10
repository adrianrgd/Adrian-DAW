/*Crea un programa que tome un número long y lo convierta explícitamente a int. 
Asegúrate de manejar la pérdida de precisión si el número es demasiado grande. */

public class C4 {
    public static void main(String[] args) {
        
        //Conversion de variables
        long a = 15000000000L;
        int b = (int) a;

        //Resultado
        System.out.println("Conversion: " + (int) a);
        
        //Aseguramos que no desborde con un numero muy grande
        try {
            b = (int) a;
        } catch (Exception e) {
            System.out.println("Error en la conversion: " + e.getMessage());
        }
    }
}
