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
        
        // prueba
        modelo.Competidor c = new modelo.Competidor("Prueba", 25, "Colombia", 100, 1.75, 70);
        c.actualizarRanking(60, true);
        System.out.println(c); // el ranking debe quedar en 180. 
        // 100 (puntos previos) + 60 (ganados) + 20 (bonus si gano medalla y ganados > 50 = 20).

        SwingUtilities.invokeLater(() -> {
            VistaMundial vista = new VistaMundial();
            ControladorMundial controlador = new ControladorMundial(vista);
            vista.setVisible(true);
        });
    }
}
