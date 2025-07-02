/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.controlador.planificacion;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.AsignaturaDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Asignatura;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Carrera;
import com.mycompany.gestionlaboratoriomicrobiologia.util.Auditoria;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ControladorAsignatura {

    public ControladorAsignatura(com.mycompany.gestionlaboratoriomicrobiologia.dao.AsignaturaDAO asignaturaDAO) {
        this.asignaturaDAO = asignaturaDAO;
    }
    private final AsignaturaDAO asignaturaDAO; //MARCA ERROR AQUI
    
    public void crearAsignatura(Asignatura asignatura) { //MARCA ERROR AQUI
        // Validar unicidad de código
        asignaturaDAO.insertar(asignatura);
        Auditoria.registrarEvento("Sistema", "CREAR_ASIGNATURA", asignatura.getCodigo()); //MARCA ERROR AQUI
    }
    
    public List<Asignatura> buscarPorCarrera(Carrera carrera) { //MARCA ERROR AQUI
        return asignaturaDAO.obtenerPorCarrera(carrera);
    }
}
