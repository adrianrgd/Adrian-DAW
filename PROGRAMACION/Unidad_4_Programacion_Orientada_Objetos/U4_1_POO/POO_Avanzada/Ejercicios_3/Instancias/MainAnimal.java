public class MainAnimal {
    public static void main(String[] args) {
        Animal a = new Perro();


        a.hacerSonido();
        a.moverCola();
    }
}

/*¿Porque hacerSonido() funciona pero moverCola() no?
Porque hacerSonido() esta definido en la clase Animal, mientras que moverCola() no, y el compilador solo ve la 
referencia de tipo Animal, no la instancia de tipo Perro*/

/*¿Que determina los metodos disponibles en compilacion?
La referencia de tipo*/

/*¿Que determina que version del metodo se ejecuta? 
La instancia de tipo*/