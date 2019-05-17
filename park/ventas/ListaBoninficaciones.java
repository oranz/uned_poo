/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.ventas;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaBoninficaciones extends ArrayList<Bonificacion> {
    
    public final String BONIFICACION_DISCAPACIDAD = "Bonificación Discapacidad";
    public final String BONIFICACION_CARNET_JOVEN = "Bonificación Carnet Joven";
    public final String BONIFICACION_ESTUDIANTE = "Bonificación Estudiante";
    public final String BONIFICACION_DESEMPLEADO = "Bonificación por Desempleado";

    private ListaBoninficaciones() {
        this.add(new Bonificacion(20,BONIFICACION_DISCAPACIDAD));
         this.add(new Bonificacion(10,BONIFICACION_CARNET_JOVEN));
        this.add(new Bonificacion(10,BONIFICACION_ESTUDIANTE));
        this.add(new Bonificacion(10,BONIFICACION_DESEMPLEADO));
    }

    private static ListaBoninficaciones listaBonificaciones;

    public static ListaBoninficaciones getListaBonificaciones() {
        if (listaBonificaciones == null) {
            listaBonificaciones = new ListaBoninficaciones();
        }

        return listaBonificaciones;
    }
}
