
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;

/**
 * Clase que representa un DTO (Data Transfer Object) para una nueva operación.
 * Contiene información como el monto, motivo, códigos de cuenta y número de cuentas
 * de origen y destino, y el tipo de operación.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class OperacionNuevaDTO {
    
    private double monto;
    private String motivo;

    private long codigoCuenta;
    private long numCuentaOrigen;
    private long numCuentaDestino;
    private String tipo;

    /**
     * Método getter para obtener el tipo de operación.
     *
     * @return El tipo de operación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el tipo de operación.
     * 
     * @param tipo El nuevo tipo de operación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * Método getter para obtener el código de la cuenta asociada a la operación.
     * 
     * @return El código de la cuenta.
     */
    public long getCodigoCuenta() {
        return codigoCuenta;
    }
    
    /**
     * Método setter para establecer el código de la cuenta asociada a la operación.
     * 
     * @param codigoCuenta El nuevo código de la cuenta.
     */
    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    /**
     * Método getter para obtener el número de cuenta de origen de la operación.
     * 
     * @return El número de cuenta de origen.
     */
    public long getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    /**
     * Método setter para establecer el número de cuenta de origen de la operación.
     * 
     * @param numCuentaOrigen El nuevo número de cuenta de origen.
     */
    public void setNumCuentaOrigen(long numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    /**
     * Método getter para obtener el número de cuenta de destino de la operación.
     * 
     * @return El número de cuenta de destino.
     */
    public long getNumCuentaDestino() {
        return numCuentaDestino;
    }

    /**
     * Método setter para establecer el número de cuenta de destino de la operación.
     * 
     * @param numCuentaDestino El nuevo número de cuenta de destino.
     */
    public void setNumCuentaDestino(long numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }
    
    
    
}
