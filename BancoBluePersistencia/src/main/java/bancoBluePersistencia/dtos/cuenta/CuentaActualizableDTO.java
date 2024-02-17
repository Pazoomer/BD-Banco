
package bancoBluePersistencia.dtos.cuenta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Jorge Zamora 245103
 */
public class CuentaActualizableDTO {

    private long codigo;
    private long saldo;
    private LocalDateTime fechaApertura;
    private long numeroCuenta;
    private long idCliente;
    String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
