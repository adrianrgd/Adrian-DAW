package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ6_Restaurante;

public class Cliente {
    private String nombre;
    private String dni;
    private Mesa mesaAsignada;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.mesaAsignada = null;
    }

    public void asignarMesa(Mesa mesa) {
        if (!mesa.isOcupada()) {
            mesa.ocupar();
            this.mesaAsignada = mesa;
            System.out.println("Mesa " + mesa.getNumMesa() + " asignada a " + this.nombre);
        } else {
            System.out.println("Error: La Mesa " + mesa.getNumMesa() + " ya está ocupada.");
        }
    }

    public void mostrarInformacion() {
        System.out.print("Cliente: " + nombre + " (DNI: " + dni + ")");
        if (mesaAsignada != null) {
            System.out.println(" - Mesa asignada: " + mesaAsignada.getNumMesa());
        } else {
            System.out.println(" - Sin mesa");
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}
