/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

/**
 *
 * @author DELL
 */
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Usuario;
import com.mycompany.gestionlaboratoriomicrobiologia.util.PasswordUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

    private static final String SQL_VALIDAR
            = "SELECT tipousuario FROM usuario WHERE email = ? AND password = ?";

    private static final String SQL_INSERT
            = "INSERT INTO usuario (nombre, apellido, email, password, tipousuario) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_OBTENER_ROL
            = "SELECT tipousuario FROM usuario WHERE email = ?";

    private static final String SQL_OBTENER_POR_ID
            = "SELECT idusuario, nombre, apellido, email, password, tipousuario "
            + "FROM usuario WHERE email = ?";

    private static final String SQL_ACTUALIZAR
            = "UPDATE usuario SET password = ?, tipousuario = ? WHERE email = ?";

    // Método validarCredenciales 
    @Override
    public Rol validarCredenciales(String email, String clave) {
        String SQL_VALIDAR = "SELECT tipousuario FROM usuario WHERE email = ? AND password = ?";//NEW to solve login
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_VALIDAR)) {

            // Depuraciod d proces
            System.out.println("Email: " + email);
            System.out.println("Clave: " + clave);

            stmt.setString(1, email);
            stmt.setString(2, clave);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String rolStr = rs.getString("tipousuario");
                    System.out.println("Rol desde BD: " + rolStr); // Depuración
                    return Rol.valueOf(rs.getString("tipousuario"));
                } else {
                    System.out.println("No se encontraron resultados"); // Depuración
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al validar credenciales", e);
            
        }
        return null;
    }

    @Override
    public Usuario insertar(Usuario usuario) {

        String SQL_VALIDAR = "SELECT tipousuario FROM usuario WHERE email = ? AND password = ?";// Consulta ACTUALIZADA
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, usuario.getId());
            stmt.setString(2, PasswordUtil.hashPassword(usuario.getCredencial()));
            stmt.setString(3, usuario.getRol().name());
            stmt.setString(4, PasswordUtil.hashPassword(usuario.getCredencial()));

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al crear usuario, ninguna fila afectada");
            }

            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar usuario", e);
        }
    }

    @Override
    public Rol obtenerRol(String usuarioId) {
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_OBTENER_ROL)) {

            stmt.setString(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Rol.valueOf(rs.getString("rol"));
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener rol", e);
        }
    }

    @Override
    public Usuario obtenerPorId(String id) {
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_OBTENER_POR_ID)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getString("id"));
                    usuario.setCredencial(rs.getString("credencial_hash"));
                    usuario.setRol(Rol.valueOf(rs.getString("rol")));
                    return usuario;
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener usuario", e);
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_ACTUALIZAR)) {

            stmt.setString(1, usuario.getCredencial());
            stmt.setString(2, usuario.getRol().name());
            stmt.setString(3, usuario.getId());          // email

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario", e);
        }
    }

    /*@Override
    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection conn = ConexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL_ACTUALIZAR)) {

            stmt.setString(1, PasswordUtil.hashPassword(usuario.getCredencial()));
            stmt.setString(2, usuario.getRol().name());
            stmt.setString(3, usuario.getId());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario", e);
        }
    }*/
}
