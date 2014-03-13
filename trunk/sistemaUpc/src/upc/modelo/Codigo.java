package upc.modelo;


public class Codigo {
    private  int  idCodigo;
    private  String  descripcionCodigo;
    private  int  idGrupo;
    private  String  grupo;

    public Codigo(int idCodigo, String descripcionCodigo, int idGrupo, String grupo) {
        this.idCodigo = idCodigo;
        this.descripcionCodigo = descripcionCodigo;
        this.idGrupo = idGrupo;
        this.grupo = grupo;
    }
    
	public Codigo() {
		super();
	}

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
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
