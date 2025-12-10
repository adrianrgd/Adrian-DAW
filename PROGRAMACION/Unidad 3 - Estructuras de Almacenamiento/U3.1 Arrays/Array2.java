public class Array2 {
    public static void main(String[] args) {
        arrayNew();
        arrayNotNew();
    }

    public static void arrayNew() {
        int numerosN[] = new int[10];
        numerosN[0] = 33;

        int[] ref1N = numerosN;
        int[] ref2N = numerosN;
        int[] ref3N = numerosN;

        System.err.println("=== Array con new ===");
        System.out.println("Referencia 1: " + ref1N);
        System.out.println("Referencia 1: " + ref2N);
        System.out.println("Referencia 1: " + ref3N);

    }

    public static void arrayNotNew() {
        int numeros[] = {0,1,2,3,4,5,6,7,8,9};

        int[] ref1 = numeros;
        int[] ref2 = numeros;
        int[] ref3 = numeros;

        System.err.println("\n=== Array sin new ===");
        System.out.println("Referencia 1: " + ref1);
        System.out.println("Referencia 1: " + ref2);
        System.out.println("Referencia 1: " + ref3);
    }
}
