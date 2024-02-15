package bancoBluePersistencia.encriptacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Contraseñas {

    /**
     * Encripta la contraseña con la sal
     * @param contraseña contraseña a encriptar
     * @param sal cadena aletoria para proteger la contraseña
     * @return Contraseña encriptada
     * @throws NoSuchAlgorithmException Cuando el algotirtmo no es compatible con la version
     */
    public static String encriptarContraseña(String contraseña, String sal) throws NoSuchAlgorithmException {
        String contraseñaConSal = contraseña + sal;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = messageDigest.digest(contraseñaConSal.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    /**
     * Genera una sal
     * @return Sal para proteger la contraseña
     */
    public static String generarSal() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    /**
     * Verifica si una contraseña es correcta
     * @param contraseñaEntrante Contraseña a encriptar y validar
     * @param contraseñaGuardada Contraseña a comparar despues del proceso
     * @param sal Cadena especifica de la contraseña para protegerla
     * @return Verdadero si la ambas contraseñas son iguales despues de la encriptacion
     * @throws NoSuchAlgorithmException Cuando el algotirtmo no es compatible con jla version
     */
    public static boolean verificarContraseña(String contraseñaEntrante, String contraseñaGuardada, String sal) throws NoSuchAlgorithmException {
        String enteredPasswordHash = encriptarContraseña(contraseñaEntrante, sal);
        return contraseñaGuardada.equals(enteredPasswordHash);
    }

    public static void main(String[] args) {
        try {
            // Registro de un nuevo usuario
            String password = "password123";
            String salt = generarSal();
            String hashedPassword = encriptarContraseña(password, salt);

            System.out.println("Password: " + password);
            System.out.println("Salt: " + salt);
            System.out.println("Hashed Password: " + hashedPassword);

            // Verificación de la contraseña ingresada por un usuario
            String enteredPassword = "password123";
            if (verificarContraseña(enteredPassword, hashedPassword, salt)) {
                System.out.println("Contraseña correcta");
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}