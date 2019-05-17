/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import park.usuarios.Usuario;
import park.usuarios.UsuarioInfantil;

/**
 *
 * @author corun
 */
public class EntradaGeneral extends Entrada{
    
    public EntradaGeneral(boolean VIP, Temporada temporada, Usuario usuario) {
        super(VIP, temporada, false, false, usuario);
    }
    
    public EntradaGeneral(Entrada entradaAdultoAsociada, UsuarioInfantil usuarioInfantil){
        super(entradaAdultoAsociada,usuarioInfantil);
    }
}
