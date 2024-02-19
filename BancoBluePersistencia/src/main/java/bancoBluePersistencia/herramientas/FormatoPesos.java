
package bancoBluePersistencia.herramientas;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Encargado de las conversiones monetarias
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class FormatoPesos {
    
    /**
     * Convierte un doble en una cadena en formato de pesos mexicanos
     * @param cantidad Cantidad a convertir
     * @return Cadena de texto en formato pesos mexicanos
     */
    public static String convertidorPesos(Double cantidad){
        // Crear un objeto NumberFormat para el formato de moneda en pesos mexicanos
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));

        // Formatear el valor double como una cantidad de dinero en pesos mexicanos
        String cantidadFormateada = formatoMoneda.format(cantidad);
        
        return cantidadFormateada;
    }
}
