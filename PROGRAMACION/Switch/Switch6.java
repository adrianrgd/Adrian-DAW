
import java.util.Scanner;

public class Switch6 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Destinos posibles: \n(MAD) - Madrid \n(PML) - Palma \n(VLC) - Valencia \n(ZGZ) - Zaragoza");
            System.out.println("Elije un destino: ");
            String destino = teclado.nextLine();
            
            switch (destino.toUpperCase()) {
                case "MAD" -> {
                    int MAD = 120;
                    System.out.println("Has elejido Madrid! Precio: " + MAD + " EUR.");
                }
                case "PML" -> {
                    try (Scanner PMLScanner = new Scanner(System.in)) {
                        System.out.println("Eres residente en las Islas Baleares?: ");
                        String Descuento = PMLScanner.nextLine();
                        if (Descuento.equalsIgnoreCase("Si")) {
                            double DESC = (240 * 0.75);
                            double PMLDESC = (240 - DESC);
                            System.out.println("Has elejido PALMA! Precio con Descuento de Residencia: " + PMLDESC + " EUR.");
                        } else {
                            int PML = 240;
                            System.out.println("Has elejido PALMA! Precio: " + PML + " EUR.");
                        }
                    }
                }

                case "VLC" -> {
                    int VLC = 85;
                    System.out.println("Has elejido Valencia! Precio: " + VLC + " EUR.");
                }
                case "ZGZ" -> {
                    int ZGZ = 160;
                    System.out.println("Has elejido Zaragoza! Precio: " + ZGZ + " EUR.");
                }
                default -> System.out.println("Destino No Encontrado!");
            }
        }
    }
}
