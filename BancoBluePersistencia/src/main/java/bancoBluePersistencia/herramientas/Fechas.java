
package bancoBluePersistencia.herramientas;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Maneja el uso de convertidores de fechas LocalDate, Date, Timestamp y LocalDateTime
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class Fechas {

    /**
     * Convierte un objeto Date a LocalDate.
     *
     * @param date Objeto Date a convertir.
     * @return LocalDate correspondiente al objeto Date proporcionado.
     */
    public static LocalDate convertidorLocalDate(Date date){
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    /**
     * Convierte un objeto Date a LocalDateTime.
     *
     * @param date Objeto Date a convertir.
     * @return LocalDateTime correspondiente al objeto Date proporcionado.
     */
    public static LocalDateTime convertidorLocalDateTime(Date date){
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /**
     * Convierte un objeto Timestamp a LocalDateTime.
     *
     * @param timestamp Objeto Timestamp a convertir.
     * @return LocalDateTime correspondiente al objeto Timestamp proporcionado.
     */
    public static LocalDateTime convertirTimestampALocalDateTime(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
