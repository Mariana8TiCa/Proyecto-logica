package com.mycompany.proyecto_logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Diálogo modal para el registro de un nuevo cliente.
 *
 * <p>Uso típico:
 * <pre>
 *   ClienteRegistroDialog dlg = new ClienteRegistroDialog(frame, clienteService);
 *   dlg.setVisible(true);
 *   if (dlg.isConfirmado()) {
 *       // cliente registrado con éxito
 *   }
 * </pre>
 */
public class ClienteRegistroDialog extends JDialog {

    private final JTextField txtDocumento   = new JTextField(20);
    private final JTextField txtNombre      = new JTextField(20);
    private final JTextField txtFecha       = new JTextField(10);

    private final ClienteService clienteService;
    private boolean confirmado = false;

    public ClienteRegistroDialog(JFrame owner, ClienteService clienteService) {
        super(owner, "Registrar cliente", true);
        this.clienteService = clienteService;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        pack();
        setLocationRelativeTo(owner);
    }

    // ── Construcción de la interfaz ──────────────────────────────────────────

    private void initUI() {
        JPanel form = buildFormPanel();
        JPanel botones = buildButtonPanel();

        getContentPane().setLayout(new BorderLayout(0, 8));
        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);
    }

    private JPanel buildFormPanel() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets  = new Insets(6, 8, 6, 8);
        gbc.anchor  = GridBagConstraints.WEST;
        gbc.fill    = GridBagConstraints.HORIZONTAL;

        // Fila 0 – Documento
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        form.add(new JLabel("Documento de identidad:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtDocumento, gbc);

        // Fila 1 – Nombre
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        form.add(new JLabel("Nombre completo:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtNombre, gbc);

        // Fila 2 – Fecha
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        form.add(new JLabel("Fecha de nacimiento (DD/MM/AAAA):"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtFecha, gbc);

        return form;
    }

    private JPanel buildButtonPanel() {
        JButton btnAceptar  = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> onAceptar());
        btnCancelar.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        panel.add(btnCancelar);
        panel.add(btnAceptar);
        return panel;
    }

    // ── Lógica del botón Aceptar ─────────────────────────────────────────────

    private void onAceptar() {
        String documento = txtDocumento.getText().trim();
        String nombre    = txtNombre.getText().trim();
        String fecha     = txtFecha.getText().trim();

        // 1. Validar campos
        try {
            ClienteValidator.validar(documento, nombre, fecha);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Datos inválidos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Registrar en el servicio
        Cliente nuevoCliente = new Cliente(
                documento, nombre, ClienteValidator.parsearFecha(fecha));
        try {
            clienteService.registrar(nuevoCliente);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Cliente duplicado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Éxito
        JOptionPane.showMessageDialog(this,
                "Cliente registrado exitosamente.",
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        confirmado = true;
        dispose();
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    /**
     * @return {@code true} si el usuario completó el registro satisfactoriamente.
     */
    public boolean isConfirmado() {
        return confirmado;
    }
}
