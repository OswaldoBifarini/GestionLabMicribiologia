/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.kardex;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Reactivo extends Material {

    private TipoReactivo tipo; // Enum: SOLIDO, LIQUIDO, GASEOSO 
    private String volatilidad;
    private String toxicidad;
    private LocalDate fechaCaducidad;
    private LocalDate fechaIngreso;
    private String conservacion;

    public boolean estaProximoCaducar() {
        return fechaCaducidad.isBefore(LocalDate.now().plusDays(30));

    }

    @Override //MARCA ERROR AQUI
    public String getEstado() {
        if (estaProximoCaducar()) {
            return "ALERTA_CADUCIDAD";
        }
        return super.getEstado();
    }

}
