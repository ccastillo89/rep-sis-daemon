package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.modelo.CentroFormacion;
import upc.modelo.Persona;
import upc.negocio.GestionPersona;
import upc.excepcion.DAOExcepcion;


public class GestionPersonaTest {
	
	@Test
	public void insertarTest() {

		GestionPersona negocio = new GestionPersona();
		Persona modelo = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();
		
		try {
			
			modelo.setNombres("Carlos");
			modelo.setPaterno("Castillo");
			modelo.setMaterno("Calderon");
			modelo.setNumeroDoc("545454444");
			modelo.setTipoDocumento(1);
			modelo.setSexo(1);
			modelo.setCelular("98754521");
			
			modeloCF.setIdCentroInformacion(1);
			modelo.setCentroFormacion(modeloCF);
			
			negocio.insertar(modelo);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() {

		GestionPersona negocio = new GestionPersona();
		Persona modelo = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();

		try {
			
			modelo.setIdPersona(1);
			modelo.setNombres("Carlos");
			modelo.setPaterno("Castillo");
			modelo.setMaterno("Calderon");
			modelo.setNumeroDoc("545454444");
			modelo.setTipoDocumento(1);
			modelo.setSexo(1);
			modelo.setCelular("98754521");
			
			modeloCF.setIdCentroInformacion(1);
			modelo.setCentroFormacion(modeloCF);
			
			negocio.actualizar(modelo);			

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
	   // @Test
		public void eliminarTest() {
			GestionPersona negocio = new GestionPersona();
			
			try {
				negocio.eliminar(1);
				
			} catch (DAOExcepcion e) {
				Assert.fail("Falló la eliminición: " + e.getMessage());
			}
		}
		
		
		// @Test
		public void BuscarPersonaPorNombreYCentroFormacionTest() {

			GestionPersona negocio = new GestionPersona();

			try {
				
				Persona ps = new Persona();
				CentroFormacion cf = new CentroFormacion();
				
				ps.setNombreCompleto("c");
				cf.setIdCentroInformacion(1);
				
				ps.setCentroFormacion(cf);
				
				Collection<Persona> listadoPersona = negocio.buscarPersonaPorNombreCentroFormacion(ps);

				System.out.println("Total de registros: "+ listadoPersona.size());
				System.out.println("");
				
				System.out.println("============= Resultado =============");
				
				for (Persona persona : listadoPersona) {
					System.out.println(persona.getNombres() + " - " + persona.getPaterno() + " - " + persona.getMaterno() + " - " + persona.getSexo() + " - " + persona.getTipoDocumento() + " - " + persona.getNumeroDoc() + " - " + persona.getCelular() + " - " + persona.getCentroFormacion().getNombre());
				}
				
			} catch (DAOExcepcion e) {
				Assert.fail("Falló el listado: " + e.getMessage());
			}
		}
		
	
	

}
