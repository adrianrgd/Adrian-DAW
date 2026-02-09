//EJERCICIO 2

public class appVehiculo {
    public static void main(String[] args) {
        vehiculo vehiculo1 = new vehiculo("Toyota", "Corolla");
        coche coche1 = new coche("Toyota", "Corolla", 4);
        moto moto1 = new moto("Honda", "CBR", 600);

        System.out.println(vehiculo1);
        System.out.println(coche1);
        System.out.println(moto1);

        System.out.println();
        vehiculo1.arrancar();
        vehiculo1.acelerar();
        coche1.acelerar();
        moto1.acelerar();
    }
}
