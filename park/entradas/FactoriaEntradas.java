/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import park.usuarios.TipoUsuario;
import park.usuarios.Usuario;
import park.usuarios.UsuarioInfantil;

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
    
    /**
     * Método para crear entradas en función de los parámetros facilitados
     * @param tipoEntrada El tipo de entrada que se debe crear
     * @param VIP true si adquiere complemento VIP, false si no lo adquiere
     * @param temporada temporada para la que compra la entrada: ALTA,MEDIA,BAJA
     * @param entradaAdultoAsociada si es infantil, la entrada del adulto al que está asociada
     * @param usuario el usuario al que pertenece la entrada
     * @return devuelve la entrada generada
     * @throws RuntimeException se generará una excepción si se intenta vender 
     * un tipo de entrada a un tipo de usuario incorrecto, o si se intenta 
     * asociar a una entrada infantil una entrada que no sea de adulto/senior
     */
    public Entrada generaEntrada(TipoEntrada tipoEntrada, boolean VIP, Temporada temporada, Entrada entradaAdultoAsociada, Usuario usuario) throws RuntimeException{
        Entrada entrada;
        switch (tipoEntrada) {
            case GENERAL_ADULTO:
                // Se comprueba que el usuario sea adulto
                if (usuario.getTipoUsuario() == TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaGeneral(VIP, temporada, usuario);
                break;
            case GENERAL_INFANTIL:
                // Se comprueba que la entrada asociada sea de adulto y el usuario infantil
                if (entradaAdultoAsociada.isEntradaAdulto()) {
                    throw new RuntimeException("La entrada asociada no es de adulto");
                } else if (usuario.getTipoUsuario() != TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado no es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaGeneral(entradaAdultoAsociada, (UsuarioInfantil) usuario);
                break;
            case LABORABLE_ADULTO:
                 // Se comprueba que el usuario sea adulto
                if (usuario.getTipoUsuario() == TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaLaborable(VIP, temporada, usuario);
                break;
            case LABORABLE_INFANTIL:
                // Se comprueba que la entrada asociada sea de adulto y el usuario infantil
                if (entradaAdultoAsociada.isEntradaAdulto()) {
                    throw new RuntimeException("La entrada asociada no es de adulto");
                } else if (usuario.getTipoUsuario() != TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado no es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaLaborable(entradaAdultoAsociada, (UsuarioInfantil) usuario);
                break;
            case TARDE_ADULTO:
                 // Se comprueba que el usuario sea adulto
                if (usuario.getTipoUsuario() == TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaTarde(VIP, temporada, usuario);
                break;
            case TARDE_INFANTIL:
                // Se comprueba que la entrada asociada sea de adulto y el usuario infantil
                if (entradaAdultoAsociada.isEntradaAdulto()) {
                    throw new RuntimeException("La entrada asociada no es de adulto");
                } else if (usuario.getTipoUsuario() != TipoUsuario.INFANTIL) {
                    throw new RuntimeException("El usuario indicado no es infantil");
                }
                //Si pasa las comprobaciones crea la entrada
                entrada = new EntradaTarde(entradaAdultoAsociada, (UsuarioInfantil) usuario);
                break;
                
            default:
                throw new RuntimeException("No se pudo crear la entrada con los datos indicados");
        }
        return entrada;
    }
    
}
