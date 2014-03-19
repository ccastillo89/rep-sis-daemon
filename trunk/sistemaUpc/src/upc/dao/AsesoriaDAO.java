package upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Asesoria;
import upc.modelo.Codigo;
import upc.modelo.Publicacion;
import upc.util.ConexionBD;


public class AsesoriaDAO extends BaseDAO  {
	
	public Collection<Asesoria> Listar(Asesoria as)
			throws DAOExcepcion {
		String query = "";
		
		query += "select  A.idasesoria, A.observacion, A.calificacion, A.fecha, ";
		query += "A.idpublicacion, B.titulo, C.Descripcion_Codigo ";
		query += "from asesoria A  ";
		query += " inner join publicacion B on A.idpublicacion = B.idpublicacion";
		query += " inner join codigo C on A.calificacion = C.idcodigo ";
				
		Collection<Asesoria> lista = new ArrayList<Asesoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			// stmt.setString(1, "%" + ps.getNombreCompleto() + "%");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Asesoria ase = new Asesoria();
				Codigo calificacion = new Codigo();
				Publicacion pb = new Publicacion();
				ase.setIdAsesoria(rs.getInt("idasesoria"));
				ase.setObservacion(rs.getString("observacion"));
				ase.setFechaAsesoria(rs.getString("fecha"));
				
				calificacion.setIdCodigo(rs.getInt("calificacion"));
				calificacion.setDescripcionCodigo(rs.getString("Descripcion_Codigo"));
				
				ase.setCalificacion(calificacion);
				
				pb.setIdPublicacion(rs.getInt("idpublicacion"));
				pb.setTitulo(rs.getString("titulo"));
				
				ase.setPublicacion(pb);
				
				lista.add(ase);
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
	
	
	public Asesoria insertar(Asesoria ase) throws DAOExcepcion {
		String query = "INSERT INTO `db_daemon`.`asesoria` (`observacion`, `calificacion`, `fecha`, `idpublicacion`)  VALUES (?, ?, STR_TO_DATE(?, '%d/%m/%Y'), ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ase.getObservacion());
			stmt.setInt(2, ase.getCalificacion().getIdCodigo());
			stmt.setString(3, ase.getFechaAsesoria());
			stmt.setInt(4, ase.getPublicacion().getIdPublicacion());
			
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
			ase.setIdAsesoria(id);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ase;
	}
	
	
	public Boolean validaAsesoria(Asesoria ase) throws DAOExcepcion {
		Boolean resultado = false;
		
		String query = "select count(1) as Cantidad from asesoria where idpublicacion = ? and fecha =  STR_TO_DATE(?, '%d/%m/%Y')";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ase.getPublicacion().getIdPublicacion());
			stmt.setString(2, ase.getFechaAsesoria());
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
	
	
}
