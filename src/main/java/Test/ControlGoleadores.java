/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Datos.Conexion1;
import java.sql.*;
import Datos.GoleadoresJDBC;
import Dominio.GoleadoresDTO;

/**
 *
 * @author Leonel
 */
public class ControlGoleadores {
    
    public static void main(String[] args) throws SQLException {

        //definimos la variable conexion
        Connection conexion = null;
        
        try {
            conexion = Conexion1.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            GoleadoresJDBC jugadoresjdbc = new GoleadoresJDBC(conexion);
            
            GoleadoresDTO cambioGoleador = new GoleadoresDTO();
            cambioGoleador.setId_jugador("C10");
            cambioGoleador.setJugadro("Frank");
            cambioGoleador.setPart_jugados(8);
            cambioGoleador.setGoles(3);
            jugadoresjdbc.update(cambioGoleador);
            
            
            GoleadoresDTO nuevogoleador = new GoleadoresDTO();
            nuevogoleador.setId_jugador("C20");
            nuevogoleador.setJugadro("Pedri");
            nuevogoleador.setPart_jugados(10);
            nuevogoleador.setGoles(9);
            jugadoresjdbc.insert(nuevogoleador);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
}}
