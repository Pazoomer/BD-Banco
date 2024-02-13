
package bancoblueDominio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Operacion {
    private long codigo;
    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;

    public Operacion() {
    }

    public Operacion(long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta) {
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
    }

    public Operacion(long codigo, long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
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
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public LocalDateTime calcularFechaCaducidad() {
        // Calcula la fecha de caducidad 10 minutos después de la fecha de creación
        return this.fechaCreacion.plus(10, ChronoUnit.MINUTES);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 89 * hash + (int) (this.monto ^ (this.monto >>> 32));
        hash = 89 * hash + Objects.hashCode(this.motivo);
        hash = 89 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 89 * hash + (int) (this.codigoCuenta ^ (this.codigoCuenta >>> 32));
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
        final Operacion other = (Operacion) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operacion{");
        sb.append("codigo=").append(codigo);
        sb.append(", monto=").append(monto);
        sb.append(", motivo=").append(motivo);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", codigoCuenta=").append(codigoCuenta);
        sb.append('}');
        return sb.toString();
    }

 

    

    
}
