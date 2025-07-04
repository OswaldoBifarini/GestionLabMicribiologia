/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gestionlaboratoriomicrobiologia;

import com.mycompany.gestionlaboratoriomicrobiologia.controlador.ControladorLogin;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.ConexionDB;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAOImpl;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Usuario;
import com.mycompany.gestionlaboratoriomicrobiologia.vista.VistaLogin;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GestionLaboratorioMicrobiologia {

    public static void main(String[] args) {
        // Iniciar en el Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // 1. Verificar conexión con PostgreSQL
                testConexionDB();
                
                /*
              
                UsuarioDAO dao = new UsuarioDAOImpl();
                dao.insertar(new Usuario("Admin", "Sistema", "admin@lab.com", "admin123", Rol.ADMINISTRADOR));
                
                */

                // 2. Configurar controlador
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
                ControladorLogin controladorLogin = new ControladorLogin(usuarioDAO);

                // 3. Iniciar interfaz
                VistaLogin vistaLogin = new VistaLogin(controladorLogin);
                vistaLogin.setVisible(true);

            } catch (SQLException e) {
                handlePostgreSQLError(e);
            } catch (Exception e) {
                handleGenericError(e);
            }
        });
    }

    private static void testConexionDB() throws SQLException {
        System.out.println("Intentando conectar a PostgreSQL...");
        try (Connection conn = ConexionDB.conectar()) {
            System.out.println("¡Conexión exitosa a PostgreSQL!");
            System.out.println("Base de datos: " + conn.getMetaData().getDatabaseProductName());
            System.out.println("Versión: " + conn.getMetaData().getDatabaseProductVersion());
        }
    }

    private static void handlePostgreSQLError(SQLException e) {
        String errorMsg = "Error de conexión con PostgreSQL:\n\n"
                + "• Verifica que el servidor PostgreSQL está en ejecución\n"
                + "• URL: " + ConexionDB.URL + "\n"
                + "• Usuario: " + ConexionDB.USER + "\n\n"
                + "Detalle técnico:\n" + e.getMessage();

        System.err.println(errorMsg);
        showErrorDialog(errorMsg);
    }

    private static void handleGenericError(Exception e) {
        String errorMsg = "Error crítico inesperado:\n\n" + e.getMessage();
        System.err.println(errorMsg);
        e.printStackTrace();
        showErrorDialog(errorMsg);
    }

    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Error de Inicio - Sistema de Gestión de Laboratorio",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
