package upc.negocio;

import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.dao.CentroFormacionDAO;

public class GestionCentroFormacion {
	
	
	
	public CentroFormacion insertar(CentroFormacion ci)	throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		
		if (dao.buscarPorNombre(ci) == 0)
		{
			return dao.insertar(ci);				
		}
		else
		{
			
			throw new SQLException("Centro de formación ya registrado.");
		}
				
		
	}


	public void eliminar(int idCentroFormacion) throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		dao.eliminar(idCentroFormacion);
	}

	public CentroFormacion actualizar(CentroFormacion ci) throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.actualizar(ci);
		
	}

	
	public Collection<CentroFormacion> listar() throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.listar();
	}

	

}
