package upc.negocio;

import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Persona;
import upc.dao.PersonaDAO;

public class GestionPersona {
	
	public Persona insertar(Persona ps)	throws  DAOExcepcion {
		
		PersonaDAO dao = new PersonaDAO();
		return dao.insertar(ps);
	}
	
	public void eliminar(int idPersona) throws DAOExcepcion {
		
		PersonaDAO dao = new PersonaDAO();
		dao.eliminar(idPersona);
	}
	
	public Persona actualizar(Persona ps) throws DAOExcepcion {
		
		PersonaDAO dao = new PersonaDAO();
		return dao.actualizar(ps);
		
	}
	
	public Collection<Persona> buscarPersonaPorNombreCentroFormacion(Persona ps) throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.buscarPersonaPorNombreCentroFormacion(ps);
	}

	
}
