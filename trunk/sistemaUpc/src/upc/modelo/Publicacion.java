package upc.modelo;

import java.util.Date;

public class Publicacion {
	
    private int idPublicacion;
    private int idComentario;
    private String titulo;
    private String descripcion;
    private String archivo;
    private int idUsuario;
    private int estado;
    private int usuarioAsesor;
    private Date fechaCreacion;
    private String palabraClave;
    private Date fechaPublicacion;
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getUsuarioAsesor() {
		return usuarioAsesor;
	}
	public void setUsuarioAsesor(int usuarioAsesor) {
		this.usuarioAsesor = usuarioAsesor;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getPalabraClave() {
		return palabraClave;
	}
	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Publicacion(int idPublicacion, int idComentario, String titulo,
			String descripcion, String archivo, int idUsuario, int estado,
			int usuarioAsesor, Date fechaCreacion, String palabraClave,
			Date fechaPublicacion) {
		
		this.idPublicacion = idPublicacion;
		this.idComentario = idComentario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.archivo = archivo;
		this.idUsuario = idUsuario;
		this.estado = estado;
		this.usuarioAsesor = usuarioAsesor;
		this.fechaCreacion = fechaCreacion;
		this.palabraClave = palabraClave;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Publicacion() {
		
	}
	
	
    
    
    


}
