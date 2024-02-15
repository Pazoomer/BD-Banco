
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Jorge Zamora 245103
 */
public class ClienteNuevoDTO {
    
    private String contrasenia;
    private Date fechaNacimiento; // Este atributo calcula la edad
    private String nombreUsuario;

    // Los siguientes atributos componen el nombre completo
    private String Nombre;
    private String apellidoMaterno;
    private String apellidopaterno;

    // Los siguientes atributos componen el domicilio
    private String ciudad;
    private String calle;
    private String colonia;
    private int numExterior;
    private int codigoPostal;
    private String estado;
    
    //Conexion con la base de datos
    IClientesDAO clientesDAO;

    public ClienteNuevoDTO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean validar() throws ValidacionDTOException{
        // Validar que todos los atributos no sean ni null ni 0
        if (contrasenia == null || fechaNacimiento == null || nombreUsuario == null ||
            Nombre == null || apellidoMaterno == null || apellidopaterno == null ||
            ciudad == null || calle == null || colonia == null || estado == null) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
        }

        // Validar que numExterior y codigoPostal no sean 0
        if (numExterior == 0 || codigoPostal == 0) {
            throw new ValidacionDTOException("Los numerosn pueden ser 0");
        }

        // Calcular la edad a partir de la fecha de nacimiento
        int edadMinima = 18;
        Calendar calendarNacimiento = Calendar.getInstance();
        calendarNacimiento.setTime(fechaNacimiento);
        Calendar calendarActual = Calendar.getInstance();

        int diferenciaAnios = calendarActual.get(Calendar.YEAR) - calendarNacimiento.get(Calendar.YEAR);

        // Ajuste para verificar si ya cumplió años en el año actual
        if (calendarActual.get(Calendar.DAY_OF_YEAR) < calendarNacimiento.get(Calendar.DAY_OF_YEAR)) {
            diferenciaAnios--;
        }

        // Verificar que la edad sea mayor o igual a 18
        if (diferenciaAnios >= edadMinima) {
            return true;
        }
        throw new ValidacionDTOException("Debe ser mayor de edad");
        
    }

}
