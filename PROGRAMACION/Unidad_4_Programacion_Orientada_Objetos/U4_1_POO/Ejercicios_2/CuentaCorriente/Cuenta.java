package CuentaCorriente;

public class Cuenta {
    String dni;
    String nombre;
    double saldo;

    public Cuenta(String dni, String nombre, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
        System.out.println("Cantidad ingresada: " + cantidad);
        System.out.println("Nuevo saldo: " + saldo);
    }

    public void retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Cantidad retirada: " + cantidad);
            System.out.println("Nuevo saldo: " + saldo);
        } else {
            System.out.println("No hay saldo disponible!");
            System.out.println("Saldo actual: " + saldo);
            System.out.println("Cantidad a retirar: " + cantidad);
        }
    }

    public void mostrarInformacionCuenta() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Saldo: " + saldo);
    }
}
