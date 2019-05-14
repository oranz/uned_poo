/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.ventas;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaBoninficaciones extends ArrayList<Bonificacion> {

    private ListaBoninficaciones() {

    }

    private static ListaBoninficaciones listaBonificaciones;

    public static ListaBoninficaciones getListaBonificaciones() {
        if (listaBonificaciones == null) {
            listaBonificaciones = new ListaBoninficaciones();
            listaBonificaciones.addBonificacionesIniciales();
        }

        return listaBonificaciones;
    }
    
    private void addBonificacionesIniciales(){
        this.add(new Bonificacion(10,"Estudiante"));
        this.add(new Bonificacion(10,"Carnet Joven"));
        this.add(new Bonificacion(20,"Discapacitado"));
    }
}
