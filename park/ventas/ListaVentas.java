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
public class ListaVentas extends ArrayList<Venta> {

    private ListaVentas() {

    }

    private static ListaVentas listaVentas;

    public static ListaVentas getListaVentas() {
        if (listaVentas == null) {
            listaVentas = new ListaVentas();
            
        }

        return listaVentas;
    }

    /**
     * Método para añadir una venta a la lista
     * @param tipoVenta el tipo de venta: taquilla o ecommerce
     * @return devuelve la venta creada
     * @throws RuntimeException  da un error si el tipo de venta facilitado no es válido
     */
    public Venta addVenta(TipoVenta tipoVenta) throws RuntimeException {
        Venta venta;
        switch (tipoVenta) {
            case ECOMMERCE:
                venta = new ventaEcommerce();
                break;
            case TAQUILLA:
                venta = new ventaTaquilla();
                break;
            default:
                throw new RuntimeException("No se ha facilitado un tipo de venta válido");
        }
        this.add(venta);
        return venta;
    }

    public Venta getVenta(int idVenta) {
        return listaVentas.stream().filter(v -> v.getIdVenta() == idVenta).findFirst().get();
    }
    
}
