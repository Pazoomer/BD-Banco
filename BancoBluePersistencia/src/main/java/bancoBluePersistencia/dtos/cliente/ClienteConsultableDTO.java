
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author t1pas
 */
public class ClienteConsultableDTO {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final ClienteConsultableDTO other = (ClienteConsultableDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("clienteConsultable{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
    public boolean validar() throws ValidacionDTOException{
        // Validar que todos los atributos no sean ni null ni 0
        if (id == 0 ) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
        }

            return true;

    }
    
    
}
