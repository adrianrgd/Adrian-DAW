package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ6_Restaurante;

public class Plato {
    private String descripcion;
    private double precio;

    public Plato(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.println("Plato: " + descripcion + " | Precio: " + precio + "EUR");
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}