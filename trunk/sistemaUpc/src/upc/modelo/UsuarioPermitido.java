package upc.modelo;

public class UsuarioPermitido {
	private Publicacion Publicacion;
	private Usuario usuario;
	private int puntos;
	
	
	public UsuarioPermitido() {
		super();
	}
	public UsuarioPermitido(upc.modelo.Publicacion publicacion,
			Usuario usuario, int puntos) {
		super();
		Publicacion = publicacion;
		this.usuario = usuario;
		this.puntos = puntos;
	}
	public Publicacion getPublicacion() {
		return Publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		Publicacion = publicacion;
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
