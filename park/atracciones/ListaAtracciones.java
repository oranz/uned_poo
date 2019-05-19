// Declaración del paquete al que pertenece  la clase
package park.atracciones;

//Importación de clases y/o paquetes
import java.util.ArrayList;
import park.empleados.TipoEmpleado;

/**
 * Clase con la lista de atracciones que están dadas de alta en el parque, no implica que estén activas.
 * @author corun
 */
public class ListaAtracciones extends ArrayList<Atraccion> {

    /**
     * Se crea con patrón Singleton para que sólo haya una lista
     */
    private ListaAtracciones() {
    }
    private static ListaAtracciones listaAtracciones;

    public static ListaAtracciones getListaAtracciones() {
        if (listaAtracciones == null) {
            listaAtracciones = new ListaAtracciones();
        }
        return listaAtracciones;
    }
    
    /**
     * @param cantidad Valor que determina la cantidad de veces que se debe crear la atracción.
     * @param tipoAtraccion Inica el tipo de clase que extiende de Atracción que se deberá crear.
     */
    
    public static void crearAtracciones(int cantidad, TipoAtraccion tipoAtraccion ){
        for (int i=0;i<cantidad;i++){
            switch (tipoAtraccion){
                case A:
                    getListaAtracciones().add(new AtraccionA());
                    break;
                    case B:
                    getListaAtracciones().add(new AtraccionB());
                    break;
                case C:
                    getListaAtracciones().add(new AtraccionC());
                    break;
                case D:
                    getListaAtracciones().add(new AtraccionD());
                    break;
                case E:
                    getListaAtracciones().add(new AtraccionE());
                    break;
            }
        }      
    }
    
   /**
     * @param tipoEmpleado El tipo de empleado sobre el que se calculará la cantidad necesaria.
     * @return Nuemero de empleados necesarios en base a las atracciones del parque.
     */
    protected static int getNumeroEmpleadosNecesarios(TipoEmpleado tipoEmpleado){
        
        int empleados = 0;
        
        switch(tipoEmpleado){
            case AyudanteAtraccion:
                empleados = getListaAtracciones().stream().mapToInt(a -> a.getNumeroAyudantes()).sum();         
                break;
            case ResponsableAtraccion:
                empleados = getListaAtracciones().stream().mapToInt(a -> a.getNumeroResponsables()).sum();
                break;
        }
        return empleados;
    }
    
}
