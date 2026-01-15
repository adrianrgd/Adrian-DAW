//Ejercicio 6 POO_1

class CuentaBancaria {
    int numeroCuenta;
    double saldo;
    String titular;

    public CuentaBancaria() {
        this.numeroCuenta = 1;
        this.saldo = 420;
        this.titular = "Pablo Garcia";

        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
        System.out.println("Titular: " + titular + "\n");
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Has depositado " + cantidad + "EUR. \nSaldo: " + saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("No tienes suficiente dinero!\nSaldo: " + saldo);
        } else {
        saldo -= cantidad;
        System.out.println("Has retirado " + cantidad + " EUR. \nSaldo: " + saldo);
        }
    }
}

public class MainCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria movimiento = new CuentaBancaria();
        movimiento.retirar(357);
        movimiento.depositar(145);
    }
}
