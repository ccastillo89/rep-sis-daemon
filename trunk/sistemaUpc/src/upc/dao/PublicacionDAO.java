package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Date;



import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Persona;
import upc.modelo.Publicacion;
import upc.modelo.Usuario;
import upc.util.ConexionBD;



public class PublicacionDAO extends BaseDAO {


	
	public Publicacion insertar(Publicacion vo) throws DAOExcepcion, ParseException {
		String query = "insert into Publicacion(titulo,descripcion,archivo,idUsuario,estado,fecha_creacion,palabra_clave) values (?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			
			java.sql.Date fechaCreacion = new java.sql.Date(vo.getFechaCreacion().getTime());
			
			
            stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTitulo());
			stmt.setString(2, vo.getDescripcion());
			stmt.setString(3, vo.getArchivo());
			stmt.setInt(4, vo.getUsuario().getIdUsuario());
			stmt.setInt(5, vo.getEstado().getIdCodigo());
			stmt.setDate(6,  fechaCreacion);
			stmt.setString(7, vo.getPalabraClave());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
					
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public Publicacion actualizar(Publicacion vo) throws DAOExcepcion {
		String query = "update publicacion set titulo=?,descripcion=?,archivo=?,palabra_clave=? where idpublicacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getTitulo());
			stmt.setString(2, vo.getDescripcion());
			stmt.setString(3, vo.getArchivo());
			stmt.setString(4, vo.getPalabraClave());
			stmt.setInt(5, vo.getIdPublicacion());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	
	public Publicacion Publicar(Publicacion vo) throws DAOExcepcion {
		String query = "update publicacion set estado=? where idpublicacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getEstado().getIdCodigo());
			stmt.setInt(2, vo.getIdPublicacion());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo Publicar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public boolean existeIdea(String titulo,int idusuario) throws DAOExcepcion {
		boolean encontrado = true; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select titulo,idusuario from publicacion where titulo=? and idusuario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, titulo);
			stmt.setInt(2, idusuario);
			rs = stmt.executeQuery(); 
			
			if (!rs.next()) {
				encontrado = false;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return encontrado;
	}
	
	public Collection<Publicacion> buscaPubliUsuario(int idUsuario,int estado)
			throws DAOExcepcion {
		String query = "select idpublicacion, titulo, descripcion,estado from publicacion where idusuario=?  and estado=?";
		Collection<Publicacion> lista = new ArrayList<Publicacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, estado);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicacion vo = new Publicacion();
				Codigo vu = new Codigo();
				
				vu.setIdCodigo(rs.getInt("Estado"));
				
				vo.setIdPublicacion(rs.getInt("idpublicacion"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setDescripcion(rs.getString("descripcion")); 
				vo.setEstado(vu);
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
	
	public Collection<Publicacion> ReportedePublicaciones(Publicacion pbePublicacion) throws DAOExcepcion {
		Collection<Publicacion> c = new ArrayList<Publicacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select cod.Descripcion_Codigo,pu.idpublicacion,pu.titulo,pu.descripcion,pu.fecha_creacion,pu.fecha_publicacion,u.correo,p.nombres,p.paterno,p.materno,cf.nombre as institucion from publicacion pu inner join usuario u on u.idusuario=pu.idusuario inner join persona p on u.idpersona=p.idpersona inner join centro_formacion cf on cf.idcentro_formacion=p.idcentro_formacion join codigo cod on cod.idcodigo=pu.estado and cod.IdGrupo=2 where pu.titulo like ? and (pu.fecha_creacion>=? and pu.fecha_creacion<=?) and pu.estado in("+pbePublicacion.getEstadossel()+")";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%"+ pbePublicacion.getTitulo()+"%");
			stmt.setDate(2, new java.sql.Date(pbePublicacion.getFechainicio().getTime()));
			stmt.setDate(3, new java.sql.Date(pbePublicacion.getFechafin().getTime()));
			//stmt.setString(4, pbePublicacion.getEstadossel());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicacion vo = new Publicacion();
				vo.setIdPublicacion(rs.getInt("idpublicacion"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setFechaCreacion(rs.getDate("fecha_creacion"));
				vo.setFechaPublicacion(rs.getDate("fecha_publicacion"));
				
				Usuario usuario=new Usuario();
				Persona persona=new Persona();
				Codigo cod=new Codigo();
				cod.setDescripcionCodigo(rs.getString("Descripcion_Codigo"));
				vo.setEstado(cod);
				CentroFormacion centroformacion=new CentroFormacion();
				usuario.setCorreo(rs.getString("correo"));
				persona.setNombres(rs.getString("nombres"));
				persona.setPaterno(rs.getString("paterno"));
				persona.setMaterno(rs.getString("materno"));
				persona.setNombreCompleto(persona.getNombres()+" "+persona.getPaterno()+" "+persona.getMaterno());
				centroformacion.setNombre(rs.getString("institucion"));
				persona.setCentroFormacion(centroformacion);
				usuario.setPersona(persona);
				vo.setUsuario(usuario);
				
				
				c.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
   
	public Collection<Publicacion> buscarPublicacion(String texto,int estado)
			throws DAOExcepcion {
		String query = "    select idpublicacion, titulo, descripcion,descripcion_codigo,c.nombres,c.paterno,fecha_publicacion, " +
				" f.nombres as nombres_asesor ,f.paterno as paterno_asesor  from "+ 
    " publicacion a inner join usuario b on a.idusuario=b.idusuario "+
    " inner join persona c on b.idpersona=c.idpersona "+
    " inner join codigo d on d.idcodigo=a.estado "+
    " inner join usuario e on a.usuario_acesor=e.idusuario "+
    " inner join persona f on e.idpersona=f.idpersona "+  
		"  where "+
		" (titulo LIKE ? or descripcion like ? or palabra_clave like ?) and "+
		" estado=? and "+
		" Grupo='Estado_Publicacion' ";
		
		
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
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setFechaPublicacion(rs.getDate("fecha_publicacion"));
				
				Codigo codigo = new Codigo();
				codigo.setDescripcionCodigo(rs.getString("descripcion_codigo")); 
				vo.setEstado(codigo);
				
				Persona personaEstudiante=new Persona();
				personaEstudiante.setNombres(rs.getString("nombres"));
				personaEstudiante.setPaterno(rs.getString("paterno"));
				Usuario usuarioEstudiante=new Usuario();
				usuarioEstudiante.setPersona(personaEstudiante);				
				vo.setUsuario(usuarioEstudiante);
				
				Persona personaAsesor=new Persona();
				personaAsesor.setNombres(rs.getString("nombres_asesor"));
				personaAsesor.setPaterno(rs.getString("paterno_asesor"));

				Usuario usuarioAsesor=new Usuario();
				usuarioEstudiante.setPersona(personaAsesor);				
				vo.setUsuarioAsesor(usuarioAsesor);
				
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
   	
   	
   	public Collection<Publicacion> buscar(String texto,int estado)
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
				Codigo vu = new Codigo();
				
				vu.setIdCodigo(rs.getInt("Estado"));
				
				vo.setIdPublicacion(rs.getInt("idpublicacion"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setDescripcion(rs.getString("descripcion")); 
				vo.setEstado(vu);
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
   	
   	public Publicacion actualizarEstado(Publicacion vo) throws DAOExcepcion {
		String query = "update publicacion set estado=? where idpublicacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getEstado().getIdCodigo());
			stmt.setInt(2, vo.getIdPublicacion());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
   	
   	public int buscarAcesorPorUsuario(Publicacion vo) throws DAOExcepcion {
		String query = "select count(titulo) as Total from publicacion where idusuario = ? and usuario_acesor = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0 ;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				

			stmt.setInt(1, vo.getUsuario().getIdUsuario());
			stmt.setInt(2, vo.getUsuarioAsesor().getIdUsuario());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				i = rs.getInt("Total");				
			
			}
			
			if (i != 0) {
				throw new SQLException("Asesor ya asignado para este usuario en otra publicacion.");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return i;
	}
   	
   	public Publicacion asignarAsesor(Publicacion vo) throws DAOExcepcion {
		String query = "Update publicacion Set usuario_acesor = ? where idpublicacion = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			
			
			stmt.setInt(1, vo.getUsuarioAsesor().getIdUsuario());
			stmt.setInt(2, vo.getIdPublicacion());
			
			stmt.executeUpdate();			
			

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
		
   	}
   	
   	
   	public int contarPuntosPublicacion(Publicacion vo) throws DAOExcepcion {
		String query = "select ifnull(sum(puntos),0) as Total from usuario_permitido Where idcomentario = ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0 ;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				

			stmt.setInt(1, vo.getIdPublicacion());
			
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				i = rs.getInt("Total");				
			
			}
			
			if (i <= 0) {
				throw new SQLException("Esta publicacion no tiene votaciones.");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return i;
	}
    

}
