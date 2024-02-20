
package bancoBluePersistencia.dtos.cuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) para consultar la información de una cuenta.
 * Contiene el código de la cuenta a consultar.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaConsultableDTO {
    private long codigo;

    /**
     * Método getter para obtener el código de la cuenta a consultar.
     * 
     * @return El código de la cuenta.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la cuenta a consultar.
     * 
     * @param codigo El nuevo código de la cuenta.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método hashCode que genera un valor único basado en el código de la cuenta.
     * 
     * @return El valor hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    /**
     * Método equals para comparar dos objetos CuentaConsultableDTO basado en el código de la cuenta.
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
        final CuentaConsultableDTO other = (CuentaConsultableDTO) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Método toString que devuelve una representación en cadena del objeto CuentaConsultableDTO.
     * 
     * @return La representación en cadena del objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaConsultableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }
    
    

}
