
package bancoblueDominio;

import java.time.LocalDateTime;

/**
 *
 * @author lv1821
 */
public class Cuenta {
    private long codigo;
    private double saldo;
    private LocalDateTime fechaApertura;
    private long numeroCuenta;
    private long idCliente;
    private String estado;

    public Cuenta() {
    }

    public Cuenta(double saldo, LocalDateTime fechaApertura, long numeroCuenta, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
    }
    
    

    public Cuenta(double saldo, LocalDateTime fechaApertura, long numeroCuenta, long idCliente, String estado) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.estado=estado;
    }
    
    public Cuenta(long codigo, double saldo, LocalDateTime fechaApertura, long numeroCuenta, long idCliente, String estado) {
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

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
