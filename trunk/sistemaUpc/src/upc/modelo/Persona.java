package upc.modelo;

public class Persona {
    private int idPersonas; 
    private int idUsuario;
    private String nombres;
    private String paterno;
    private String materno;
    private int sexo;
    private int tipoDocumento;
    private String numeroDoc;
    private String celular;
    private CentroFormacion centroFormacion;

    
	public Persona() {
		super();
	}
	
	public Persona(int idPersonas, int idUsuario, String nombres,
			String paterno, String materno, int sexo, int tipoDocumento,
			String numeroDoc, String celular, CentroFormacion centroFormacion) {
		super();
		this.idPersonas = idPersonas;
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.sexo = sexo;
		this.tipoDocumento = tipoDocumento;
		this.numeroDoc = numeroDoc;
		this.celular = celular;
		this.centroFormacion = centroFormacion;
	}
	
	public int getIdPersonas() {
		return idPersonas;
	}
	public void setIdPersonas(int idPersonas) {
		this.idPersonas = idPersonas;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public CentroFormacion getCentroFormacion() {
		return centroFormacion;
	}
	public void setCentroFormacion(CentroFormacion centroFormacion) {
		this.centroFormacion = centroFormacion;
	}
	
}
