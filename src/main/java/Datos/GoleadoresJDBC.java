/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.GoleadoresDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Datos.Conexion1;

/**
 *
 * @author Leonel
 */
public class GoleadoresJDBC {
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_jugador, Jugador, Part_jugados, Goles FROM persona";
    private static final String SQL_INSERT = "INSERT INTO Goleadores(Id_jugador, Jugador, Part_jugados, Goles) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Goleadores SET Jugador= ?, Part_jugados= ?, Goles= ? WHERE Id_Jugador = ?";
    private static final String SQL_DELETE = "DELETE FROM Goleadores WHERE Id_jugador=?";
    
    
    public GoleadoresJDBC() {

    }

    public GoleadoresJDBC (Connection conexionTransaccional) {
        
        this.conexionTransaccional = conexionTransaccional;
    }

    
    public List<GoleadoresDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet cls = null;
        GoleadoresDTO jugador = null;
        List<GoleadoresDTO> Jugadores = new ArrayList<GoleadoresDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            cls = stmt.executeQuery();
            while (cls.next()) {
                String Id_jugador = cls.getString("id_Jugador");
                String Jugador = cls.getString("Jugador");
                int Part_jugados = cls.getInt("Partidos jugados");
                int Goles = cls.getInt("Goles");
               
                jugador = new GoleadoresDTO();
                jugador.setId_jugador(Id_jugador);
                jugador.setJugadro(Jugador);
                jugador.setPart_jugados(Part_jugados);
                jugador.setGoles(Goles);
                
                Jugadores.add(jugador);
            }
        } finally {
            Conexion1.close(cls);
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }

        }

        return Jugadores;
    }

   
   
    public int insert(GoleadoresDTO Jugadores) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
           
            stmt.setString(1, Jugadores.getId_jugador());
            stmt.setString(2, Jugadores.getJugadro());
            stmt.setInt(3, Jugadores.getPart_jugados());
            stmt.setInt(4, Jugadores.getGoles());
            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }
        }

        return rows;
    }

 
    public int update(GoleadoresDTO Equipos) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, Equipos.getId_jugador());
            stmt.setString(2, Equipos.getJugadro());
            stmt.setInt(3, Equipos.getPart_jugados());
            stmt.setInt(4, Equipos.getGoles());

            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }
        }

        return rows;
    }

    public int delete(GoleadoresDTO Jugadores) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null ;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, Jugadores.getId_jugador());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }
        }

        return rows;
    }
}
