// Declaración del paquete al que pertenece  la clase
package park.entradas;

//Importación de clases y/o paquetes
import java.time.LocalDateTime;
import java.util.ArrayList;
import park.usuarios.TipoUsuario;
import park.usuarios.Usuario;
import park.usuarios.UsuarioInfantil;
import park.ventas.Bonificacion;

/**
 * Clase base Entrada, de la que extenderán el resto de clases tipo Entrada.
 * @author Oscar Ranz Rumbo
 */
public abstract class Entrada {
    
    // Declaración de constantes y varibles
    private final int precioBase = 60;
    private final int precioVIP = 50;
    private final int porcentajeTemporadaAlta = -15;
    private final int procentajeTemporadaBaja = 15;
    private final boolean VIP;
    private final Temporada temporada;
    private final Usuario Usuario;
    private final boolean accesoTarde;
    private final boolean soloLaborable;
    private LocalDateTime fechaAcceso;
    private boolean anulada;
    private final int idEntrada;
    private static int ultimoIDEntrada;
    private final Entrada entradaAdultoAsociada;
    private final ArrayList<Bonificacion> bonificaciones = new ArrayList<>();
    
    /**
     * Constructor para entradas adulto
     * @param VIP true si adquiere VIP false si no lo adquiere
     * @param temporada temporada para la que se compró la entrada
     * @param accesoTarde true si la entrada sólo es válida por la tarde, false vale todo el día
     * @param soloLaborable true si sólo vale de Lu a Vi y false vale para toda la semana.
     * @param usuario  usuario al que está asociada la entrada.
     */
    protected Entrada( boolean VIP, Temporada temporada, boolean accesoTarde, boolean soloLaborable, Usuario usuario) {
        this.VIP = VIP;
        this.temporada = temporada;
        this.Usuario = usuario;
        this.accesoTarde = accesoTarde;
        this.soloLaborable = soloLaborable;
        this.anulada = false;
        this.idEntrada=ultimoIDEntrada++;
        this.entradaAdultoAsociada = null;
        
        // Se añaden bonificación si es senior y otras
        if (usuario.getTipoUsuario()==TipoUsuario.SENIOR){
            this.addBonificacion(new Bonificacion(35,"Bonificación senior"));
        }     
        this.addBonificacionTemporada(temporada);
    }
    
    /**
     * Constructor para entradas infantiles-
     * La mayor parte de los datos de la entrada se obtienen de la entrada del adulto asociado.
     * @param entradaAdultoAsociada entrada del adulto que acompaña al menor
     * @param usuarioInfantil usuario infantil al que se le asocia la entrada
     */
    protected Entrada (Entrada entradaAdultoAsociada, UsuarioInfantil usuarioInfantil){
        this.VIP = entradaAdultoAsociada.VIP;
        this.accesoTarde = entradaAdultoAsociada.accesoTarde;
        this.soloLaborable = entradaAdultoAsociada.soloLaborable;
        this.temporada = entradaAdultoAsociada.temporada;
        this.Usuario = usuarioInfantil;
        this.anulada = false;
        this.idEntrada=ultimoIDEntrada++;
        this.entradaAdultoAsociada = entradaAdultoAsociada;
        // Se añaden las bonificaciones
        this.addBonificacion(new Bonificacion(50,"Bonificación Infantil"));
        this.addBonificacionTemporada(temporada);
    }

    /**
     * Método para comprobar el precio base de la entrada
     * @return devuelve el precio base de la entrada
     */
    public int getPrecioBase() {
        return precioBase;
    }

    /**
     * Método para comprobar el precio del complemento VIP
     * @return devuelve el precio del complemento VIP
     */
    public int getPrecioVIP() {
        return precioVIP;
    }

    /**
     * Método para determinar si la entrada se adquirió con suplemento VIP
     * @return true si tiene VIP false si no tiene acceso VIP
     */
    public boolean isVIP() {
        return VIP;
    }

    /**
     * Método para obterner la temprada para la que se adquirió la entrada
     * @return devuelve la temporada de la entrada
     */
    public Temporada getTemporada() {
        return temporada;
    }

    /**
     * Método para obtener el usuario asociado a la entrada
     * @return devuelve el usuario asociado a la entrada
     */
    public Usuario getUsuario() {
        return Usuario;
    }

    /**
     * Método para determinar si la entrada es sólo de tarde
     * @return true la entrada sólo es de tarde, false la entrada es para todo el día
     */
    public boolean isAccesoTarde() {
        return accesoTarde;
    }

    /**
     * Método para determinar si la entrada es sólo para días laborables
     * @return true si es sólo de Lu a Vi, false para cualquier día de la semana.
     */
    public boolean isSoloLaborable() {
        return soloLaborable;
    }
    
    /**
     * Método para determinar la fecha en la que se accedió a la atracción con esta entrada.
     * @return fecha en la que se ha accedido al parque o null si no se ha accedido todavía con esta entrada.
     */
    public LocalDateTime getFechaAcceso() {
        return fechaAcceso;
    }

    /**
     * Método para establecer el día de acceso al parque con esta entrada
     * @param fechaAcceso LocalDate con la fecha en la que se accede al parque con la entrada.
     */
    void setFechaAcceso(LocalDateTime fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    /**
     * Método que determina si una entrada ha sido anulada
     * @return true si está anulada false si es válida
     */
    public boolean isAnulada() {
        return anulada;
    }

    /**
     * Método para anular una entrada, ya sea por devolución o por motivos disciplinarios u otros.
     * @param anulada true para anular la entrada false para activar la entrada
     */
    void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    /**
     * Método para obtener el Identificador único asociado a la entrada.
     * @return devuelve el ID de la entrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * Método para determinar si es una entrada de adulto
     * @return true si la entrada es de adulto, false si es entrada infantil
     */
    public boolean isEntradaAdulto(){
        return this.entradaAdultoAsociada == null;
    }
    
    /**
     * Método para obtener la entrada asociada de un adulto en caso de ser entrada infantil.
     * @return devuelve la entrada del adulto responsable del menor, null si es una entrada de adulto.
     */
    public Entrada getEntradaAdultoAsociada() {
        return this.entradaAdultoAsociada;
    }     
    
    /**
     * Método para añadir bonificaciones a la entrada.
     * @param bonificacion bonificación a aplicar
     */
    public final void addBonificacion(Bonificacion bonificacion){
        this.bonificaciones.add(bonificacion);
    }
    
    /**
     * Método para eliminar bonificaciones a al entrada
     * @param indice posición de la bonificación a eliminar en el array
     */
    public void removeBonificacion(int indice){
        this.bonificaciones.remove(indice);
    }
    
    /**
     * Método para recuperar las bonificaciones asociadas a la entrada
     * @return lista de bonificaciones asociada a la entrada.
     */
    public ArrayList<Bonificacion> getlistaBonificaciones(){
        return this.bonificaciones;
    }
    
    /**
     * Método para añadir la bonificación o penalización de la temporada.
     * @param temporada temporada de la entrada.
     */
    private void addBonificacionTemporada(Temporada temporada){
        // Se añade penalización por temporada alta o bonificación por temporada baja
        if(temporada== Temporada.ALTA){
            this.addBonificacion(new Bonificacion(porcentajeTemporadaAlta,"Temporada alta"));
        }else if (temporada == Temporada.BAJA){
            this.addBonificacion(new Bonificacion(procentajeTemporadaBaja,"Temporada baja"));
        }
    }
    
    /**
     * Método para recuperar el importe total de la entrada
     * @return devuelve el importe total de la entrada, se tiene en cuenta el importe mínimo según temporada.
     */
    public int getImporteTotal(){
        int sumatorio, descuentos;
        descuentos = this.getlistaBonificaciones().stream().mapToInt(b -> b.getPorcentajeBonificacion()).sum();
        sumatorio = getPrecioBaseTemporada();
        // El descuento no puede ser mayor de un 90% del precio de la temporada.
        if (descuentos > 90){
            descuentos = 90;
        }
        sumatorio -= (sumatorio * descuentos) / 100;        
        return sumatorio;
    }
      
    /**
     * Método para calcular el precio base según la temporada
     * @return devuelve el precio base según la temporada.
     */
    private int getPrecioBaseTemporada(){
        int calculo;
        switch (this.temporada) {
            case ALTA:
                calculo=((this.precioBase * porcentajeTemporadaAlta)/100)+this.precioBase;
            case BAJA:
                calculo=((this.precioBase * procentajeTemporadaBaja)/100)+this.precioBase;
            default:
                calculo=this.getPrecioBase();
        }
        return calculo;
    }
}
