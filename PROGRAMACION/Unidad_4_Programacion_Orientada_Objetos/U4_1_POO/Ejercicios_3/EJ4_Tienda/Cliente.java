public class Cliente {
    public String nombre;
    private String dni;
    private int saldo;

    public Cliente(String nombre, String dni, int saldoInicial) {
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = saldoInicial;
    }

    public boolean pagar(int cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        } else {
            System.out.println("Saldo insuficiente " + this.saldo);
            return false;
        }
    }

    public void mostrarInformacionCliente() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("DNI: " + this.dni);
        System.out.println("Saldo Actual: " + this.saldo);
    }
    
    public String getDni() {
        return dni;
    }
}
