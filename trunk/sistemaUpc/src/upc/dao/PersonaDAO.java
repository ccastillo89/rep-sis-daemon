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
		String query = "select idpersona, nombres, paterno, materno, sexo, tipo_documento, numero_doc, celular, idcentro_formacion from persona where nombres like ? and idcentro_formacion = ?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			stmt.setInt(2, IdCentroFormacion);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setIdPersona(rs.getInt("idpersona"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setSexo(rs.getInt("sexo"));
				vo.setTipoDocumento(rs.getInt("tipo_documento"));
				vo.setNumeroDoc(rs.getString("numero_doc"));
				vo.setCelular(rs.getString("celular"));
				
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
