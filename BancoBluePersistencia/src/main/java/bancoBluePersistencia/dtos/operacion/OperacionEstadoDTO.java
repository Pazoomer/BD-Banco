
package bancoBluePersistencia.dtos.operacion;

/**
 * Clase que representa un DTO (Data Transfer Object) para el estado de una operación.
 * Contiene información como el código de la operación y su estado.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class OperacionEstadoDTO {
    private long codigo;
    private String estado;

    /**
     * Método getter para obtener el código de la operación.
     * 
     * @return El código de la operación.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la operación.
     * 
     * @param codigo El nuevo código de la operación.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el estado de la operación.
     * 
     * @return El estado de la operación.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado de la operación.
     * 
     * @param estado El nuevo estado de la operación.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
