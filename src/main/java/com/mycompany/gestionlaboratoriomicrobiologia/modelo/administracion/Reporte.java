/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.administracion;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Reporte {
    private TipoReporte tipo; // Enum: FECHAS, PRODUCTOS
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String codigoProducto;
}

