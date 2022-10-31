/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.*;
/**
 *
 * @author Leonel
 */
public class Conexion1 {
    
    
    private static final String JDBC_URL = "jdbc:sqlite:C:\\Users\\Leonel\\Desktop\\FinalPrograII\\FinalPrograII.db";
    private static final String JDBC_USER = "";
    private static final String JDBC_PASS = "";
    
    
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
    
    public static void close(ResultSet cls){
        try {
            cls.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
