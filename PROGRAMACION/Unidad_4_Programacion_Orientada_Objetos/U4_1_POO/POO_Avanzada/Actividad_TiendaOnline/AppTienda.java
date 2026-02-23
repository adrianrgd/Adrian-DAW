import java.time.LocalDate;
import java.util.Scanner;
import usuarios.*;
import productos.*;

public class AppTienda {
    private static Producto[] catalogo = new Producto[100];
    private static int numProductos = 0;
    private static Usuario[] usuarios = new Usuario[10];
    private static int numUsuarios = 0;
    private static Scanner sc = new Scanner(System.in);
    private static Usuario usuarioActual = null;

    public static void main(String[] args) {
        precargarDatos();

        System.out.println("=== BIENVENIDO A LA TIENDA ONLINE ===");

        boolean salir = false;
        while (!salir) {
            if (usuarioActual == null) {
                salir = menuLogin();
            } else if (usuarioActual instanceof Cliente) {
                menuCliente();
            } else if (usuarioActual instanceof Empleado) {
                menuEmpleado();
            }
        }
        System.out.println("¡Hasta pronto!");
    }

    private static void precargarDatos() {
        // Usuarios
        usuarios[numUsuarios++] = new Cliente("Adrián", "adri@email.com", "1234", LocalDate.now());
        usuarios[numUsuarios++] = new Empleado("Juan", "juan@admin.com", "admin", LocalDate.now());

        // Productos
        catalogo[numProductos++] = new Alimentacion("P01", "Manzana", 0.5, 50, "Huerta", LocalDate.now().plusDays(7));
        catalogo[numProductos++] = new Ropa("P08", "Pantalones", 15.0, 20, "Nike", "L", "Azul");
        catalogo[numProductos++] = new Electronica("P02", "Teclado", 25.0, 10, "Logitech", 24, "Logitech"); 
        catalogo[numProductos++] = new Electronica("P03", "Teclado", 25.0, 10, "Logitech", 24, "Logitech");
        catalogo[numProductos++] = new Ropa("P04", "Zapatillas", 25.0, 10, "Adidas", "42", "Negro");  
        catalogo[numProductos++] = new Ropa("P05", "Camiseta", 15.0, 20, "ZARA", "L", "Azul");
        catalogo[numProductos++] = new Ropa("P06", "Pantalones", 15.0, 20, "ZARA", "L", "Azul");
        catalogo[numProductos++] = new Ropa("P07", "", 15.0, 20, "Nike", "L", "Azul");
    }

    private static boolean menuLogin() {
        System.out.println("\n--- LOGIN ---");
        System.out.println("1. Entrar como Cliente");
        System.out.println("2. Entrar como Empleado");
        System.out.println("0. Salir");
        System.out.print("Elige: ");
        int opt = Integer.parseInt(sc.nextLine());

        if (opt == 1)
            usuarioActual = usuarios[0];
        else if (opt == 2)
            usuarioActual = usuarios[1];
        else if (opt == 0)
            return true;
        return false;
    }

    private static void menuCliente() {
        Cliente c = (Cliente) usuarioActual;
        System.out.println("\n--- MENÚ CLIENTE (" + c.getClass().getSimpleName() + ") ---");
        System.out.println("1. Ver Catálogo y Añadir");
        System.out.println("2. Ver Carrito / Modificar Cantidad / Eliminar");
        System.out.println("3. Confirmar Compra");
        System.out.println("4. Historial de Compras");
        System.out.println("0. Cerrar Sesión");
        System.out.print("Elige: ");
        int opt = Integer.parseInt(sc.nextLine());

        switch (opt) {
            case 1:
                mostrarCatalogo(true);
                System.out.print("ID Producto (0 para volver): ");
                String id = sc.nextLine();
                if (!id.equals("0")) {
                    Producto p = buscarProducto(id);
                    if (p != null) {
                        c.añadirAlCarrito(p);
                        System.out.println("¡Producto añadido!");
                    }
                }
                break;
            case 2:
                mostrarCarrito(c);
                System.out.println("Acciones: [M]odificar cantidad, [E]liminar, [V]olver");
                String acc = sc.nextLine().toUpperCase();
                if (acc.equals("M")) {
                    System.out.print("Índice (1, 2...): ");
                    int idx = Integer.parseInt(sc.nextLine()) - 1;
                    System.out.print("Nueva cantidad: ");
                    int cant = Integer.parseInt(sc.nextLine());
                    c.modificarCantidad(idx, cant);
                } else if (acc.equals("E")) {
                    System.out.print("Índice (1, 2...): ");
                    int idx = Integer.parseInt(sc.nextLine()) - 1;
                    c.eliminarDelCarrito(idx);
                }
                break;
            case 3:
                try {
                    Compra comp = new Compra(c);
                    comp.confirmarCompra();
                    System.out.println("¡Compra realizada con éxito!");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 4:
                mostrarHistorial(c);
                break;
            case 0:
                usuarioActual = null;
                break;
        }
    }

    private static void menuEmpleado() {
        Empleado e = (Empleado) usuarioActual;
        System.out.println("\n--- MENÚ EMPLEADO ---");
        System.out.println("1. Ver Inventario Completo");
        System.out.println("2. Crear Producto");
        System.out.println("3. Modificar Stock / Precio");
        System.out.println("4. Cambiar Estado (Activar/Desactivar)");
        System.out.println("0. Cerrar Sesión");
        System.out.print("Elige: ");
        int opt = Integer.parseInt(sc.nextLine());

        switch (opt) {
            case 1:
                mostrarCatalogo(false);
                break;
            case 2:
                System.out.println("Tipo: [A]limentacion, [E]lectronica, [R]opa");
                String tipo = sc.nextLine().toUpperCase();
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String nom = sc.nextLine();
                System.out.print("Precio: ");
                double pre = Double.parseDouble(sc.nextLine());
                System.out.print("Stock: ");
                int sto = Integer.parseInt(sc.nextLine());
                System.out.print("Prov: ");
                String pro = sc.nextLine();

                if (tipo.equals("A")) {
                    System.out.print("Días hasta caducar: ");
                    int dias = Integer.parseInt(sc.nextLine());
                    catalogo[numProductos++] = e.crearAlimentacion(id, nom, pre, sto, pro,
                            LocalDate.now().plusDays(dias));
                } else if (tipo.equals("E")) {
                    System.out.print("Meses garantía: ");
                    int mes = Integer.parseInt(sc.nextLine());
                    System.out.print("Marca: ");
                    String mar = sc.nextLine();
                    catalogo[numProductos++] = e.crearElectronica(id, nom, pre, sto, pro, mes, mar);
                } else if (tipo.equals("R")) {
                    System.out.print("Talla: ");
                    String tal = sc.nextLine();
                    System.out.print("Color: ");
                    String col = sc.nextLine();
                    catalogo[numProductos++] = e.crearRopa(id, nom, pre, sto, pro, tal, col);
                }
                System.out.println("Producto creado.");
                break;
            case 3:
                System.out.print("ID Producto: ");
                String pid = sc.nextLine();
                Producto p = buscarProducto(pid);
                if (p != null) {
                    System.out.print("Nuevo Precio (" + p.getPrecio() + "): ");
                    double npre = Double.parseDouble(sc.nextLine());
                    e.modificarProducto(p, p.getNombre(), npre);
                    System.out.print("Nuevo Stock (" + p.getStock() + "): ");
                    int nsto = Integer.parseInt(sc.nextLine());
                    e.modificarStock(p, nsto);
                    System.out.println("Actualizado.");
                }
                break;
            case 4:
                System.out.print("ID Producto: ");
                String id2 = sc.nextLine();
                Producto p2 = buscarProducto(id2);
                if (p2 != null) {
                    e.cambiarEstadoProducto(p2, !p2.isActivo());
                    System.out.println("Estado: " + (p2.isActivo() ? "ACTIVO" : "INACTIVO"));
                }
                break;
            case 0:
                usuarioActual = null;
                break;
        }
    }

    private static void mostrarCatalogo(boolean soloActivos) {
        System.out.println("\n--- PRODUCTOS ---");
        for (int i = 0; i < numProductos; i++) {
            Producto p = catalogo[i];
            if (soloActivos && !p.isActivo())
                continue;
            System.out.println(p.toString()); // Implementar toString en Producto
        }
    }

    private static void mostrarCarrito(Cliente c) {
        System.out.println("\n--- TU CARRITO ---");
        Producto[] car = c.getCarrito();
        int[] cants = c.getCantidades();
        for (int i = 0; i < c.getNumProductosCarrito(); i++) {
            System.out.println((i + 1) + ". " + car[i].getNombre() + " x" + cants[i] + " ("
                    + (car[i].getPrecio() * cants[i]) + "€)");
        }
        System.out.println("------------------");
        System.out.println("TOTAL: " + c.calcularTotalCarrito() + "€");
    }

    private static void mostrarHistorial(Cliente c) {
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");
        System.out.println("Has realizado " + c.getNumCompras() + " compras.");
    }

    private static Producto buscarProducto(String id) {
        for (int i = 0; i < numProductos; i++) {
            if (catalogo[i].getId().equalsIgnoreCase(id))
                return catalogo[i];
        }
        return null;
    }
}
