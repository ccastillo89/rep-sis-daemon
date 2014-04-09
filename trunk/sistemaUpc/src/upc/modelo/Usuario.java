package upc.modelo;

public class Usuario {

    private int idUsuario;
    private String correo;
    private String password;
    private Codigo tipoUsuario;
    private Persona persona;
    
    //Campos adicionales
    private String nombretipoUsuario;

    
    public Usuario() {
		super();
	}
	
	public Usuario(int idUsuario, String correo, String password,
			Codigo tipoUsuario, Persona persona) {
		super();
		this.idUsuario = idUsuario;
		this.correo = correo;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.persona = persona;
	}
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Codigo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Codigo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombretipoUsuario() {
		return nombretipoUsuario;
	}

	public void setNombretipoUsuario(String nombretipoUsuario) {
		this.nombretipoUsuario = nombretipoUsuario;
	}



}