class Paypal {
    String email;
    double saldoDisponible;

    public Paypal(String email, double saldoDisponible) {
        this.email = email;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String toString() {
        return "Paypal [email=" + email + ", saldoDisponible=" + saldoDisponible + "]";
    }

}
