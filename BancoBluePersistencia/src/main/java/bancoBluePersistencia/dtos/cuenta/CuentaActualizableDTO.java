
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
    private int numeroCuenta;
    private int idCliente;

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

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 17 * hash + (int) (this.saldo ^ (this.saldo >>> 32));
        hash = 17 * hash + Objects.hashCode(this.fechaApertura);
        hash = 17 * hash + this.numeroCuenta;
        hash = 17 * hash + this.idCliente;
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
        final CuentaActualizableDTO other = (CuentaActualizableDTO) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaActualizableDTO{");
        sb.append("codigo=").append(codigo);
        sb.append(", saldo=").append(saldo);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}