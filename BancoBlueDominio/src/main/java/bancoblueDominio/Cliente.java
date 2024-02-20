
package bancoblueDominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Representa a los usuarios del sistema, contiene los atributos de docicilios
 * @author Jorge Zamora y Victoria Vega
 */
public class Cliente {
    
    /**
     * Distingue los clientes
     */
    private long id;
    /**
     * Permite acceder a su cuenta
     */
    private String contrasenia;
    /**
     * Fecha de nacimiento con la que se calcula la edad
     */
    private Date fechaNacimiento; 
    /**
     * Nombre unico para ingresar a nivel usuario
     */
    private String nombreUsuario;
    
    // Los siguientes atributos componen el nombre completo
    private String Nombre;
    private String apellidoMaterno;
    private String apellidopaterno;
    
    // Los siguientes atributos componen el domicilio
    private long codigoDomicilio;
    private String ciudad;
    private String calle;
    private String colonia;
    private int numExterior;
    private int codigoPostal;
    private String estado;

    /**
     * Constructor por defecto de la clase Cliente. Crea una instancia de Cliente sin inicializar los atributos.
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa los atributos del cliente con detalles específicos.
     * 
     * @param id               El identificador único del cliente.
     * @param contrasenia      La contraseña asociada al cliente.
     * @param fechaNacimiento  La fecha de nacimiento del cliente.
     * @param nombreUsuario    El nombre de usuario del cliente.
     * @param Nombre           El nombre del cliente.
     * @param apellidoMaterno  El apellido materno del cliente.
     * @param apellidopaterno  El apellido paterno del cliente.
     * @param codigoDomicilio  El código único del domicilio del cliente.
     * @param ciudad           La ciudad del domicilio del cliente.
     * @param calle            La calle del domicilio del cliente.
     * @param colonia          La colonia del domicilio del cliente.
     * @param numExterior      El número exterior del domicilio del cliente.
     * @param codigoPostal     El código postal del domicilio del cliente.
     * @param estado           El estado del domicilio del cliente.
     */
    public Cliente(long id, String contrasenia, Date fechaNacimiento, String nombreUsuario, String Nombre, String apellidoMaterno, String apellidopaterno, long codigoDomicilio, String ciudad, String calle, String colonia, int numExterior, int codigoPostal, String estado) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.Nombre = Nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.codigoDomicilio = codigoDomicilio;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }
    
    /**
     * Constructor que inicializa los atributos del cliente sin el identificador único y el código del domicilio.
     * 
     * @param contrasenia      La contraseña asociada al cliente.
     * @param fechaNacimiento  La fecha de nacimiento del cliente.
     * @param nombreUsuario    El nombre de usuario del cliente.
     * @param Nombre           El nombre del cliente.
     * @param apellidoMaterno  El apellido materno del cliente.
     * @param apellidopaterno  El apellido paterno del cliente.
     * @param ciudad           La ciudad del domicilio del cliente.
     * @param calle            La calle del domicilio del cliente.
     * @param colonia          La colonia del domicilio del cliente.
     * @param numExterior      El número exterior del domicilio del cliente.
     * @param codigoPostal     El código postal del domicilio del cliente.
     * @param estado           El estado del domicilio del cliente.
     */
    public Cliente(String contrasenia, Date fechaNacimiento, String nombreUsuario, String Nombre, String apellidoMaterno, String apellidopaterno, String ciudad, String calle, String colonia, int numExterior, int codigoPostal, String estado) {
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.Nombre = Nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidopaterno;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa los atributos del cliente con el identificador único y el código del domicilio.
     * 
     * @param id               El identificador único del cliente.
     * @param contrasenia      La contraseña asociada al cliente.
     * @param fechaNacimiento  La fecha de nacimiento del cliente.
     * @param nombreUsuario    El nombre de usuario del cliente.
     * @param Nombre           El nombre del cliente.
     * @param apellidoMaterno  El apellido materno del cliente.
     * @param apellidoPaterno  El apellido paterno del cliente.
     * @param ciudad           La ciudad del domicilio del cliente.
     * @param calle            La calle del domicilio del cliente.
     * @param colonia          La colonia del domicilio del cliente.
     * @param numExterior      El número exterior del domicilio del cliente.
     * @param codigoPostal     El código postal del domicilio del cliente.
     * @param estado           El estado del domicilio del cliente.
     */
    public Cliente(long id, String contrasenia, Date fechaNacimiento, String nombreUsuario, String Nombre, String apellidoMaterno, String apellidoPaterno, String ciudad, String calle, String colonia, int numExterior, int codigoPostal, String estado) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.Nombre = Nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidopaterno = apellidoPaterno;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }

    /**
     * Método getter para obtener el código del domicilio del cliente.
     * 
     * @return El código del domicilio del cliente.
     */
    public long getCodigoDomicilio() {
        return codigoDomicilio;
    }

    /**
     * Método setter para establecer el código del domicilio del cliente.
     * 
     * @param codigoDomicilio El nuevo código del domicilio del cliente.
     */
    public void setCodigoDomicilio(long codigoDomicilio) {
        this.codigoDomicilio = codigoDomicilio;
    }
    
    /**
     * Método getter para obtener el identificador único del cliente.
     * 
     * @return El identificador único del cliente.
     */
    public long getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador único del cliente.
     * 
     * @param id El nuevo identificador único del cliente.
     */
    public void setId(long id) {
        this.id = id;
    }

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
    public void setNombres(String Nombre) {
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
     * Método para calcular la edad del cliente en años.
     * 
     * @return La edad del cliente.
     */
    public int getEdad() {
        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimientoLocal, fechaActual);

        return periodo.getYears();
    }
    
    /**
     * Método para obtener el nombre completo del cliente.
     * 
     * @return El nombre completo del cliente.
     */
    public String getNombreCompleto(){
        return this.Nombre.concat(" ").concat(this.apellidopaterno.concat(" ").concat(this.apellidoMaterno));
    }

    /**
     * Método para generar el código hash de la instancia de Cliente.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.contrasenia);
        hash = 43 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 43 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 43 * hash + Objects.hashCode(this.Nombre);
        hash = 43 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 43 * hash + Objects.hashCode(this.apellidopaterno);
        hash = 43 * hash + (int) (this.codigoDomicilio ^ (this.codigoDomicilio >>> 32));
        hash = 43 * hash + Objects.hashCode(this.ciudad);
        hash = 43 * hash + Objects.hashCode(this.calle);
        hash = 43 * hash + Objects.hashCode(this.colonia);
        hash = 43 * hash + this.numExterior;
        hash = 43 * hash + this.codigoPostal;
        hash = 43 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    /**
     * Método para comparar dos instancias de Cliente y determinar si son iguales.
     * 
     * @param obj La instancia de Cliente a comparar.
     * @return true si son iguales, false en caso contrario.
     */
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }

    /**
     * Método para obtener una representación en cadena de la instancia de Cliente.
     * 
     * @return La representación en cadena de la instancia de Cliente.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", nombreUsuario=").append(nombreUsuario);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", apellidopaterno=").append(apellidopaterno);
        sb.append(", codigoDomicilio=").append(codigoDomicilio);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", numExterior=").append(numExterior);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }


    
    
    
}
