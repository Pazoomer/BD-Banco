
package bancoBluePersistencia.dtos.retiroSinCuenta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author t1pas
 */
public class RetiroSinCuentaNuevoDTO {

    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;
    
    private String estado;
    private int folio;
    private String contrasenia;

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

    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (int) (this.monto ^ (this.monto >>> 32));
        hash = 31 * hash + Objects.hashCode(this.motivo);
        hash = 31 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 31 * hash + (int) (this.codigoCuenta ^ (this.codigoCuenta >>> 32));
        hash = 31 * hash + Objects.hashCode(this.estado);
        hash = 31 * hash + this.folio;
        hash = 31 * hash + Objects.hashCode(this.contrasenia);
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
        final RetiroSinCuentaNuevoDTO other = (RetiroSinCuentaNuevoDTO) obj;
        if (this.monto != other.monto) {
            return false;
        }
        if (this.codigoCuenta != other.codigoCuenta) {
            return false;
        }
        if (this.folio != other.folio) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return Objects.equals(this.fechaCreacion, other.fechaCreacion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RetiroSinCuentaNuevoDTO{");
        sb.append("monto=").append(monto);
        sb.append(", motivo=").append(motivo);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", codigoCuenta=").append(codigoCuenta);
        sb.append(", estado=").append(estado);
        sb.append(", folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append('}');
        return sb.toString();
    }

    

    
    
    
}
