/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.modelo;

import java.util.Collection;


/**
 *
 * @author proyecto
 */
public class CentroFormacion { 
	
	
	private int idCentroInformacion;
	private String nombre;
	private int tipo;
	private String url;
	private String logo;
	private Collection<Persona> persona;
	
	
	//campos adicionales
	private String strTipo;
	private double pago;
	private double costoporusuario;
	
	
	
	
	
	public Collection<Persona> getPersona() {
		return persona;
	}
	public void setPersona(Collection<Persona> persona) {
		this.persona = persona;
	}
	public int getIdCentroInformacion() {
		return idCentroInformacion;
	}
	public void setIdCentroInformacion(int idCentroInformacion) {
		this.idCentroInformacion = idCentroInformacion;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}


	
	public CentroFormacion(int idCentroInformacion, String nombre, int tipo,
			String url, String logo, Collection<Persona> persona) {
		super();
		this.idCentroInformacion = idCentroInformacion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.url = url;
		this.logo = logo;
		this.persona = persona;
	}
	public CentroFormacion() {
		super();
	
	}
	public String getStrTipo() {
		return strTipo;
	}
	public void setStrTipo(String strTipo) {
		this.strTipo = strTipo;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public double getCostoporusuario() {
		return costoporusuario;
	}
	public void setCostoporusuario(double costoporusuario) {
		this.costoporusuario = costoporusuario;
	}
	
	
	
	
	
}
