
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author t1pas
 */
public class OperacionActualizableDTO {
    
    private long codigo;
    private double monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

   
    
    
}
