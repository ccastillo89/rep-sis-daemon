package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Codigo;
import upc.util.ConexionBD;

public class CodigoDAO extends BaseDAO {
	
	public Collection<Codigo> ListarCodigosPorIdGrupo(Codigo codes)
			throws DAOExcepcion {
		String query = "";
		
		query = "Select idcodigo, Descripcion_Codigo, IdGrupo, Grupo from codigo where IdGrupo = ? ";
				
		Collection<Codigo> lista = new ArrayList<Codigo>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codes.getIdGrupo());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Codigo co = new Codigo();
				co.setIdCodigo(rs.getInt("idcodigo"));
				co.setDescripcionCodigo(rs.getString("Descripcion_Codigo"));
				co.setIdGrupo(rs.getInt("IdGrupo"));
				co.setGrupo(rs.getString("Grupo"));
				
				lista.add(co);
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
