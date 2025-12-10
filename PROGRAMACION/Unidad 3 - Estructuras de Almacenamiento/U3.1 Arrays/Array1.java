public class Array1 {
    public static void main(String[] args) {
        arrayNew();
        arrayNotNew();
    }

    public static void arrayNew() {

        int numerosN[] = new int[5];
        double decimalesN[] = new double[5];
        boolean booleanoN[] = new boolean[5];
        
        System.err.println("=== Array con new ===");
        System.out.println("Numeros: " + numerosN);
        System.out.println("Decimales: " + decimalesN);
        System.out.println("Booleanos: " + booleanoN);
    }
 
    public static void arrayNotNew() {

        int numeros[] = {0,1,2,3,4};
        double decimales[] = {0.5,1.5,2.5,3.5,4.5};
        boolean booleano[] = {true,false,true,false,true};
        
        System.err.println("\n=== Array con new ===");
        System.out.println("Numeros: " + numeros);
        System.out.println("Decimales: " + decimales);
        System.out.println("Booleanos: " + booleano);
    }
}



