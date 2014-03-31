package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.util.ConexionBD;

public class CentroFormacionDAO extends BaseDAO {

	
	public CentroFormacion insertar(CentroFormacion vo) throws DAOExcepcion {
		String query = "insert into Centro_Formacion (nombre,tipo,url,logo) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setInt(2, vo.getTipo());
			stmt.setString(3, vo.getUrl());
			stmt.setString(4, vo.getLogo());
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

	

	public void eliminar(int idCentroFormacion) throws DAOExcepcion {
		String query = "delete from Centro_Formacion WHERE idcentro_formacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCentroFormacion);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public CentroFormacion actualizar(CentroFormacion vo) throws DAOExcepcion {
		String query = "update Centro_Formacion set nombre=?,tipo=?,url=?,logo=? where idcentro_formacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setString(1, vo.getNombre());
			stmt.setInt(2, vo.getTipo());
			stmt.setString(3, vo.getUrl());
			stmt.setString(4, vo.getLogo());
			stmt.setInt(5, vo.getIdCentroInformacion());
						
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

	
	public Collection<CentroFormacion> listar(CentroFormacion ci) throws DAOExcepcion {

		Collection<CentroFormacion> c = new ArrayList<CentroFormacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {			
			String query = "select idcentro_formacion,nombre,tipo,url,logo from Centro_Formacion WHERE nombre like ? order by nombre";
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + ci.getNombre() + "%");
			rs = stmt.executeQuery();			
			while (rs.next()) {
				CentroFormacion vo = new CentroFormacion();
				vo.setIdCentroInformacion(rs.getInt("idcentro_formacion"));
				vo.setNombre(rs.getString("nombre"));
				vo.setTipo(rs.getInt("tipo"));
				vo.setUrl(rs.getString("url"));
				vo.setLogo(rs.getString("logo"));						
				
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
	
	public int buscarPorNombre(CentroFormacion vo) throws DAOExcepcion {
		String query = "Select count(nombre) as Total From centro_formacion where nombre = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0 ;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setString(1, vo.getNombre());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				i = rs.getInt("Total");				
			
			}
			
			if (i != 0) {
				throw new SQLException("Centro de formacion ya registrado.");
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
	
	
	public int buscarPorURL(CentroFormacion vo) throws DAOExcepcion {
		String query = "Select count(url) as Total From centro_formacion where url = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0 ;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setString(1, vo.getUrl());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				i = rs.getInt("Total");				
			
			}
			
			if (i != 0) {
				throw new SQLException("URL ya registrada.");
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
	
	public CentroFormacion obtener(Integer IdCentroFormacion) throws DAOExcepcion {
		System.out.println("CentroFormacionDAO: obtener(Int IdcentroFormacion)");
		CentroFormacion vo = new CentroFormacion();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idcentro_formacion,nombre,tipo,url,logo from Centro_Formacion where idcentro_formacion=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdCentroFormacion);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdCentroInformacion(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setTipo(rs.getInt(3));
				vo.setUrl(rs.getString(4));
				vo.setLogo(rs.getString(5));
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


	
}
