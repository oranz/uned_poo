/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.atracciones;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaAccesoAtracciones extends ArrayList<AccesoAtraccion> {

    private ListaAccesoAtracciones() {
    }
    private static ListaAccesoAtracciones listaAccesoAtracciones;

    public static ListaAccesoAtracciones getLista() {
        if (listaAccesoAtracciones == null) {
            listaAccesoAtracciones = new ListaAccesoAtracciones();
        }
        return listaAccesoAtracciones;
    }
 
}
