
package bancoblueDominio;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * La clase Operacion representa una operación financiera en un banco.
 * Puede ser una transacción, un retiro, una transferencia.
 * Contiene atributos que describen la operación y sus detalles.
 * 
 * @author Jorge Zamora, Victoria Vega
 */
public class Operacion {
    
    //Atributos de la operacion
    private long codigo;
    private double monto;
    private String motivo;
    private String tipo;
    private Timestamp fechaCreacion;
    private long codigoCuenta;
    
    //Atributos del retiro sin cuenta
    private String estado;
    private long folio;
    private int contrasenia;

    //Atributos de la transferencia
    private long numCuentaDestino;

    /**
     * Constructor por defecto de la clase Operacion.
     */
    public Operacion() {
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, String estado, long folio, long numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.numCuentaDestino = numCuentaDestino;
    }
    
    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, String estado, long folio,long numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.numCuentaDestino = numCuentaDestino;
        this.estado = estado;
        this.folio = folio;
    }
    
    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param contrasenia       La contraseña del perfil del cliente.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia, long numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }
    
    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param contrasenia       La contraseña del perfil del cliente.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, String estado, long folio, int contrasenia, long numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param contrasenia       La contraseña del perfil del cliente.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia, long numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param contrasenia       La contraseña del perfil del cliente.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param estado            El estado de la operación.
     * @param folio             El folio de la operación.
     * @param contrasenia       La contraseña del perfil del cliente.
     */
    public Operacion(double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param codigo            El código de la operación.
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(long codigo, double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, long numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Constructor que inicializa los atributos de la operación.
     * 
     * @param monto             El monto de la operación.
     * @param motivo            El motivo de la operación.
     * @param tipo              El tipo de operación.
     * @param fechaCreacion     La fecha de creación de la operación.
     * @param codigoCuenta      El código de la cuenta asociada a la operación.
     * @param numCuentaDestino  El número de cuenta de destino en caso de transferencia.
     */
    public Operacion(double monto, String motivo, String tipo, Timestamp fechaCreacion, long codigoCuenta, long numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Método getter para obtener el tipo de la operación.
     * 
     * @return El tipo de la operación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el tipo de la operación.
     * 
     * @param tipo El nuevo tipo de la operación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método getter para obtener el código de la operación.
     * 
     * @return El código de la operación.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la operación.
     * 
     * @param codigo El nuevo código de la operación.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el monto de la operación.
     * 
     * @return El monto de la operación.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método setter para establecer el monto de la operación.
     * 
     * @param monto El nuevo monto de la operación.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Método getter para obtener el motivo de la operación.
     * 
     * @return El motivo de la operación.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Método setter para establecer el motivo de la operación.
     * 
     * @param motivo El nuevo motivo de la operación.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Método getter para obtener la fecha de creación de la operación.
     * 
     * @return La fecha de creación de la operación.
     */
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método setter para establecer la fecha de creación de la operación.
     * 
     * @param fechaCreacion La nueva fecha de creación de la operación.
     */
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método getter para obtener el código de la cuenta asociada a la operación.
     * 
     * @return El código de la cuenta asociada a la operación.
     */
    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Método setter para establecer el código de la cuenta asociada a la operación.
     * 
     * @param codigoCuenta El nuevo código de la cuenta asociada a la operación.
     */
    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    /**
     * Método getter para obtener el estado de la operación (en el caso de retiros sin cuenta).
     * 
     * @return El estado de la operación.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado de la operación (en el caso de retiros sin cuenta).
     * 
     * @param estado El nuevo estado de la operación.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener el folio de la operación (en el caso de retiros sin cuenta).
     * 
     * @return El folio de la operación.
     */
    public long getFolio() {
        return folio;
    }

    /**
     * Método setter para establecer el folio de la operación (en el caso de retiros sin cuenta).
     * 
     * @param folio El nuevo folio de la operación.
     */
    public void setFolio(long folio) {
        this.folio = folio;
    }

    /**
     * Método getter para obtener la contraseña de la operación.
     * 
     * @return La contraseña de la operación.
     */
    public int getContrasenia() {
        return contrasenia;
    }

    /**
     * Método setter para establecer la contraseña de la operación.
     * 
     * @param contrasenia La nueva contraseña de la operación.
     */
    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método getter para obtener el número de cuenta de destino (en el caso de transferencias).
     * 
     * @return El número de cuenta de destino.
     */
    public long getNumCuentaDestino() {
        return numCuentaDestino;
    }

    /**
     * Método setter para establecer el número de cuenta de destino (en el caso de transferencias).
     * 
     * @param numCuentaDestino El nuevo número de cuenta de destino.
     */
    public void setNumCuentaDestino(long numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }


    
}
