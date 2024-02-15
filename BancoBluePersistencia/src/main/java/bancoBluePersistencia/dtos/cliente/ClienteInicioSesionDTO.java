
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.excepciones.ValidacionDTOException;
import java.util.Calendar;

/**
 *
 * @author t1pas
 */
public class ClienteInicioSesionDTO {
    private String contrasenia;
    private String nombreUsuario;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    public boolean validar() throws ValidacionDTOException{
        // Validar que todos los atributos no sean ni null ni 0
        if (contrasenia == null || nombreUsuario == null ) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
        }

            return true;

    }
    
    
}
