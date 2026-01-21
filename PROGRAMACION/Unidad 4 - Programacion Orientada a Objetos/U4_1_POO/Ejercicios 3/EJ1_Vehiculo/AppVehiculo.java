public class AppVehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("1234 ABC", "Toyota", 10000);
        Vehiculo vehiculo2 = new Vehiculo("5678 DEF", "Honda", 20000);

        vehiculo1.registrarKilometros(500);
        vehiculo1.mostrarInformacionVehiculo();

        vehiculo2.registrarKilometros(250);
        vehiculo2.mostrarInformacionVehiculo();
    }
}