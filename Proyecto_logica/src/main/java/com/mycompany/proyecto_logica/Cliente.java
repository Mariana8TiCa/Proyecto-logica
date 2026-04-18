/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_logica;

/**
 *
 * @author Mariana
 */

import java.time.LocalDate; //Para importar los meses y hacer el if para el descuento del 10%
public class Cliente {
    private String documento_identidad;
    private String nombre;
    private LocalDate fecha_cumpleaños;

    public Cliente(String documento_identidad, String nombre, LocalDate fecha_cumpleaños) {
        this.documento_identidad = documento_identidad;
        this.nombre = nombre;
        this.fecha_cumpleaños = fecha_cumpleaños;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_cumpleaños() {
        return fecha_cumpleaños;
    }

    public void setFecha_cumpleaños(LocalDate fecha_cumpleaños) {
        this.fecha_cumpleaños = fecha_cumpleaños;
    }

    @Override
    public String toString() {
        return "Cliente: " + 
                "Documento de identidad: " + documento_identidad + 
                ". Nombre: " + nombre + 
                ". Fecha de cumpleaños: " + fecha_cumpleaños + '}';
    }

}
