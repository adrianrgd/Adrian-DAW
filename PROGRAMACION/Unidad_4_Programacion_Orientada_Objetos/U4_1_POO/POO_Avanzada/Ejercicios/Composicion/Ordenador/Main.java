//Ejericicio 6
public class Main {
    public static void main(String[] args) {
        System.out.println("Creando un Ordenador con Composición...");
        Ordenador miPC = new Ordenador("Intel Core i7", "Corsair Vengeance", 16, "Samsung EVO 970", 1000);

        miPC.mostrarComponentes();
    }
}
