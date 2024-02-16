
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;

/**
 *
 * @author t1pas
 */
public class OperacionNuevaDTO {
    
    private double monto;
    private String motivo;

    private long codigoCuenta;
    private int numCuentaOrigen;
    private int numCuentaDestino;
    private String tipo;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
