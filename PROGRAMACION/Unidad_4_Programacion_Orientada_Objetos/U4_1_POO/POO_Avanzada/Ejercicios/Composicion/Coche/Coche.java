public class Coche {
    private Ruedas[] ruedas;

    public Coche() {
        this.ruedas = new Ruedas[4];
    }

    public void setRuedas(Ruedas[] ruedas) {
        this.ruedas = ruedas;
    }

    public Ruedas[] getRuedas() {
        return ruedas;
    }
}
