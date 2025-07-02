/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Carrera;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.PAO;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PAODAO {

    void insertar(PAO pao);

    void actualizar(PAO pao);

    void eliminar(int id);

    PAO obtenerPorId(int id);

    List<PAO> obtenerTodos();

    List<PAO> obtenerPorCarrera(Carrera carrera);

    boolean existePAO(int nroPAO, Carrera carrera);

    boolean existePorId(int id);

    boolean tieneAgendamientosAsociados(int idPAO);

    List<PAO> obtenerConAsignaturas();
}
