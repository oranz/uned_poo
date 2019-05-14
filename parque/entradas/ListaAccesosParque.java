/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.entradas;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaAccesosParque extends ArrayList<AccesoParque> {

    private ListaAccesosParque() {

    }

    private static ListaAccesosParque listaAccesosParque;

    public static ListaAccesosParque getListaAccesosParque() {
        if (listaAccesosParque == null) {
            listaAccesosParque = new ListaAccesosParque();
        }

        return listaAccesosParque;
    }

}
