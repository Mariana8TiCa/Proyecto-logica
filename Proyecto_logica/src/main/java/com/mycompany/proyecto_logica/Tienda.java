package com.mycompany.proyecto_logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import java.awt.*;
import javax.swing.*;

public class Tienda extends JFrame {
    public static void main(String[] args) {

        Tienda ventana = new Tienda();
    }

    // Estructuras de datos
    HashMap<Integer, Cliente> clientes = new HashMap<>();
    HashMap<Integer, Mueble> productos = new HashMap<>();
    ArrayList<Compra> compras = new ArrayList<>();

    // Interfaz
    JMenuBar barra;
    JMenu menu, registrarProducto, graficos;
    JMenuItem registrarCliente, clientesRegistrados, productosRegistrados, opcionSilla, opcioneMesa, opcion5, opcion6,
            opcion7, opcion8,
            opcion9, submenu91,
            submenu92;

    public Tienda() {

        setTitle("Sistema de Compra");

        barra = new JMenuBar();
        setJMenuBar(barra);

        menu = new JMenu("Menú");
        barra.add(menu);

        registrarCliente = new JMenuItem("Registrar cliente");
        menu.add(registrarCliente);

        // Acciones para registrar Cliente
        registrarCliente.addActionListener(e -> {
            registrarCliente();
        });

        clientesRegistrados = new JMenuItem("Ver clientes registrados");
        menu.add(clientesRegistrados);

        clientesRegistrados.addActionListener(e -> {
            verClientes();
        });

        productosRegistrados = new JMenuItem("Ver productos registrados");
        menu.add(productosRegistrados);

        productosRegistrados.addActionListener(e -> {
            verProductos();
        });

        menu.addSeparator();
        registrarProducto = new JMenu("Registrar un producto.");
        menu.add(registrarProducto);

        opcioneMesa = new JMenuItem("Registrar una mesa.");
        opcionSilla = new JMenuItem("Registrar una silla.");

        registrarProducto.add(opcioneMesa);
        registrarProducto.add(opcionSilla);

        opcioneMesa.addActionListener(e -> {
            registrarProducto(new Mesa());
        });

        opcionSilla.addActionListener(e -> {
            registrarProducto(new Silla());
        });

        // opcion2.addActionListener(e -> {
        // try {
        // int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mueble
        // a registrar:\n1. Mesa\n2. Silla"));

        // String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");
        // String descripcion_producto = JOptionPane.showInputDialog("Ingrese la
        // descripcion del producto:");
        // String material_producto = JOptionPane.showInputDialog("Ingrese el
        // material:");
        // double precio_procuto =
        // Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
        // String color_producto = JOptionPane.showInputDialog("Ingrese el color:");
        // int cantidad_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese
        // la cantidad de unidades:"));

        // if (opcion == 1) {
        // String forma_tapam = JOptionPane.showInputDialog("Ingrese la forma de la
        // tapa:");
        // double ancho_tapam = Double.parseDouble(JOptionPane.showInputDialog("Ingrese
        // el ancho de la tapa:"));
        // double largo_tapam = Double.parseDouble(JOptionPane.showInputDialog("Ingrese
        // el largo de la tapa:"));
        // String material_tapam = JOptionPane.showInputDialog("Ingrese el material de
        // la tapa:");

        // productos.add(new Mesa(codigo, descripcion_producto, material_producto,
        // precio_procuto, color_producto, cantidad_producto,
        // forma_tapam, ancho_tapam, largo_tapam, material_tapam));

        // }else if(opcion == 2){
        // String tapizados = JOptionPane.showInputDialog("Ingrese el material de
        // tapizado:");
        // String colors = JOptionPane.showInputDialog("Ingrese el color del
        // tapizado:");
        // String densidads = JOptionPane.showInputDialog("Ingrese la densidad de la
        // espuma:");

        // productos.add(new Silla(codigo, descripcion_producto, material_producto,
        // precio_procuto, color_producto, cantidad_producto,
        // tapizados, colors, densidads));

        // }else{
        // JOptionPane.showMessageDialog(null, "Opción invalida.");
        // }

        // JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");

        // } catch (Exception ex) {
        // JOptionPane.showMessageDialog(null, "Error en los datos.");
        // }
        // });

        // opcion3 = new JMenuItem("Registrar compra.");
        // menu.add(opcion3);

        // Acciones de la opcion 3, lo hice con IA porque no sabía como seguir
        // opcion3.addActionListener(e -> {
        // try {
        // int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el
        // numero de documento de identidad:"));

        // if (!clientes.containsKey(documento)) {
        // JOptionPane.showMessageDialog(null, "El cliente " + documento + " no
        // existe");
        // return;
        // }

        // Cliente cliente = clientes.get(documento);
        // LocalDate fechaCompra = LocalDate.now();

        // int documento_existe = 1;
        // double total = 0;

        // while (documento_existe == 1) {
        // String codigo = JOptionPane.showInputDialog("Ingrese el código del
        // producto:");

        // Mueble prod = null;
        // for (Mueble m : productos) {
        // if (m.getCodigo().equals(codigo)) {
        // prod = m;
        // break;
        // }
        // }

        // if (prod == null) {
        // JOptionPane.showMessageDialog(null, "El producto no fue encontrado");
        // continue;
        // }

        // int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

        // if (prod.getCantidad_unidades() < cant) {
        // JOptionPane.showMessageDialog(null, "Sin stock");
        // continue;
        // }

        // total += prod.getPrecio() * cant;

        // prod.setCantidad_unidades(prod.getCantidad_unidades() - cant);

        // documento_existe = JOptionPane.showConfirmDialog(null,"¿Agregar otro
        // producto?", "Compra",
        // JOptionPane.YES_NO_OPTION);
        // }

        // double pagar = total;

        // if (cliente.getFecha_cumpleaños().getMonth() == fechaCompra.getMonth()) {
        // pagar = total * 0.90;
        // }

        // JOptionPane.showMessageDialog(null,
        // "Total: " + total + "\nA pagar: " + pagar);

        // } catch (Exception ex) {
        // JOptionPane.showMessageDialog(null, "Error en compra");
        // }
        // });

        // opcion4 = new JMenuItem("Mostrar los productos de la tienda.");
        // menu.add(opcion4);

        // opcion5 = new JMenuItem("Mostrar el porcentaje de mesa.");
        // menu.add(opcion5);

        // opcion6 = new JMenuItem("Precio promedio de los productos de madera.");
        // menu.add(opcion6);

        // opcion7 = new JMenuItem("Cantidades unitarias de los productos.");
        // menu.add(opcion7);

        // opcion8 = new JMenuItem("Fecha y valor pagado para las compras de un
        // cliente.");
        // menu.add(opcion8);

        // opcion9 = new JMenuItem("Gráficos.");
        // menu.add(opcion9);
        // //Submenu de la opcion 9
        // submenu91 = new JMenuItem("Cantidad de prouctos por material.");
        // opcion9.add(submenu91);
        // submenu92 = new JMenuItem("Cantidad por tipo de productos.");
        // opcion9.add(submenu92);

        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Funcion para registrar un cliente
    private void registrarCliente() {
        // creacion del dialogo para registrar un cliente (ventana emergente - modal)
        JDialog dialog = new JDialog(this, "Registrar Cliente", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // creacion de los campos para registrar un cliente
        JTextField fieldDocumento = new JTextField();
        JTextField fieldNombre = new JTextField();
        JTextField fieldFechaNacimiento = new JTextField();

        // creacion del formulario para registrar un cliente
        JPanel form = new JPanel(new GridLayout(3, 2, 5, 4)); // (filas - columnas - gap horizontal - gap vertical)
        // labels y campos para el formulario
        form.add(new JLabel("Documento de identidad:"));
        form.add(fieldDocumento);
        form.add(new JLabel("Nombre:"));
        form.add(fieldNombre);
        form.add(new JLabel("Fecha de nacimiento (DD/MM/YYYY):"));
        form.add(fieldFechaNacimiento);

        // botones para guardar o cancelar el registro del cliente
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        // Acciones del boton guardar, con validaciones para los campos y el formato de
        // la fecha
        btnGuardar.addActionListener(evento -> {
            try {

                // validacion de campos vacios
                if (fieldDocumento.getText().trim().isEmpty()
                        || fieldNombre.getText().trim().isEmpty()
                        || fieldFechaNacimiento.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Complete todos los campos");
                    return;
                }

                // validacion de datos ingresados, el documento solo debe ser numeros
                if (!fieldDocumento.getText().trim().matches("\\d+")) {
                    JOptionPane.showMessageDialog(dialog, "El documento de identidad solo debe contener números");
                    return;
                } else {
                    // captura de los datos ingresados por el usuario
                    int documento = Integer.parseInt(fieldDocumento.getText().trim());
                    String nombre = fieldNombre.getText().trim();

                    // validacion de cliente existente
                    if (clientes.containsKey(documento)) {
                        JOptionPane.showMessageDialog(dialog, "El cliente con documento " + documento + " ya existe");
                        return;
                    }

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(fieldFechaNacimiento.getText().trim(), formatter);

                    // creacion del cliente y guardado en la estructura de datos
                    clientes.put(documento, new Cliente(documento, nombre, fecha));
                    JOptionPane.showMessageDialog(dialog, "Cliente registrado correctamente");
                    dialog.dispose(); // cerrar el dialogo despues de guardar el cliente
                }

            } catch (Exception ex) { // captura de errores en el formato de los datos ingresados
                JOptionPane.showMessageDialog(dialog, "Error en los datos");
                return;
            }
        });

        // Acciones del boton cancelar, que simplemente cierra el dialogo sin guardar
        btnCancelar.addActionListener(ev -> dialog.dispose());

        // panel para los botones
        JPanel botones = new JPanel();
        botones.add(btnGuardar);
        botones.add(btnCancelar);
        // panel contenedor para el formulario y botonnes, con un borde para hacerlo mas
        // bonito
        JPanel contenido = new JPanel(new BorderLayout(10, 10));
        contenido.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12)); // margen alrededor del contenido
        contenido.add(form, BorderLayout.CENTER); // formulario en el centro
        contenido.add(botones, BorderLayout.SOUTH); // botones en la parte inferior
        dialog.setContentPane(contenido); // se establece el contenido del dialogo (modal)

        dialog.pack(); // ajusta el tamaño del dialogo al contenido
        dialog.setLocationRelativeTo(this); // centra el dialogo respecto a la ventana principal
        dialog.setVisible(true); // muestra el dialogo para registrar un cliente

    }

    // funcion para ver los clientes registrados
    private void verClientes() {
        String cad = "";

        for (Cliente c : clientes.values()) {
            cad += c.toString() + "\n";
        }
        JOptionPane.showMessageDialog(this, cad, "Clientes Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    // funcion para registrar un producto (mueble)
    // dependiendo del tipo de objeto mueble que se le pase por parametro, mostrara
    // un formulario diferente
    private void registrarProducto(Mueble mueble) {

        if (mueble instanceof Mesa) { // modal para registrar una mesa
            JDialog dialog = new JDialog(this, "Registrar Mesa", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // para que al cerrar el dialogo no se cierre la ventana principal

            // campos
            JTextField fieldCodigo = new JTextField();
            JTextField fieldDescripcion = new JTextField();
            // JTextField fieldMaterial = new JTextField();
            JTextField fieldPrecio = new JTextField();
            // JTextField fieldColor = new JTextField();
            JTextField fieldCantidad = new JTextField();
            // JTextField fieldFormaTapa = new JTextField();
            JTextField fieldAnchoTapa = new JTextField();
            JTextField fieldLargoTapa = new JTextField();
            // JTextField fieldMaterialTapa = new JTextField();

            // añadimos los campos
            JPanel form = new JPanel(new GridLayout(10, 2, 5, 4));
            form.add(new JLabel("Codigo:"));
            form.add(fieldCodigo);
            form.add(new JLabel("Descripcion:"));
            form.add(fieldDescripcion);

            // materiales es un combo box
            String[] materiales = { "Madera", "Aglomerado", "Metal", "Otro" }; // opciones de materiales
            JComboBox<String> comboMaterial = new JComboBox<>(materiales);
            form.add(new JLabel("Material:"));
            form.add(comboMaterial);

            form.add(new JLabel("Precio:"));
            form.add(fieldPrecio);

            // color es un combo box
            String[] colores = { "Blanco", "Gris", "Beidge", "Negro", "Cedro", "Roble", "Otro" };
            JComboBox<String> comboColor = new JComboBox<>(colores);
            form.add(new JLabel("Color:"));
            form.add(comboColor);

            form.add(new JLabel("Cantidad de unidades:"));
            form.add(fieldCantidad);

            // forma de la tapa es un combo box
            String[] formasTapa = { "Rectangular", "Cuadrada", "Ovalada", "Redonda", "Otro" };
            JComboBox<String> comboFormaTapa = new JComboBox<>(formasTapa);
            form.add(new JLabel("Forma de la tapa:"));
            form.add(comboFormaTapa);

            form.add(new JLabel("Ancho de la tapa:"));
            form.add(fieldAnchoTapa);
            form.add(new JLabel("Largo de la tapa:"));
            form.add(fieldLargoTapa);

            // material de la tapa es un combo box
            String[] materialesTapa = { "Madera", "Aglomerado", "Metal", "Vidrio", "Otro" };
            JComboBox<String> comboMaterialTapa = new JComboBox<>(materialesTapa);
            form.add(new JLabel("Material de la tapa:"));
            form.add(comboMaterialTapa);

            // botones para guardar o cancelar el registro del producto
            JButton btnGuardar = new JButton("Guardar");
            JButton btnCancelar = new JButton("Cancelar");

            btnGuardar.addActionListener(evento -> {
                try {

                    // validacion para campos vacios
                    if (fieldCodigo.getText().trim().isEmpty() ||
                            fieldDescripcion.getText().trim().isEmpty() ||
                            fieldPrecio.getText().trim().isEmpty() ||
                            fieldCantidad.getText().trim().isEmpty() ||
                            fieldAnchoTapa.getText().trim().isEmpty() ||
                            fieldLargoTapa.getText().trim().isEmpty() ||
                            comboMaterial.getSelectedItem() == null ||
                            comboColor.getSelectedItem() == null ||
                            comboFormaTapa.getSelectedItem() == null ||
                            comboMaterialTapa.getSelectedItem() == null) {

                        JOptionPane.showMessageDialog(dialog, "Complete todos los campos");
                        return;
                    }

                    // validaciones para tipos de datos datos ingresados en los campos
                    if (!fieldCodigo.getText().trim().matches("\\d+")) {
                        JOptionPane.showMessageDialog(dialog, "El codigo solo debe contener números");
                        return;
                    } else if (!fieldPrecio.getText().trim().matches("\\d+(\\.\\d+)?")) {
                        JOptionPane.showMessageDialog(dialog, "El precio debe ser un número válido");
                        return;
                    } else if (!fieldCantidad.getText().trim().matches("\\d+")) {
                        JOptionPane.showMessageDialog(dialog, "La cantidad de unidades solo debe contener números");
                        return;
                    } else if (!fieldAnchoTapa.getText().trim().matches("\\d+(\\.\\d+)?")) {
                        JOptionPane.showMessageDialog(dialog, "El ancho de la tapa debe ser un número válido");
                        return;
                    } else if (!fieldLargoTapa.getText().trim().matches("\\d+(\\.\\d+)?")) {
                        JOptionPane.showMessageDialog(dialog, "El largo de la tapa debe ser un número válido");
                        return;
                    } else {
                        int codigo = Integer.parseInt(fieldCodigo.getText().trim());
                        String descripcion = fieldDescripcion.getText().trim();
                        String material = (String) comboMaterial.getSelectedItem();
                        double precio = Double.parseDouble(fieldPrecio.getText().trim());
                        String color = (String) comboColor.getSelectedItem();
                        int cantidad = Integer.parseInt(fieldCantidad.getText().trim());
                        String formaTapa = (String) comboFormaTapa.getSelectedItem();
                        double anchoTapa = Double.parseDouble(fieldAnchoTapa.getText().trim());
                        double largoTapa = Double.parseDouble(fieldLargoTapa.getText().trim());
                        String materialTapa = (String) comboMaterialTapa.getSelectedItem();

                        // validamos que la mesa ya exista
                        if (productos.containsKey(codigo)) {
                            JOptionPane.showMessageDialog(dialog, "El producto con codigo: " + codigo + " ya existe");
                            return;
                        }

                        productos.put(codigo, new Mesa(codigo, descripcion, material, precio, color, cantidad,
                                formaTapa, anchoTapa, largoTapa, materialTapa));
                        JOptionPane.showMessageDialog(dialog, "Mesa registrada correctamente");
                        dialog.dispose(); // cerrar el dialogo despues de guardar la mesa
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error al registrar los datos");
                }
            });

            btnCancelar.addActionListener(ev -> dialog.dispose());

            // panel para los botones
            JPanel botones = new JPanel();
            botones.add(btnGuardar);
            botones.add(btnCancelar);

            JPanel contenedor = new JPanel(new BorderLayout(10, 10));
            contenedor.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
            contenedor.add(form, BorderLayout.CENTER);
            contenedor.add(botones, BorderLayout.SOUTH);
            dialog.setContentPane(contenedor);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

        } else if (mueble instanceof Silla) { // modal para registrar una silla

            JDialog dialog = new JDialog(this, "Registrar Silla", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // campos
            JTextField fieldCodigo = new JTextField();
            JTextField fieldDescripcion = new JTextField();
            JTextField fieldPrecio = new JTextField();
            JTextField fieldCantidad = new JTextField();

            // añadimos los campos
            JPanel form = new JPanel(new GridLayout(9, 2, 5, 4));
            form.add(new JLabel("Codigo:"));
            form.add(fieldCodigo);

            form.add(new JLabel("Descripcion:"));
            form.add(fieldDescripcion);

            String[] materiales = { "Madera", "Aglomerado", "Metal", "Otro" }; // opciones de materiales
            JComboBox<String> comboMaterial = new JComboBox<>(materiales);
            form.add(new JLabel("Material:"));
            form.add(comboMaterial);

            form.add(new JLabel("Precio:"));
            form.add(fieldPrecio);

            // color es un combo box
            String[] colores = { "Blanco", "Gris", "Beidge", "Negro", "Cedro", "Roble", "Otro" };
            JComboBox<String> comboColor = new JComboBox<>(colores);
            form.add(new JLabel("Color:"));
            form.add(comboColor);

            form.add(new JLabel("Cantidad de unidades:"));
            form.add(fieldCantidad);

            String[] materialesTapizado = { "Cuero", "Cuero sintético", "Tela", "Otro" };
            JComboBox<String> comboMaterialTapizado = new JComboBox<>(materialesTapizado);
            form.add(new JLabel("Material del tapizado:"));
            form.add(comboMaterialTapizado);

            String[] coloresTapizado = { "Beige", "Gris claro", "Gris oscuro", "Crema", "Blanco roto", "Marrón",
                    "Azul petróleo", "Verde esmeralda", "Amarillo mostaza", "Otro" };
            JComboBox<String> comboColorTapizado = new JComboBox<>(coloresTapizado);
            form.add(new JLabel("Color del tapizado:"));
            form.add(comboColorTapizado);

            // para la densidad de la espuma, se usan radioButtons para dar solo 2 opciones
            // a elegir
            JRadioButton densidadAlta = new JRadioButton("Alta");
            JRadioButton densidadMedia = new JRadioButton("Media");
            ButtonGroup grupoDensidad = new ButtonGroup();
            // añadimos los radio buttons al grupo para que solo se pueda seleccionar uno
            grupoDensidad.add(densidadAlta);
            grupoDensidad.add(densidadMedia);
            // creamos un panel para los radio buttons y los añadimos al formulario
            JPanel panelDensidad = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelDensidad.add(densidadAlta);
            panelDensidad.add(densidadMedia);
            form.add(new JLabel("Densidad de la espuma:"));
            form.add(panelDensidad);

            JButton btnGuardar = new JButton("Guardar");
            JButton btnCancelar = new JButton("Cancelar");

            btnGuardar.addActionListener(evento -> {
                try {

                    // validacion de campos vacios
                    if (fieldCodigo.getText().trim().isEmpty() ||
                            fieldDescripcion.getText().trim().isEmpty() ||
                            fieldPrecio.getText().trim().isEmpty() ||
                            fieldCantidad.getText().trim().isEmpty() ||
                            comboMaterialTapizado.getSelectedItem() == null ||
                            comboColorTapizado.getSelectedItem() == null ||
                            comboColor.getSelectedItem() == null ||
                            comboMaterial.getSelectedItem() == null ||
                            grupoDensidad.getSelection() == null) {
                        JOptionPane.showMessageDialog(dialog, "Complete todos los campos");
                        return;
                    }

                    // validacion de tipos de datos
                    if (!fieldCodigo.getText().trim().matches("\\d+")) {
                        JOptionPane.showMessageDialog(dialog, "El codigo solo debe contener números");
                        return;
                    } else if (!fieldPrecio.getText().trim().matches("\\d+(\\.\\d+)?")) {
                        JOptionPane.showMessageDialog(dialog, "El precio debe ser un número válido");
                        return;
                    } else if (!fieldCantidad.getText().trim().matches("\\d+")) {
                        JOptionPane.showMessageDialog(dialog, "La cantidad de unidades solo debe contener números");
                        return;
                    } else {

                        int codigo = Integer.parseInt(fieldCodigo.getText().trim());
                        String descripcion = fieldDescripcion.getText().trim();
                        String material = (String) comboMaterial.getSelectedItem();
                        double precio = Double.parseDouble(fieldPrecio.getText().trim());
                        String color = (String) comboColor.getSelectedItem();
                        int cantidad = Integer.parseInt(fieldCantidad.getText().trim());
                        String materialTapizado = (String) comboMaterialTapizado.getSelectedItem();
                        String colorTapizado = (String) comboColorTapizado.getSelectedItem();

                        String densidadEspuma = "";
                        if (densidadAlta.isSelected()) {
                            densidadEspuma = "Alta";
                        } else if (densidadMedia.isSelected()) {
                            densidadEspuma = "Media";
                        }

                        // validamos que la silla ya exista
                        if (productos.containsKey(codigo)) {
                            JOptionPane.showMessageDialog(dialog, "El producto con codigo: " + codigo + " ya existe");
                            return;
                        }

                        productos.put(codigo, new Silla(codigo, descripcion, material, precio, color, cantidad,
                                materialTapizado, colorTapizado, densidadEspuma));
                        JOptionPane.showMessageDialog(dialog, "Silla registrada correctamente");
                        dialog.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error en los datos");
                }
            });

            btnCancelar.addActionListener(ev -> dialog.dispose());

            JPanel botones = new JPanel();
            botones.add(btnGuardar);
            botones.add(btnCancelar);

            JPanel contenedor = new JPanel(new BorderLayout(10, 10));
            contenedor.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
            contenedor.add(form, BorderLayout.CENTER);
            contenedor.add(botones, BorderLayout.SOUTH);
            dialog.setContentPane(contenedor);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

        }

    }

    private void verProductos() {
        String cad = "";

        for (Mueble m : productos.values()) {
            cad += m.toString() + "\n";
        }
        JOptionPane.showMessageDialog(this, cad, "Productos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

}