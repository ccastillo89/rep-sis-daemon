package upc.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import upc.excepcion.DAOExcepcion;


import upc.modelo.UsuarioPermitido;
import upc.modelo.Usuario;
import upc.negocio.GestionUsuarioPermitido;

public class GestionUsuarioPermitidoTest {
	
    @Test
			public void accesoTest() throws ParseException {

				GestionUsuarioPermitido negocio = new GestionUsuarioPermitido();
				UsuarioPermitido p = new UsuarioPermitido();
				 Usuario usu = new Usuario();
				 UsuarioPermitido p2 = new UsuarioPermitido();
				 
				 try { 
				 //ingreso Usuario
				 usu.setIdUsuario(2);
				 
				// ingreso UsuarioPermitido
				 
				    p.setUsuario(usu);
				 								
				  	p2=negocio.acceso(p);
					if (!p2.equals("")) {
						System.out.println("Se Permiso al usuario");	
					}
				
				} catch (DAOExcepcion e) {
					Assert.fail("Fallo verificar el acceso");
				}
			}
	

}
