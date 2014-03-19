package upc.modelo;

public class Asesoria {
	
	private int idAsesoria;
    private Publicacion publicacion;
    private String observacion;
    private Codigo calificacion;
    private String fechaAsesoria;
    
	public Asesoria() {
		super();
	}

	public Asesoria(int idAsesoria, Publicacion publicacion,
			String observacion, Codigo calificacion, String fechaAsesoria) {
		super();
		this.idAsesoria = idAsesoria;
		this.publicacion = publicacion;
		this.observacion = observacion;
		this.calificacion = calificacion;
		this.fechaAsesoria = fechaAsesoria;
	}
	
	public int getIdAsesoria() {
		return idAsesoria;
	}
	public void setIdAsesoria(int idAsesoria) {
		this.idAsesoria = idAsesoria;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Codigo getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Codigo calificacion) {
		this.calificacion = calificacion;
	}
	public String getFechaAsesoria() {
		return fechaAsesoria;
	}
	public void setFechaAsesoria(String fechaAsesoria) {
		this.fechaAsesoria = fechaAsesoria;
	}



    
}
