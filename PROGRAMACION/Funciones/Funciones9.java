public class Funciones9 {
    public static void main(String[] args) {

        int cantidadEnteros = 10;
        int minimo = 1;
        int maximo = 100;

        if (validarCantidad(cantidadEnteros)) {
            System.out.println("🔹 Números enteros aleatorios:");
            mostrarNumerosAleatorios(cantidadEnteros, minimo, maximo);

            System.out.println("\n🔹 Números reales aleatorios:");
            mostrarNumerosAleatorios(cantidadEnteros);
        } else {
            System.out.println("Error: la cantidad debe ser mayor o igual a 0.");
        }
    }

    public static boolean validarCantidad(int cantidad) {
        return cantidad >= 0;
    }

    public static void mostrarNumerosAleatorios(int cantidad, int minimo, int maximo) {
        for (int i = 1; i <= cantidad; i++) {
            int num = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            System.out.println("Número " + i + ": " + num);
        }
    }

    public static void mostrarNumerosAleatorios(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            double num = Math.random();
            System.out.printf("Número %.0f: %.4f%n", (double)i, num);
        }
    }
}
