/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.entradas;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaEntradas extends ArrayList<Entrada> {

    private ListaEntradas() {

    }

    private static ListaEntradas listaEntradas;

    public static ListaEntradas getListaEntradas() {
        if (listaEntradas == null) {
            listaEntradas = new ListaEntradas();
        }

        return listaEntradas;
    }
}
