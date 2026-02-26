class Figura {
    public void dibujar() {
        System.out.println("Dibujando figura");
    }   
}

class Circulo extends Figura {
    public void dibujar() {
        System.out.println("Dibujando circulo");
    }
    public void dibujar(String color) {
        System.out.println("Dibujando circulo de color " + color);
    }   
}
