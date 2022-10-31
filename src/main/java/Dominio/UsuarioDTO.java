/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Leonel
 */
public class UsuarioDTO {
    private int Id_User;
    private String Usuario;
    private String Contrasena;

    /**
     * @return the Id_User
     */
    public int getId_User() {
        return Id_User;
    }

    /**
     * @param Id_User the Id_User to set
     */
    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Contrasena
     */
    public String getContrasena() {
        return Contrasena;
    }

    /**
     * @param Contrasena the Contrasena to set
     */
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    
    @Override
    public String toString() {
        return "UsuarioDTO{" + "Id_User=" + Id_User + ", Usuario=" + Usuario + ", Contrasena=" + Contrasena +  '}';
    }
}
