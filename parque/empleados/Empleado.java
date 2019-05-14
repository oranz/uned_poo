/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.empleados;

/**
 *
 * @author corun
 */
public abstract class Empleado {
    
    protected int sueldoBase;

    public Empleado(int porcentajeAdicional) {
        this.sueldoBase = 950+(950*(porcentajeAdicional/100));
    }

    
    public int getSueldoBase() {
        return sueldoBase;
    }

}
