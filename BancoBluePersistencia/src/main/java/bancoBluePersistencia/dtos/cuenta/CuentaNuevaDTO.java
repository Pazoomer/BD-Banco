
package bancoBluePersistencia.dtos.cuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) para la creación de una nueva cuenta.
 * Contiene el ID del cliente al que se asociará la cuenta.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaNuevaDTO {
   
    private long idCliente;

    /**
     * Constructor por defecto de la clase CuentaNuevaDTO.
     */
    public CuentaNuevaDTO() {
        
    }
     
    /**
     * Método getter para obtener el ID del cliente asociado a la cuenta.
     * 
     * @return El ID del cliente.
     */
    public long getIdCliente() {
        return idCliente;
    }
    
    /**
     * Método setter para establecer el ID del cliente asociado a la cuenta.
     * 
     * @param idCliente El nuevo ID del cliente.
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
 
    
}
