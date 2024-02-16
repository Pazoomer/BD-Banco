
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
    
     public static int generarNumeroAleatorio8Digitos() {
        Random random = new Random();
        return 100_000_00 + random.nextInt(900_000_00);
    }
}
