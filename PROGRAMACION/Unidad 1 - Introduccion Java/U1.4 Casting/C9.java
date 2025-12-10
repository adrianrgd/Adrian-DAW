/*Crea un programa que tome un número double y lo convierta explícitamente a long, 
observando el truncamiento de la parte decimal.*/

public class C9 {
    public static void main(String[] args) {
        
        //Convertir double en long
        double a = 534.264;
        long b = (long)a;

        //Resultado
        System.out.println("Conversion: " + (long)a);
    }
}
