package upc.negocio;

import java.text.ParseException;
import java.util.Collection;

import upc.dao.PublicacionDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;

public class GestionPublicaciones {

	public Publicacion insertar(Publicacion pub) throws DAOExcepcion {
				
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion pub2= new Publicacion();
		
		if (dao.existeIdea(pub.getTitulo(),pub.getUsuario().getIdUsuario())== false) {
			try {
				pub2=dao.insertar(pub);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
			}
		else {
			System.out.println("Ya idea ya Existe");	
			}
		return pub2;
		
	}
	
	 
	
	public Publicacion actualizar(Publicacion pub)	throws DAOExcepcion {
		
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion vo = new Publicacion();
				
		return dao.actualizar(vo);
	}
	
	/*
	public Publicacion publicar(int idPublicacion,int estado,Date fechaPublicacion)
							throws DAOExcepcion {
				
				PublicacionDAO dao = new PublicacionDAO();
				Publicacion vo = new Publicacion();
				
				vo.setIdPublicacion(idPublicacion);
				vo.setEstado(estado);
				vo.setFechaPublicacion(fechaPublicacion);
												
				return dao.actualizar(vo);
			}
	*/
	
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
     	
     	public Publicacion asignarAcesor(Publicacion vo)
				throws DAOExcepcion {
     		
     			PublicacionDAO dao = new PublicacionDAO();
     			return dao.asignarAcesor(vo);
     			
     	}

}
