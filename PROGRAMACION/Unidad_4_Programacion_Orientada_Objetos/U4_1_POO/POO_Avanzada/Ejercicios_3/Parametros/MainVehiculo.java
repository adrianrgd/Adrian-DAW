public class MainVehiculo {
    public static void probarVehiculo(Vehiculo v) {
        v.arrancar();
        v.abrirMaletero();
    }

    Coche c = new Coche();
    probarVehiculo(c);
}

/*¿Porque el metodo recibe un coche pero solo permite metodos de vehiculo? 
Por declarar la variable de tipo Vehiculo hace que falle la compilacion al intentar acceder a metodos que no 
estan definidos en la clase Vehiculo*/

/*¿Que ventaja aporta este tipo de diseño? 
Permite que el metodo sea mas generico y pueda recibir cualquier tipo de objeto que herede de Vehiculo*/