
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.excepciones.ValidacionDTOException;

/**
 * Clase que representa un DTO (Data Transfer Object) para la consulta de información de un cliente.
 * Contiene el identificador único del cliente.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class ClienteConsultableDTO {
    private long id;

    /**
     * Método getter para obtener el identificador único del cliente.
     * 
     * @return El identificador único del cliente.
     */
    public long getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador único del cliente.
     * 
     * @param id El nuevo identificador único del cliente.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Método hashCode que genera un código hash para la instancia.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    /**
     * Método equals que compara la instancia con otro objeto.
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
        final ClienteConsultableDTO other = (ClienteConsultableDTO) obj;
        return this.id == other.id;
    }

    /**
     * Método toString que devuelve una representación en cadena del objeto.
     * 
     * @return La representación en cadena del objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("clienteConsultable{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * Método para validar los datos del cliente consultable.
     * 
     * @return true si los datos son válidos, false en caso contrario.
     * @throws ValidacionDTOException Si hay errores de validación en los datos.
     */
    public boolean validar() throws ValidacionDTOException{
        // Validar que todos los atributos no sean ni null ni 0
        if (id == 0 ) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
        }

            return true;

    }
    
    
}
