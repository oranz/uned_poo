/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import park.ventas.Bonificacion;

/**
 * Clase para crear entradas bonificadas.
 * @author corun
 */
public class EntradaBonificada extends Entrada{
    
    public EntradaBonificada(boolean VIP, Temporada temporada, boolean accesoTarde, boolean soloLaborable, park.usuarios.Usuario usuario, Bonificacion bonificacion) {
        super(VIP, temporada, accesoTarde, soloLaborable, usuario);
        this.addBonificacion(bonificacion);
    }
    
}
