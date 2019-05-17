/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import park.atracciones.ListaAtracciones;
import park.atracciones.TipoAtraccion;
import park.empleados.ListaEmpleados;
import park.entradas.ListaEntradas;
import park.usuarios.ListaUsuarios;
import park.ventas.ListaVentas;
import park.ventas.TipoVenta;
import park.ventas.Venta;

/**
 *
 * @author corun
 */
public class parque {
    // Listas estáticas
    public static final ListaEntradas listaEntradas = ListaEntradas.getListaEntradas();
    public static final ListaAtracciones listaAtracciones = ListaAtracciones.getListaAtracciones();
    public static final ListaEmpleados listaEmpleados = ListaEmpleados.getListaEmpleados();
    public static final ListaVentas listaVentas = ListaVentas.getListaVentas();
    public static final ListaUsuarios listaUsuarios = ListaUsuarios.getListaUsuarios();
    
    // Constantes
    private final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_A=4;
    private final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_B=6;
    private final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_C=4;
    private final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_D=3;
    private final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_E=7;
    
    // Constanes de mensajes
    private final String CONSTRUYENDO_PARQUE = "Iniciando la construcción del parque:\n"
                                            + "- Construyendo atracciones...\n";
    private final String ATRACCIONES_CONSTRUIDAS = "\tSe han construido las atracciones...\n"
                                            + "- Contratando empleados...";
    private final String EMPLEADOS_CONTRATADOS = "\tSe han contratado a los empleados...\n"
                                            + "- Ultimando apertura...\n";
    private final String PARQUE_INAUGURADO = "El parque ya está funcionando.\n";
    private final static String FIN_PROGRAMA = "Fin de programa";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           parque parque1 = new parque();
           System.out.print(FIN_PROGRAMA);
    }
    
    /**
     * En el constructor del parque se inicia con las atracciones indicadas en el ejercicio
     * a fecha 1/enero/2019 (fecha en la que decido iniciar el parque) con todos los empleados
     * necesarios para su puesta en marcha.
     */
    public parque(){
        
        System.out.print(CONSTRUYENDO_PARQUE);
        
        // Se añaden las atracciones iniciales indicadas en el punto 2 de la práctica
        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_A,TipoAtraccion.A);
        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_B,TipoAtraccion.B);
        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_C,TipoAtraccion.C);
        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_D,TipoAtraccion.D);
        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_E,TipoAtraccion.E);
        
        System.out.print(ATRACCIONES_CONSTRUIDAS);
        
        // Dado que en el mismo punto se indica el porcentaje de empleados necesarios,
        // se presupone que están todas las atracciones activas en el inicio del parque.
        
        
        System.out.print(EMPLEADOS_CONTRATADOS);
        
        System.out.print(PARQUE_INAUGURADO);
        
    }
    
    public Venta comprarEntradaTaquilla(boolean complementoVIP){  
        Venta nuevaVenta = null;
        try{
            nuevaVenta= ListaVentas.getListaVentas().addVenta(TipoVenta.TAQUILLA);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return nuevaVenta;
    }
    
    public ListaAtracciones getListaAtracciones(){
        return parque.listaAtracciones;
    }
    public ListaEmpleados getListaEmpleados(){
        return parque.listaEmpleados;
    }
    public ListaEntradas getListaEntradas(){
        return parque.listaEntradas;
    }
    public ListaVentas getListaVentas(){
        return parque.listaVentas;
    }   
    
    public ListaUsuarios getListaUsuarios(){
        return parque.listaUsuarios;
    }  
    
    /**
     * Método que creará datos simulados del parque.
     */
    public void runRepositorioDatos(){
        
    }
}
