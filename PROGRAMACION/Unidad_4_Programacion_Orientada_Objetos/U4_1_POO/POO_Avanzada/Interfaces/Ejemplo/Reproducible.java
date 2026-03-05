public interface Reproducible {

    // Atributos -> Public, final y static por defecto
    String version = "1.0";

    // Metodos -> Public y abstract por defecto
    void reproducir();

    void pausar();

    void detener();

    // No hay constructor!
}