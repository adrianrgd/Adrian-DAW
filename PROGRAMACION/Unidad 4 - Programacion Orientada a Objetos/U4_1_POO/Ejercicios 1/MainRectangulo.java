//Ejercicio 5 POO_1

class Rectangulo {
    double alto;
    double ancho;

    public Rectangulo(int ancho, int alto) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public double area() {
        return ancho * alto;
    }

    public double perimetro() {
        return 2 * (ancho + alto);
    }
}

public class MainRectangulo {
    public static void main(String[] args) {
        Rectangulo operar = new Rectangulo(5,11);
        System.out.println("Area: " + operar.area());
        System.out.println("Perimetro: " + operar.perimetro());
    }
}