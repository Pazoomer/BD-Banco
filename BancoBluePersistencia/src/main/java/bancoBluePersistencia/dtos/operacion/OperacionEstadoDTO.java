
package bancoBluePersistencia.dtos.operacion;

/**
 *
 * @author t1pas
 */
public class OperacionEstadoDTO {
    private long codigo;
    private String estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
