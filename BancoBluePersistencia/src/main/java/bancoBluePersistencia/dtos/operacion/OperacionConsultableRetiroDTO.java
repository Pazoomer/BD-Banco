
package bancoBluePersistencia.dtos.operacion;

/**
 *
 * @author t1pas
 */
public class OperacionConsultableRetiroDTO {
    
    private long folio;
    private int contrasenia;

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
    
    
}
