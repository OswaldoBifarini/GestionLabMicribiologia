/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.controlador;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.ReactivoDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.kardex.Reactivo;
import java.util.List;

/**
 *
 * @author DELL
 */

public class ControladorKardex {
    public void generarAlertaCaducidad() {
        List<Reactivo> reactivos = new ReactivoDAO().obtenerProximosCaducar(); 
        // pars enviar notificaciones
    }
}
