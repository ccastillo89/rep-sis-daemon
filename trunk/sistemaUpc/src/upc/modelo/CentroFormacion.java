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
	private Collection<Personas> personas;
	
	
	
	
	
	public Collection<Personas> getPersonas() {
		return personas;
	}
	public void setPersonas(Collection<Personas> personas) {
		this.personas = personas;
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
			String url, String logo, Collection<Personas> personas) {
		super();
		this.idCentroInformacion = idCentroInformacion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.url = url;
		this.logo = logo;
		this.personas = personas;
	}
	public CentroFormacion() {
		super();
	}
	
	
	
	
	
}
