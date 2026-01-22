package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ6_Restaurante;

public class Mesa {
    private int numMesa;
    private int capacidad;
    private boolean ocupada;

    public Mesa(int numMesa, int capacidad) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.ocupada = false;
    }

    public boolean ocupar() {
        if (!this.ocupada) {
            this.ocupada = true;
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacion() {
        String estado = ocupada ? "Ocupada" : "Libre";
        System.out.println("Mesa " + numMesa + " (Capacidad: " + capacidad + ") - Estado: " + estado);
    }

    public int getNumMesa() {
        return numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isOcupada() {
        return ocupada;
    }
}
