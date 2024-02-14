
package bancoblueDominio;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Operacion {
    
    //Atributos de la operacion
    private long codigo;
    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;
    
    //Atributos del retiro sin cuenta
    private String estado;
    private int folio;
    private String contrasenia;

    //Atributos de la transferencia
    private int numCuentaDestino;

    public Operacion() {
    }

    public Operacion(long codigo) {
        this.codigo = codigo;
    }

    public Operacion(String estado, int folio, String contrasenia) {
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Operacion(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, int numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(long codigo, long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, int numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, int folio, String contrasenia) {
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Operacion(long codigo, long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, int folio, String contrasenia) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Operacion(long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, int folio, String contrasenia, int numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(long codigo, long monto, String motivo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, int folio, String contrasenia, int numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
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

    public int getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 67 * hash + (int) (this.monto ^ (this.monto >>> 32));
        hash = 67 * hash + Objects.hashCode(this.motivo);
        hash = 67 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 67 * hash + (int) (this.codigoCuenta ^ (this.codigoCuenta >>> 32));
        hash = 67 * hash + Objects.hashCode(this.estado);
        hash = 67 * hash + this.folio;
        hash = 67 * hash + Objects.hashCode(this.contrasenia);
        hash = 67 * hash + this.numCuentaDestino;
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
        sb.append(", estado=").append(estado);
        sb.append(", folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", numCuentaDestino=").append(numCuentaDestino);
        sb.append('}');
        return sb.toString();
    }

    
}
