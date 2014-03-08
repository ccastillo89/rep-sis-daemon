package upc.test;

import java.util.Collection;

/*import org.junit.Assert;
import org.junit.Test;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.negocio.GestionCategorias;*/

public class GestionUsuariosTest {
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
	
	@Test
	public void listarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			Collection<Categoria> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			
			for (Categoria categoria : listado) {
				System.out.println(categoria.getNombre());
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	

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
