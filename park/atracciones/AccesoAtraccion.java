/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.atracciones;

import java.time.LocalDateTime;
import park.entradas.Entrada;

/**
 *Clase que controla el acceso a una atracción para un día y una entrada.
 * @author corun
 */
public class AccesoAtraccion {
    private final Atraccion Atraccion;
    private final Entrada Entrada;
    private final LocalDateTime timestamp;

    /**
     * Método para generar un acceso a una atracción.
     * @param Atraccion atracción a la que se accede
     * @param Entrada  entrada con su usuario asociado que accede a la entrada.
     */
    public AccesoAtraccion(Atraccion Atraccion, Entrada Entrada) {
        this.Atraccion = Atraccion;
        this.Entrada = Entrada;
        this.timestamp=LocalDateTime.now();
    }

    /**
     * Método para recuperar la atracción a la que se ha accedido
     * @return Devuelve la atracción a la que se ha accedido
     */
    public Atraccion getAtraccion() {
        return Atraccion;
    }

    /**
     * Método para recuperar la entrada con la que se accedió y el usuario asociado
     * @return entrada registrada
     */
    public Entrada getEntrada() {
        return Entrada;
    }

    /**
     * Método que devuelve el timestamp del acceso a la atracción.
     * @return LocalDateTime con el timestamp del acceso.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    } 
    
}
