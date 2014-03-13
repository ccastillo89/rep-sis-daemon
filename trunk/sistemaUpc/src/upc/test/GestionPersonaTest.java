package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.modelo.CentroFormacion;
import upc.modelo.Persona;
import upc.negocio.GestionPersona;
import upc.excepcion.DAOExcepcion;


public class GestionPersonaTest {
	
	//@Test
	public void insertarTest() {

		GestionPersona negocio = new GestionPersona();
		Persona modelo = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();
		
		try {
			
			modelo.setNombres("Carlos");
			modelo.setPaterno("Castillo");
			modelo.setMaterno("Calderon");
			modelo.setNumeroDoc("545454444");
			//modelo.setTipoDocumento(1);
			//modelo.setSexo(1);
			modelo.setCelular("98754521");
			
			modeloCF.setIdCentroInformacion(1);
			modelo.setCentroFormacion(modeloCF);
			
			if (modelo.getNombres() == "")
			{
				System.out.println("Ingrese nombre");
			}else if(modelo.getPaterno() == ""){
				System.out.println("Ingrese Apellido Paterno");
			}else if(modelo.getMaterno() == ""){
				System.out.println("Ingrese Apellido Materno");
			}
			//else if(modelo.getSexo() == 0){
			//	System.out.println("Ingrese Sexo");
			//}else if(modelo.getTipoDocumento() == 0){
			//	System.out.println("Ingrese Tipo Documento");
			//}
			else if(modelo.getNumeroDoc() == ""){
				System.out.println("Ingrese Nro documento");
			}else if(modelo.getCelular() == ""){
				System.out.println("Ingrese numero de celular");
			}
			else{
				negocio.insertar(modelo);			
				System.out.println("============= Registrado Correctamente =============");
			}
			
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
			//modelo.setTipoDocumento(1);
			//modelo.setSexo(1);
			modelo.setCelular("98754521");
			
			modeloCF.setIdCentroInformacion(1);
			modelo.setCentroFormacion(modeloCF);
			
			if (modelo.getNombres() == "")
			{
				System.out.println("Ingrese nombre");
			}else if(modelo.getPaterno() == ""){
				System.out.println("Ingrese Apellido Paterno");
			}else if(modelo.getMaterno() == ""){
				System.out.println("Ingrese Apellido Materno");
			//}else if(modelo.getSexo() == 0){
			//	System.out.println("Ingrese Sexo");
			//}else if(modelo.getTipoDocumento() == 0){
			//	System.out.println("Ingrese Tipo Documento");
			}else if(modelo.getNumeroDoc() == ""){
				System.out.println("Ingrese Nro documento");
			}else if(modelo.getCelular() == ""){
				System.out.println("Ingrese numero de celular");
			}
			else{
				negocio.actualizar(modelo);			
				System.out.println("============= Actualizado Correctamente =============");	
			}
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
	   // @Test
		public void eliminarTest() {
			GestionPersona negocio = new GestionPersona();
			
			try {
				negocio.eliminar(1);
				System.out.println("============= eliminado Correctamente =============");	
			} catch (DAOExcepcion e) {
				Assert.fail("Falló la eliminición: " + e.getMessage());
			}
		}
		
		
		//@Test
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
		
		@Test
		public void validarNumeroDocumentoTest(){
			
			GestionPersona negocio = new GestionPersona();
			try {
				
				Persona ps = new Persona();
				ps.setNumeroDoc("45782145");
				if (negocio.validarDocumentoIdentidad(ps))
				{
					
					System.out.println("============= No existe DNI =============");
				}else
				{
					System.out.println("============= EEEExiste DNI =============");
					
				}				
			} catch (DAOExcepcion e) {
				Assert.fail("Falló el listado: " + e.getMessage());
			}
			
		}
	
	

}
