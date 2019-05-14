/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.entradas;

import parque.usuarios.Usuario;

/**
 *
 * @author corun
 */
public class EntradaGeneralAdulto extends Entrada{
    
    public EntradaGeneralAdulto(boolean VIP, Temporada temporada, Usuario usuario) {
        super(VIP, temporada, false, usuario);
    }
    
    @Override
    public boolean isEntradaAdulto() {
        return true;
    }
}
