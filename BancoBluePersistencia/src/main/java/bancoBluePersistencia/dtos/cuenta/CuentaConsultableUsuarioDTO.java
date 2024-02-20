
package bancoBluePersistencia.dtos.cuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) para consultar la información de una cuenta asociada a un usuario.
 * Contiene el número de cuenta a consultar.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaConsultableUsuarioDTO {
    private long numeroCuenta;

    /**
     * Método getter para obtener el número de cuenta a consultar.
     * 
     * @return El número de cuenta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método setter para establecer el número de cuenta a consultar.
     * 
     * @param numeroCuenta El nuevo número de cuenta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
}
