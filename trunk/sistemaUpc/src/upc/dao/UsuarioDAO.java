package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.LoginExcepcion;
import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Persona;
import upc.modelo.Usuario;
import upc.util.ConexionBD;

public class UsuarioDAO extends BaseDAO {

	public Collection<Usuario> buscarUsuariosPorCentroFormacion(Persona ps)
			throws DAOExcepcion {
		String query = "";
		
		query += "select A.idUsuario, A.tipo_usuario, D.descripcion_codigo as TipoUsuario, B.idpersona, B.nombres, B.paterno, ";
		query += "B.materno, B.sexo as idSexo, E.descripcion_codigo as Sexo, ";
		query += "B.tipo_documento as idtipoDocumento, F.descripcion_codigo as tipoDocumento,";
		query += "B.numero_doc, B.celular, B.idcentro_formacion,  C.nombre as CentroFormacion, A.correo ";
		query += "from usuario A ";
		query += "inner join persona B on A.idpersona = B.idpersona ";
		query += "inner join centro_formacion C on B.idcentro_formacion = C.idcentro_formacion ";
		query += "inner join codigo D on A.tipo_usuario = D.idcodigo ";
		query += "inner join codigo E on B.sexo= E.idcodigo ";
		query += "inner join codigo F on B.tipo_documento = F.idcodigo ";
		query += "where (B.nombres like ? or B.paterno like ? or B.materno like ?)  ";
		query += "and B.idcentro_formacion = ?"; 
		
		Collection<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + ps.getNombreCompleto() + "%");
			stmt.setString(2, "%" + ps.getNombreCompleto() + "%");
			stmt.setString(3, "%" + ps.getNombreCompleto() + "%");
			stmt.setInt(4, ps.getCentroFormacion().getIdCentroInformacion());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario user = new Usuario();
				Persona person = new Persona();
				CentroFormacion cf = new CentroFormacion();
				Codigo sexo = new Codigo();
				Codigo tipoDocumento = new Codigo();
				Codigo rol = new Codigo(); 
				
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setCorreo(rs.getString("correo"));
				rol.setIdCodigo(rs.getInt("tipo_usuario"));
				rol.setDescripcionCodigo(rs.getString("TipoUsuario"));
				user.setTipoUsuario(rol);
				
				person.setIdPersona(rs.getInt("idpersona"));
				person.setNombres(rs.getString("nombres"));
				person.setPaterno(rs.getString("paterno"));
				person.setMaterno(rs.getString("materno"));
				sexo.setIdCodigo(rs.getInt("idSexo"));
				sexo.setDescripcionCodigo(rs.getString("Sexo"));
				person.setSexo(sexo);
				tipoDocumento.setDescripcionCodigo(rs.getString("tipoDocumento"));
				tipoDocumento.setIdCodigo(rs.getInt("idtipoDocumento"));
				person.setTipoDocumento(tipoDocumento);
				person.setNumeroDoc(rs.getString("numero_doc"));
				person.setCelular(rs.getString("celular"));
				cf.setIdCentroInformacion(rs.getInt("idcentro_formacion"));
				cf.setNombre(rs.getString("CentroFormacion"));
				person.setCentroFormacion(cf);
				
				
				user.setPersona(person);
				
				lista.add(user);
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
	
	public Usuario insertar(Usuario user) throws DAOExcepcion {
		String query = "insert into usuario (idpersona,correo,password,tipo_usuario) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, user.getPersona().getIdPersona());
			stmt.setString(2, user.getCorreo());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getTipoUsuario().getIdCodigo());
			
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
		return user;
	}
	
	public void eliminar(int idUsuario) throws DAOExcepcion {
		String query = "delete from usuario WHERE idpersona=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idUsuario);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar.");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
	
	public Usuario actualizar(Usuario user) throws DAOExcepcion {
		String query = "update usuario set correo = ?, password = ?, tipo_usuario = ? where idpersona=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setString(1, user.getCorreo());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getTipoUsuario().getIdCodigo());
			stmt.setInt(4, user.getPersona().getIdPersona());
						
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
		return user;
	}
	
	public Boolean loginUsuario(Usuario user) throws DAOExcepcion {
		Boolean resultado = false;
		
		String query = "select count(1) as Cantidad from usuario where correo = ? and password = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, user.getCorreo().trim());
			stmt.setString(2, user.getPassword().trim());
			rs = stmt.executeQuery();
			while (rs.next()) {
				cantidad += rs.getInt("Cantidad");
			}
			if (cantidad > 0){
				resultado = true;
			}else{
				resultado = false;}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return resultado;
	}
	
	public Boolean validarCorreoPersona(Usuario user) throws DAOExcepcion {
		Boolean resultado = false;
		
		String query = "select count(1) as Cantidad from usuario where correo = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, user.getCorreo());
			rs = stmt.executeQuery();
			while (rs.next()) {
				cantidad += rs.getInt("Cantidad");
			}
			if (cantidad > 0){
				resultado = false;
			}else{
				resultado = true;}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return resultado;
	}
	
	public Collection<Usuario> buscarPorTipoUsuario(Codigo vo) throws DAOExcepcion {
		String query = "select idusuario,correo,tipo_usuario from usuario where tipo_usuario = ?";
		Collection<Usuario> c = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setInt(1, vo.getIdCodigo());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Usuario vu = new Usuario();
				
				vu.setIdUsuario(rs.getInt("idusuario"));
				vu.setCorreo(rs.getString("correo"));
									
				c.add(vu);
			
			}
			


		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
	
	public Usuario validar(String correo, String password)
			throws DAOExcepcion, LoginExcepcion {
		String query = "select idusuario, idpersona, correo"				
				+ " from usuario where correo = ? and password = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario vo = new Usuario();
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setIdUsuario(rs.getInt("idusuario"));				 
				vo.setCorreo(rs.getString("correo"));
			} else {
				throw new LoginExcepcion("No existe");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion(e.getMessage());
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
	
	public Usuario obtener(Integer IdPersona) throws DAOExcepcion {
		Usuario user = new Usuario();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "";
			
			query += "select A.idUsuario, A.tipo_usuario, D.descripcion_codigo as TipoUsuario, B.idpersona, B.nombres, B.paterno, ";
			query += "B.materno, B.sexo as idSexo, E.descripcion_codigo as Sexo, ";
			query += "B.tipo_documento as idtipoDocumento, F.descripcion_codigo as tipoDocumento,";
			query += "B.numero_doc, B.celular, B.idcentro_formacion,  C.nombre as CentroFormacion, A.correo,  A.password ";
			query += "from usuario A ";
			query += "inner join persona B on A.idpersona = B.idpersona ";
			query += "inner join centro_formacion C on B.idcentro_formacion = C.idcentro_formacion ";
			query += "inner join codigo D on A.tipo_usuario = D.idcodigo ";
			query += "inner join codigo E on B.sexo= E.idcodigo ";
			query += "inner join codigo F on B.tipo_documento = F.idcodigo ";
			query += "where B.idpersona = ? ";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdPersona);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Persona person = new Persona();
				CentroFormacion cf = new CentroFormacion();
				Codigo sexo = new Codigo();
				Codigo tipoDocumento = new Codigo();
				Codigo rol = new Codigo(); 
				
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setCorreo(rs.getString("correo"));
				rol.setIdCodigo(rs.getInt("tipo_usuario"));
				rol.setDescripcionCodigo(rs.getString("TipoUsuario"));
				user.setTipoUsuario(rol);
				
				person.setIdPersona(rs.getInt("idpersona"));
				person.setNombres(rs.getString("nombres"));
				person.setPaterno(rs.getString("paterno"));
				person.setMaterno(rs.getString("materno"));
				sexo.setIdCodigo(rs.getInt("idSexo"));
				sexo.setDescripcionCodigo(rs.getString("Sexo"));
				person.setSexo(sexo);
				tipoDocumento.setDescripcionCodigo(rs.getString("tipoDocumento"));
				tipoDocumento.setIdCodigo(rs.getInt("idtipoDocumento"));
				person.setTipoDocumento(tipoDocumento);
				person.setNumeroDoc(rs.getString("numero_doc"));
				person.setCelular(rs.getString("celular"));
				cf.setIdCentroInformacion(rs.getInt("idcentro_formacion"));
				cf.setNombre(rs.getString("CentroFormacion"));
				person.setCentroFormacion(cf);
				user.setPassword(rs.getString("password"));
				
				user.setPersona(person);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return user;
	}
}
