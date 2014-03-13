package upc.negocio;

import java.util.Collection;

import upc.dao.CobranzaDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;

public class GestionCobranza {

	  public Collection<CentroFormacion> ListaCobranza(CentroFormacion pbeCentroformacion) throws DAOExcepcion
	  { CobranzaDAO dao = new CobranzaDAO();
	  return dao.ListaCobranza(pbeCentroformacion); 
	  }
}
