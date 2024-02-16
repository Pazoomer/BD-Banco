
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;

/**
 *
 * @author t1pas
 */
public class OperacionTransferenciaNuevaDTO {
    
    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;
    private int numCuentaOrigen;
    private int numCuentaDestino;

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public int getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    public void setNumCuentaOrigen(int numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    public int getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }
    
    
    
}
