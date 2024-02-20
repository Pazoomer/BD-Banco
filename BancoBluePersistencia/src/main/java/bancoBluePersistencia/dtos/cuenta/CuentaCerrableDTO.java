
package bancoBluePersistencia.dtos.cuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) para cerrar una cuenta.
 * Contiene el número de cuenta a cerrar.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaCerrableDTO {
    
    private long numeroCuenta;

    /**
     * Método getter para obtener el número de cuenta a cerrar.
     * 
     * @return El número de cuenta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método setter para establecer el número de cuenta a cerrar.
     * 
     * @param numeroCuenta El nuevo número de cuenta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    
    
}
