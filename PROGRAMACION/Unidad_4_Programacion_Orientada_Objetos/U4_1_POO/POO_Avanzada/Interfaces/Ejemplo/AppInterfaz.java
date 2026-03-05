public class AppInterfaz {
    public static void main(String[] args) {

        ReproductorMP3 reproductor = new ReproductorMP3();

        reproductor.reproducir();
        reproductor.pausar();
        reproductor.detener();
        reproductor.cargar();

        System.out.println(Reproducible.version);
    }
}