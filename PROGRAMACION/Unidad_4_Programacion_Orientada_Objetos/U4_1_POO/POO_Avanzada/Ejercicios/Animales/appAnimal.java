//EJERCICIO 1

public class appAnimal {
    public static void main(String[] args) {
        animal animal1 = new animal("Animal", 1);
        perro perro1 = new perro("Bobby", 5, "Labrador");
        gato gato1 = new gato("Misi", 3, "Siames");

        System.out.println(animal1);
        System.out.println(perro1);
        System.out.println(gato1);

        System.out.println();
        animal1.hacerSonido();
        perro1.hacerSonido();
        gato1.hacerSonido();
    }
}
