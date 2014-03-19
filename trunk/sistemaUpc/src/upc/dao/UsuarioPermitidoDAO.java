package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upc.excepcion.DAOExcepcion;
import upc.modelo.UsuarioPermitido;
import upc.util.ConexionBD;


public class UsuarioPermitidoDAO extends BaseDAO {

	public UsuarioPermitido darAcceso(UsuarioPermitido userPer) throws DAOExcepcion {
		String query = "insert into usuario_permitido (idusuario) values (?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, userPer.getUsuario().getIdUsuario());
		
					
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
		return userPer;
	}
	
	public boolean existeUsuario(int tipoUsuario) throws DAOExcepcion {
		boolean encontrado = true; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select p.Idusuario, u.tipo_usuario from Usuario U, Usuario_permitido P where U.Idusuario = P.Idusuario and P.Idusuario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, tipoUsuario);
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
	
	
	
}
