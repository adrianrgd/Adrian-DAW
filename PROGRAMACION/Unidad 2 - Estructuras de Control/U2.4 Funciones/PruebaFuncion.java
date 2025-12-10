public class PruebaFuncion {
    public static void main(String[] args) {
        
        miSaludo();
        miSaludo();
        miSaludo();

        System.out.println(" ");
        funcionBoolean();
        funcionBoolean();
        funcionBoolean();

        System.out.println(" ");
        boolean pruebaVariable = funcionBoolean();
        System.out.println(pruebaVariable);

        System.out.println(" ");
        if (funcionBoolean()) {
            System.out.println("Todo salio bien!");
        }
        
        System.out.println(" ");
        boolean pruebaVariable2 = funcionBoolean2("Arguiñano");
        System.out.println(pruebaVariable2);
    }

    public static void miSaludo(){
        System.out.println("UwU");
    }

    public static boolean funcionBoolean(){
        System.out.println("Melones!");
        return true;
    }

    public static boolean funcionBoolean2(String cadena){
        System.out.println("Hola " + cadena);
        return true;
    }
}