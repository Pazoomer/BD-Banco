
package bancoBluePersistencia.dtos.cliente.transferencia;

/**
 * Clase que representa un DTO (Data Transfer Object) para consultar información de una transferencia.
 * Contiene el código de la transferencia y métodos equals, hashCode y toString para facilitar la comparación y representación de objetos.
 * 
 * @author Jorge Zamora, Victoria Vega
 */
public class TransferenciaConsultableDTO {
    private long codigo;

    /**
     * Método getter para obtener el código de la transferencia.
     * 
     * @return El código de la transferencia.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la transferencia.
     * 
     * @param codigo El nuevo código de la transferencia.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método hashCode para calcular el código hash del objeto.
     * 
     * @return El código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    /**
     * Método equals para comparar dos objetos.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
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
        final TransferenciaConsultableDTO other = (TransferenciaConsultableDTO) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Método toString para representar el objeto como una cadena de texto.
     * 
     * @return La representación del objeto como cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferenciaConsultableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }
    
    
}
