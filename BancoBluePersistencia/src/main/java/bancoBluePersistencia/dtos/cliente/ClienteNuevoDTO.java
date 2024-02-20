
package bancoBluePersistencia.dtos.cliente;

import bancoBluePersistencia.excepciones.ValidacionDTOException;
import java.sql.Date;
import java.util.Calendar;

/**
 * Clase que representa un DTO (Data Transfer Object) para la creación de nuevos clientes.
 * Contiene información relacionada con la creación de clientes, incluyendo datos personales y de domicilio.
 * 
 * @author Jorge Zamora, Victoria Vega
 */
public class ClienteNuevoDTO {
    
    // Atributos para datos personales
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
     * Método getter para obtener la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método setter para establecer la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
     * Método getter para obtener el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Método setter para establecer el nombre del cliente.
     * 
     * @param Nombre El nuevo nombre del cliente.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Método getter para obtener el apellido materno del cliente.
     * 
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método setter para establecer el apellido materno del cliente.
     * 
     * @param apellidoMaterno El nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método getter para obtener el apellido paterno del cliente.
     * 
     * @return El apellido paterno del cliente.
     */
    public String getApellidopaterno() {
        return apellidopaterno;
    }

    /**
     * Método setter para establecer el apellido paterno del cliente.
     * 
     * @param apellidopaterno El nuevo apellido paterno del cliente.
     */
    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    /**
     * Método getter para obtener la ciudad del domicilio del cliente.
     * 
     * @return La ciudad del domicilio del cliente.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Método setter para establecer la ciudad del domicilio del cliente.
     * 
     * @param ciudad La nueva ciudad del domicilio del cliente.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Método getter para obtener la calle del domicilio del cliente.
     * 
     * @return La calle del domicilio del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método setter para establecer la calle del domicilio del cliente.
     * 
     * @param calle La nueva calle del domicilio del cliente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método getter para obtener la colonia del domicilio del cliente.
     * 
     * @return La colonia del domicilio del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Método setter para establecer la colonia del domicilio del cliente.
     * 
     * @param colonia La nueva colonia del domicilio del cliente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Método getter para obtener el número exterior del domicilio del cliente.
     * 
     * @return El número exterior del domicilio del cliente.
     */
    public int getNumExterior() {
        return numExterior;
    }

    /**
     * Método setter para establecer el número exterior del domicilio del cliente.
     * 
     * @param numExterior El nuevo número exterior del domicilio del cliente.
     */
    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * Método getter para obtener el código postal del domicilio del cliente.
     * 
     * @return El código postal del domicilio del cliente.
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método setter para establecer el código postal del domicilio del cliente.
     * 
     * @param codigoPostal El nuevo código postal del domicilio del cliente.
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método getter para obtener el estado del domicilio del cliente.
     * 
     * @return El estado del domicilio del cliente.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado del domicilio del cliente.
     * 
     * @param estado El nuevo estado del domicilio del cliente.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Método para validar los datos personales del cliente.
     * 
     * @return true si los datos personales son válidos, false en caso contrario.
     * @throws ValidacionDTOException Si hay errores de validación en los datos personales.
     */
    public boolean validarDatosPersonales() throws ValidacionDTOException{
        
        // Validar que todos los atributos no sean ni null ni 0
        if (fechaNacimiento == null|| Nombre == null || apellidoMaterno == null || apellidopaterno == null ) {
            throw new ValidacionDTOException("Los campos no pueden estar vacios");
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

    /**
     * Método para validar todos los datos del cliente.
     * 
     * @return true si todos los datos son válidos, false en caso contrario.
     * @throws ValidacionDTOException Si hay errores de validación en los datos.
     */
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
