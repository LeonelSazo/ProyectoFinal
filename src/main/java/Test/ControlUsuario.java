/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Datos.Conexion1;
import Datos.UsuarioJDBC;


import Dominio.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Leonel
 */
public class ControlUsuario {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion1.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);

            UsuarioDTO cambioUsuario = new UsuarioDTO();
            cambioUsuario.setId_User(1);
            cambioUsuario.setUsuario("Leonel");
            cambioUsuario.setContrasena("506");
            usuarioJdbc.update(cambioUsuario);

            UsuarioDTO nuevoUsuario = new UsuarioDTO();
            nuevoUsuario.setUsuario("ale");
            nuevoUsuario.setContrasena("1234");
            usuarioJdbc.insert(nuevoUsuario);

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
    }
}
