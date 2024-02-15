
package bancoBluePersistencia.dtos.cuenta;

import bancoBluePersistencia.herramientas.GeneradorNumeros;

/**
 *
 * @author t1pas
 */
public class CuentaNuevaDTO {
   
    private long numeroCuenta;
    private int idCliente;
    String estado="abierta";

    public CuentaNuevaDTO() {
        this.numeroCuenta=GeneradorNumeros.generarNumeroAleatorio16Digitos();
        
    }
     

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
