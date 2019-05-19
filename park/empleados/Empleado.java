/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.empleados;

/**
 * Clase base de la que extienden los distintos tipos de empleado.
 * @author corun
 */
public abstract class Empleado {
    
    protected int sueldoBase;

    /**
     * Constructor del empleado
     * @param porcentajeAdicional  0 si es ayudante, entero del tanto porciento de diferencia con el sueldo del ayudante.
     */
    public Empleado(int porcentajeAdicional) {
        this.sueldoBase = 950+(950*(porcentajeAdicional/100));
    }

    /**
     * Método que devuelve el sueldo del empleado
     * @return sueldo del empleado.
     */
    public int getSueldoBase() {
        return sueldoBase;
    }

}
