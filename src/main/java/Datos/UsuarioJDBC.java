/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import Dominio.UsuarioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonel
 */
public class UsuarioJDBC {
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_User, Usuario, Contrasena FROM Usuarios";
    private static final String SQL_INSERT = "INSERT INTO Usuarios(Usuario, Contrasena) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET Usuario=?, Contrasena=? WHERE Id_user = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuarios WHERE Id_user=?";

    public UsuarioJDBC() {

    }

    public UsuarioJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<UsuarioDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_User = rs.getInt("id_User");
                String Usuario = rs.getString("Usuario");
                String Contrasena = rs.getString("Contrasena");

                usuario = new UsuarioDTO();
                usuario.setId_User(Id_User);
                usuario.setUsuario(Usuario);
                usuario.setContrasena(Contrasena);

                usuarios.add(usuario);
            }
        } finally {
            Conexion1.close(rs);
            Conexion1.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion1.close(conn);
            }
        }

        return usuarios;
    }

    public int insert(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());

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

    public int update(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getId_User());

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

    public int delete(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_User());
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
