/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Usuario;

/**
 *
 * @author DELL
 */

public interface UsuarioDAO {

    // Autenticación
    Rol validarCredenciales(String usuario, String clave);

    // CRUD básico
    Usuario insertar(Usuario usuario);

    Usuario obtenerPorId(String id);

    boolean actualizarUsuario(Usuario usuario);

    // Métodos específicos
    Rol obtenerRol(String usuarioId);
}
