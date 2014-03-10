package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;
import upc.util.ConexionBD;



public class PublicacionDAO extends BaseDAO {


	public Publicacion insertar(Publicacion vo) throws DAOExcepcion {
		String query = "insert into Publicacion(titulo,descripcion,archivo,idUsuario,estado,usuario_acesor,fecha_creacion,palabra_clave,fecha_publicacion) values (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTitulo());
			stmt.setString(2, vo.getDescripcion());
			stmt.setString(3, vo.getArchivo());
			stmt.setInt(4, vo.getIdUsuario());
			stmt.setInt(5, vo.getEstado());
			stmt.setInt(6, vo.getUsuarioAsesor());
			stmt.setDate(7, (java.sql.Date) vo.getFechaCreacion());
			stmt.setString(8, vo.getPalabraClave());
			stmt.setDate(9, (java.sql.Date) vo.getFechaPublicacion());
					
			
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

	public Collection<Publicacion> ReportedePublicaciones() throws DAOExcepcion {
		Collection<Publicacion> c = new ArrayList<Publicacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from publicacion";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicacion vo = new Publicacion();
				vo.setIdPublicacion(rs.getInt("idpublicacion"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setDescripcion(rs.getString("descripcion"));
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

}
