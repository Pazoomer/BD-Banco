
package bancoBluePersistencia.herramientas;

import java.util.Random;

/**
 *
 * @author t1pas
 */
public class GeneradorNumeros {
    
    public static long generarNumeroAleatorio16Digitos() {
        Random random = new Random();
        long numeroAleatorio = Math.abs(random.nextLong()); // Asegura un número positivo
        numeroAleatorio = numeroAleatorio % 1_000_000_000_000_000L; // Limita a 16 dígitos
        return numeroAleatorio;
    }
}
