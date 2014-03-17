package upc.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Usuario;
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
	
	
	
}
