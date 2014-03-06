/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.modelo;

/**
 *
 * @author proyecto
 */
public class Usuario {

    private int idUsuario;
    private String correo;
    private String password;
    private int tipoUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int idUsuario, String correo, String password,
            int tipoUsuario) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }
}