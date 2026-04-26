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
    private int documento_identidad;
    private String nombre;
    private LocalDate fecha_nacimiento;

    public Cliente(int documento_identidad, String nombre, LocalDate fecha_nacimiento) {
        this.documento_identidad = documento_identidad;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(int documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getfecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setfecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Cliente: " + 
                "Documento de identidad: " + documento_identidad + 
                ". Nombre: " + nombre + 
                ". Fecha de nacimiento: " + fecha_nacimiento + '}';
    }

}
