//Importación de clases y/o paquetes
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import park.atracciones.*;
import park.empleados.*;
import park.entradas.*;
import park.informes.*;
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
    public static final ListaAccesosParque listaAccesosParque = ListaAccesosParque.getListaAccesosParque();
    
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
           parque1.runRepositorioDatos();
           System.out.println(listaEntradas.size());
           System.out.println(parque1.getInformeNumeroVisitantes().getTotalAccesosParquePorMes(2019, 2));
           System.out.println(parque1.getInformeNumeroVisitantes().getTotalAccesosParqueAnual(2019));
           System.out.println(FIN_PROGRAMA);
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
        // se presupone que están todas las atracciones activas en el inicio del parque,
        // por lo que se añaden a la lista de AtraccionesFuncionando para el 1/1/2019
        DiarioAtraccionesFuncionando diarioAtraccionesFuncionando = new DiarioAtraccionesFuncionando(LocalDate.of(2019, 1, 1));
        diarioAtraccionesFuncionando.getListaAtraccionesFuncionando().addAll(ListaAtracciones.getListaAtracciones());
        AtraccionesFuncionando.getLista().add(diarioAtraccionesFuncionando);       
        
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
        entradaNoUtilizadaAnulada = entrada.isAnulada() && entrada.getFechaAcceso()==null;
        // Se comprueba que si es entrada de tarde la hora no sea las antes de las 16 horas.
        validoHora = (entrada.isAccesoTarde() && LocalDateTime.now().getHour()>=16)
                        || !entrada.isAccesoTarde();
        // Se comprueba que si la entrada es sólo día laborable no sea sábado o domingo.
        validoDia = !entrada.isSoloLaborable()
                || (LocalDate.now().getDayOfWeek()!=DayOfWeek.SUNDAY || LocalDate.now().getDayOfWeek()!= DayOfWeek.SATURDAY);
        
        // Si todas las validaciones son correctas se registra la entrada y se autoriza la entrada (devuelve true)
        if (perteneceTemporada && entradaNoUtilizadaAnulada && validoHora && validoDia){
            //se registra la entrada en la colección correspondiente.
            ListaAccesosParque.getListaAccesosParque().add(new AccesoParque(entrada));
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
        
        // Se hace la comprobación de acceso
        if (atraccion.acceder(entrada)){
            ListaAccesoAtracciones.getLista().add(new AccesoAtraccion(atraccion,entrada));
            return true;
        }
        return false;
    }
      
    /**
     * Método que creará datos simulados del parque.
     */
    public void runRepositorioDatos(){
        Venta ventaRepositorio = new ventaTaquilla();        
        FactoriaEntradas fe =  FactoriaEntradas.getInstance();  
        LocalDate fecha = LocalDate.of(2019, 1, 1);
        Random r = new Random();
        
        // Se crean entradas y usuarios
        System.out.println("Creando entradas y usuarios...");

        int control=1000;
        Entrada entrada=fe.generaEntrada(TipoEntrada.GENERAL_ADULTO, true, Temporada.MEDIA, null, new UsuarioAdulto(185));
        ventaRepositorio.getListaCesta().add(entrada);
        do{
            int random = r.nextInt(4);
            int alturaRandom = r.nextInt(50)+120;
            switch(random){
                case 0:
                    try{
                        entrada=fe.generaEntrada(TipoEntrada.TARDE_ADULTO, true, Temporada.MEDIA, null, new UsuarioAdulto(alturaRandom));
                    }catch (Exception e){}
                    break;
                case 1:
                    try{
                        entrada=fe.generaEntrada(TipoEntrada.LABORABLE_ADULTO, false, Temporada.ALTA, null, new UsuarioSenior(alturaRandom));
                    }catch (Exception e){}
                    break;
                case 2:
                    try{
                        entrada=fe.generaEntrada(TipoEntrada.GENERAL_ADULTO, false, Temporada.BAJA, null, new UsuarioAdulto(alturaRandom));
                    }catch (Exception e){}
                    break;
                case 3:
                    try{
                        Entrada entradaAdulto = ListaEntradas.getListaEntradas().stream().filter(e -> e.isEntradaAdulto()).findAny().get();
                        entrada=fe.generaEntrada(TipoEntrada.LABORABLE_INFANTIL, true, null, entradaAdulto, new UsuarioAdulto(alturaRandom));
                    }catch (Exception e){}
                    break;                        
            }

            ventaRepositorio.getListaCesta().add(entrada);
            control--;
        }while(control>0);

        ventaRepositorio.finCompra();
        
        // Se simulan entradas al parque
        System.out.println("Creando accesos al parque...");
        fecha =  LocalDate.of(2019, 1, 1);
        for (int i=0; i< ListaEntradas.getListaEntradas().size();i++){
            try{
                ListaAccesosParque.getListaAccesosParque().add(new AccesoParque(ListaEntradas.getListaEntradas().get(i),fecha));
            }catch(Exception e){}
            if(r.nextInt(7)==3){
                fecha=fecha.plusDays(1);
            }
        }
        
        
        // Se simulan atracciones activas por día
        System.out.println("Creando simulación de atracciones activas por día...");
        fecha =  LocalDate.of(2019, 1, 2);
        do{
            DiarioAtraccionesFuncionando temporal = new DiarioAtraccionesFuncionando(fecha);
            for (int i=0; i< ListaAtracciones.getListaAtracciones().size();i++){
                if(r.nextInt(7)==3){
                    temporal.getListaAtraccionesFuncionando().add(ListaAtracciones.getListaAtracciones().get(i));
                }
            }
            AtraccionesFuncionando.getLista().add(temporal);
            fecha=fecha.plusDays(1);
        }while(fecha.getYear()!=2020);
            
        
        // Se simulan accesos a las atracciones
//        try{
//            fecha =  LocalDate.of(2019, 1, 1);
//            
//            Atraccion atraccion = AtraccionesFuncionando.getLista().getListadoAtraccionesDia(fecha).get(r.nextInt(7));
//            Entrada entrada = ListaEntradas.getListaEntradas().stream().filter(e -> e.getFechaAcceso().toLocalDate().isEqual(fecha)).findAny().get();
//            for (int i=0; i< ListaEntradas.getListaEntradas().size();i++){
//                LocalDate fechaTemp = fecha;
//                ListaAccesosParque.getListaAccesosParque().add(new AccesoParque(ListaEntradas.getListaEntradas().get(i),fecha));
//                if(r.nextInt(7)==3){
//                    fecha.plusDays(1);
//                }
//            }
//        }catch(Exception e){
//            
//        }
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
    
    /**
     * Método que devuelve un objeto InformeNumeroVisitantes que permite 
     * generar datos con sus métodos para recuperar los datos necesarios
     * para hacer estadísticas.
     * @return devuelve un objeto InformeNumeroVisitantes.
     */
    public InformeNumeroVisitantes getInformeNumeroVisitantes(){
        return new InformeNumeroVisitantes();
    }
    
    /**
     * Método para recuperar la lista de atracciones funcionando
     * por cada día. Con los diversos métodos se puede conseguir
     * el número de empleado y costes laborales.
     * @return Lista de atracciones funcionando.
     */
    public AtraccionesFuncionando getAtraccionesFuncionando(){
        return AtraccionesFuncionando.getLista();
    }
}
