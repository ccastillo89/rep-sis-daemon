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
			String query = "select titulo from publicacion where titulo=? and idusuario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, titulo);
			stmt.setInt(2, idusuario);
			rs = stmt.executeQuery(); 
			
			if (rs == null) {
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
	
	
	
	public Collection<Publicacion> ReportedePublicaciones(Publicacion pbePublicacion) throws DAOExcepcion {
		Collection<Publicacion> c = new ArrayList<Publicacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select pu.idpublicacion,pu.titulo,pu.descripcion,pu.fecha_creacion,pu.fecha_publicacion,u.correo,p.nombres,p.paterno,p.materno,cf.nombre as institucion from publicacion pu inner join usuario u on u.idusuario=pu.idusuario inner join persona p on u.idpersona=p.idpersona inner join centro_formacion cf on cf.idcentro_formacion=p.idcentro_formacion where pu.titulo like ? and (pu.fecha_creacion>=? and pu.fecha_creacion<=?) and pu.estado=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%"+ pbePublicacion.getTitulo()+"%");
			stmt.setDate(2, new java.sql.Date(pbePublicacion.getFechainicio().getTime()));
			stmt.setDate(3, new java.sql.Date(pbePublicacion.getFechafin().getTime()));
			stmt.setInt(4, pbePublicacion.getEstado());
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
				CentroFormacion centroformacion=new CentroFormacion();
				usuario.setCorreo(rs.getString("correo"));
				persona.setNombres(rs.getString("nombres"));
				persona.setPaterno(rs.getString("paterno"));
				persona.setMaterno(rs.getString("materno"));
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
    

}
