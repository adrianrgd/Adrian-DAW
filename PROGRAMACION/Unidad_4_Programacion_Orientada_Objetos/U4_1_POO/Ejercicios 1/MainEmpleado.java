//Ejercicio 8 POO_1

class Empleado {
    String nombre;
    double sueldo;
    String puesto;

    public Empleado(String nombre, double sueldo, String puesto) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " | Puesto: " + puesto + " | Sueldo: " + sueldo);
    }

    public void aumentarSueldo(double porcentaje) {
        double aumento = sueldo * (porcentaje / 100);
        sueldo += aumento;
        System.out.println("Sueldo aumentado en un " + porcentaje + "%");
    }
}

public class MainEmpleado {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Ana López", 2000, "Desarrolladora");
        emp.mostrarInformacion();
        
        emp.aumentarSueldo(10);
        
        emp.mostrarInformacion();
    }
}