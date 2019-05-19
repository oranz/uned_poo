/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.empleados;

import java.time.LocalDate;

/**
 * Clase para dar de alta ayudantes de atracción.
 * Implementa la interfaz IPromocionable, ya que puede promocionarse a Resposable
 * @author corun
 */
public class AyudanteAtraccion extends Empleado implements IPromocionable{
    
    private boolean promocionado;
    private LocalDate fechaPromocion;
    private ResponsableAtraccion responsableAtraccion;

    public AyudanteAtraccion() {
        super(0);
    }
    /**
     * Método que promociona al ayudante a responsable.
     * una vez promocionado se tiene en cuenta la fecha para saber si puede ser
     * o no utilizado como ayudante o responsable.
     * @return nuevo empleado responsable
     */
    @Override
    public Empleado promocionar() {
        this.setResponsableAtraccion(new ResponsableAtraccion());
        this.setPromocionado(true);
        this.setFechaPromocion(LocalDate.now());
        return this.getResponsableAtraccion();
    }

    /**
     * Comprueba si el empleado ha sido promocionado
     * @return true si ha sido promocionado, false si no ha sido promocionado
     */
    public boolean isPromocionado() {
        return promocionado;
    }

    /**
     * Método que modifica la popiedad promocionado
     * @param promocionado 
     */
    private void setPromocionado(boolean promocionado) {
        this.promocionado = promocionado;
    }

    /**
     * Método que recupera la fecha desde la que se ha promocionado o va a ser promocionado
     * @return fecha en la que se promociona a responsable
     */
    public LocalDate getFechaPromocion() {
        return fechaPromocion;
    }

    /**
     * Método que modifica la fecha de promoción
     * @param fechaPromocion 
     */
    private void setFechaPromocion(LocalDate fechaPromocion) {
        this.fechaPromocion = fechaPromocion;
    }

    /**
     * Método que recupera el objeto ResponsableAtraccion asociado al antiguo ayudante de atracción.
     * @return devuelve el nuevo objeto de empleado al que está asociado este ayudante.
     */
    public ResponsableAtraccion getResponsableAtraccion() {
        return responsableAtraccion;
    }

    /**
     * Método que asigna el nuevo responsable de la atracción.
     * @param responsableAtraccion 
     */
    private void setResponsableAtraccion(ResponsableAtraccion responsableAtraccion) {
        this.responsableAtraccion = responsableAtraccion;
    }    
}
