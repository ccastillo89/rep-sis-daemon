package upc.negocio;

import java.util.Collection;

import upc.dao.CodigoDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Codigo;

public class GestionCodigos {

	public Collection<Codigo> ListarCodigosPorIdGrupo(Codigo co) throws DAOExcepcion {
		CodigoDAO dao = new CodigoDAO();
		return dao.ListarCodigosPorIdGrupo(co);
	}
}
