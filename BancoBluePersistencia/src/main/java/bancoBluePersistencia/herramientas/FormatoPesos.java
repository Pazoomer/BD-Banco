
package bancoBluePersistencia.herramientas;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author t1pas
 */
public class FormatoPesos {
    
    public static String convertidorPesos(Double cantidad){
        // Crear un objeto NumberFormat para el formato de moneda en pesos mexicanos
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));

        // Formatear el valor double como una cantidad de dinero en pesos mexicanos
        String cantidadFormateada = formatoMoneda.format(cantidad);
        
        return cantidadFormateada;
    }
}
