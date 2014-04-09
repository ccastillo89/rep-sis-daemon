package servlet.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Persona;
import upc.modelo.Usuario;
import upc.negocio.GestionPersona;

/**
 * Servlet implementation class UsuarioInsertarServlet
 */
@WebServlet("/UsuarioInsertarServlet")
public class UsuarioInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioInsertarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String nombres = request.getParameter("txtNombres");
		String paterno = request.getParameter("txtApePaterno");
		String materno = request.getParameter("txtApeMaterno");
		String sexo = request.getParameter("ddlSexo");
		String tipoDoc = request.getParameter("ddlTipo");
		String nroDocumento = request.getParameter("txtNroDocumento");
		String email = request.getParameter("txtEmail");
		String celular = request.getParameter("txtCelular");
		String contrasena = request.getParameter("txtContrasena");	
		String rolAsignado = request.getParameter("ddlRol");
		String cformacion = request.getParameter("ddlCentro");
		
		
		GestionPersona negocio = new GestionPersona();
		Persona person = new Persona();
		CentroFormacion modeloCF = new CentroFormacion();
		Codigo sx = new Codigo();
		Codigo tipoDocumento = new Codigo();
		Usuario user = new Usuario();
		Codigo rol = new Codigo();
		
		person.setNombres(nombres);
		person.setPaterno(paterno);
		person.setMaterno(materno);
		person.setNumeroDoc(nroDocumento);
		person.setCelular(celular);

		modeloCF.setIdCentroInformacion(Integer.parseInt(cformacion));
		person.setCentroFormacion(modeloCF);

		sx.setIdCodigo(Integer.parseInt(sexo));
		person.setSexo(sx);

		tipoDocumento.setIdCodigo(Integer.parseInt(tipoDoc));
		person.setTipoDocumento(tipoDocumento);

		user.setCorreo(email);
		user.setPassword(contrasena);
		rol.setIdCodigo(Integer.parseInt(rolAsignado));
		user.setTipoUsuario(rol);
		
		try {
			negocio.insertar(person, user);
			response.sendRedirect(request.getContextPath()	+ "/UsuariosBuscarServlet");
		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}		
		
	}

}
