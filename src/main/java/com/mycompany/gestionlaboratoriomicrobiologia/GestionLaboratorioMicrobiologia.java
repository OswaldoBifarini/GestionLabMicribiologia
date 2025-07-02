/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gestionlaboratoriomicrobiologia;

import com.mycompany.gestionlaboratoriomicrobiologia.controlador.ControladorLogin;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.ConexionDB;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAOImpl;
import com.mycompany.gestionlaboratoriomicrobiologia.vista.VistaLogin;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class GestionLaboratorioMicrobiologia {

    public static void main(String[] args) {
        try {
            // 1. Verificar conexión con PostgreSQL
            testConexionDB();

            // 2. Configurar controlador
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            ControladorLogin controladorLogin = new ControladorLogin(usuarioDAO);

            // 3. Iniciar interfaz
            VistaLogin vistaLogin = new VistaLogin(controladorLogin);
            vistaLogin.mostrar();

        } catch (SQLException e) {
            // Manejo específico para errores de PostgreSQL
            String errorMsg = "Error de conexión con PostgreSQL:\n\n";
            errorMsg += "• Verifica que el servidor PostgreSQL está en ejecución\n";
            errorMsg += "• URL: " + ConexionDB.URL + "\n";
            errorMsg += "• Usuario: " + ConexionDB.USER + "\n\n";
            errorMsg += "Detalle técnico:\n" + e.getMessage();

            System.err.println(errorMsg);
            showErrorDialog(errorMsg);
        } catch (Exception e) {
            // Manejo de otros errores genéricos
            String errorMsg = "Error crítico inesperado:\n\n" + e.getMessage();
            System.err.println(errorMsg);
            e.printStackTrace();
            showErrorDialog(errorMsg);
        }
    }

    private static void testConexionDB() throws SQLException {
        System.out.println("Intentando conectar a PostgreSQL...");
        try (Connection conn = ConexionDB.conectar()) {
            System.out.println("¡Conexión exitosa a PostgreSQL!");
            System.out.println("Base de datos: " + conn.getMetaData().getDatabaseProductName());
            System.out.println("Versión: " + conn.getMetaData().getDatabaseProductVersion());
        }
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
