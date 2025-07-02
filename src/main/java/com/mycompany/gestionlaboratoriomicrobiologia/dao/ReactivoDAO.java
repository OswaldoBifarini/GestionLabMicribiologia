/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.kardex.Reactivo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ReactivoDAO implements GenericDAO<Reactivo> {
    public List<Reactivo> obtenerProximosCaducar() {
        // SQL: WHERE fecha_caducidad BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY)
        return null;
        // SQL: WHERE fecha_caducidad BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY)
    }
}