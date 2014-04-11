package upc.negocio;

import java.text.ParseException;
import java.util.Collection;

import upc.dao.PublicacionDAO;
import upc.dao.UsuarioDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;
import upc.util.Utilitarios;

public class GestionPublicaciones {

	public Publicacion insertar(Publicacion pub) throws DAOExcepcion, ParseException {
				
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion pub2= new Publicacion();
		Utilitarios validar = new Utilitarios();
		
		if (dao.existeIdea(pub.getTitulo(),pub.getUsuario().getIdUsuario())== false) {
			if 	(validar.validarDatosIncompletos(pub)== true) {
				pub2=dao.insertar(pub);				
				}
			else {
				System.out.println("Datos Incomletos");	
				}
			}
		else {
			System.out.println("Ya idea ya Existe");	
			}
		
		
		
		//return dao.insertar(pub);
		//pub2=dao.insertar(pub);	
		return pub2;
		
	}
	
	 
	
	public Publicacion actualizar(Publicacion pub)	throws DAOExcepcion {
		
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion pub2= new Publicacion();
		Utilitarios validar = new Utilitarios();
				
		if 	(validar.validarDatosIncompletos(pub)== true) {
			pub2=dao.actualizar(pub);
		}
		else {
			System.out.println("Porfavor Completar Todos Los Datos");	
			}
		return pub2;
	}
	
	
	public Publicacion publicar(Publicacion pub) throws DAOExcepcion {
				
				PublicacionDAO dao = new PublicacionDAO();
				return dao.actualizar(pub);
			}
	
	 public Collection<Publicacion> buscarPubliUsuario(int idusuario,int estado)
             throws DAOExcepcion {
     PublicacionDAO dao = new PublicacionDAO();
     return dao.buscaPubliUsuario(idusuario, estado);
}
	  public Collection<Publicacion> ReportedePublicaciones(Publicacion pbePublicacion) throws DAOExcepcion
	  { PublicacionDAO dao = new PublicacionDAO();
	  return dao.ReportedePublicaciones(pbePublicacion); 
	  }
	 
 
         public Collection<Publicacion> buscarPublicacion(String nombre,int estado)
                        throws DAOExcepcion {
                PublicacionDAO dao = new PublicacionDAO();
                return dao.buscarPublicacion(nombre, estado);
        }
         

         public Collection<Publicacion> buscar(String nombre,int estado)
                 throws DAOExcepcion {
        	 
         PublicacionDAO dao = new PublicacionDAO();
         return dao.buscar(nombre, estado);
         
         }
         
     	public Publicacion actualizarEstado(Publicacion vo)
				throws DAOExcepcion {
     		
     			PublicacionDAO dao = new PublicacionDAO();
     			return dao.actualizarEstado(vo);
     			
     	}
     	
     	public void buscarAcesorPorUsuario(Publicacion vo)
				throws DAOExcepcion {
     		
     			PublicacionDAO dao = new PublicacionDAO();
     			 dao.buscarAcesorPorUsuario(vo);    			 
     			 
     			
     	}
     	
     	public Publicacion asignarAcesor(Publicacion vo)
				throws DAOExcepcion {
     		
     			PublicacionDAO dao = new PublicacionDAO();
     			return dao.asignarAsesor(vo);
     			
     	}
     	
     	public int contarPuntosPublicacion(Publicacion vo)
				throws DAOExcepcion {
     		
     			PublicacionDAO dao = new PublicacionDAO();
     			 return dao.contarPuntosPublicacion(vo);    			 
     			 
     			
     	}	

}
