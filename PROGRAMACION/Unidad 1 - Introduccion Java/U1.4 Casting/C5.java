/*Escribe un programa que tome un carácter (por ejemplo, 'A') y lo convierta a su valor 
numérico ASCII mediante casting. Luego, convierte ese valor numérico nuevamente al 
carácter correspondiente.*/

public class C5 {
    public static void main(String[] args) {
        
        //Convertirmos las variables
        char x = 'A'; //Caracter a ASCII
        int y = x;
        char z = x; //ASCII a caracter de nuevo

        //Resultado
        System.out.println("Conversion a ASCII: " + (int) y + " Conversion a Char: " + (char) z);
    }
}
