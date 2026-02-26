public abstract class MetodoPago {
    protected String titular;

    abstract boolean procesarPago(double importe);

    public MetodoPago(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "MetodoPago -> titular: " + titular;
    }
}
