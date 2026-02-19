public class Ordenador {
    private Componente procesador;
    private Componente ram;
    private Componente disco;
    public Ordenador(String modeloProcesador, String modeloRam, int capacidadRam, String modeloDisco,
            int capacidadDisco) {
        this.procesador = new Componente("Procesador", modeloProcesador, 0);
        this.ram = new Componente("RAM", modeloRam, capacidadRam);
        this.disco = new Componente("Disco Duro", modeloDisco, capacidadDisco);
    }

    public void mostrarComponentes() {
        System.out.println("---- ESPECIFICACIONES DEL ORDENADOR ----");
        System.out.println(procesador);
        System.out.println(ram);
        System.out.println(disco);
        System.out.println("----------------------------------------");
    }
}
