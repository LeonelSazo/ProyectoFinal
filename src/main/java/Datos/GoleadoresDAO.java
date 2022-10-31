/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;


import Dominio.GoleadoresDTO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Leonel
 */
public interface GoleadoresDAO {
    
    public List<GoleadoresDTO> select() throws SQLException;
    
    public int insert(GoleadoresDTO Goleadores) throws SQLException;
    
    public int update(GoleadoresDTO Goleadores) throws SQLException;
    
    public int delete(GoleadoresDTO Goleadores) throws SQLException;
}
