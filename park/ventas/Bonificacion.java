/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.ventas;

/**
 *
 * @author corun
 */
public class Bonificacion {
    private int porcentajeBonificacion;
    private String descripcionBonificacion;

    public Bonificacion(int porcentajeBonificacion, String descripcionBonificacion) {
        this.porcentajeBonificacion = porcentajeBonificacion;
        this.descripcionBonificacion = descripcionBonificacion;
    }

    public int getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }

    public void setPorcentajeBonificacion(int porcentajeBonificacion) {
        this.porcentajeBonificacion = porcentajeBonificacion;
    }

    public String getDescripcionBonificacion() {
        return descripcionBonificacion;
    }

    public void setDescripcionBonificacion(String descripcionBonificacion) {
        this.descripcionBonificacion = descripcionBonificacion;
    }
    
    
}
