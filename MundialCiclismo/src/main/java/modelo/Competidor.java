/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */


/**
 * Ciclista que participa en el Mundial de Ciclismo de Pista.
 * Hereda los datos basicos de Atleta y agrega ranking, estatura y peso.
 */
public class Competidor extends Atleta {

    private int ranking;      // puntaje acumulado en el ranking mundial
    private double estatura;  // en metros
    private double peso;      // en kilogramos

    public Competidor(String nombre, int edad, String pais,
                      int ranking, double estatura, double peso) {
        super(nombre, edad, pais);
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Sobreescritura: reutiliza el toString de la superclase con super
    @Override
    public String toString() {
        return super.toString() + " | Ranking: " + ranking
                + " | Estatura: " + estatura + " m | Peso: " + peso + " kg";
    }
}
