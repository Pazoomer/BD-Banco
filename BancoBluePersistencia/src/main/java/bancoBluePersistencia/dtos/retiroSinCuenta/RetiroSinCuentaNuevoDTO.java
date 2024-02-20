
package bancoBluePersistencia.dtos.retiroSinCuenta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa un DTO (Data Transfer Object) para un retiro sin cuenta.
 * Contiene información como el monto, motivo, fecha de creación, código de cuenta, estado, folio y contraseña.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class RetiroSinCuentaNuevoDTO {

    private long monto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;
    
    private String estado;
    private int folio;
    private String contrasenia;

    /**
     * Método getter para obtener el monto del retiro sin cuenta.
     * 
     * @return El monto del retiro sin cuenta.
     */
    public long getMonto() {
        return monto;
    }

    /**
     * Método setter para establecer el monto del retiro sin cuenta.
     * 
     * @param monto El nuevo monto del retiro sin cuenta.
     */
    public void setMonto(long monto) {
        this.monto = monto;
    }

    /**
     * Método getter para obtener el motivo del retiro sin cuenta.
     * 
     * @return El motivo del retiro sin cuenta.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Método setter para establecer el motivo del retiro sin cuenta.
     * 
     * @param motivo El nuevo motivo del retiro sin cuenta.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Método getter para obtener la fecha de creación del retiro sin cuenta.
     * 
     * @return La fecha de creación del retiro sin cuenta.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método setter para establecer la fecha de creación del retiro sin cuenta.
     * 
     * @param fechaCreacion La nueva fecha de creación del retiro sin cuenta.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método getter para obtener el código de cuenta asociado al retiro sin cuenta.
     * 
     * @return El código de cuenta asociado al retiro sin cuenta.
     */
    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Método setter para establecer el código de cuenta asociado al retiro sin cuenta.
     * 
     * @param codigoCuenta El nuevo código de cuenta asociado al retiro sin cuenta.
     */
    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    /**
     * Método getter para obtener el estado del retiro sin cuenta.
     * 
     * @return El estado del retiro sin cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado del retiro sin cuenta.
     * 
     * @param estado El nuevo estado del retiro sin cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener el folio del retiro sin cuenta.
     * 
     * @return El folio del retiro sin cuenta.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Método setter para establecer el folio del retiro sin cuenta.
     * 
     * @param folio El nuevo folio del retiro sin cuenta.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Método getter para obtener la contraseña del retiro sin cuenta.
     * 
     * @return La contraseña del retiro sin cuenta.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método setter para establecer la contraseña del retiro sin cuenta.
     * 
     * @param contrasenia La nueva contraseña del retiro sin cuenta.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método hashCode que genera un código hash basado en los atributos del retiro sin cuenta.
     * 
     * @return El código hash generado.
     */
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

    /**
     * Método equals que compara la igualdad del retiro sin cuenta con otro objeto.
     * 
     * @param obj El objeto con el que se compara.
     * @return true si son iguales, false en caso contrario.
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

    /**
     * Método toString que devuelve una representación en cadena del retiro sin cuenta.
     * 
     * @return Representación en cadena del retiro sin cuenta.
     */
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
