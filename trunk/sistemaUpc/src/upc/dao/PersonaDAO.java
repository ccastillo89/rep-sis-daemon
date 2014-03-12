package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Persona;
import upc.util.ConexionBD;

public class PersonaDAO extends BaseDAO {
	
	
	public Collection<Persona> buscarPersonaPorNombreCentroFormacion(String nombre, int IdCentroFormacion)
			throws DAOExcepcion {
		String query = "select idpersona,  from categoria where nombre like ?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setNombres(rs.getString("Nombres"));
				vo.setPaterno(rs.getString("ApellidoPaterno"));
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
