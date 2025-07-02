/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionlaboratoriomicrobiologia;

import com.mycompany.gestionlaboratoriomicrobiologia.controlador.ControladorLogin;
import com.mycompany.gestionlaboratoriomicrobiologia.controlador.ControladorNotificacion;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.ConexionDB;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.vista.VistaLogin;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.UsuarioDAOImpl;
/**
 *
 * @author DELL
 */

public class GestionLaboratorioMicrobiologia{ //MainApp
    public static void main(String[] args) {
        
        
        try {
            // 1. Inicializar conexión a BD
            ConexionDB.inicializar();
            
            // 2. Configurar controlador
            UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
            ControladorLogin controladorLogin = new ControladorLogin((UsuarioDAO) usuarioDAO);
            
            // 3. Iniciar interfaz
            VistaLogin vistaLogin = new VistaLogin(controladorLogin);
            vistaLogin.mostrar();
            
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
        // Inicialización de dependencias
        ConexionDB.inicializar();
        ControladorNotificacion.init();
        
        // Configuración de la inyección de dependencias
        ControladorLogin controladorLogin = new ControladorLogin((UsuarioDAO) new UsuarioDAOImpl()); // Error
        
        // Inicio de la aplicación
        VistaLogin vistaLogin = new VistaLogin(controladorLogin); 
        vistaLogin.mostrar();
        
        
    }
}


