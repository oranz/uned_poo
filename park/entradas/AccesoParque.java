/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import java.time.LocalDateTime;

/**
 *
 * @author corun
 */
public class AccesoParque {
    private final int idEntrada;
    private final LocalDateTime timestamp;

    public AccesoParque(int idEntrada) {
        this.idEntrada = idEntrada;
        this.timestamp = LocalDateTime.now();
    }

    public int getEntrada() {
        return idEntrada;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    
    
}
