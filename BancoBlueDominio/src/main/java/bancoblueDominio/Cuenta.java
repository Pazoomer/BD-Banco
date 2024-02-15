
package bancoblueDominio;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Cuenta {
    private long codigo;
    private long saldo;
    private LocalDateTime fechaApertura;
    private int numeroCuenta;
    private int idCliente;
    private String estado;

    public Cuenta() {
    }

    public Cuenta(long saldo, LocalDateTime fechaApertura, int numeroCuenta, int idCliente, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.estado=estado;
    }
    
    

    public Cuenta(long codigo, long saldo, LocalDateTime fechaApertura, int numeroCuenta, int idCliente, String estado) {
        this.codigo = codigo;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 31 * hash + (int) (this.saldo ^ (this.saldo >>> 32));
        hash = 31 * hash + Objects.hashCode(this.fechaApertura);
        hash = 31 * hash + this.numeroCuenta;
        hash = 31 * hash + this.idCliente;
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
        final Cuenta other = (Cuenta) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("codigo=").append(codigo);
        sb.append(", saldo=").append(saldo);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }

 
    
    
}
