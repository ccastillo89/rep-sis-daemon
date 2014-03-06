/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.modelo;

/**
 *
 * @author proyecto
 */
public class OpcionesMenu {

    private int idOpcionesMenu;
    private String nombre;

    public OpcionesMenu(int idOpcionesMenu, String nombre) {
        this.idOpcionesMenu = idOpcionesMenu;
        this.nombre = nombre;
    }

    public int getIdOpcionesMenu() {
        return idOpcionesMenu;
    }

    public void setIdOpcionesMenu(int idOpcionesMenu) {
        this.idOpcionesMenu = idOpcionesMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
