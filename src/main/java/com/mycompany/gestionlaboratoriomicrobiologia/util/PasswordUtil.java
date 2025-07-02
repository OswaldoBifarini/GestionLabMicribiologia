/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public static boolean verificarPassword(String candidato, String hash) {
        return BCrypt.checkpw(candidato, hash);
    }
}
   