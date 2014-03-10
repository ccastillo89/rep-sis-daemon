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
			
			modelo.setNombre("UPC");
			modelo.setTipo(1);
			modelo.setUrl("http://www.upc.edu.pe/");
			modelo.setLogo("Logo1");	
			
			negocio.insertar(modelo);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {

		GestionCentroFormacion negocio = new GestionCentroFormacion();
		CentroFormacion modelo = new CentroFormacion();

		try {
			
			modelo.setNombre("UPC");
			modelo.setTipo(2);
			modelo.setUrl("http://www.upc.edu.pe/");
			modelo.setLogo("Logo 2");
														
			negocio.actualizar(modelo);

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
	@Test
	public void listarTest() {

		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			Collection<CentroFormacion> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			
			for (CentroFormacion CentroFormacion : listado) {
				System.out.println(CentroFormacion.getNombre() + " - " + CentroFormacion.getTipo());
			}
			
			//Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	

//	@Test
	public void eliminarTest() {


		GestionCentroFormacion negocio = new GestionCentroFormacion();
				
		try {
			negocio.eliminar(1);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}
	
}
