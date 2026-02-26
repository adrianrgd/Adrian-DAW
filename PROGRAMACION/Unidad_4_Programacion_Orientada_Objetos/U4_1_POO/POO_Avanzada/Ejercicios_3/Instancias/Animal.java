class Animal {
    public void hacerSonido() {
        System.out.println("Sonido generico");
    }
}

class Perro extends Animal {
    public void hacerSonido() {
        System.out.println("Guau");
    }
    public void moverCola() {
        System.out.println("El perro mueve la cola");
    }
}
