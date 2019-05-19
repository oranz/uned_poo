// Declaración del paquete al que pertenece  la clase
package park.atracciones;

//Importación de clases y/o paquetes
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Calse que guarda las atracciones funcionando en una fecha concreta
 * @author Oscar Ranz Rumbo
 */
public class DiarioAtraccionesFuncionando {
    private final LocalDate fecha;
    private final ArrayList<Atraccion> listaAtraccionesFuncionando = new ArrayList<>();

    /**
     * Constructor en el que se indicará la fecha de registro
     * @param fecha fecha del registro de las atracciones
     */
    public DiarioAtraccionesFuncionando(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para recuperar la fecha del registro
     * @return devuelve la fecha del registro
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Método para recuperar la lista de atracciones funcionando
     * @return devuelve la lista de atracciones.
     */
    public ArrayList<Atraccion> getListaAtraccionesFuncionando() {
        return listaAtraccionesFuncionando;
    }
}
