package upc.test;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;
import upc.negocio.GestionPublicaciones;

/*import org.junit.Assert;
import org.junit.Test;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.negocio.GestionCategorias;*/

public class GestionPublicacionesTest {
/*//	@Test
	public void insertarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			Categoria c = negocio.insertar("TV Led", "Televisores");
			System.out.println("Se insertó el id: " + c.getIdCategoria());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			negocio.actualizar(1, "Monitores", "Pantalla plana");



		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	*/

	@Test
	public void ReportedePublicacionesTest() throws ParseException {

		GestionPublicaciones negocio = new GestionPublicaciones();
		Publicacion publi=new Publicacion();

		try {
			publi.setTitulo("");
			Date fecha=new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2014");
			publi.setFechainicio(fecha);
			
			Collection<Publicacion> listado = negocio.ReportedePublicaciones(publi);

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("Titulo \t \t \t \t Descripcion \t \t \t FechaPublicacion");
			System.out.println("--------------------------------------------------------------------------------");
			for (Publicacion publicacion : listado) {
				
				System.out.println(publicacion.getTitulo()+"\t\t"+publicacion.getDescripcion()+"\t"+publicacion.getFechaPublicacion());
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	/*

//	@Test
	public void eliminarTest() {
		GestionCategorias negocio = new GestionCategorias();
		try {
			negocio.eliminar(5);
			Categoria nuevo = negocio.obtener(5);
			Assert.assertEquals(null, nuevo.getDescripcion());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}

*/
}
