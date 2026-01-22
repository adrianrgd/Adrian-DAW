package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ6_Restaurante;

public class Orden {
    private Cliente cliente;
    private Mesa mesa;
    private Plato plato;

    public Orden(Cliente cliente, Mesa mesa, Plato plato) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.plato = plato;
    }

    public void calcularCosteTotal() {
        double total = plato.getPrecio() * mesa.getCapacidad();
        
        System.out.println("== Ticket de la Orden ==");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Mesa: " + mesa.getNumMesa() + " (" + mesa.getCapacidad() + " personas)");
        System.out.println("Plato: " + plato.getDescripcion() + " (" + plato.getPrecio() + "EUR)");
        System.out.println("TOTAL A PAGAR: " + total + "EUR");
    }

    public void mostrarDetalle() {
        System.out.println("Orden: " + plato.getDescripcion() + " para la Mesa " + mesa.getNumMesa());
    }
}
