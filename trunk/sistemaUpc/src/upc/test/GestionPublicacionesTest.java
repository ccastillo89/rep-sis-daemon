package upc.test;



import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Persona;
import upc.modelo.Publicacion;
import upc.modelo.Codigo;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionPublicaciones;
//import upc.util.utilfechas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/*import org.junit.Assert;
import org.junit.Test;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.negocio.GestionCategorias;*/

public class GestionPublicacionesTest {
	
	
	//@Test
	public void insertarTest() throws ParseException {

		GestionPublicaciones negocio = new GestionPublicaciones();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = formatoFecha.parse("2013-01-01");
		java.sql.Date fechaCreacion = new java.sql.Date(fecha.getTime());
		
	
		try {
			Publicacion p = negocio.insertar("Idea2", "xxx", "archivo", 1, 1,  fechaCreacion, "palabra1,palabra2,palabra3,palabra4");
			System.out.println("Se insertó la Idea " + p.getTitulo());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	/*
	public void actualizarTest() {

		GestionCategorias negocio = new GestionCategorias();

		try {
			negocio.actualizar(1, "Monitores", "Pantalla plana");



		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	*/

	//@Test
	
	public void ReportedePublicacionesTest() throws ParseException {

		GestionPublicaciones negocio = new GestionPublicaciones();
		Publicacion publi=new Publicacion();

		try {
			publi.setTitulo("");
			Date fecha=new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2014");
			publi.setFechainicio(fecha);
			fecha=new SimpleDateFormat("dd/MM/yyyy").parse("12/03/2014");
			publi.setFechafin(fecha);
			publi.setEstado(1); //Creada
			Collection<Publicacion> listado = negocio.ReportedePublicaciones(publi);

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("Titulo \t \t \t \t Descripcion \t \t \t FechaCreacion \t \t \t Institucion \t \t \t Persona");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			for (Publicacion publicacion : listado) {
				Persona person=publicacion.getUsuario().getPersona();
				System.out.println(publicacion.getTitulo()+"\t\t"+publicacion.getDescripcion()+"\t"+publicacion.getFechaCreacion()+"\t"+person.getCentroFormacion().getNombre()+"\t\t"+person.getNombres());
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

   // @Test
    public void listarPublicacionTest() {

        GestionPublicaciones negocio = new GestionPublicaciones();

        try {
            Collection<Publicacion> listado = negocio.buscarPublicacion("descripcion", 1);

            System.out.println("Total de registros: " + listado.size());

            for (Publicacion publicacion : listado) {
                System.out.println(publicacion.getTitulo());
                System.out.println(publicacion.getEstado());
                System.out.println(publicacion.getIdUsuario());

            }

            Assert.assertTrue(listado.size() > 0);

        } catch (DAOExcepcion e) {
            Assert.fail("Falló el listado: " + e.getMessage());
        }
    }
    
    
    @Test
    public void buscarPublicacionTest() {

        GestionPublicaciones negocio = new GestionPublicaciones();

        try {
            Collection<Publicacion> listado = negocio.buscar("", 8);

            System.out.println("Total de registros: " + listado.size());

            for (Publicacion publicacion : listado) {
            	
                System.out.println("ID : " + publicacion.getIdPublicacion() + " | Titulo : " + publicacion.getTitulo() + "  | Descripci�n : " + publicacion.getDescripcion() + "  | Estado : " + publicacion.getEstado().getIdCodigo());

            }

            Assert.assertTrue(listado.size() > 0);

        } catch (DAOExcepcion e) {
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
    //@Test
  	public void actualizarEstadoTest() {

  		GestionPublicaciones negocio = new GestionPublicaciones();
  		Publicacion modelo = new Publicacion();
  		Codigo modeloEstado = new Codigo(); 

  		try {
  			
  			modeloEstado.setIdCodigo(8);
  			
  			modelo.setIdPublicacion(3);
  			modelo.setEstado(modeloEstado); 								
  					
  			negocio.actualizarEstado(modelo);
  			

  		} catch (DAOExcepcion e) {
  			Assert.fail("Fall� la actualizaci�n: " + e.getMessage());
  		}
  	}
	

}
