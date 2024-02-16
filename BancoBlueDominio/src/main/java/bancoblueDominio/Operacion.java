
package bancoblueDominio;

import java.time.LocalDateTime;

/**
 *
 * @author lv1821
 */
public class Operacion {
    
    //Atributos de la operacion
    private long codigo;
    private double monto;
    private String motivo;
    private String tipo;
    private LocalDateTime fechaCreacion;
    private long codigoCuenta;
    
    //Atributos del retiro sin cuenta
    private String estado;
    private long folio;
    private int contrasenia;

    //Atributos de la transferencia
    private int numCuentaDestino;

    public Operacion() {
    }

    public Operacion(long codigo, double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia, int numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }
    
    
    public Operacion(long codigo, double monto, String motivo, String tipo, LocalDateTime fechaCreacion, String estado, long folio, int contrasenia, int numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia, int numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(long codigo, double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Operacion(double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, String estado, long folio, int contrasenia) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.estado = estado;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Operacion(long codigo, double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, int numCuentaDestino) {
        this.codigo = codigo;
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    public Operacion(double monto, String motivo, String tipo, LocalDateTime fechaCreacion, long codigoCuenta, int numCuentaDestino) {
        this.monto = monto;
        this.motivo = motivo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.codigoCuenta = codigoCuenta;
        this.numCuentaDestino = numCuentaDestino;
    }

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }


    
}
