/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.entradas;

import java.time.LocalDateTime;
import parque.usuarios.Usuario;

/**
 *
 * @author corun
 */
public abstract class Entrada {

    private final int precioBase = 60;
    private final int precioVIP = 50;
    private final boolean VIP;
    private final Temporada temporada;
    private final Usuario Usuario;
    private final boolean accesoTarde;
    private LocalDateTime fechaAcceso;
    private boolean anulada;
    private final int idEntrada;
    private static int ultimoIDEntrada;
    
    protected Entrada(boolean VIP, Temporada temporada, boolean accesoTarde, Usuario usuario) {
        this.VIP = VIP;
        this.temporada = temporada;
        this.Usuario = usuario;
        this.accesoTarde = accesoTarde;
        this.anulada = false;
        this.idEntrada=ultimoIDEntrada++;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public int getPrecioVIP() {
        return precioVIP;
    }

    public boolean isVIP() {
        return VIP;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public boolean isAccesoTarde() {
        return accesoTarde;
    }

    public LocalDateTime getFechaAcceso() {
        return fechaAcceso;
    }

    void setFechaAcceso(LocalDateTime fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public boolean isAnulada() {
        return anulada;
    }

    void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    abstract boolean isEntradaAdulto();
       
}
