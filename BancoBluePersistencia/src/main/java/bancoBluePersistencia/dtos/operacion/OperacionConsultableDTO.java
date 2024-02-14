
package bancoBluePersistencia.dtos.operacion;

/**
 *
 * @author t1pas
 */
public class OperacionConsultableDTO {
    private long codigo;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
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
        final OperacionConsultableDTO other = (OperacionConsultableDTO) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperacionConsultableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }
    
    
}
