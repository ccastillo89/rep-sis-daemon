package upc.modelo;

public class Comentario {

    public Comentario () {
    }
	
	public Comentario(int idComentario, String descripcion, int idUsuario,
			int idPublicacion, int puntos) {
		super();
		this.idComentario = idComentario;
		this.descripcion = descripcion;
		this.idUsuario = idUsuario;
		this.idPublicacion = idPublicacion;
		this.puntos = puntos;
	}
	
	private int idComentario;
	private String descripcion;
	private int idUsuario;
	private int idPublicacion;
	private int puntos;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
