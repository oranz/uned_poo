/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.entradas;

import parque.usuarios.TipoUsuario;
import parque.usuarios.Usuario;

/**
 *
 * @author corun
 */
public class FactoriaEntradas {
    
    private FactoriaEntradas() {

    }

    private static FactoriaEntradas factoriaEntradas;

    public static FactoriaEntradas getInstance() {
        if (factoriaEntradas == null) {
            factoriaEntradas = new FactoriaEntradas();
        }

        return factoriaEntradas;
    }
    
    public Entrada generaEntrada(TipoEntrada tipoEntrada, boolean VIP, Temporada temporada, Entrada entradaAdultoAsociada, Usuario usuario) {
        Entrada entrada;
        switch (tipoEntrada) {
            case GENERAL_ADULTO:
                // Se comprueba que el usuario sea adulto
                if (usuario.getTipoUsuario() == TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaGeneralAdulto(VIP, temporada, usuario);
                break;
            case GENERAL_INFANTIL:
                // Se comprueba que la entrada asociada sea de adulto y el usuario infantil
                if (entradaAdultoAsociada.isEntradaAdulto()) {
                    throw new RuntimeException("La entrada asociada no es de adulto");
                } else if (usuario.getTipoUsuario() != TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado no es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaGeneralInfantil(entradaAdultoAsociada, VIP, temporada, usuario);
                break;
            default:
                throw new RuntimeException("No se pudo crear la entrada con los datos indicados");
        }
        return entrada;
    }
    
}
