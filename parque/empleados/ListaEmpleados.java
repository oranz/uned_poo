/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.empleados;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaEmpleados extends ArrayList<Empleado> {

    private ListaEmpleados() {

    }

    private static ListaEmpleados listaEmpleados;

    public static ListaEmpleados getListaEmpleados() {
        if (listaEmpleados == null) {
            listaEmpleados = new ListaEmpleados();
        }

        return listaEmpleados;
    }
    
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
