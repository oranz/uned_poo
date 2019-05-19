/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.empleados;

import java.util.ArrayList;

/**
 * clase que contiene la lista de los empleados que han trabajado o se pueden contratar y asignar.
 * @author corun
 */
public class ListaEmpleados extends ArrayList<Empleado> {

    /**
     * Uso de patrón Singleton para que sólo haya una lista.
     */
    private ListaEmpleados() {

    }

    private static ListaEmpleados listaEmpleados;

    public static ListaEmpleados getListaEmpleados() {
        if (listaEmpleados == null) {
            listaEmpleados = new ListaEmpleados();
        }

        return listaEmpleados;
    }
    
    /**
     * Uso del patrón factory para crear los distintos tipos de empleado.
     * @param cantidad numero de empleados a crear del tipo indicado
     * @param tipoEmpleado tipo de empleado a generar
     */
    public static void crearEmpleados(int cantidad, TipoEmpleado tipoEmpleado){
        for (int i=0; i<cantidad;i++){
            switch(tipoEmpleado){
                case AtencionCliente:
                    getListaEmpleados().add(new AtencionCliente());
                    break;
                case RelacionesPublicas:
                    getListaEmpleados().add(new RelacionesPublicas());
                    break;
                case AyudanteAtraccion:
                    getListaEmpleados().add(new AyudanteAtraccion());
                    break;
                case ResponsableAtraccion:
                    getListaEmpleados().add(new ResponsableAtraccion());
                    break;
            }
        }
    }

}
