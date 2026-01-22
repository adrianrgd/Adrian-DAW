// Ejercicio 2 POO_1

class Calculadora {
    public Calculadora() {}

    public double sumar(double a, double b) {return a + b;}
    public double restar(double a, double b) {return a - b;}
    public double multiplicar(double a, double b) {return a * b;}
    public double division(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("No se puede dividir entre 0.");
            return 0;
        }
    }
}

public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora operar = new Calculadora();
        System.out.println("Suma: " + operar.sumar(6, 3));
        System.out.println("Resta: " + operar.restar(11, 5));
        System.out.println("Multiplicacion: " + operar.multiplicar(5, 2));
        System.out.println("Division: " + operar.division(16, 4));
    }
}
