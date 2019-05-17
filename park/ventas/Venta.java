/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import park.entradas.Entrada;
import park.entradas.FactoriaEntradas;
import park.entradas.ListaEntradas;
import park.entradas.TipoEntrada;
import park.entradas.Temporada;
import park.usuarios.Usuario;

/**
 *
 * @author corun
 */
public abstract class Venta {

    private LocalDate fechaCompra;
    private boolean finCompra;
    private final int idVenta;
    private static int ultimoIdVenta;
    private final TipoVenta tipoVenta;
    private final ArrayList<Entrada> cesta = new ArrayList<>();

    Venta( TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
        this.idVenta = ultimoIdVenta++;
    }
    
    
    public void addEntrada(TipoEntrada tipoEntrada,boolean VIP, Temporada temporada, Entrada entradaAdultoAsociada,Usuario usuario) {
        if(isFinCompra()){
            throw new RuntimeException("No se puede añadir entrada, la venta ha sido finalizada");
        }
        cesta.add(FactoriaEntradas.getInstance().generaEntrada(tipoEntrada, VIP, temporada, entradaAdultoAsociada, usuario));
    }

    void finCompra() {
        
        if(!ListaEntradas.getListaEntradas().addAll(cesta)){
            throw new RuntimeException("Error al añadir las entradas en la lista de entradas");
        }
        fechaCompra = LocalDate.now();
        this.finCompra = true;
    }

    boolean isFinCompra() {
        return finCompra;
    }

    int getIdVenta() {
        return idVenta;
    }

    LocalDate getFechaCompra() {
        return fechaCompra;
    }

    TipoVenta getTipoVenta() {
        return tipoVenta;
    }
   
}
