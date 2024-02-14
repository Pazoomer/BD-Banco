
package bancoBluePersistencia.dtos.operacion;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author t1pas
 */
public class OperacionNuevaDTO {
    
    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.monto ^ (this.monto >>> 32));
        hash = 67 * hash + Objects.hashCode(this.motivo);
        hash = 67 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 67 * hash + (int) (this.codigoCuenta ^ (this.codigoCuenta >>> 32));
        return hash;
    }

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
        final OperacionNuevaDTO other = (OperacionNuevaDTO) obj;
        if (this.monto != other.monto) {
            return false;
        }
        if (this.codigoCuenta != other.codigoCuenta) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        return Objects.equals(this.fechaCreacion, other.fechaCreacion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperacionNuevaDTO{");
        sb.append("monto=").append(monto);
        sb.append(", motivo=").append(motivo);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", codigoCuenta=").append(codigoCuenta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
