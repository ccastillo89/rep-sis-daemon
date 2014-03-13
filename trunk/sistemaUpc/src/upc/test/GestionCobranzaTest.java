package upc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.negocio.GestionCobranza;;

public class GestionCobranzaTest {

	
	@Test
	public void CobranzaTest() throws ParseException {

		GestionCobranza negocio = new GestionCobranza();
		CentroFormacion cf=new CentroFormacion();

		try {
		
			
			Collection<CentroFormacion> listado = negocio.ListaCobranza(cf);

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("Nombre \t \t \t \t Tipo \t \t \t Cant.Usuarios \t \t \t Pago");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			for (CentroFormacion centroformacion : listado) {
				System.out.println(centroformacion.getNombre()+"\t\t"+centroformacion.getStrTipo()+"\t"+centroformacion.getPersona().size()+"\t\t");
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
}
