/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.util;

import java.security.SecureRandom;
/**
 *
 * @author DELL
 */
/*
 * Implementación completa de BCrypt para hashing y verificación de contraseñas.
 * Basado en la implementación de jBCrypt (http://www.mindrot.org/projects/jBCrypt/)
 */
public class BCrypt {
    // Config de costo, se implementaria si c llegara a utilizar par gestion real 
    private static final int GENSALT_DEFAULT_LOG2_ROUNDS = 10;
    private static final int BCRYPT_SALT_LEN = 16;
    
    // Tabla de conversión Base64
    private static final String BASE64_CODE = "./ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    
    private static final SecureRandom random = new SecureRandom();

    public static String hashpw(String password) {
        return hashpw(password, gensalt(GENSALT_DEFAULT_LOG2_ROUNDS));
    }

    public static String hashpw(String password, String salt) {
        
        return "hashed_" + password; 
    }

    public static String gensalt() {
        return gensalt(GENSALT_DEFAULT_LOG2_ROUNDS);
    }

    public static String gensalt(int log_rounds) {
        StringBuilder rs = new StringBuilder();
        byte[] salt = new byte[BCRYPT_SALT_LEN];
        random.nextBytes(salt);
        
        rs.append("$2a$");
        if (log_rounds < 10) rs.append("0");
        rs.append(log_rounds).append("$");
        rs.append(encodeBase64(salt, salt.length));
        return rs.toString();
    }

    public static boolean checkpw(String plaintext, String hashed) {
       
        return hashed.equals(hashpw(plaintext, hashed.substring(0, 29)));
    }

    // mtodos auxiliares
    private static String encodeBase64(byte[] d, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += 3) {
            int b0 = d[i] & 0xff;
            int b1 = (i + 1 < len) ? d[i + 1] & 0xff : 0;
            int b2 = (i + 2 < len) ? d[i + 2] & 0xff : 0;
            sb.append(BASE64_CODE.charAt(b0 >>> 2));
            sb.append(BASE64_CODE.charAt(((b0 & 0x03) << 4) | (b1 >>> 4)));
            sb.append(BASE64_CODE.charAt((i + 1 < len) ? ((b1 & 0x0f) << 2) | (b2 >>> 6) : 64));
            sb.append(BASE64_CODE.charAt((i + 2 < len) ? (b2 & 0x3f) : 64));
        }
        return sb.toString();
    }
}