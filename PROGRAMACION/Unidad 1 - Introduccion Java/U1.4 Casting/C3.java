/*Crea un programa que sume un número entero (int) y un número flotante (float). Usa el 
casting implícito para que el entero se convierta automáticamente a float. */

public class C3 {
    public static void main(String[] args) {
        
        //Conversion a float
        int a = 4;
        float b = a;
        float c = 12;
        
        //Suma de las variables y resultado
        float suma = b + c;
        System.out.println("Conversion: " + (float)b + "Resultado: " + suma);
    }
}
