package bancoBluePersistencia.herramientas;

import java.util.Random;

/**
 * Clase de utilidad para generar números aleatorios. 
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class GeneradorNumeros {

    /**
     * Genera un número aleatorio de 16 dígitos.
     *
     * @return Número aleatorio de 16 dígitos.
     */
    public static long generarNumeroAleatorio16Digitos() {
        Random random = new Random();
        long numeroAleatorio = Math.abs(random.nextLong());

        // Asegurar que tenga 16 dígitos
        while (numeroAleatorio < 1_000_000_000_000_000L) {
            numeroAleatorio *= 10;
        }

        // Limitar a 16 dígitos
        return numeroAleatorio % 10_000_000_000_000_000L;
    }

    /**
     * Genera un número aleatorio de 8 dígitos.
     *
     * @return Número aleatorio de 8 dígitos.
     */
    public static int generarNumeroAleatorio8Digitos() {
        Random random = new Random();
        int numeroAleatorio = 100_000_00 + random.nextInt(900_000_00);
        return numeroAleatorio;
    }
}
