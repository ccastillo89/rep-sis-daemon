package upc.negocio;

import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Asesoria;
import upc.dao.AsesoriaDAO;


public class GestionAsesoria {

	public Collection<Asesoria> Listar(Asesoria ase) throws DAOExcepcion {
		AsesoriaDAO dao = new AsesoriaDAO();
		return dao.Listar(ase);
	}
	
	public Asesoria insertar(Asesoria ase)	throws DAOExcepcion {
		
		AsesoriaDAO dao = new AsesoriaDAO();
		Asesoria asesoriaRegistrada = new Asesoria();
		
		String msg = "";
		
		if (ase.getObservacion().equals(""))
		{
			msg += "Ingrese alguna observaci�n \n\r"; 
			System.err.println("Ingrese nombre");
		}else if(ase.getFechaAsesoria().equals("")){
			msg += "Ingrese fecha asesoria \n\r";
			System.err.println("Ingrese fecha asesoria");
		}else if(ase.getPublicacion().getIdPublicacion() == 0){
			msg += "Seleccione publicaci�n \n\r";
			System.err.println("Seleccione publicaci�n");
		}else if(ase.getCalificacion().getIdCodigo() == 0){
			msg += "Seleccione calificaci�n \n\r";
			System.err.println("Seleccione calificaci�n");
		}
		
		if(msg.length() > 0){
			throw new DAOExcepcion(msg);
		}else{
			if(!validaAsesoria(ase)){
				System.err.println("Ya registr� una asesoria para el dia: " + ase.getFechaAsesoria());
				throw new DAOExcepcion("Ya registr� una asesoria para el dia: " + ase.getFechaAsesoria());
			}else{
				asesoriaRegistrada = dao.insertar(ase);
			}
		}
		
		return asesoriaRegistrada;
	}
	
	private Boolean validaAsesoria(Asesoria ase) throws DAOExcepcion {
		AsesoriaDAO dao = new AsesoriaDAO();
		return dao.validaAsesoria(ase);
	}
	
}
