package upc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upc.excepcion.DAOExcepcion;
import upc.excepcion.LoginExcepcion;
import upc.modelo.Usuario;
import upc.negocio.GestionUsuarios;

/**
 * Servlet implementation class for Servlet: LoginServlet
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		GestionUsuarios negocio = new GestionUsuarios();


		try {
			Usuario vo = negocio.validarUsuario(usuario, clave);
			
			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);
			session.setAttribute("PERSONA_ACTUAL", vo.getPersona());
			session.setAttribute("CENTRO_FORMACION", vo.getPersona().getCentroFormacion());
			response.sendRedirect("PortadaServlet");
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("MENSAJE", "Hubo un error al procesar la operación: " + e.getMessage());	
		} catch (LoginExcepcion e) {			
			request.setAttribute("MENSAJE", "Usuario y/o clave incorrectos");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}