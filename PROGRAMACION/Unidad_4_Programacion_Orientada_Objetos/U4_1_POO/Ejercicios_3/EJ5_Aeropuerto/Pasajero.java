package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ5_Aeropuerto;

public class Pasajero {
    private String nombre;
    private String dni;
    
    public Pasajero(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }
}