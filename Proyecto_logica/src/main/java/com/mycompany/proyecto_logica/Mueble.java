/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_logica;

/**
 *
 * @author Mariana
 */
public abstract class Mueble {
    protected String codigo;
    protected String descripcion;
    protected String material;
    protected double precio;
    protected String color;
    protected int cantidad_unidades;

    public Mueble(String codigo, String descripcion, String material, double precio, String color, int cantidad_unidades) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.material = material;
        this.precio = precio;
        this.color = color;
        this.cantidad_unidades = cantidad_unidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad_unidades() {
        return cantidad_unidades;
    }

    public void setCantidad_unidades(int cantidad_unidades) {
        this.cantidad_unidades = cantidad_unidades;
    }

    @Override
    public String toString() {
        return "Mueble:" + 
                "Codigo: " + codigo + 
                ". Descripcion: " + descripcion + 
                ". Material: " + material + 
                ". Precio: " + precio + 
                ". Color: " + color + 
                ". Cantidad de unidades disponibles: " + cantidad_unidades + '}';
    }
}
