package upc.modelo;

public class UsuarioPermitido {
	private Comentario Comentario;
	private Usuario usuario;
	private int puntos;
	
	public Comentario getComentario() {
		return Comentario;
	}
	public void setComentario(Comentario comentario) {
		Comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
