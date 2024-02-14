
package bancoBluePersistencia.dtos.cliente;

import java.time.LocalDate;

/**
 *
 * @author Jorge Zamora 245103
 */
public class ClienteNuevoDTO {
    
    private String contrasenia;
    private LocalDate fechaNacimiento; // Este atributo calcula la edad
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

    
    /*
    public boolean esValido() throws ValidacionDTOException{
        
        if (this.nombre==null 
                || this.nombre.isBlank() 
                || this.nombre.trim().length()>100) {
            throw new ValidacionDTOException("Nombre de socio invalido");
        }
        
        String regexTelefono = "^[0-9]{9,15}$";
        Pattern patternTelefono = Pattern.compile(regexTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(this.telefono);
        
        if (this.telefono == null
                || this.telefono.isBlank()
                || this.telefono.trim().length() > 16
                || !matcherTelefono.matches()) {
            throw new ValidacionDTOException("Telefono de socio invalido");
        }

        String regexCorreo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern patternCorreo = Pattern.compile(regexCorreo);
        Matcher matcherCorreo = patternCorreo.matcher(this.correo);

        if (this.correo.length()==0) {
            return true;
        } else if (this.correo.trim().length() > 200
                || !matcherCorreo.matches()) {
            throw new ValidacionDTOException("Correo de socio invalido");
        }
        return true;
    }*/

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

}
