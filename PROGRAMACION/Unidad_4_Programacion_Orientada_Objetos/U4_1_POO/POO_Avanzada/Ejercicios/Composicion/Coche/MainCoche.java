public class MainCoche {
    public static void main(String[] args) {
        Ruedas[] ruedas = new Ruedas[4];
        ruedas[0] = new Ruedas("Michelin", 16);
        ruedas[1] = new Ruedas("Michelin", 16);
        ruedas[2] = new Ruedas("Michelin", 16);
        ruedas[3] = new Ruedas("Michelin", 16);
        Coche coche = new Coche();
        coche.setRuedas(ruedas);
        for (int i = 0; i < coche.getRuedas().length; i++) {
            System.out.println(coche.getRuedas()[i]);
        }
    }
}
