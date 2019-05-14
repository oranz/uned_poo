/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.atracciones;

import java.time.LocalDateTime;
import java.time.LocalTime;
import parque.entradas.Entrada;
import parque.usuarios.TipoUsuario;

/**
 *
 * @author corun
 */
public abstract class Atraccion {
    
        private final int alturaMinima;
        private final int alturaMaxima;
        private final boolean accesoNinhos;
        private final boolean accesoAdultos;
        private final int numeroAyudantes;
        private final int numeroResponsables;
        private final boolean accesoVIP;
        private boolean activa;

    protected Atraccion(int alturaMinima, int alturaMaxima, boolean accesoNinhos, boolean accesoAdultos, int numeroAyudantes, int responsable, boolean VIP) {
        this.alturaMinima = alturaMinima;
        this.alturaMaxima = alturaMaxima;
        this.accesoNinhos = accesoNinhos;
        this.accesoAdultos = accesoAdultos;
        this.numeroAyudantes = numeroAyudantes;
        this.numeroResponsables = responsable;
        this.accesoVIP = VIP;
        this.activa = false;
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
    
    int getNumeroAyudantes() {
        return numeroAyudantes;
    }

    int getNumeroResponsables() {
        return numeroResponsables;
    }

    boolean isActiva() {
        return activa;
    }

    void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isAcesoVIP() {
        return accesoVIP;
    }
       
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
