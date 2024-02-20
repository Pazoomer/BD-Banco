
package bancoBluePersistencia.dtos.cuenta;

import java.time.LocalDateTime;

/**
 * Clase que representa un DTO (Data Transfer Object) para actualizar una cuenta.
 * Contiene información como el código de cuenta, saldo, fecha de apertura, número de cuenta, ID del cliente y estado.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaActualizableDTO {

    private long codigo;
    private double saldo;
    private LocalDateTime fechaApertura;
    private long numeroCuenta;
    private long idCliente;
    String estado;

    /**
     * Método getter para obtener el estado de la cuenta.
     * 
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado de la cuenta.
     * 
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener el código de la cuenta.
     * 
     * @return El código de la cuenta.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la cuenta.
     * 
     * @param codigo El nuevo código de la cuenta.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el saldo de la cuenta.
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
     * Método getter para obtener la fecha de apertura de la cuenta.
     * 
     * @return La fecha de apertura de la cuenta.
     */
    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método setter para establecer la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura La nueva fecha de apertura de la cuenta.
     */
    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método getter para obtener el número de cuenta.
     * 
     * @return El número de cuenta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método setter para establecer el número de cuenta.
     * 
     * @param numeroCuenta El nuevo número de cuenta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método getter para obtener el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public long getIdCliente() {
        return idCliente;
    }

    /**
     * Método setter para establecer el ID del cliente.
     * 
     * @param idCliente El nuevo ID del cliente.
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
