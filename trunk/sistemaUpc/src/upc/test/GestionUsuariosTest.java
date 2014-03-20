package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Usuario;
import upc.modelo.Codigo;
import upc.negocio.GestionUsuarios;

public class GestionUsuariosTest {

	@Test
	public void Login() {
		
		GestionUsuarios negocio = new GestionUsuarios();
		Usuario user = new Usuario();
		
		try {

			user.setCorreo("carlosdevel@gmail.com");
			user.setPassword("1234s5");
			
			if (negocio.loginUsuario(user)){
				System.out.println("============= Logueado Correctamente =============");
			}else{
				System.out.println("============= Usuario o contraseña incorrectos =============");
			}
			

		} catch (DAOExcepcion e) {
			Assert.fail("Falló el loguin: " + e.getMessage());
		}
		
	}
	
	@Test
	public void buscarPorTipoUsuarioTest() {

		GestionUsuarios negocio = new GestionUsuarios();
		Codigo modelo = new Codigo();
		
		modelo.setIdCodigo(1);
		

		try {
			Collection<Usuario> listado = negocio.buscarPorTipoUsuario(modelo);

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("");
			
			for (Usuario usuario : listado) {
				System.out.println("ID : " + usuario.getIdUsuario() + " | Correo :  " + usuario.getCorreo() );
			}
			
			//Assert.assertTrue(listado.size() > 0);	

		
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	
	
}
