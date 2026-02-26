class Empleado_3 {
    public void trabajar() {
        System.out.println("Empleado trabajando");
    }
}

class Programador extends Empleado_3 {
    public void trabajar() {
        System.out.println("Programando...");
    }
    public void compilarCodigo() {
        System.out.println("Compilando codigo...");
    }
}
