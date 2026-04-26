package com.mycompany.proyecto_logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Tienda extends JFrame  {
    public static void main(String[] args) {
        
        Tienda ventana = new Tienda();
    }

    //Estructuras de datos
    HashMap<String, Cliente> clientes = new HashMap<>();
    ArrayList<Mueble> productos = new ArrayList<>();

    //Interfaz
    JMenuBar barra;
    JMenu menu, graficos;
    JMenuItem opcion, opcion1, opcion2, opcion3, opcion4, opcion5, opcion6, opcion7, opcion8, opcion9
    , submenu91, submenu92;

    public Tienda(){

        setTitle("Sistema de Compra");

        barra = new JMenuBar();
        setJMenuBar(barra);

        menu = new JMenu("Menú");
        barra.add(menu);

        opcion1 = new JMenuItem("Registrar cliente");
        menu.add(opcion1);

        //Acciones de la opcion 1
        opcion1.addActionListener(e -> {
            try {
                String documento = JOptionPane.showInputDialog("Ingrese el numero de documento de identidad:");
                
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo:");            

                String fechaTexto = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (DD/MM/YYYY):");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.parse(fechaTexto, formatter);

                //para ver que no se repita el usuario y agregarlo al hashmap
                if (clientes.containsKey(documento)) {
                    JOptionPane.showMessageDialog(null, "El cliente" + nombre + " ya existe");
                    return;
                }else{ 
                    clientes.put(documento, new Cliente(documento, nombre, fecha));
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en datos");
            }
        });

        opcion2 = new JMenuItem("Registrar un producto.");
        menu.add(opcion2);

        //Acciones de la opcion 2
        opcion2.addActionListener(e -> {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mueble a registrar:\n1. Mesa\n2. Silla"));
                
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");            
                String descripcion_producto = JOptionPane.showInputDialog("Ingrese la descripcion del producto:");
                String material_producto  = JOptionPane.showInputDialog("Ingrese el material:");
                double precio_procuto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
                String color_producto  = JOptionPane.showInputDialog("Ingrese el color:");
                int cantidad_producto  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades:"));
                
                if (opcion == 1) {
                    String forma_tapam = JOptionPane.showInputDialog("Ingrese la forma de la tapa:");
                    double ancho_tapam = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el ancho de la tapa:"));
                    double largo_tapam = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el largo de la tapa:"));
                    String material_tapam = JOptionPane.showInputDialog("Ingrese el material de la tapa:");

                    productos.add(new Mesa(codigo, descripcion_producto, material_producto, precio_procuto, color_producto, cantidad_producto, 
                        forma_tapam, ancho_tapam, largo_tapam, material_tapam));

                }else if(opcion == 2){
                    String tapizados = JOptionPane.showInputDialog("Ingrese el material de tapizado:");
                    String colors = JOptionPane.showInputDialog("Ingrese el color del tapizado:");
                    String densidads = JOptionPane.showInputDialog("Ingrese la densidad de la espuma:");

                    productos.add(new Silla(codigo, descripcion_producto, material_producto, precio_procuto, color_producto, cantidad_producto, 
                        tapizados, colors, densidads));

                }else{
                    JOptionPane.showMessageDialog(null, "Opción invalida.");   
                }

                JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos.");
            }
        });

        opcion3 = new JMenuItem("Registrar compra.");
        menu.add(opcion3);

        //Acciones de la opcion 3, lo hice con IA porque no sabía como seguir
        opcion3.addActionListener(e -> {
            try {
                String documento = JOptionPane.showInputDialog("Ingrese el numero de documento de identidad:");

                if (!clientes.containsKey(documento)) {
                    JOptionPane.showMessageDialog(null, "El cliente " + documento + " no existe");
                    return;
                }

                Cliente cliente = clientes.get(documento);
                LocalDate fechaCompra = LocalDate.now();

                int documento_existe = 1;
                double total = 0;

                while (documento_existe == 1) {
                    String codigo = JOptionPane.showInputDialog("Ingrese el código del producto:");

                    Mueble prod = null;
                    for (Mueble m : productos) {
                        if (m.getCodigo().equals(codigo)) {
                            prod = m;
                            break;
                        }
                    }

                    if (prod == null) {
                        JOptionPane.showMessageDialog(null, "El producto no fue encontrado");
                        continue;
                    }

                    int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                    if (prod.getCantidad_unidades() < cant) {
                        JOptionPane.showMessageDialog(null, "Sin stock");
                        continue;
                    }

                    total += prod.getPrecio() * cant;

                    prod.setCantidad_unidades(prod.getCantidad_unidades() - cant);

                    documento_existe = JOptionPane.showConfirmDialog(null,"¿Agregar otro producto?", "Compra",
                            JOptionPane.YES_NO_OPTION);
                }

                double pagar = total;

                if (cliente.getFecha_cumpleaños().getMonth() == fechaCompra.getMonth()) {
                    pagar = total * 0.90;
                }

                JOptionPane.showMessageDialog(null,
                        "Total: " + total + "\nA pagar: " + pagar);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en compra");
            }
        });

        // opcion4 = new JMenuItem("Mostrar los productos de la tienda.");
        // menu.add(opcion4);

        // opcion5 = new JMenuItem("Mostrar el porcentaje de mesa.");
        // menu.add(opcion5);

        // opcion6 = new JMenuItem("Precio promedio de los productos de madera.");
        // menu.add(opcion6);

        // opcion7 = new JMenuItem("Cantidades unitarias de los productos.");
        // menu.add(opcion7);

        // opcion8 = new JMenuItem("Fecha y valor pagado para las compras de un cliente.");
        // menu.add(opcion8);

        // opcion9 = new JMenuItem("Gráficos.");
        // menu.add(opcion9); 
        // //Submenu de la opcion 9
        // submenu91 = new JMenuItem("Cantidad de prouctos por material.");
        // opcion9.add(submenu91);
        // submenu92 = new JMenuItem("Cantidad por tipo de productos.");
        // opcion9.add(submenu92);

        setVisible(true);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
