/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author juans
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Competidor;

public class VistaMundial extends JFrame {

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPais;
    private JTextField txtRanking;
    private JTextField txtEstatura;
    private JTextField txtPeso;
    private JButton btnRegistrar;
    private JTable tablaCompetidores;
    private DefaultTableModel modeloTabla;

    public VistaMundial() {
        setTitle("Mundial de Ciclismo de Pista - Cali");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(crearPanelFormulario(), BorderLayout.NORTH);
        add(crearPanelTabla(), BorderLayout.CENTER);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registrar competidor"));

        txtNombre = new JTextField();
        txtEdad = new JTextField();
        txtPais = new JTextField();
        txtRanking = new JTextField();
        txtEstatura = new JTextField();
        txtPeso = new JTextField();
        btnRegistrar = new JButton("Registrar");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Edad:"));
        panel.add(txtEdad);
        panel.add(new JLabel("Pais:"));
        panel.add(txtPais);
        panel.add(new JLabel("Ranking (puntos):"));
        panel.add(txtRanking);
        panel.add(new JLabel("Estatura (m):"));
        panel.add(txtEstatura);
        panel.add(new JLabel("Peso (kg):"));
        panel.add(txtPeso);
        panel.add(new JLabel(""));
        panel.add(btnRegistrar);

        return panel;
    }

    private JScrollPane crearPanelTabla() {
        String[] columnas = {"Nombre", "Edad", "Pais", "Ranking", "Estatura (m)", "Peso (kg)"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; // la tabla es solo de lectura
            }
        };
        tablaCompetidores = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaCompetidores);
        scroll.setBorder(BorderFactory.createTitledBorder("Competidores registrados"));
        return scroll;
    }

    // ---- Listeners ----
    public void addRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    // ---- Lectura de los campos ----
    public String getNombre() {
        return txtNombre.getText();
    }

    public String getEdad() {
        return txtEdad.getText();
    }

    public String getPais() {
        return txtPais.getText();
    }

    public String getRanking() {
        return txtRanking.getText();
    }

    public String getEstatura() {
        return txtEstatura.getText();
    }

    public String getPeso() {
        return txtPeso.getText();
    }

    // ---- Acciones sobre la vista ----
    public void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPais.setText("");
        txtRanking.setText("");
        txtEstatura.setText("");
        txtPeso.setText("");
        txtNombre.requestFocus();
    }

    public void actualizarTabla(ArrayList<Competidor> competidores) {
        modeloTabla.setRowCount(0);
        for (Competidor c : competidores) {
            modeloTabla.addRow(new Object[]{
                c.getNombre(), c.getEdad(), c.getPais(),
                c.getRanking(), c.getEstatura(), c.getPeso()
            });
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
