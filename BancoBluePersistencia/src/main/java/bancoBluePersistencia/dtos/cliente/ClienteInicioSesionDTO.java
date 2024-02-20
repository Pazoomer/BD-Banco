
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.excepciones.ValidacionDTOException;
import java.util.Calendar;

/**
 * Clase que representa un DTO (Data Transfer Object) para el inicio de sesión de un cliente.
 * Contiene información necesaria para validar el inicio de sesión.
 * 
 * @author Jorge Zamora, Victoria Vega.
 */
public class ClienteInicioSesionDTO {
    private String contrasenia;
    private String nombreUsuario;

    /**
     * Método getter para obtener la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método setter para establecer la contraseña del cliente.
     * 
     * @param contrasenia La nueva contraseña del cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método getter para obtener el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método setter para establecer el nombre de usuario del cliente.
     * 
     * @param nombreUsuario El nuevo nombre de usuario del cliente.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Método para validar los datos de inicio de sesión del cliente.
     * 
     * @return true si los datos son válidos, false en caso contrario.
     * @throws ValidacionDTOException Si hay errores de validación en los datos.
     */
    public boolean validar() throws ValidacionDTOException{
        // Validar que todos los atributos no sean ni null ni 0
        if (contrasenia == null || nombreUsuario == null ) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
        }

            return true;

    }
    
    
}
