public class App {
    public static void main(String[] args) {

        Presupuesto p1 = new Presupuesto(1000.0);
        Presupuesto p2 = new Presupuesto(500.0);
        Presupuesto p3 = new Presupuesto(200.0);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println();
        p1.confirmarPresupuesto();
        Factura f1 = p1.getFactura();
        System.out.println(f1);

        p1.cancelarPresupuesto();

        System.out.println();
        p2.cancelarPresupuesto();
        System.out.println(p2);

        p2.confirmarPresupuesto();

        Factura f3 = p3.getFactura();
        System.out.println(f3);
    }
}