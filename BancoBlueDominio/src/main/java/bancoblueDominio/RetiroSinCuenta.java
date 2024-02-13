
package bancoblueDominio;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author t1pas
 */
public class RetiroSinCuenta extends Operacion{
    private String estado;
    private int folio;
    private String contrasenia;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(String estado, int folio, String contrasenia, long monto, String motivo, LocalDateTime fechaCreacion, int codigoCuenta) {
        super(monto, motivo, fechaCreacion, codigoCuenta);
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public RetiroSinCuenta(String estado, int folio, String contrasenia, int codigo, long monto, String motivo, LocalDateTime fechaCreacion, int codigoCuenta) {
        super(codigo, monto, motivo, fechaCreacion, codigoCuenta);
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
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
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.estado);
        hash = 71 * hash + this.folio;
        hash = 71 * hash + Objects.hashCode(this.contrasenia);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        if (this.folio != other.folio) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.contrasenia, other.contrasenia);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RetiroSinCuenta{");
        sb.append("estado=").append(estado);
        sb.append(", folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append('}');
        return sb.toString();
    }
    
    
}
