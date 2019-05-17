// Declaración del paquete al que pertenece  la clase
package park.entradas;

//Importación de clases y/o paquetes
import park.usuarios.Usuario;
import park.usuarios.UsuarioInfantil;
import park.ventas.Bonificacion;

/**
 * Clase para la creación de entradas laborables
 * @author Oscar Ranz Rumbo
 */
public class EntradaLaborable extends Entrada {

    /**
     * Constructor para entradas de adulto
     * @param VIP true si tiene complemento VIP, false si no tiene
     * @param temporada temporada para la que la entrada es válida
     * @param usuario usuario asociado a la entrada
     */
    EntradaLaborable(boolean VIP, Temporada temporada, Usuario usuario) {
        super(VIP,temporada,false,true,usuario);
        this.addBonificacion(new Bonificacion(10,"Boonificación entrada laboral."));
    }

    /**
     * Constructor para entradas infantiles
     * @param entradaAdultoAsociada entrada de adulto asociada
     * @param usuarioInfantil  usuario infantil asociado a la entrada.
     */
    EntradaLaborable(Entrada entradaAdultoAsociada, UsuarioInfantil usuarioInfantil) {
        super(entradaAdultoAsociada, usuarioInfantil);
        this.addBonificacion(new Bonificacion(10,"Boonificación entrada laboral."));
    }
    
}
