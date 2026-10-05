/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author juans
 */

import java.util.ArrayList;
import modelo.Competidor;

/**
 * Gestiona la lista de competidores y conecta el modelo con la vista.
 */
public class ControladorMundial {

    private final ArrayList<Competidor> competidores;

    public ControladorMundial() {
        this.competidores = new ArrayList<>();
    }

    public void agregarCompetidor(Competidor competidor) {
        competidores.add(competidor);
    }

    public ArrayList<Competidor> getCompetidores() {
        return competidores;
    }
}
