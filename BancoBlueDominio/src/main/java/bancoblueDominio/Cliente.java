
package bancoblueDominio;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Cliente {
    
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setNombres(String Nombre) {
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
    
    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
    
    public String getNombreCompleto(){
        return this.Nombre.concat(this.apellidopaterno.concat(this.apellidoMaterno));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 24 * hash + this.id;
        hash = 24 * hash + Objects.hashCode(this.contrasenia);
        hash = 24 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 24 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 24 * hash + Objects.hashCode(this.Nombre);
        hash = 24 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 24 * hash + Objects.hashCode(this.apellidopaterno);
        hash = 24 * hash + Objects.hashCode(this.ciudad);
        hash = 24 * hash + Objects.hashCode(this.calle);
        hash = 24 * hash + Objects.hashCode(this.colonia);
        hash = 24 * hash + this.numExterior;
        hash = 24 * hash + this.codigoPostal;
        hash = 24 * hash + Objects.hashCode(this.estado);
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }

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
