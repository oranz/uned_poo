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
    
    /**
     * Método para añadir una entrada a la cesta de la compra de esta venta.
     * @param tipoEntrada el tipo de entrada que se va a crear
     * @param VIP true si adquiere complemento VIP, false si no tiene. En caso de entrada infantil puede ser null porque cogerá el dato de la entrada del adulto.
     * @param temporada la temporada para la que compra la entrada. En caso de entrada infantil puede ser null porque cogerá el dato de la entrada del adulto.
     * @param entradaAdultoAsociada si es entrada de adulto será null, si es entrada infantil deberá indicarse una entrada de adulto
     * @param usuario usuario asociado a la entrada
     * @throws RuntimeException si la compra ya ha finalizado, ya que no se podrá añadir ninguna entrada más en esta compra.
     */
    public void addEntrada(TipoEntrada tipoEntrada,boolean VIP, Temporada temporada, Entrada entradaAdultoAsociada,Usuario usuario) throws RuntimeException{
        if(isFinCompra()){
            throw new RuntimeException("No se puede añadir entrada, la venta ha sido finalizada");
        }
        cesta.add(FactoriaEntradas.getInstance().generaEntrada(tipoEntrada, VIP, temporada, entradaAdultoAsociada, usuario));
    }

    /**
     * Método que finaliza una venta, incorporando las entradas de la cesta en la lista de entradas
     * y devuelve el importe a cobrar.
     * @return importe total a cobrar por las entradas adquiridas.
     * @throws RuntimeException bien porque la compra ya ha finalizado o porque hubo un error al añadir las entradas de la centas en la lista de entradas vendidas
     */
    public int finCompra() throws RuntimeException{
        if (this.isFinCompra()){
            throw new RuntimeException ("Esta compra ya se ha finalizado previamente.");
        }
        if(!ListaEntradas.getListaEntradas().addAll(cesta)){
            throw new RuntimeException("Error al añadir las entradas en la lista de entradas");
        }
        fechaCompra = LocalDate.now();
        this.finCompra = true;
        return this.cesta.stream().mapToInt(e -> e.getImporteTotal()).sum();
    }

    /**
     * Método para comprobar si ya se ha finalizado la venta
     * @return true si la venta ya finalizó, false si la venta está pendiente de finalizar
     */
    public boolean isFinCompra() {
        return finCompra;
    }

    /**
     * Método para devolver el identificador único de la venta
     * @return devuelve el ID de la venta.
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Método para recuperar la fecha de la compra
     * @return devuelve la fecha de finalización de la compra.
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     *  Método para devolver el tipo de venta que se ha realizado
     * @return devuelve el tipo de venta realizado: taquilla (implementado) o ecommerce (no implementado)
     */
    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }
   
    /**
     * Método que devuelve la cesta con las entradas de la venta
     * @return devuelve una lista con las entradas de la venta.
     */
    public ArrayList<Entrada> getListaCesta(){
        return this.cesta;
    }
}
