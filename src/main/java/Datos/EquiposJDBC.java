/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.EquiposDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonel
 */
public class EquiposJDBC implements EquiposDAO{
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_equipo, Equipo, Partidos, Goles_favor, Putos FROM Equipos";
    private static final String SQL_INSERT = "INSERT INTO Equipos(Id_equipo, Equipo, Partidos, Goles_favor, Puntos) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Equipos SET Equipo= ?, Partidos= ?, Goles_favor= ?, Puntos= ? WHERE Id_equipo = ?";
    private static final String SQL_DELETE = "DELETE FROM Equipos WHERE Id_Equipo=?";
    
    
    public EquiposJDBC() {

    }

    public EquiposJDBC(Connection conexionTransaccional) {
        
        this.conexionTransaccional = conexionTransaccional;
    }

    
    public List<EquiposDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet cls = null;
        EquiposDTO equipos = null;
        List<EquiposDTO> Equipos = new ArrayList<EquiposDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            cls = stmt.executeQuery();
            while (cls.next()) {
                String Id_equipo = cls.getString("id_equipo");
                String equipo = cls.getString("Equipo");
                int Part_jugados = cls.getInt("Partidos");
                int Goles_favor = cls.getInt("Goles a favor");
                int Puntos = cls.getInt("Puntos");

                equipos = new EquiposDTO();
                equipos.setId_equipo(Id_equipo);
                equipos.setEquipo(equipo);
                equipos.setPartidos(Part_jugados);
                equipos.setGoles_favor(Goles_favor);
                equipos.setPuntos(Puntos);

                Equipos.add(equipos);
            }
        } finally {
            Conexion1.close(cls);
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }

        }

        return Equipos;
    }

   
   
    public int insert(EquiposDTO Equipos) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
           
            stmt.setString(1, Equipos.getId_equipo());
            stmt.setString(2, Equipos.getEquipo());
            stmt.setInt(3, Equipos.getPartidos());
            stmt.setInt(4, Equipos.getGoles_favor());
            stmt.setInt(5, Equipos.getPuntos());

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

 
    public int update(EquiposDTO Equipos) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, Equipos.getId_equipo());
            stmt.setString(2, Equipos.getEquipo());
            stmt.setInt(3, Equipos.getPartidos());
            stmt.setInt(4, Equipos.getGoles_favor());
            stmt.setInt(5, Equipos.getPuntos());
            
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

    public int delete(EquiposDTO Equipos) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null ;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, Equipos.getId_equipo());
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
