/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Laboratorio;
import java.util.List;

/**
 *
 * @author DELL
 */

public interface LaboratorioDAO<T> {
    Laboratorio obtenerPorCodigo(String codigo);
    void insertar(T entidad);
    void actualizar(T entidad);
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
    
}
