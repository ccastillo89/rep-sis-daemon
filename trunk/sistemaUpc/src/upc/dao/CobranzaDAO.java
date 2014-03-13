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

public class CobranzaDAO extends BaseDAO {
	public Collection<CentroFormacion> ListaCobranza(CentroFormacion pbeCentroFormacion)
			throws DAOExcepcion {
		String query = "select cf.idcentro_formacion,cf.nombre,c.Descripcion_Codigo as strTipo,cf.url from centro_formacion cf inner join codigo c on c.idcodigo=cf.tipo and c.idgrupo=3";
		Collection<CentroFormacion> lista = new ArrayList<CentroFormacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			/*stmt.setString(1, "%" + nombre + "%");
			stmt.setInt(2, IdCentroFormacion);*/
			rs = stmt.executeQuery();
			Collection<Persona> pers ;
			CentroFormacion vo ;
			Persona per=new Persona();
			while (rs.next()) {
				vo = new CentroFormacion();
				pers = new ArrayList<Persona>();
				vo.setIdCentroInformacion(rs.getInt("idcentro_formacion"));
				vo.setNombre(rs.getString("nombre"));
				vo.setStrTipo(rs.getString("strTipo"));
				vo.setUrl(rs.getString("url"));
				String query2="select * from persona where idcentro_formacion="+vo.getIdCentroInformacion();
				stmt2=con.prepareStatement(query2);
				rs2 = stmt2.executeQuery();
				while(rs2.next()){
					per=new Persona();
					per.setIdPersona(rs2.getInt("idpersona"));
					pers.add(per);	
				}
				vo.setPersona(pers);
				
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
