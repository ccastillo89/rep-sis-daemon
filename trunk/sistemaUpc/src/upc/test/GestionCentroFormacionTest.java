package upc.test;


import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.modelo.CentroFormacion;
import upc.negocio.GestionCentroFormacion;
import upc.excepcion.DAOExcepcion;


public class GestionCentroFormacionTest {

	
	//@Test
	public void insertarTest() {

		GestionCentroFormacion negocio = new GestionCentroFormacion();
		CentroFormacion modelo = new CentroFormacion();

		try {
			
			modelo.setNombre("USMP");
			modelo.setTipo(1);
			modelo.setUrl("http://www.usmp.edu.pe/");
			modelo.setLogo("Logo_USMP.jpg");	
			
			negocio.insertar(modelo);
			listarTest();
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	@Test
	public void actualizarTest() {

		GestionCentroFormacion negocio = new GestionCentroFormacion();
		CentroFormacion modelo = new CentroFormacion();

		try {
			
			modelo.setIdCentroInformacion(2);
			modelo.setNombre("UPC");
			modelo.setTipo(1);
			modelo.setUrl("www.upc.edu.pe/");
			modelo.setLogo("Logo_UPC.jpg");
									

					
			negocio.actualizar(modelo);
			listarTest();

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
    //@Test
	public void listarTest() {

		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			Collection<CentroFormacion> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("");
			
			for (CentroFormacion CentroFormacion : listado) {
				System.out.println(CentroFormacion.getIdCentroInformacion() + " - " + CentroFormacion.getNombre() + " - " + CentroFormacion.getTipo() + " - " + CentroFormacion.getUrl() + " - " + CentroFormacion.getLogo());
			}
			
			//Assert.assertTrue(listado.size() > 0);	

		
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	

   // @Test
	public void eliminarTest() {


		GestionCentroFormacion negocio = new GestionCentroFormacion();
				
		try {
			
			negocio.eliminar(12);
			listarTest();
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}
	
}
