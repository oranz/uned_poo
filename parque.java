//Importación de clases y/o paquetes
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import park.atracciones.*;
import park.empleados.*;
import park.entradas.*;
import park.usuarios.*;
import park.ventas.*;

/**
 * La clase parque es la clase principal de la aplicación.
 * Contempla los métodos principales de las tareas a realizar in situ, como son
 * venta directa por taquilla, acceso al parque o acceso a las atracciones.
 * @author Oscar Ranz Rumbo
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
                                            + "- Contratando empleados...\n";
    private final String EMPLEADOS_CONTRATADOS = "\tSe han contratado a los empleados...\n"
                                            + "- Ultimando apertura...\n";
    private final String PARQUE_INAUGURADO = "El parque ya está funcionando.\n";
    private final static String FIN_PROGRAMA = "Fin de programa\n";
    
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
    
    /**
     * Método para comprar entrada directamente en la taquilla del parque
     * @return Venta, a la que se podrá añadir las entradas y finalizar su venta.
     */
    public Venta comprarEntradaTaquilla(){  
        Venta nuevaVenta = null;
        try{
            nuevaVenta= ListaVentas.getListaVentas().addVenta(TipoVenta.TAQUILLA);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return nuevaVenta;
    }
    
    /**
     * Es el control de acceso al parque en función de la entrada disponible.
     * @param entrada la entrada con la que se comprobará si dispone o no de acceso al parque en ese momento.
     * @return boolean, devuelve verdadero si cumple los requisitos de acceso, falso en caso contrario.
     */
    public boolean accesoParque(Entrada entrada){
        
        boolean perteneceTemporada, entradaNoUtilizadaAnulada, validoHora, validoDia;
        // Se comprueba que la entrada pertenece a la temporada actual
        perteneceTemporada=entrada.getTemporada()==temporadaActual();
        // Se comprueba que la entrada no ha sido anulada o ya ha sido utilizada.
        entradaNoUtilizadaAnulada = entrada.isAnulada();
        // Se comprueba que si es entrada de tarde la hora no sea las antes de las 16 horas.
        validoHora = (entrada.isAccesoTarde() && LocalDateTime.now().getHour()>=16)
                        || !entrada.isAccesoTarde();
        // Se comprueba que si la entrada es sólo día laborable no sea sábado o domingo.
        validoDia = !entrada.isSoloLaborable()
                || (LocalDate.now().getDayOfWeek()!=DayOfWeek.SUNDAY || LocalDate.now().getDayOfWeek()!= DayOfWeek.SATURDAY);
        
        // Si todas las validaciones son correctas se registra la entrada y se autoriza la entrada (devuelve true)
        if (perteneceTemporada && entradaNoUtilizadaAnulada && validoHora && validoDia){
            //se registra la entrada en la colección correspondiente.
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método para acceder a las atracciones. Comprueba si el usuario estaba en el parque y cumple con los requisitos de la atracción.
     * @param atraccion la atracción a la que se quiere acceder
     * @param entrada la entrada con la que se determina si dispone de VIP y el usuario para compobar si cumple altura y otros.
     * @return 
     */
    public boolean accesoAtraccion(Atraccion atraccion, Entrada entrada){
        return false;
    }
    
      
    /**
     * Método que creará datos simulados del parque.
     */
    public void runRepositorioDatos(){
        
    }

    /**
     * Se calcula la temporada en base a la fecha actual del sistema
     * @return temporada actual.
     */
    private Temporada temporadaActual() {
        LocalDate fechaActual = LocalDate.now();
        
        if ((fechaActual.getMonthValue()==1 && fechaActual.getDayOfMonth()<9)
            || fechaActual.getMonthValue()==4 //Semana Santa de 2019 ha coincidido en abril.
            || fechaActual.getMonthValue()==8
            || fechaActual.getMonthValue()==12){
            return Temporada.ALTA;
        }else if(fechaActual.getMonthValue()==2
                || fechaActual.getMonthValue()==11){
            return Temporada.BAJA;
        }else{
            return Temporada.MEDIA;
        }

    }
}
