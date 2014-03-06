package upc.modelo;

public class Asesoria {
	
	private int idAsesoria;
    private int idPublicacion;
    private String observacion;
    private int calificacion;
    private String fechaAsesoria;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria, int idPublicacion, String observacion, int calificacion, String fechaAsesoria) {
        this.idAsesoria = idAsesoria;
        this.idPublicacion = idPublicacion;
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
	
	public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
	
    public String getFechaAsesoria() {
        return fechaAsesoria;
    }

    public void setFechaAsesoria(String fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    
}
