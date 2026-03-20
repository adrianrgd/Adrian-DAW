public class Contenedor<T> {

    private T valor;

    public void setValor(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public static void main(String[] args) {

        // Con la creacion del objeto se concreta el tipo de dato que va a almacenar.
        Contenedor<String> contenedorTexto = new Contenedor<>();
        contenedorTexto.setValor("Hola");
        System.out.println("Texto: " + contenedorTexto.getValor());

        Contenedor<Integer> contenedorInteger = new Contenedor<>();
        contenedorInteger.setValor(10);
        System.out.println("Numero: " + contenedorInteger.getValor());
    }
}
