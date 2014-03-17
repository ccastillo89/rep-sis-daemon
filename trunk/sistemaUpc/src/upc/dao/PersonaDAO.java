package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Persona;
import upc.util.ConexionBD;

public class PersonaDAO extends BaseDAO {
		
	public Collection<Persona> buscarPersonaPorNombreCentroFormacion(Persona ps)
			throws DAOExcepcion {
		String query = "select A.idpersona, A.nombres, A.paterno, A.materno, A.sexo, A.tipo_documento, A.numero_doc, A.celular, A.idcentro_formacion , B.nombre as CentroFormacion from persona as A inner join centro_formacion as B on A.idcentro_formacion = B.idcentro_formacion  where (A.nombres like ? or A.paterno like ? or A.materno like ?) and A.idcentro_formacion = ?";
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
				CentroFormacion cf = new CentroFormacion();
				Codigo sexo = new Codigo();
				Codigo tipoDocumento = new Codigo();
				cf.setNombre(rs.getString("CentroFormacion"));
				vo.setIdPersona(rs.getInt("idpersona"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				sexo.setIdCodigo(rs.getInt("sexo"));
				tipoDocumento.setIdCodigo(rs.getInt("tipo_documento"));
				vo.setNumeroDoc(rs.getString("numero_doc"));
				vo.setCelular(rs.getString("celular"));
				vo.setCentroFormacion(cf);
				vo.setSexo(sexo);
				vo.setTipoDocumento(tipoDocumento);
				
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
	
	public Boolean validarDocumentoIdentidad(Persona ps) throws DAOExcepcion {
		Boolean resultado = false;
		
		String query = "select count(1) as Cantidad from persona where numero_doc = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ps.getNumeroDoc());
			rs = stmt.executeQuery();
			while (rs.next()) {
				cantidad += rs.getInt("Cantidad");
			}
			
			if (cantidad > 0){
				resultado = false;
			}else
			{
				resultado = true;
			}
			
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
	
	public Persona insertar(Persona ps) throws DAOExcepcion {
		String query = "insert into Persona (nombres,paterno,materno,sexo, tipo_documento, numero_doc, celular, idcentro_formacion) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ps.getNombres());
			stmt.setString(2, ps.getPaterno());
			stmt.setString(3, ps.getMaterno());
			stmt.setInt(4, ps.getSexo().getIdCodigo());
			stmt.setInt(5, ps.getTipoDocumento().getIdCodigo());
			stmt.setString(6, ps.getNumeroDoc());
			stmt.setString(7, ps.getCelular());
			stmt.setInt(8, ps.getCentroFormacion().getIdCentroInformacion());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			ps.setIdPersona(id);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ps;
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
			stmt.setInt(4, vo.getSexo().getIdCodigo());
			stmt.setInt(5, vo.getTipoDocumento().getIdCodigo());
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
