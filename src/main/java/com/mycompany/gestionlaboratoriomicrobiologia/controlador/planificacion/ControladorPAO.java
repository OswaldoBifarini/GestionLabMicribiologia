/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.controlador.planificacion;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.PAODAO;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.BusinessException;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.RelacionException;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Carrera;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.PAO;
import java.util.List;

public class ControladorPAO {
    private final PAODAO paoDAO;
    
    public ControladorPAO(PAODAO paoDAO) {
        this.paoDAO = paoDAO;
    }
    
    // Método existente
    public void crearPAO(PAO pao) throws BusinessException {
        if (paoDAO.existePAO(pao.getNroPAO(), pao.getCarrera())) {
            throw new BusinessException("PAO ya existe para esta carrera");
        }
        paoDAO.insertar(pao);
    }
    
    // ---- MÉTODOS ADICIONALES RECOMENDADOS ----
    
    // 1. Actualizar PAO
    public void actualizarPAO(PAO pao) throws BusinessException {
        if (!paoDAO.existePorId(pao.getId())) {
            throw new BusinessException("PAO no encontrado para actualización");
        }
        paoDAO.actualizar(pao);
    }
    
    // 2. Eliminar PAO (con validación)
    public void eliminarPAO(int id) throws BusinessException, RelacionException {
        if (paoDAO.tieneAgendamientosAsociados(id)) {
            throw new RelacionException("No se puede eliminar: PAO tiene agendamientos asociados");
        }
        paoDAO.eliminar(id);
    }
    
    // 3. Obtener PAO por ID
    public PAO obtenerPAOPorId(int id) throws BusinessException {
        PAO pao = paoDAO.obtenerPorId(id);
        if (pao == null) {
            throw new BusinessException("PAO no encontrado con ID: " + id);
        }
        return pao;
    }
    
    // 4. Listar todos los PAOs
    public List<PAO> listarTodosPAOs() {
        return paoDAO.obtenerTodos();
    }
    
    // 5. Filtrar PAOs por carrera
    public List<PAO> filtrarPorCarrera(Carrera carrera) {
        return paoDAO.obtenerPorCarrera(carrera);
    }
    
    // 6. Validar existencia de PAO
    public boolean existePAO(int nroPAO, Carrera carrera) {
        return paoDAO.existePAO(nroPAO, carrera);
    }
    
    // 7. Obtener PAOs con asignaturas
    public List<PAO> obtenerConAsignaturas() {
        return paoDAO.obtenerConAsignaturas();
    }
    
    // 8. Actualizar carrera de un PAO
    public void cambiarCarreraPAO(int idPAO, Carrera nuevaCarrera) throws BusinessException {
        PAO pao = obtenerPAOPorId(idPAO);
        pao.setCarrera(nuevaCarrera);
        paoDAO.actualizar(pao);
    }
}