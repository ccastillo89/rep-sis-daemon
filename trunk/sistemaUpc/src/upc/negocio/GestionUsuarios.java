package upc.negocio;

import java.util.Collection;

import upc.dao.UsuarioDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Persona;
import upc.modelo.Usuario;

public class GestionUsuarios {

	public Collection<Usuario> BuscarUsuariosPorCentroFormacion(Persona ps)
			throws DAOExcepcion {

		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarUsuariosPorCentroFormacion(ps);
	}

	public Usuario insertar(Usuario user) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.insertar(user);
	}

	public void eliminar(int idCategoria) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		dao.eliminar(idCategoria);
	}

	public Usuario actualizar(Usuario user) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.actualizar(user);
	}

	public Boolean loginUsuario(Usuario user) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.loginUsuario(user);
	}
	
	public Boolean validarCorreoPersona(Usuario user) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validarCorreoPersona(user);
	}

}
