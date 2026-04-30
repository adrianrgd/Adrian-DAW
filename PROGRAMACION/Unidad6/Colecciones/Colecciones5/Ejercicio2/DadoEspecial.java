public class DadoEspecial {
    private int lados;
    private String color;

    public DadoEspecial(int lados, String color) {
        this.lados = lados;
        this.color = color;
    }

    public int getLados() {
        return lados;
    }

    public String getColor() {
        return color;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dado Especial :" + lados + " lados" + " | Color :" + color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lados;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DadoEspecial other = (DadoEspecial) obj;
        if (lados != other.lados)
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }

}
