package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.modelo.Codigo;
import upc.modelo.Asesoria;
import upc.modelo.Publicacion;
import upc.negocio.GestionAsesoria;
import upc.excepcion.DAOExcepcion;

public class GestionAsesoriaTest {

	@Test
	public void insertarTest() {

		GestionAsesoria negocio = new GestionAsesoria();
		Asesoria asesoria = new Asesoria();
		Codigo calificacion = new Codigo();
		Publicacion publicacion = new Publicacion();

		Asesoria asesoriaRegistrada = new Asesoria();

		try {

			asesoria.setObservacion("El trbajo necesita mejorar la idea.");
			asesoria.setFechaAsesoria("18/03/2014");
			
			calificacion.setIdCodigo(18);
			asesoria.setCalificacion(calificacion);
			
			publicacion.setIdPublicacion(3);
			asesoria.setPublicacion(publicacion);
			
			asesoriaRegistrada = negocio.insertar(asesoria);

			if (!asesoriaRegistrada.equals(null)) {
				System.out
						.println("============= Registrado Correctamente =============");
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	@Test
	public void ListarAsesoriaRegistradas() {

		GestionAsesoria negocio = new GestionAsesoria();

		try {

			Asesoria asesoria = new Asesoria();

			Collection<Asesoria> listadoAsesoria = negocio.Listar(asesoria);

			System.out.println("Total de registros: " + listadoAsesoria.size());
			System.out.println("");

			System.out.println("============= Resultado =============");

			for (Asesoria ase : listadoAsesoria) {
				System.out.println(ase.getIdAsesoria() + " - "
						+ ase.getFechaAsesoria() + " - " + ase.getObservacion()
						+ " - " + ase.getCalificacion().getIdCodigo() + " - "
						+ ase.getCalificacion().getDescripcionCodigo() + " - "
						+ ase.getPublicacion().getIdPublicacion()
						+ " - " + ase.getPublicacion().getTitulo());
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}


	
	
}
