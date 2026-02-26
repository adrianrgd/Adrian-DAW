public class MainFigura {
    public static void main(String[] args) {
        
    Figura f = new Circulo();
    f.dibujar();
    f.dibujar("rojo");
    }
}

/*¿Porque no se puede llamar a la version con parametro? 
Porque el compilador solo ve la referencia de tipo Figura, no la instancia de tipo Circulo*/

/*¿Diferencia entre sobrecarga y sobreescritura? 
Sobrecarga: mismo nombre, diferentes parametros
Sobrescritura: mismo nombre, mismos parametros, diferente clase*/

/*¿Que tipo de polimorfismo es dinamico y cual es estatico? 
Polimorfismo dinamico: sobreescritura
Polimorfismo estatico: sobrecarga*/
