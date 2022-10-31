/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Leonel
 */
public class GoleadoresDTO {
    
    private String Id_jugador;
    private String Jugador;
    private int Part_jugados;
    private int Goles;

    /**
     * @return the Id_jugador
     */
    public String getId_jugador() {
        return Id_jugador;
    }

    /**
     * @param Id_jugador the Id_jugador to set
     */
    public void setId_jugador(String Id_jugador) {
        this.Id_jugador = Id_jugador;
    }

    /**
     * @return the Jugadro
     */
    public String getJugadro() {
        return Jugador;
    }

    /**
     * @param Jugadro the Jugadro to set
     */
    public void setJugadro(String Jugadro) {
        this.Jugador = Jugadro;
    }

    /**
     * @return the Part_jugados
     */
    public int getPart_jugados() {
        return Part_jugados;
    }

    /**
     * @param Part_jugados the Part_jugados to set
     */
    public void setPart_jugados(int Part_jugados) {
        this.Part_jugados = Part_jugados;
    }

    /**
     * @return the Goles
     */
    public int getGoles() {
        return Goles;
    }

    /**
     * @param Goles the Goles to set
     */
    public void setGoles(int Goles) {
        this.Goles = Goles;
    }
    
    
    @Override
    public String toString() {
        return "GoleadoresDTO{" + "Id_jugador=" + Id_jugador + ", Jugador=" + Jugador + ", Part_jugados=" + Part_jugados + ", Goles=" + Goles +  '}';
    }
}
