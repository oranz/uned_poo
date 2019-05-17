// Declaración del paquete al que pertenece  la clase
package park.entradas;

//Importación de clases y/o paquetes
import park.usuarios.Usuario;
import park.usuarios.UsuarioInfantil;
import park.ventas.Bonificacion;

/**
 * Clase para la creación de entradas de acceso exclusivo en horario de tarde
 * @author Oscar Ranz Rumbo
 */
public class EntradaTarde extends Entrada{

    /**
     * Constructor para la creación de entradas de adulto
     * @param VIP true si tiene VIP, false si no tiene
     * @param temporada temporada válida para esta entrada
     * @param usuario usuario asociado
     */
    EntradaTarde(boolean VIP, Temporada temporada, Usuario usuario) {
        super(VIP,temporada, true, false, usuario);
        this.addBonificacion(new Bonificacion(10, "Bonificación entrada de tarde"));
    }

    /**
     * Constructor para la creación de entradas infantiles
     * @param entradaAdultoAsociada entrada del adulto responsable del menor
     * @param usuarioInfantil  usuario infantil asociado a la entrada
     */
    EntradaTarde(Entrada entradaAdultoAsociada, UsuarioInfantil usuarioInfantil) {
        super(entradaAdultoAsociada, usuarioInfantil);
        this.addBonificacion(new Bonificacion(10, "Bonificación entrada de tarde"));
    }
    
}
