/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_logica;

/**
 *
 * @author Mariana
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Compra {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        
        HashMap <String, Cliente> clientes = new HashMap<>();
        ArrayList <Mueble> productos = new ArrayList<>();
        
        int opcion = 0, opcion1 = 0;
        
        while(opcion != 10){
            System.out.println("Ingrese una opcion:");
            System.out.println("1. Registrar un cliente.");
            System.out.println("2. Registrar un producto de tipo mesa o de tipo silla.");
            System.out.println("3. Registrar una compra.");
            System.out.println("4. Mostrar la cantidad de productos que ofrece la tienda y "
                    + "la información de cada uno de estos productos.");
            System.out.println("5. Calcular y mostrar el porcentaje de productos de tipo mesa.");
            System.out.println("6. Mostrar el precio promedio de los productos cuyo material es madera.");
            System.out.println("7. Mostrar la información del producto o de los productos "
                    + "con mayor cantidad de unidades disponibles.");
            System.out.println("8. Mostrar la fecha y valor pagado para cada una de las compras de un cliente. "
                    + "Además, debe mostrar el resultado de la sumatoria de los valores pagados por dicho cliente.");
            System.out.println("9. Graficos:");
            System.out.println("• La cantidad de productos por material.");
            System.out.println("• La cantidad de productos por tipo (mesas y sillas).");
            System.out.println("10. Salir.");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    String documento, nombre;
                    System.out.println("Ingrese el numero de documento de identidad:");
                    documento = sc.next();
                    System.out.println("Ingrese el nombre completo:");
                    nombre = sc.next();
                    System.out.println("Ingrese la fecha de nacimiento (DD/MM/AAAA):");
                    String fechaTexto = sc.next();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha_n = LocalDate.parse(fechaTexto, formatter);
                    
                    Cliente cliente = new Cliente(documento, nombre, fecha_n);

                    clientes.put(documento, cliente);
                    
                    if (clientes.containsKey(documento)) {
                        System.out.println("el cliente " + nombre + " ya existe.");
                    } else {
                        clientes.put(documento, cliente);
                        System.out.println("Registro exitoso.");
                    }
                    break;
                case 2:
                    while(opcion1 != 3){
                        System.out.println("Ingrese el mueble a registrar:");
                        System.out.println("1. Mesa.");
                        System.out.println("2. Silla.");
                        opcion1 = sc.nextInt();
                        switch (opcion1){
                            case 1:
                                System.out.println("Ingrese el codigo:");
                                System.out.println("Ingrese la descrip");
                                
                        }
                    }
                case 3:
                    
                case 4:
                    
                case 5:
                    
                case 4:
                    
                    
            }
            
            
        }
        
        
    }
}
