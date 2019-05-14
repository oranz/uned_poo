/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import parque.atracciones.ListaAtracciones;
import parque.empleados.ListaEmpleados;
import parque.entradas.ListaEntradas;
import parque.usuarios.ListaUsuarios;
import parque.ventas.ListaVentas;
import parque.ventas.TipoVenta;
import parque.ventas.Venta;

/**
 *
 * @author corun
 */
public class parque {
    
    public static final ListaEntradas listaEntradas = ListaEntradas.getListaEntradas();
    public static final ListaAtracciones listaAtracciones = ListaAtracciones.getListaAtracciones();
    public static final ListaEmpleados listaEmpleados = ListaEmpleados.getListaEmpleados();
    public static final ListaVentas listaVentas = ListaVentas.getListaVentas();
    public static final ListaUsuarios listaUsuarios = ListaUsuarios.getListaUsuarios();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Constantes locales
//        final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_A=4;
//        final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_B=6;
//        final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_C=4;
//        final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_D=3;
//        final int CANTIDAD_ATRACCIONES_INICIALES_TIPO_E=7;
//        
//        final String TEXTO_INICIALIZANDO_APLICACION = "Inicializando la aplicación Parque de atracciones.\n"
//                + "-------------------------------------------------";
//        final String TEXTO_CREACION_ATRACCIONES_INICIALES = "Se inicia la creación de"
//                + " atracciones requeridas (%d tipo A, %d tipo B, %d tipo C, %d tipo D"
//                + "(sobreentiendo que hay una errata en el enunciado) y %d tipo E.\n";
//        final String TEXTO_FIN_CREACION_ATRACCIONES_INICIALES = "Se han creado las atracciones.";
//        final String TEXTO_RECORDATORIO_ACTIVACION_PARQUES = "Se debe proceder a la activación de los parques y"
//                + " contratación de los empleados para iniciar la actividad del parque.";
//        
//        // Variables locales
//        int ayudantesNecesarios, responsablesNecesarios, atencionClientesNecesarios, relacionesNecesarios;
//        
//        // Inicio de las acciones de carga de la aplicación
//        // Mensaje bienvenida
//        System.out.println(TEXTO_INICIALIZANDO_APLICACION);
//        
//        // Inicio de la creación de las atracciones inciales
//        System.out.printf(TEXTO_CREACION_ATRACCIONES_INICIALES,
//                CANTIDAD_ATRACCIONES_INICIALES_TIPO_A,
//                CANTIDAD_ATRACCIONES_INICIALES_TIPO_B,
//                CANTIDAD_ATRACCIONES_INICIALES_TIPO_C,
//                CANTIDAD_ATRACCIONES_INICIALES_TIPO_D,
//                CANTIDAD_ATRACCIONES_INICIALES_TIPO_E);
//        
//        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_A,TipoAtraccion.A);
//        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_B,TipoAtraccion.B);
//        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_C,TipoAtraccion.C);
//        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_D,TipoAtraccion.D);
//        ListaAtracciones.crearAtracciones(CANTIDAD_ATRACCIONES_INICIALES_TIPO_E,TipoAtraccion.E);
//        
//        System.out.println(TEXTO_FIN_CREACION_ATRACCIONES_INICIALES);
//        
//        // Inicio de la creación de empleados necesario para el inicio del parque.
//        System.out.println(TEXTO_RECORDATORIO_ACTIVACION_PARQUES);
//        
//       
//        System.out.println(ListaEntradas.getListaEntradas().isEmpty());
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
}
