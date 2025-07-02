/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.controlador.seguridad;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.BusinessException;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Usuario;
import com.mycompany.gestionlaboratoriomicrobiologia.util.PasswordUtil;

/**
 *
 * @author DELL
 */
public class ControladorUsuario {

    private final UsuarioDAO usuarioDAO;

    // Constructor con inyección de dependencia
    public ControladorUsuario(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario registrarUsuario(Usuario usuario, Rol rol) throws BusinessException {
        if (usuario == null) {
            throw new BusinessException("El usuario no puede ser nulo");
        }

        usuario.setCredencial(PasswordUtil.hashPassword(usuario.getCredencial()));
        usuario.setRol(rol);
        return usuarioDAO.insertar(usuario);
    }

    public boolean validarAcceso(String usuarioId, String accion) {
        Rol rol = usuarioDAO.obtenerRol(usuarioId);

        // Manejo de rol nulo
        if (rol == null) {
            return false;
        }

        return switch (rol) {
            case ADMINISTRADOR ->
                true;
            case TECNICO ->
                !"ELIMINAR".equals(accion);
            case DOCENTE ->
                "SOLICITAR_AGENDAMIENTO".equals(accion);
            default ->
                false;
        };
    }

}
