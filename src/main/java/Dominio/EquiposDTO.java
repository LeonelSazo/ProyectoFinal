/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Leonel
 */
public class EquiposDTO {
    private String Id_equipo;
    private String Equipo;
    private int Partidos;
    private int Goles_favor;
    private int Puntos;

    /**
     * @return the Id_equipo
     */
    public String getId_equipo() {
        return Id_equipo;
    }

    /**
     * @param Id_equipo the Id_equipo to set
     */
    public void setId_equipo(String Id_equipo) {
        this.Id_equipo = Id_equipo;
    }

    /**
     * @return the Equipo
     */
    public String getEquipo() {
        return Equipo;
    }

    /**
     * @param Equipo the Equipo to set
     */
    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    /**
     * @return the Partidos
     */
    public int getPartidos() {
        return Partidos;
    }

    /**
     * @param Partidos the Partidos to set
     */
    public void setPartidos(int Partidos) {
        this.Partidos = Partidos;
    }

    /**
     * @return the Goles_favor
     */
    public int getGoles_favor() {
        return Goles_favor;
    }

    /**
     * @param Goles_favor the Goles_favor to set
     */
    public void setGoles_favor(int Goles_favor) {
        this.Goles_favor = Goles_favor;
    }

    /**
     * @return the Puntos
     */
    public int getPuntos() {
        return Puntos;
    }

    /**
     * @param Puntos the Puntos to set
     */
    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }
    

    
    
    @Override
    public String toString(){
        return "EquiposDTOS{" + "Id_Equipo=" + Id_equipo + ", Equipo=" + Equipo + " Partidos" + Partidos + " Goles_favor=" + Goles_favor + " Puntos=" + Puntos + '}';
    }
}
