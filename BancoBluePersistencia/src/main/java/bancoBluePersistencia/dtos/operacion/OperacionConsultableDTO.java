
package bancoBluePersistencia.dtos.operacion;

/**
 * Clase que representa un DTO (Data Transfer Object) para una operación consultable.
 * Contiene información como el código de la operación.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class OperacionConsultableDTO {
    private long codigo;

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

    
    
}
