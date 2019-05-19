// Declaración del paquete al que pertenece  la clase
package park.entradas;
//Importación de clases y/o paquetes
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Clase que registra el acceso al parque de una entrada.
 * @author Oscar Ranz RUmbo
 */
public class AccesoParque {
    private final Entrada entrada;
    private final LocalDateTime timestamp;

    /**
     * Constructor que asocia la entrada con su fecha de entrada
     * @param entrada entrada con la que se accede al parque
     */
    public AccesoParque(Entrada entrada) {
        this.entrada = entrada;
        this.timestamp = LocalDateTime.now();
        entrada.setFechaAcceso(timestamp);
    }

    public AccesoParque(Entrada entrada, LocalDate fecha) {
        this.entrada = entrada;
        this.timestamp=LocalDateTime.of(fecha, LocalTime.now());
        entrada.setFechaAcceso(timestamp);
    }

    /**
     * Método que recupera la entrada utilizada en el acceso.
     * @return entrada
     */
    public Entrada getEntrada() {
        return entrada;
    }

    /**
     * Método que recupera la fecha y hora de entrada en el parque.
     * @return fecha y hora de acceso con la entrada en el parque.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
}
