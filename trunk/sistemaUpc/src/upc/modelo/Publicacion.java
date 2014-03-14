package upc.modelo;

import java.util.Date;

public class Publicacion {
	
    private int idPublicacion;
    private String titulo;
    private String descripcion;
    private String archivo; 
    private Codigo estado; 
    private Date fechaCreacion;
    private String palabraClave;
    private Date fechaPublicacion;
    private Usuario usuario;
    private Usuario usuarioAsesor;
    
    
  //Campos Adicionales
    private Date fechainicio;
    private Date fechafin;
    
	
	public Publicacion(int idPublicacion, String titulo, String descripcion,
			String archivo, Codigo estado, Date fechaCreacion,
			String palabraClave, Date fechaPublicacion, Usuario usuario,
			Usuario usuarioAsesor) {
		super();
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.archivo = archivo;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.palabraClave = palabraClave;
		this.fechaPublicacion = fechaPublicacion;
		this.usuario = usuario;
		this.usuarioAsesor = usuarioAsesor;
	}
	public Publicacion() {
		super();
	}
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
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
	public Codigo getEstado() {
		return estado;
	}
	public void setEstado(Codigo estado) {
		this.estado = estado;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuarioAsesor() {
		return usuarioAsesor;
	}
	public void setUsuarioAsesor(Usuario usuarioAsesor) {
		this.usuarioAsesor = usuarioAsesor;
	}
    

	//get y set  campos adicionales
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	
}
