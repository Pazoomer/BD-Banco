
package bancoBluePersistencia.dtos.cliente.transferencia;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa un DTO (Data Transfer Object) para actualizar información de una transferencia.
 * Contiene el código de la transferencia, monto, motivo, fecha de creación, código de cuenta y número de cuenta de destino.
 * Además, implementa métodos equals, hashCode y toString para facilitar la comparación y representación de objetos.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class TransferenciaActualizableDTO {
    
    private long codigo;
    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;

    private int numCuentaDestino;

    /**
     * Método getter para obtener el monto de la transferencia.
     * 
     * @return El monto de la transferencia.
     */
    public long getMonto() {
        return monto;
    }

    /**
     * Método setter para establecer el monto de la transferencia.
     * 
     * @param monto El nuevo monto de la transferencia.
     */
    public void setMonto(long monto) {
        this.monto = monto;
    }

    /**
     * Método getter para obtener el motivo de la transferencia.
     * 
     * @return El motivo de la transferencia.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Método setter para establecer el motivo de la transferencia.
     * 
     * @param motivo El nuevo motivo de la transferencia.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Método getter para obtener la fecha de creación de la transferencia.
     * 
     * @return La fecha de creación de la transferencia.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método setter para establecer la fecha de creación de la transferencia.
     * 
     * @param fechaCreacion La nueva fecha de creación de la transferencia.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método getter para obtener el código de cuenta de la transferencia.
     * 
     * @return El código de cuenta de la transferencia.
     */
    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Método setter para establecer el código de cuenta de la transferencia.
     * 
     * @param codigoCuenta El nuevo código de cuenta de la transferencia.
     */
    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    
    /**
     * Método getter para obtener el código de la transferencia.
     * 
     * @return El código de la transferencia.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la transferencia.
     * 
     * @param codigo El nuevo código de la transferencia.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el número de cuenta de destino de la transferencia.
     * 
     * @return El número de cuenta de destino de la transferencia.
     */
    public int getNumCuentaDestino() {
        return numCuentaDestino;
    }

    /**
     * Método setter para establecer el número de cuenta de destino de la transferencia.
     * 
     * @param numCuentaDestino El nuevo número de cuenta de destino de la transferencia.
     */
    public void setNumCuentaDestino(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Método hashCode para calcular el código hash del objeto.
     * 
     * @return El código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 59 * hash + (int) (this.monto ^ (this.monto >>> 32));
        hash = 59 * hash + Objects.hashCode(this.motivo);
        hash = 59 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 59 * hash + (int) (this.codigoCuenta ^ (this.codigoCuenta >>> 32));
        hash = 59 * hash + this.numCuentaDestino;
        return hash;
    }

    /**
     * Método equals para comparar dos objetos.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransferenciaActualizableDTO other = (TransferenciaActualizableDTO) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Método toString para representar el objeto como una cadena de texto.
     * 
     * @return La representación del objeto como cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferenciaActualizableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append(", monto=").append(monto);
        sb.append(", motivo=").append(motivo);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", codigoCuenta=").append(codigoCuenta);
        sb.append(", numCuentaDestino=").append(numCuentaDestino);
        sb.append('}');
        return sb.toString();
    }

    
    
}
