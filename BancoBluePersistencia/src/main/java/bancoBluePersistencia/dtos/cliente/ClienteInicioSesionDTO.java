
package bancoBluePersistencia.dtos.cliente;

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
    
    
}
