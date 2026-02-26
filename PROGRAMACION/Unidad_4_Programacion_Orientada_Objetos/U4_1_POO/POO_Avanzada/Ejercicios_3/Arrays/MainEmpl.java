public class MainEmpl {
    public static void main(String[] args) {
        
    Empleado_3[] empleados = new Empleado_3[2];
    empleados[0] = new Empleado_3();
    empleados[1] = new Programador();
    }
}

/*¿Porque el array permite almacenar un Programador? 
Porque Programador es una subclase de Empleado_3*/

/*¿Porque no se puede llamar a compilarCodigo()? 
Porque el array es de tipo Empleado_3 y compilarCodigo() no esta definido en Empleado_3*/
