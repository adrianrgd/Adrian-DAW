package CuentaCorriente;

public class AppCuentaCorriente {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("12345678A", "Francisco", 1000);
        cuenta1.mostrarInformacionCuenta();

        System.out.println();
        cuenta1.ingresar(535.65);

        System.out.println();
        cuenta1.retirar(215.50);

        System.out.println();
        cuenta1.retirar(1500);
    }
}
