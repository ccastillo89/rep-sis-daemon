package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Persona;
import upc.modelo.Usuario;
import upc.negocio.GestionPersona;
import upc.excepcion.DAOExcepcion;

public class GestionPersonaTest {

	//@Test
	public void insertarTest() {

		GestionPersona negocio = new GestionPersona();
		Persona person = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();
		Codigo sexo = new Codigo();
		Codigo tipoDocumento = new Codigo();
		Usuario user = new Usuario();
		Codigo rol = new Codigo();

		Persona personaRegistrada = new Persona();

		try {

			sexo.setIdCodigo(14);
			person.setSexo(sexo);

			tipoDocumento.setIdCodigo(12);
			person.setTipoDocumento(tipoDocumento);

			person.setNombres("sssss");
			person.setPaterno("2222");
			person.setMaterno("3212313");
			person.setNumeroDoc("4324324");
			person.setCelular("98754521");

			modeloCF.setIdCentroInformacion(1);
			person.setCentroFormacion(modeloCF);

			user.setCorreo("carlosdevel2@gmail.com");
			user.setPassword("12345");
			rol.setIdCodigo(1);
			user.setTipoUsuario(rol);

			personaRegistrada = negocio.insertar(person, user);

			if (!personaRegistrada.equals(null)) {
				System.out
						.println("============= Registrado Correctamente =============");
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	// @Test
	public void actualizarTest() {

		GestionPersona negocio = new GestionPersona();
		Persona person = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();
		Codigo sexo = new Codigo();
		Codigo tipoDocumento = new Codigo();
		Usuario user = new Usuario();
		Codigo rol = new Codigo();

		Persona personaActualizada = new Persona();

		try {

			person.setIdPersona(6);
			person.setNombres("Carlos");
			person.setPaterno("Castillo");
			person.setMaterno("Calderon");
			person.setNumeroDoc("545454444");
			person.setCelular("98754521");

			modeloCF.setIdCentroInformacion(1);
			person.setCentroFormacion(modeloCF);

			sexo.setIdCodigo(14);
			person.setSexo(sexo);

			tipoDocumento.setIdCodigo(12);
			person.setTipoDocumento(tipoDocumento);

			user.setCorreo("carlosdevelop@gmail.com");
			user.setPassword("12345");
			rol.setIdCodigo(1);
			user.setTipoUsuario(rol);

			negocio.actualizar(person, user);

			if (!personaActualizada.equals(null)) {
				System.out
						.println("============= Actualizado Correctamente =============");
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}

	// @Test
	public void eliminarTest() {
		GestionPersona negocio = new GestionPersona();

		try {
			negocio.eliminar(6);
			System.out
					.println("============= eliminado Correctamente =============");
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}

	@Test
	public void BuscarPersonaPorNombreYCentroFormacionTest() {

		GestionPersona negocio = new GestionPersona();

		try {

			Persona ps = new Persona();
			CentroFormacion cf = new CentroFormacion();

			ps.setNombreCompleto("c");
			cf.setIdCentroInformacion(1);

			ps.setCentroFormacion(cf);

			Collection<Persona> listadoPersona = negocio
					.buscarPersonaPorNombreCentroFormacion(ps);

			System.out.println("Total de registros: " + listadoPersona.size());
			System.out.println("");

			System.out.println("============= Resultado =============");

			for (Persona persona : listadoPersona) {
				System.out.println(persona.getNombres() + " - "
						+ persona.getPaterno() + " - " + persona.getMaterno()
						+ " - " + persona.getSexo().getIdCodigo() + " - "
						+ persona.getTipoDocumento().getIdCodigo() + " - "
						+ persona.getNumeroDoc() + " - " + persona.getCelular()
						+ " - " + persona.getCentroFormacion().getNombre());
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

}
