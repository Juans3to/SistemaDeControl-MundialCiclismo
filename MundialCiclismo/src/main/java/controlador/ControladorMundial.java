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
import vista.VistaMundial;

/**
 * Gestiona la lista de competidores y conecta el modelo con la vista.
 */
public class ControladorMundial {

    private final ArrayList<Competidor> competidores;
    private final VistaMundial vista;

    public ControladorMundial(VistaMundial vista) {
        this.competidores = new ArrayList<>();
        this.vista = vista;
        this.vista.addRegistrarListener(e -> registrarCompetidor());
        this.vista.addActualizarListener(e -> actualizarRankingCompetidor());
    }

    public void agregarCompetidor(Competidor competidor) {
        competidores.add(competidor);
    }

    public ArrayList<Competidor> getCompetidores() {
        return competidores;
    }

    private void actualizarRankingCompetidor() {
        int fila = vista.getFilaSeleccionada();

        if (fila < 0) {
            vista.mostrarMensaje("Selecciona un competidor de la tabla.");
            return;
        }

        try {
            int puntos = Integer.parseInt(vista.getPuntos().trim());

            if (puntos < 0) {
                vista.mostrarMensaje("Los puntos no pueden ser negativos.");
                return;
            }

            Competidor competidor = competidores.get(fila);

            // Se elige la sobrecarga segun si gano medalla o no
            if (vista.isGanoMedalla()) {
                competidor.actualizarRanking(puntos, true);
            } else {
                competidor.actualizarRanking(puntos);
            }

            vista.actualizarTabla(competidores);
            vista.limpiarPuntos();
            vista.mostrarMensaje("Ranking actualizado:\n" + competidor.toString());
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Los puntos deben ser un numero entero valido.");
        }
    }

    private void registrarCompetidor() {
        try {
            String nombre = vista.getNombre().trim();
            String pais = vista.getPais().trim();

            if (nombre.isEmpty() || pais.isEmpty()) {
                vista.mostrarMensaje("El nombre y el pais son obligatorios.");
                return;
            }

            int edad = Integer.parseInt(vista.getEdad().trim());
            int ranking = Integer.parseInt(vista.getRanking().trim());
            double estatura = Double.parseDouble(vista.getEstatura().trim().replace(',', '.'));
            double peso = Double.parseDouble(vista.getPeso().trim().replace(',', '.'));

            if (edad <= 0 || ranking < 0 || estatura <= 0 || peso <= 0) {
                vista.mostrarMensaje("Edad, estatura y peso deben ser mayores a 0 y el ranking no puede ser negativo.");
                return;
            }

            Competidor nuevo = new Competidor(nombre, edad, pais, ranking, estatura, peso);
            agregarCompetidor(nuevo);
            vista.actualizarTabla(competidores);
            vista.limpiarCampos();
            vista.mostrarMensaje("Competidor registrado:\n" + nuevo.toString());
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Edad, ranking, estatura y peso deben ser numeros validos.");
        }
    }
}