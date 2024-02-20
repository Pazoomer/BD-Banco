
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa un DTO (Data Transfer Object) para una operación actualizable.
 * Contiene información como el código de la operación, monto, motivo, fecha de creación y código de cuenta asociado.
 * 
 * @author Victoria Vega, Jorge Zamora.
 */
public class OperacionActualizableDTO {
    
    private long codigo;
    private double monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;

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
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método setter para establecer la fecha de creación de la operación.
     * 
     * @param fechaCreacion La nueva fecha de creación de la operación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método getter para obtener el código de cuenta asociado a la operación.
     * 
     * @return El código de cuenta asociado a la operación.
     */
    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Método setter para establecer el código de cuenta asociado a la operación.
     * 
     * @param codigoCuenta El nuevo código de cuenta asociado a la operación.
     */
    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

   
    
    
}
