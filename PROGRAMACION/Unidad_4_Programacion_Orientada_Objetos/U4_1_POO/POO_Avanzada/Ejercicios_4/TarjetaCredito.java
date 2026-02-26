class TarjetaCredito extends MetodoPago {
    String numTarjeta;
    double limiteDisponible;

    public TarjetaCredito(String titular, String numTarjeta, double limiteDisponible) {
        super(titular);
        this.numTarjeta = numTarjeta;
        this.limiteDisponible = limiteDisponible;
    }

    @Override
    public String toString() {
        return "TarjetaCredito -> Numero de Tarjeta: " + numTarjeta + ", limiteDisponible: " + limiteDisponible;
    }

    @Override
    public boolean procesarPago(double importe) {
        if (importe <= limiteDisponible) {
            limiteDisponible -= importe;
            return true;
        } else {
            return false;
        }
    }
}
