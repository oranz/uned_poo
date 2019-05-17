/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.atracciones;

import java.time.LocalDateTime;
import park.entradas.Entrada;

/**
 *
 * @author corun
 */
public class AccesoAtraccion {
    private final Atraccion Atraccion;
    private final Entrada Entrada;
    private final LocalDateTime timestamp;

    public AccesoAtraccion(Atraccion Atraccion, Entrada Entrada) {
        this.Atraccion = Atraccion;
        this.Entrada = Entrada;
        this.timestamp=LocalDateTime.now();
    }

    public Atraccion getAtraccion() {
        return Atraccion;
    }

    public Entrada getEntrada() {
        return Entrada;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    } 
    
}
