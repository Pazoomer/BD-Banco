
package bancoBluePersistencia.dtos.cuenta;

/**
 * Clase que representa un DTO (Data Transfer Object) para consultar el saldo de una cuenta.
 * Contiene el código de la cuenta y el saldo actual.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class CuentaSaldoDTO {
    private long codigo;
    private double saldo;

    /**
     * Método getter para obtener el código de la cuenta.
     * 
     * @return El código de la cuenta.
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Método setter para establecer el código de la cuenta.
     * 
     * @param codigo El nuevo código de la cuenta.
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getter para obtener el saldo de la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método setter para establecer el saldo de la cuenta.
     * 
     * @param saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
