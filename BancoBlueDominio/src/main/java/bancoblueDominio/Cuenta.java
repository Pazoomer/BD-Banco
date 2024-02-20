
package bancoblueDominio;

import java.time.LocalDateTime;

/**
 * La clase Cuenta representa una cuenta en un banco, con información sobre su saldo, fecha de apertura,
 * número de cuenta, identificación del cliente asociado y estado actual.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class Cuenta {
    private long codigo;
    private double saldo;
    private LocalDateTime fechaApertura;
    private long numeroCuenta;
    private long idCliente;
    private String estado;

    /**
     * Constructor por defecto de la clase Cuenta. Crea una instancia de Cuenta sin inicializar
     * los atributos.
     */
    public Cuenta() {
    }
    
    /**
     * Constructor que inicializa algunos atributos de la cuenta.
     * 
     * @param saldo           El saldo inicial de la cuenta.
     * @param fechaApertura   La fecha de apertura de la cuenta.
     * @param numeroCuenta    El número de cuenta único.
     * @param estado          El estado actual de la cuenta.
     */
    public Cuenta(double saldo, LocalDateTime fechaApertura, long numeroCuenta, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
    }
    
    /**
     * Constructor que inicializa algunos atributos de la cuenta, incluyendo la identificación del cliente.
     * 
     * @param saldo           El saldo inicial de la cuenta.
     * @param fechaApertura   La fecha de apertura de la cuenta.
     * @param numeroCuenta    El número de cuenta único.
     * @param idCliente       La identificación única del cliente asociado a la cuenta.
     * @param estado          El estado actual de la cuenta.
     */
    public Cuenta(double saldo, LocalDateTime fechaApertura, long numeroCuenta, long idCliente, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.estado=estado;
    }
    
    /**
     * Constructor que inicializa todos los atributos de la cuenta, incluyendo el código único.
     * 
     * @param codigo          El código único de la cuenta.
     * @param saldo           El saldo inicial de la cuenta.
     * @param fechaApertura   La fecha de apertura de la cuenta.
     * @param numeroCuenta    El número de cuenta único.
     * @param idCliente       La identificación única del cliente asociado a la cuenta.
     * @param estado          El estado actual de la cuenta.
     */
    public Cuenta(long codigo, double saldo, LocalDateTime fechaApertura, long numeroCuenta, long idCliente, String estado) {
        this.codigo = codigo;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.estado=estado;
    }

    /**
     * Método getter para obtener el estado actual de la cuenta.
     * 
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado actual de la cuenta.
     * 
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener el identificador único del cliente asociado a la cuenta.
     * 
     * @return El identificador único del cliente.
     */
    public long getIdCliente() {
        return idCliente;
    }

    /**
     * Método setter para establecer el identificador único del cliente asociado a la cuenta.
     * 
     * @param idCliente El nuevo identificador único del cliente.
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método getter para obtener el saldo actual de la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método setter para establecer el saldo de la cuenta.
     * 
     * @param saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método getter para obtener la fecha y hora de apertura de la cuenta.
     * 
     * @return La fecha y hora de apertura de la cuenta.
     */
    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método setter para establecer la fecha y hora de apertura de la cuenta.
     * 
     * @param fechaApertura La nueva fecha y hora de apertura de la cuenta.
     */
    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método getter para obtener el número único de la cuenta.
     * 
     * @return El número único de la cuenta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método setter para establecer el número único de la cuenta.
     * 
     * @param numeroCuenta El nuevo número único de la cuenta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método getter para obtener el código único de la cuenta.
     * 
     * @return El código único de la cuenta.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código único de la cuenta.
     * 
     * @param codigo El nuevo código único de la cuenta.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método toString que devuelve una representación en cadena de la cuenta.
     * 
     * @return Una cadena que representa la cuenta y sus atributos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("codigo=").append(codigo);
        sb.append(", saldo=").append(saldo);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
