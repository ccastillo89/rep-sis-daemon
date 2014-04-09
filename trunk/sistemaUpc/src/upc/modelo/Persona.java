package upc.modelo;

public class Persona {
    private int idPersona;
    private String nombres;
    private String paterno;
    private String materno;
    private Codigo sexo;
    private Codigo tipoDocumento;
    private String numeroDoc;
    private String celular;
    private CentroFormacion centroFormacion;
    private String nombreCompleto;
	

    
	public Persona() {
		super();
	}
	
	public Persona(int idPersona, String nombres,
			String paterno, String materno, Codigo sexo, Codigo tipoDocumento,
			String numeroDoc, String celular, CentroFormacion centroFormacion) {
		super();
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.sexo = sexo;
		this.tipoDocumento = tipoDocumento;
		this.numeroDoc = numeroDoc;
		this.celular = celular;
		this.centroFormacion = centroFormacion;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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
	
  

	public Codigo getSexo() {
		return sexo;
	}

	public void setSexo(Codigo sexo) {
		this.sexo = sexo;
	}

	public Codigo getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Codigo tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
}
