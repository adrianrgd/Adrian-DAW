import java.util.HashSet;
import java.util.Set;

public class ColeccionDados {
    HashSet<DadoEspecial> dados = new HashSet();
    DadoEspecial dado1 = new DadoEspecial(6, "azul");
    DadoEspecial dado2 = new DadoEspecial(6, "rojo");
    DadoEspecial dado3 = new DadoEspecial(20, "verde");
    DadoEspecial dado4 = new DadoEspecial(4, "negro");
    DadoEspecial dado5 = new DadoEspecial(6, "azul");

    public void agregarDado(Set<DadoEspecial> dados, DadoEspecial dado) throws DadoDuplicadoExcepcion {
        try {
            dados.add(dado);
        } catch (DadoDuplicadoExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ColeccionDados coleccion = new ColeccionDados();
        coleccion.agregarDado(coleccion.dados, coleccion.dado1);
        coleccion.agregarDado(coleccion.dados, coleccion.dado2);
        coleccion.agregarDado(coleccion.dados, coleccion.dado3);
        coleccion.agregarDado(coleccion.dados, coleccion.dado4);
        coleccion.agregarDado(coleccion.dados, coleccion.dado5);
        System.out.println(coleccion.dados);
    }

}
