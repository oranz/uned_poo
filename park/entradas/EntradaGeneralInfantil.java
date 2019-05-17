/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import park.usuarios.Usuario;

/**
 *
 * @author corun
 */
public class EntradaGeneralInfantil extends Entrada{
    private final Entrada entradaAdultoAsociada;

    public EntradaGeneralInfantil(Entrada entradaAdultoAsociada, boolean VIP, Temporada temporada, Usuario usuario) {
        super(VIP, temporada,false, usuario);
        this.entradaAdultoAsociada = entradaAdultoAsociada;
    }

    public Entrada getEntradaAdultoAsociada() {
        return this.entradaAdultoAsociada;
    }

    @Override
    public boolean isEntradaAdulto() {
        return false;
    }


    
}
