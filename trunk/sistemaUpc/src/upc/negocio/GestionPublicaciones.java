package upc.negocio;

import java.sql.Date;
import java.text.ParseException;
import java.util.Collection;

import upc.dao.PublicacionDAO;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;

public class GestionPublicaciones {

	public Publicacion insertar(String titulo, String descripcion,String archivo,int idUsuario,
				int estado,Date fechaCreacion,String palabraClave)
			throws DAOExcepcion, ParseException {
		
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion vo = new Publicacion();
		vo.setTitulo(titulo);
		vo.setDescripcion(descripcion);
		vo.setArchivo(archivo);
		vo.setIdUsuario(idUsuario);
		vo.setEstado(estado);
		vo.setFechaCreacion(fechaCreacion);
		vo.setPalabraClave(palabraClave);
				
		return dao.insertar(vo);
	}
	
	public Publicacion actualizar(int idPublicacion,String titulo, String descripcion,String archivo,String palabraClave)
					throws DAOExcepcion {
		
		PublicacionDAO dao = new PublicacionDAO();
		Publicacion vo = new Publicacion();
		
		vo.setIdPublicacion(idPublicacion);
		vo.setTitulo(titulo);
		vo.setDescripcion(descripcion);
		vo.setArchivo(archivo);
		vo.setPalabraClave(palabraClave);
		
		return dao.actualizar(vo);
	}
	
	
	public Publicacion publicar(int idPublicacion,int estado,Date fechaPublicacion)
							throws DAOExcepcion {
				
				PublicacionDAO dao = new PublicacionDAO();
				Publicacion vo = new Publicacion();
				
				vo.setIdPublicacion(idPublicacion);
				vo.setEstado(estado);
				vo.setFechaPublicacion(fechaPublicacion);
												
				return dao.actualizar(vo);
			}
	
	public boolean validarDatosIncompletos(String titulo, String descripcion,String archivo,int idUsuario,
	int estado,String palabraClave){
        boolean estadovalido=true ;
        if (titulo.trim().length()==0  ){
        	estadovalido =false;          
       }
        if (descripcion.trim().length()==0  ){
        	estadovalido =false;          
         }
        if (archivo.trim().length()==0 ){
        	estadovalido =false;          
         }
        if (idUsuario ==0  ){
        	estadovalido =false;          
         }
        if (palabraClave.trim().length()==0 ){
        	estadovalido =false;          
         }
        
        return estadovalido;
        
    }  
	public boolean validarTitulo(String titulo) throws DAOExcepcion{
		        boolean estadovalido=true ;
		        PublicacionDAO dao = new PublicacionDAO();
				Publicacion vo = new Publicacion();
				vo.setTitulo(titulo);
				estadovalido =dao.obtener(vo);
			    return estadovalido;
		        
		    }  
	
	
	  public Collection<Publicacion> ReportedePublicaciones(Publicacion pbePublicacion) throws DAOExcepcion
	  { PublicacionDAO dao = new PublicacionDAO();
	  return dao.ReportedePublicaciones(pbePublicacion); 
	  }
	 
 
	public Collection<Publicacion> buscarPublicacion(String texto,int estado)
			throws DAOExcepcion {
		String query = "select idpublicacion, titulo, descripcion,estado from publicacion where (titulo LIKE ? or descripcion like ? or palabra_clave like ?)  and estado=?";
		Collection<Publicacion> lista = new ArrayList<Publicacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + texto + "%");
			stmt.setString(2, "%" + texto + "%");
			stmt.setString(3, "%" + texto + "%");
			stmt.setInt(4,  estado );
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicacion vo = new Publicacion();
				vo.setIdPublicacion(rs.getInt("idpublicacion"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setDescripcion(rs.getString("estado")); 
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}   
    
}
