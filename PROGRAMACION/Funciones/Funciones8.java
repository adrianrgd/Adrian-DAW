public class Funciones8 {

    public static void main(String[] args) {

        int cantidad = 10;
        int minimo = 1;
        int maximo = 100;

        if (validarCantidad(cantidad)) {
            mostrarNumerosAleatorios(cantidad, minimo, maximo);
        } else {
            System.out.println("Error: la cantidad debe ser mayor o igual a 0.");
        }
    }

    public static boolean validarCantidad(int cantidad) {
        return cantidad >= 0;
    }

    public static void mostrarNumerosAleatorios(int cantidad, int minimo, int maximo) {
        for (int i = 1; i <= cantidad; i++) {
            int num = (int)(Math.random() * (maximo - minimo + 1)) + minimo;
            System.out.println("Número " + i + ": " + num);
        }
    }
}