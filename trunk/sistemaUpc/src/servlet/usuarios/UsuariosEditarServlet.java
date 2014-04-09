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
import upc.modelo.Usuario;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionUsuarios;

/**
 * Servlet implementation class UsuariosEditarServlet
 */
@WebServlet("/UsuariosEditarServlet")
public class UsuariosEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosEditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Integer IdPersona = Integer.parseInt(id);
		
		GestionUsuarios negocio = new GestionUsuarios();
		
		try {
			Usuario us = negocio.obtener(IdPersona);
			request.setAttribute("Usuario", us);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("usuarios_Editar.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

}
