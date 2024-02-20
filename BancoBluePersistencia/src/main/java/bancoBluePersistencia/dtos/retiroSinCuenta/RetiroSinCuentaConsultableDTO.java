
package bancoBluePersistencia.dtos.retiroSinCuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) consultable para un retiro sin cuenta.
 * Contiene información como el código del retiro sin cuenta.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class RetiroSinCuentaConsultableDTO {
    
    private long codigo;

    /**
     * Método getter para obtener el código del retiro sin cuenta.
     * 
     * @return El código del retiro sin cuenta.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código del retiro sin cuenta.
     * 
     * @param codigo El nuevo código del retiro sin cuenta.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método hashCode que genera un código hash basado en el código del retiro sin cuenta.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    /**
     * Método equals que compara la igualdad del retiro sin cuenta consultable con otro objeto.
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
        final RetiroSinCuentaConsultableDTO other = (RetiroSinCuentaConsultableDTO) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Método toString que devuelve una representación en cadena del retiro sin cuenta consultable.
     * 
     * @return Representación en cadena del retiro sin cuenta consultable.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RetiroSinCuentaConsultableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }

    
    
}
