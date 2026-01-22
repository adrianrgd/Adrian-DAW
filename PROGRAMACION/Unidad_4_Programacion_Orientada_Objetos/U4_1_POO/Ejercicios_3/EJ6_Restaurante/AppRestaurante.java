package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ6_Restaurante;

public class AppRestaurante {
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1, 2);
        Mesa mesa2 = new Mesa(2, 7);

        Plato plato1 = new Plato("Penne", 23.55);
        Plato plato2 = new Plato("Pizza", 8.99);

        Cliente cliente1 = new Cliente("Pablo Motos", "123456789A");
        Cliente cliente2 = new Cliente("Jordi Wild", "987654321B");

        cliente1.asignarMesa(mesa1);
        cliente2.asignarMesa(mesa1); // Comprobar el fallo correctamente
        cliente2.asignarMesa(mesa2);

        System.out.println();

        Orden orden1 = new Orden(cliente1, mesa1, plato1);
        orden1.calcularCosteTotal();

        System.out.println();

        Orden orden2 = new Orden(cliente2, mesa2, plato2);
        orden2.calcularCosteTotal();
    }
}
