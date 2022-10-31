/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;
import Dominio.EquiposDTO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Leonel
 */
public interface EquiposDAO {
    public List<EquiposDTO> select() throws SQLException;
    
    public int insert(EquiposDTO Equipos) throws SQLException;
    
    public int update(EquiposDTO Equipos) throws SQLException;
    
    public int delete(EquiposDTO Equipos) throws SQLException;
}
