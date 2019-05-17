/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.empleados;

import java.time.LocalDate;

/**
 *
 * @author corun
 */
public class AyudanteAtraccion extends Empleado implements IPromocionable{
    
    private boolean promocionado;
    private LocalDate fechaPromocion;
    private ResponsableAtraccion responsableAtraccion;

    public AyudanteAtraccion() {
        super(0);
    }

    @Override
    public Empleado promocionar() {
        this.setResponsableAtraccion(new ResponsableAtraccion());
        this.setPromocionado(true);
        this.setFechaPromocion(LocalDate.now());
        return this.getResponsableAtraccion();
    }

    public boolean isPromocionado() {
        return promocionado;
    }

    public void setPromocionado(boolean promocionado) {
        this.promocionado = promocionado;
    }

    public LocalDate getFechaPromocion() {
        return fechaPromocion;
    }

    public void setFechaPromocion(LocalDate fechaPromocion) {
        this.fechaPromocion = fechaPromocion;
    }

    public ResponsableAtraccion getResponsableAtraccion() {
        return responsableAtraccion;
    }

    public void setResponsableAtraccion(ResponsableAtraccion responsableAtraccion) {
        this.responsableAtraccion = responsableAtraccion;
    }    
}
