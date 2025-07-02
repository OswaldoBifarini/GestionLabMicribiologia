/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.gestionlaboratoriomicrobiologia.controlador;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import com.mycompany.gestionlaboratoriomicrobiologia.util.PasswordUtil;

/**
 *
 * @author DELL
 */
public class ControladorLogin {
    private final UsuarioDAO usuarioDAO;

    public ControladorLogin(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Rol autenticar(String usuario, String clave) {
        String hashClave = PasswordUtil.hashPassword(clave);
        return usuarioDAO.validarCredenciales(usuario, hashClave);
    }
}