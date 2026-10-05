/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author juans
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Vista del Mundial: ventana Swing (JFrame).
 * En los siguientes commits agregaremos los campos, botones y la tabla.
 */

public class VistaMundial extends JFrame {

    public VistaMundial() {
        setTitle("Mundial de Ciclismo de Pista - Cali");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
