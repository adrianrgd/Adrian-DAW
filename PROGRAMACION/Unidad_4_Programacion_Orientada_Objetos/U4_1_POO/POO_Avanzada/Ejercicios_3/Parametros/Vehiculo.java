class Vehiculo {
    public void arrancar() {
        System.out.println("Vehiculo arrancado");
    }    
}

class Coche extends Vehiculo {
    public void arrancar() {
        System.out.println("Coche arrancado");
    }    
    public void abrirMaletero() {
        System.out.println("Maletero abierto");
    }
}
