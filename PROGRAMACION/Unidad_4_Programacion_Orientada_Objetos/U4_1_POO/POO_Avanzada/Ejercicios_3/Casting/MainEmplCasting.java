public class MainEmplCasting {
    public static void main(String[] args) {
        
    EmpleadoCasting[] empleados = new EmpleadoCasting[2];
    empleados[0] = new EmpleadoCasting();    
    empleados[1] = new Programador();
        
    EmpleadoCasting e = new Programador();
    ((Programador) e).compilarCodigo();

    EmpleadoCasting e2 = new EmpleadoCasting();
    ((Programador) e2).compilarCodigo();
    }

}

/*¿Porque el primer cast funciona y el segundo no? 
Porque el primer cast es correcto, mientras que el segundo no, ya que e2 es de tipo EmpleadoCasting y no Programador*/

/*¿Que excepcion aparece en tiempo de ejecucion? 
ClassCastException, porque e2 es de tipo EmpleadoCasting y no Programador*/

/*¿Que operador permite verificar el tipo antes del cast? 
instanceof, devuelve true si el objeto es del tipo especificado o de una subclase*/
