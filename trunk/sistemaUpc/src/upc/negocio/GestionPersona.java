package upc.negocio;

import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Persona;
import upc.modelo.Usuario;
import upc.dao.PersonaDAO;
import upc.dao.UsuarioDAO;

public class GestionPersona {
	
	public Persona insertar(Persona ps)	throws DAOExcepcion {
		
		PersonaDAO dao = new PersonaDAO();
		String msg = "";
		Persona personaRegistrada = new Persona();
		
		if (ps.getNombres().equals(""))
		{
			msg += "Ingrese nombre \n\r"; 
			System.err.println("Ingrese nombre");
		}else if(ps.getPaterno().equals("")){
			msg += "Ingrese Apellido Paterno \n\r";
			System.err.println("Ingrese Apellido Paterno");
		}else if(ps.getMaterno().equals("")){
			msg += "Ingrese Apellido Materno \n\r";
			System.err.println("Ingrese Apellido Materno");
		}
		else if(ps.getSexo().getIdCodigo() == 0){
			msg += "Seleccione Genero \n\r";
			System.err.println("Ingrese Genero");
		}else if(ps.getTipoDocumento().getIdCodigo() == 0){
			msg += "Seleccione Tipo documento \n\r";
			System.err.println("Seleccione Tipo Documento");
		}
		else if(ps.getNumeroDoc().equals("")){
			msg += "Ingrese Nro. documento \n\r";
			System.err.println("Ingrese Nro. documento");
		}else if(ps.getCelular().equals("")){
			msg += "Ingrese número de celular \n\r";
			System.err.println("Ingrese número de celular");
		}
		
		if(msg.length() > 0){
			throw new DAOExcepcion(msg);
		}else{
			
			if(!validarDocumentoIdentidad(ps)){
				System.err.println("El nro de documento ingresado ya existe. Verifique.");
				throw new DAOExcepcion("El nro de documento ingresado ya existe. Verifique.");
			}else if(!validarDocumentoIdentidad(ps)){
				System.err.println("El email ingresado ya existe. Verifique.");
				throw new DAOExcepcion("El email ingresado ya existe. Verifique.");
			}else{
				personaRegistrada = dao.insertar(ps);
			}
		}
		
		return personaRegistrada;
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
	
	public Boolean validarDocumentoIdentidad(Persona ps) throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.validarDocumentoIdentidad(ps);
	}
}
