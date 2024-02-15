
package bancoBluePersistencia.dtos.cuenta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author t1pas
 */
public class CuentaNuevaDTO {
   
    private long saldo;
    private LocalDateTime fechaApertura;
    private int numeroCuenta;
    private int idCliente;
    String estado="abierta";

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash = 37 * hash + (int) (this.saldo ^ (this.saldo >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fechaApertura);
        hash = 37 * hash + this.numeroCuenta;
        hash = 37 * hash + this.idCliente;
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
        final CuentaNuevaDTO other = (CuentaNuevaDTO) obj;
        if (this.saldo != other.saldo) {
            return false;
        }
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaNuevaDTO{");
        sb.append(", saldo=").append(saldo);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }
    
    
}
