public class ReproductorMP3 implements Reproducible, Cargable {

    //Metodos de Reproducible
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo MP3...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando MP3...");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo MP3...");
    }

    //Metodos de Cargable
    @Override
    public void cargar() {
        System.out.println("Cargando MP3...");
    }
}