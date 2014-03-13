/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.modelo;

/**
 *
 * @author proyecto
 */
public class Codigo {
    private  int  idCodigo;
    private  String  descripcionCodigo;
    private  int  idGrupo;
    private  String  grupo;

    public Codigo(int idCodigos, String descripcionCodigo, int idGrupo, String grupo) {
        this.idCodigo = idCodigos;
        this.descripcionCodigo = descripcionCodigo;
        this.idGrupo = idGrupo;
        this.grupo = grupo;
    }

    public int getIdCodigos() {
        return idCodigo;
    }

    public void setIdCodigos(int idCodigos) {
        this.idCodigo = idCodigos;
    }

    public String getDescripcionCodigo() {
        return descripcionCodigo;
    }

    public void setDescripcionCodigo(String descripcionCodigo) {
        this.descripcionCodigo = descripcionCodigo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
