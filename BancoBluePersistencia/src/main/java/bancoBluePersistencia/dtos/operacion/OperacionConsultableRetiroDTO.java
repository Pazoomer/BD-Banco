
package bancoBluePersistencia.dtos.operacion;

/**
 * Clase que representa un DTO (Data Transfer Object) para una operación de retiro consultable.
 * Contiene información como el folio de la operación y la contraseña asociada.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class OperacionConsultableRetiroDTO {
    
    private long folio;
    private int contrasenia;

    /**
     * Método getter para obtener el folio de la operación.
     * 
     * @return El folio de la operación.
     */
    public long getFolio() {
        return folio;
    }

    /**
     * Método setter para establecer el folio de la operación.
     * 
     * @param folio El nuevo folio de la operación.
     */
    public void setFolio(long folio) {
        this.folio = folio;
    }

    /**
     * Método getter para obtener la contraseña asociada a la operación.
     * 
     * @return La contraseña asociada a la operación.
     */
    public int getContrasenia() {
        return contrasenia;
    }

    /**
     * Método setter para establecer la contraseña asociada a la operación.
     * 
     * @param contrasenia La nueva contraseña asociada a la operación.
     */
    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
