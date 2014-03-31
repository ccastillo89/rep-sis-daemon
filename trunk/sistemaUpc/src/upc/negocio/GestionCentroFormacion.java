package upc.negocio;

import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.dao.CentroFormacionDAO;

public class GestionCentroFormacion {
	
	
	
	public CentroFormacion insertar(CentroFormacion ci)	throws  DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		
		dao.buscarPorNombre(ci); 
		dao.buscarPorURL(ci); 
		return dao.insertar(ci);				
						
		
	}


	public void eliminar(int idCentroFormacion) throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		dao.eliminar(idCentroFormacion);
	}

	public CentroFormacion actualizar(CentroFormacion ci) throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.actualizar(ci);
		
	}

	
	public Collection<CentroFormacion> listar(CentroFormacion ci) throws DAOExcepcion {
		
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.listar(ci);
	}
	
	public CentroFormacion obtener(Integer IdCentroFormacion) throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();

		return dao.obtener(IdCentroFormacion);

	}

	

}
