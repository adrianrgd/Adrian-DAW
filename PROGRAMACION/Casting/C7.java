/*Crea un programa que sume un número byte y un número short, usando el casting 
implícito para realizar la operación.*/

public class C7 {
    public static void main(String[] args) {
        
        //valores byte y short
        byte a = 1;
        short b = 4;
        short c = a;

        //Suma
        int suma = (short)b + (short)c;
        System.out.println("Resultado: " + suma);
    }
}
