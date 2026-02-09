import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMaquina {

    // STOCK DISPONIBLE (DEPÓSITO)
    private static Ingrediente agua = new Ingrediente(new Peso(4000, "ml"), "Agua");
    private static Ingrediente leche = new Ingrediente(new Peso(1000, "g"), "Leche");
    private static Ingrediente cafe = new Ingrediente(new Peso(1000, "g"), "Café");
    private static Ingrediente cacao = new Ingrediente(new Peso(1000, "g"), "Cacao");
    private static Ingrediente te = new Ingrediente(new Peso(1000, "g"), "Té");
    private static Ingrediente azucar = new Ingrediente(new Peso(1000, "g"), "Azúcar");
    private static Ingrediente[] ingredientes = {agua,leche,cafe,cacao,te,azucar};

    private static Utensilio vaso = new Utensilio(200, "Vaso");
    private static Utensilio cuchara = new Utensilio(100, "Cuchara");
    private static Utensilio[] utensilios = {vaso,cuchara};

    // Bebidas
    private static Bebida cafeExpresso = new Bebida("Café Expresso", new float[]{7, 35}, new Ingrediente[]{cafe, agua}, new Utensilio[]{vaso,cuchara}, new int[]{1,1}, 1);
    private static Bebida cafeLargo = new Bebida("Café Largo", new float[]{10, 50}, new Ingrediente[]{cafe, agua}, new Utensilio[]{vaso,cuchara}, new int[]{1,1}, 1.2F);
    private static Bebida cafeConLeche = new Bebida("Café con Leche", new float[]{8,12,100}, new Ingrediente[]{cafe, leche, agua}, new Utensilio[]{vaso,cuchara}, new int[]{1,1}, 1.5F);
    private static Bebida teBebida = new Bebida("Te", new float[]{10,120}, new Ingrediente[]{te,agua}, new Utensilio[]{vaso,cuchara}, new int[]{1,1}, 1.1F);
    private static Bebida chocolate = new Bebida("Chocolate", new float[]{20,150}, new Ingrediente[]{cacao,agua}, new Utensilio[]{vaso,cuchara}, new int[]{1,1}, 1.5F);
    private static Bebida[] bebidas = {cafeExpresso,cafeLargo,cafeConLeche,teBebida,chocolate};

    private static final Scanner sc = new Scanner(System.in);

    //Metodo para obtener los ingredientes y utensilios.
    private static void obtenerBebidas() {
        for (Ingrediente ingrediente : ingredientes) { //Recorre el array de ingredientes.
            System.out.println("Ingrediente: " + ingrediente.getNombre() + " - Stock: " + ingrediente.getInventario().getCantidad() + ingrediente.getInventario().getMedida());
        }
        for (Utensilio utensilio : utensilios) { //Recorre el array de utensilios.
            System.out.println("Utensilio: " + utensilio.getNombre() + " - Stock: " + utensilio.getStock());
        }
    }

    //Metodo para mostrar el menu.
    public static void mostarMenu() {
        System.out.print("\nMÁQUINA BEBIDAS -> GESTOR\n1. Recargar Ingredientes\n2. Recargar Utensilios\n3. Consultar estado de depositos y utensilios\n4. Seleccionar Bebida\n5. Cerrar\n");
        System.out.print("-> ");
    }

    // Metodo inicial que crea un bucle donde el usuario debe seleccionar una opcion del menu.
    public static void iniciar() {
        boolean bucle = true; //Bucle se ejecuta hasta que el usuario elija la opcion 5 (Salir).
        while (bucle) {
            try { //Try catch para controlar excepciones.
                mostarMenu();
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        recargarIngredientes(4000,1000,1000,1000,1000,1000);
                        break;
                    case 2:
                        recargarUtensilios(200, 100);
                        break;
                    case 3:
                        obtenerBebidas();
                        break;
                    case 4:
                        elegirBebida();
                        break;
                    case 5:
                        bucle = false; //Salir del bucle.
                        break;
                    default:
                        System.out.println("Selecciona una opción correcta."); //Si el usuario introduce una opcion no valida.
                }
            } catch (Exception e) { //Por si el usuario introduce un valor no valido.
                System.out.println("Error al detectar input: " + e);
                sc.nextLine(); //Devuelve el menu en la siguiente iteracion.
            }

        }
    }

    // Metodo para recargar todos los ingredientes a su maxima capacidad.
    private static void recargarIngredientes(float cantidadAgua, float cantidadLeche, float cantidadCafe, float cantidadCacao, float cantidadTe, float cantidadAzucar) {
        agua.getInventario().setCantidad(cantidadAgua); //Llama al metodo setCantidad de la clase Inventario.
        leche.getInventario().setCantidad(cantidadLeche); 
        cafe.getInventario().setCantidad(cantidadCafe);
        cacao.getInventario().setCantidad(cantidadCacao);
        te.getInventario().setCantidad(cantidadTe);
        azucar.getInventario().setCantidad(cantidadAzucar);
        System.out.println("Ingredientes recargados al maximo.");
    }

    // Metodo para recargar todos los utensilios a su maxima capacidad.
    private static void recargarUtensilios(int stockVaso, int stockCuchara) {
        vaso.setStock(stockVaso); //Llama al metodo setStock de la clase Utensilio.
        cuchara.setStock(stockCuchara);
        System.out.println("Utensilios recargados al maximo.");
    }

    //Metodo para preparar una bebida.
    private static void prepararBebida(int eleccion) {
        boolean checkItemsCantidad = false; // Variable para controlar si hay ingredientes suficientes.
        for (int i = 0; i < bebidas[eleccion].getIngredientes().length; i++) {
            if (bebidas[eleccion].getGastosIngredientes()[i] > bebidas[eleccion].getIngredientes()[i].getInventario().getCantidad()) {
                checkItemsCantidad = true;
            }
        }
        for (int i = 0; i < bebidas[eleccion].getUtensilios().length; i++) { //Recorre el array de utensilios.
            if (bebidas[eleccion].getGastosUtensilios()[i] > bebidas[eleccion].getUtensilios()[i].getStock()) {
                checkItemsCantidad = true; 
            }
        }
        if (checkItemsCantidad) { // Si no hay ingredientes suficientes, se muestra un mensaje de error.
            System.out.println("No se puede preparar el café. Hay un problema con el stock.");
        } else {
            //Recorre el array de ingredientes.
            for (int i = 0; i < bebidas[eleccion].getIngredientes().length; i++) { 
                bebidas[eleccion].getIngredientes()[i].gastarIngrediente(bebidas[eleccion].getGastosIngredientes()[i]);
            }
            //Recorre el array de utensilios.
            for (int i = 0; i < bebidas[eleccion].getUtensilios().length; i++) {
                bebidas[eleccion].getUtensilios()[i].gastarUtensilios(bebidas[eleccion].getGastosUtensilios()[i]);
            }
            //Se suma 1 a la cantidad total de bebidas preparadas.
            Bebida.setCantidadTotalBebidas(Bebida.getCantidadTotalBebidas() + 1);
            System.out.println(bebidas[eleccion].getNombre() + " preparado. Has pedido " + Bebida.getCantidadTotalBebidas() + " bebidas. Muchas gracias!");
        }
    }

    //Metodo para elegir una bebida.
    private static void elegirBebida() {
        System.out.println("Selecciona una bebida:");
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println(i+1 + ". " + bebidas[i].getNombre());
        }
        System.out.print("-> ");
        try {
            int eleccion = sc.nextInt() - 1;
            try { // Si se elige una bebida que no existe, se muestra un mensaje de error.
                prepararBebida(eleccion);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Elije una opción correcta.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Elije una opción numérica");
            sc.nextLine();
        }
    }

    static void main() {
        iniciar();
    }
}
