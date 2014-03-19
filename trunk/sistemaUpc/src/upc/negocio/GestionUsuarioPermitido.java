package upc.negocio;

import java.text.ParseException;

import upc.dao.UsuarioPermitidoDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.UsuarioPermitido;

public class GestionUsuarioPermitido {
	
	public UsuarioPermitido acceso(UsuarioPermitido usuPer) throws DAOExcepcion, ParseException {
		
		UsuarioPermitidoDAO dao = new UsuarioPermitidoDAO();
		UsuarioPermitido usuPer2= new UsuarioPermitido();
				
		if (dao.existeUsuario(usuPer.getUsuario().getIdUsuario())== false) {
			usuPer2=dao.darAcceso(usuPer);				
				
			}
		else {
			System.out.println("El usuario ya tiene permiso");	
			}
		return usuPer2;
		
	}

}
