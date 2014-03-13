package upc.negocio;

import java.util.ArrayList;
import java.util.Collection;

import upc.dao.CobranzaDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;

public class GestionCobranza {

	  public Collection<CentroFormacion> ListaCobranza(CentroFormacion pbeCentroformacion) throws DAOExcepcion
	  { CobranzaDAO dao = new CobranzaDAO();
	  Collection<CentroFormacion> listacf=new ArrayList<CentroFormacion>();
	  
	  listacf= dao.ListaCobranza(pbeCentroformacion); 
	  
	  for (CentroFormacion centroFormacion : listacf) {
		centroFormacion.setPago(centroFormacion.getPersona().size()*pbeCentroformacion.getCostoporusuario());
	}
	  
	  return listacf;
	  }
}
