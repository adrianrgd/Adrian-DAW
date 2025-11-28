public class Array8 {
    public static void main(String[] args) {
        int longitud = 10;
        int fin = 100;
        rellenaPares(longitud, fin);
    }

    public static void rellenaPares(int longitud, int fin) {
        int array[] = new int[longitud];

        for (int i = 0; i < array.length; i++) {
            int numRandom = (int) (Math.random() * (fin/2));
            int resultado = numRandom * 2;
            array[i] = resultado;
        }

        System.out.println("=== Números guardados en el Array ===");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición [" + i + "]: " + array[i]);
        }
    }
}
