
package park.atracciones;

import java.time.LocalDateTime;
import java.time.LocalTime;
import park.entradas.Entrada;
import park.usuarios.TipoUsuario;

/**
 * Clase atracción, de la que extenderán todos los tipos de atracción.
 * Gestionará casi toda la casuística necesaria para controlar la atracción.
 * @author Oscar Ranz Rumbo
 */
public abstract class Atraccion {
    
        private final int alturaMinima;
        private final int alturaMaxima;
        private final boolean accesoNinhos;
        private final boolean accesoAdultos;
        private final int numeroAyudantes;
        private final int numeroResponsables;
        private final boolean accesoVIP;
//        private boolean activa;

    /**
     * Constructor de la atracción
     * @param alturaMinima la altura mínima permitida en la atracción en cm. 0 implica que no tiene altura máxima
     * @param alturaMaxima la altura máxima permitida en la atracción en cm. 0 implica que no tiene altura máxima
     * @param accesoNinhos true se permiten niños, false no se permiten
     * @param accesoAdultos true se permiten adultos, false no se permiten
     * @param numeroAyudantes número de ayudantes necesarios en la atracción
     * @param responsable número de responsables que necesita la atracción
     * @param VIP true permite acceso VIP, false no permite acceso VIP.
     */
    protected Atraccion(int alturaMinima, int alturaMaxima, boolean accesoNinhos, boolean accesoAdultos, int numeroAyudantes, int responsable, boolean VIP) {
        this.alturaMinima = alturaMinima;
        this.alturaMaxima = alturaMaxima;
        this.accesoNinhos = accesoNinhos;
        this.accesoAdultos = accesoAdultos;
        this.numeroAyudantes = numeroAyudantes;
        this.numeroResponsables = responsable;
        this.accesoVIP = VIP;
        //this.activa = false;
    }    

    /**
     * Devuelve el valor de la altura mínima para acceder a la atraccion.
     *
     * @return el valor de alturaMinima (en cm. Si la altura mínima es menor que 1, se considenra que no hay altura mínima)
     */
    int getAlturaMinima() {
        return alturaMinima;
    }
    
    /**
     * Devuelve el valor de la altura máxima para acceder a la atraccion.
     *
     * @return el valor de alturaMaxima (en cm. Si la altura máxima es menor que 1, se considenra que no hay altura máxima)
     */
    int getAlturaMaxima() {
        return alturaMaxima;
    }

     /**
     * Inidica si la atraccion permite el acceso de niños
     *
     * @return valor de adminsionNinhos
     */
    boolean seAdmitenNinhos() {
        return accesoNinhos;
    }   

    /**
     * Inidica si la atraccion permite el acceso de adultos
     *
     * @return valor de adminsionAdultos
     */
    boolean seAdmitenAdultos() {
        return accesoAdultos;
    } 
    
    /**
     * Método para comprobar el número de ayudantes que requiere la atracción
     * @return numero ayudantes necesarios.
     */
    int getNumeroAyudantes() {
        return numeroAyudantes;
    }

    /**
     * Método que devuelve el número de responsables que necesita la atracción
     * @return número de responsables necesarios.
     */
    int getNumeroResponsables() {
        return numeroResponsables;
    }

//    /**
//     * Métodos deprecated 
//     * @return 
//     */
//    boolean isActiva() {
//        return activa;
//    }
//
//    void setActiva(boolean activa) {
//        this.activa = activa;
//    }

    /**
     * Método que comprueba si dispone de acceso VIP
     * @return true si tiene acceso VIP, false si no tiene acceso VIP
     */
    public boolean isAcesoVIP() {
        return accesoVIP;
    }
     
    /**
     * Método que comprueba si con una entrada y su usuario asociado pueden acceeder a la atracción.
     * @param entrada
     * @return true si puede acceder a la tracción y registra el acceso a la atracción, false si no puede acceder a la atracción
     */
    public boolean acceder(Entrada entrada){
        boolean resultado=false;
        if(entrada.isAnulada()==false 
                && (entrada.isAccesoTarde()==false || (LocalTime.now().isAfter(LocalTime.of(16,0))))
                && entrada.getUsuario().getAltura()>this.alturaMinima
                && entrada.getUsuario().getAltura()<this.alturaMaxima
                && (entrada.getUsuario().getTipoUsuario()==TipoUsuario.INFANTIL && this.accesoNinhos)
                && (entrada.getUsuario().getTipoUsuario()!=TipoUsuario.INFANTIL && this.accesoAdultos)){
            resultado=ListaAccesoAtracciones.getLista().add(new AccesoAtraccion(this,entrada));
        }
        return resultado;
    }
    
}
