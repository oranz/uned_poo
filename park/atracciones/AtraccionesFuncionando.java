// Declaración del paquete al que pertenece  la clase
package park.atracciones;

//Importación de clases y/o paquetes
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase requerida por el ejercicio que debe devolver el listado anual de las 
 * actracciones activas durante un año, así como realizar el cálculo de los
 * costes laborales de los empleados debido a las fluctuaciones.
 * @author corun
 */
public class AtraccionesFuncionando extends ArrayList<DiarioAtraccionesFuncionando>{
    
    /**
     * Se utiliza el patrón Singleton para que sólo exista una única lista de atracciones funcionando.
     */
    private AtraccionesFuncionando() {
    }
    private static AtraccionesFuncionando AtraccionesFuncionando;
    /**
     * Conforme al patrón Singleton se crea un método para devolver siempre la misma lista, si no existe se crea.
     * @return lista de atracciones funcionando
     */
    public static AtraccionesFuncionando getLista() {
        if (AtraccionesFuncionando == null) {
            AtraccionesFuncionando = new AtraccionesFuncionando();
        }
        return AtraccionesFuncionando;
    }
    
    /**
     * Método que devuelve una lista con todos los DiariosAtraccionesFuncionando del año indicado
     * @param anho año del que se quiere recibir todos los diarios.
     * @return Lista con todos los DiariosAtraccionesFuncionando del año solicitado
     */
    public List<DiarioAtraccionesFuncionando> getListadoAnual(int anho){
        return this.stream().filter(d -> d.getFecha().getYear()==anho).collect(Collectors.toList());
    }

    /**
     * Método para recuperar la lista de atracciones funcionando un día concreto
     * @param fecha fecha que se quiere recuperar
     * @return  ArrayList con las atracciones disponibles en la fecha indicada.
     */
    public ArrayList<Atraccion> getListadoAtraccionesDia(LocalDate fecha){
        return this.stream().filter(d -> d.getFecha().isEqual(fecha)).findFirst().get().getListaAtraccionesFuncionando();
    }

    /**
     * Método para recuperar el número de ayudantes de atracciones en una fecha específica.
     * @param fecha fecha para la que  se quiere comprobar el número de ayudantes necesarios
     * @return número de ayudantes necesario en el día solicitado.
     */
    public int getNumeroAyudantesAtracciones(LocalDate fecha){
        return this.getListadoAtraccionesDia(fecha).stream().mapToInt(a -> a.getNumeroAyudantes()).sum();
    }
    
    /**
     * Método para recuperar el número de responsables de atracciones en una fecha específica
     * @param fecha fecha para la que  se quiere comprobar el número de responsables necesarios
     * @return número de responsables necesario en el día solicitado.
     */
    public int getNumeroResponsablesAtracciones(LocalDate fecha){
        return this.getListadoAtraccionesDia(fecha).stream().mapToInt(a -> a.getNumeroResponsables()).sum();
    }

    /**
     * Método que calcula el número de RRPP necesarios en una fecha, en función de los ayudantes + responsables
     * @param fecha fecha  que se quiere comprobar
     * @return número de RRPP
     */
    public int getNumeroRelacionesPublicas(LocalDate fecha){
        return (getNumeroAyudantesAtracciones(fecha) + getNumeroResponsablesAtracciones(fecha))*10/100;
    }
    
    /**
     * Método que calcula el número de personal de Atención al cliente necesarios en una fecha, en función de los ayudantes + responsables
     * @param fecha fecha  que se quiere comprobar
     * @return número de empleados necesario
     */
    public int getNumeroAtencionCliente(LocalDate fecha){
        return (getNumeroAyudantesAtracciones(fecha) + getNumeroResponsablesAtracciones(fecha))*30/100;
    }
    
    /**
     * Método que calcula y devuelve el coste laboral para una fecha específica.
     * @param fecha  que se quiere comprobar
     * @return sumatorio de los costes por tipo de empelado
     */
    public int getCosteLaboraPorFecha(LocalDate fecha){
        int costeAyudantes, costeResponsables, costeRRPP, costeAtencionCliente;
        
        costeAyudantes = getNumeroAyudantesAtracciones(fecha) * 950;
        costeResponsables = getNumeroResponsablesAtracciones(fecha) * (950+(950*15/100));
        costeRRPP = getNumeroRelacionesPublicas(fecha) * (950+(950*20/100));
        costeAtencionCliente = getNumeroRelacionesPublicas(fecha) * (950+(950*10/100));
        
        return costeAyudantes+costeResponsables+costeRRPP+costeAtencionCliente;
    }

    /**
     * Método que calcula y devuelve el coste de los ayudantes durante un año natural
     * @param anho año que se quiere calcular
     * @return coste de los ayudantes durante el año indicado
     */
    public int getCosteAyudantesAnual(int anho){
        return this.stream().filter(d -> d.getFecha().getYear()==anho)
                .mapToInt(d -> d.getListaAtraccionesFuncionando().stream().mapToInt(a -> a.getNumeroAyudantes()).sum())
                .sum() * 950;
    }
    
    /**
     * Método que calcula y devuelve el coste de los responsables durante un año natural
     * @param anho año que se quiere calcular
     * @return coste de los reponsables durante el año indicado
     */
    public int getCosteResponsablesAnual(int anho){
        return this.stream().filter(d -> d.getFecha().getYear()==anho)
                .mapToInt(d -> d.getListaAtraccionesFuncionando().stream().mapToInt(a -> a.getNumeroResponsables()).sum())
                .sum() * (950+(950*15/100));
    }
    
    /**
     * Método que calcula y devuelve el coste de los responsables durante un año natural
     * @param anho año que se quiere calcular
     * @return coste de los RRPP durante el año indicado
     */
    public int getCosteRelacionesPublicasAnual(int anho){
        return ((getCosteAyudantesAnual(anho)+getCosteResponsablesAnual(anho)) * (10/100)) * (950+(950*20/100));
    }
    
    /**
     * Método que calcula y devuelve el coste de empleados de atención al cliente durante un año natural
     * @param anho año que se quiere calcular
     * @return  coste de los empleados de Atención al Cliente durante el año indicado
     */
    public int getCosteAtencionClienteAnual(int anho){
        return ((getCosteAyudantesAnual(anho)+getCosteResponsablesAnual(anho)) * (30/100)) * (950+(950*10/100));
    }
    
    /**
     * Método que calcula y devuelve el coste laboral total durante un año
     * @param anho año que se quiere calcular
     * @return coste de los empleados ddurante el año indicado
     */
    public int getCosteTotalAnual(int anho){
        return getCosteAyudantesAnual(anho) + getCosteResponsablesAnual(anho) 
                + getCosteRelacionesPublicasAnual(anho) + getCosteAtencionClienteAnual(anho);
    }
}
