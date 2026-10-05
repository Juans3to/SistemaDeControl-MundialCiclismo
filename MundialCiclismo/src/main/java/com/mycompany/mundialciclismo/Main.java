/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mundialciclismo;

/**
 *
 * @author juans
 */

import controlador.ControladorMundial;
import javax.swing.SwingUtilities;
import vista.VistaMundial;

/**
 * Clase principal: inicializa el MVC y lanza la ventana.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaMundial vista = new VistaMundial();
            ControladorMundial controlador = new ControladorMundial();
            vista.setVisible(true);
        });
    }
}
