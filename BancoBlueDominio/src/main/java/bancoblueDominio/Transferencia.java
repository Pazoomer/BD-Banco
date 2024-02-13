
package bancoblueDominio;

import java.time.LocalDateTime;


/**
 *
 * @author t1pas
 */
public class Transferencia extends Operacion {
    
    private int numCuentaDestino;

    public Transferencia() {
    }

    public Transferencia(int numCuentaDestino, long monto, String motivo, LocalDateTime fechaCreacion, int codigoCuenta) {
        super(monto, motivo, fechaCreacion, codigoCuenta);
        this.numCuentaDestino = numCuentaDestino;
    }

    public Transferencia(int numCuentaDestino, int codigo, long monto, String motivo, LocalDateTime fechaCreacion, int codigoCuenta) {
        super(codigo, monto, motivo, fechaCreacion, codigoCuenta);
        this.numCuentaDestino = numCuentaDestino;
    }
    
    public int getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(int numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numCuentaDestino;
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
        final Transferencia other = (Transferencia) obj;
        return this.numCuentaDestino == other.numCuentaDestino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("numCuentaDestino=").append(numCuentaDestino);
        sb.append('}');
        return sb.toString();
    }
    

    
    
    
}
