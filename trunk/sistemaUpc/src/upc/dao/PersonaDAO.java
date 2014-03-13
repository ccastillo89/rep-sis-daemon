package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Persona;
import upc.util.ConexionBD;

public class PersonaDAO extends BaseDAO {
		
	public Collection<Persona> buscarPersonaPorNombreCentroFormacion(Persona ps)
			throws DAOExcepcion {
		String query = "select idpersona, nombres, paterno, materno, sexo, tipo_documento, numero_doc, celular, idcentro_formacion from persona where (nombres like ? or paterno like ? materno like ?) and idcentro_formacion = ?";
		Collection<Persona> lista = new ArrayList<Persona>();
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
	
	
	public Persona insertar(Persona vo) throws DAOExcepcion {
		String query = "insert into Personas (nombres,paterno,materno,sexo, tipo_documento, numero_doc, celular, idcentro_formacion) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombres());
			stmt.setString(2, vo.getPaterno());
			stmt.setString(3, vo.getMaterno());
			stmt.setInt(4, vo.getSexo());
			stmt.setInt(5, vo.getTipoDocumento());
			stmt.setString(6, vo.getNumeroDoc());
			stmt.setString(7, vo.getCelular());
			stmt.setInt(8, vo.getCentroFormacion().getIdCentroInformacion());
			
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
	
	public void eliminar(int idPersona) throws DAOExcepcion {
		String query = "delete from Persona WHERE idpersona=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPersona);
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
	
	public Persona actualizar(Persona vo) throws DAOExcepcion {
		String query = "update Persona set nombres=?,paterno=?,materno=?,sexo=?, tipo_documento=?,numero_doc=?,celular=?,idcentro_formacion=?  where idpersona=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
	
			stmt.setString(1, vo.getNombres());
			stmt.setString(2, vo.getPaterno());
			stmt.setString(3, vo.getMaterno());
			stmt.setInt(4, vo.getSexo());
			stmt.setInt(5, vo.getTipoDocumento());
			stmt.setString(6, vo.getNumeroDoc());
			stmt.setString(7, vo.getCelular());
			stmt.setInt(8, vo.getCentroFormacion().getIdCentroInformacion());
			stmt.setInt(9, vo.getIdPersona());
						
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
