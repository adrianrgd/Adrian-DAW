import java.util.Scanner;

/*Con el siguiente código se pretende solicitar al usuario un número entero 
para imprimirlo posteriormente por pantalla. Corrige el código y comenta las 
correcciones realizadas.
public class Prueba{   
public static void main(String() args){  
Scanner miEscaner = new Scanner(System.in);  
System.out.println("Introduce un número entero");     
numEntradaInt = miEscaner.nextInt();  
System.out.println("El número entero introducido es: "+numEntradaInt); 
} 
}*/
public class Repaso5 {
    public static void main(String[] args) {//cambiado el String() por String[]
         
        Scanner miEscaner = new Scanner(System.in);  
        System.out.println("Introduce un número entero: ");    
        int numEntrada = miEscaner.nextInt();//numEntradaInt cambiado por int numEntrada, es un error de sintaxis, primero va el tipo int.
        System.out.println("El número entero introducido es: "+ numEntrada);//cambiado numEntradaInt por el nombre del tipo int.
    }
}


