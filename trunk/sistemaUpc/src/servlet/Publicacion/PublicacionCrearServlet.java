package servlet.Publicacion;

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
import upc.modelo.Publicacion;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionPublicaciones;
/**
 * Servlet implementation class PublicacionCrearServlet
 */
@WebServlet("/PublicacionCrearServlet")
public class PublicacionCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PublicacionCrearServlet() {
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
		// TODO Auto-generated method stub
		
    		
		GestionPublicaciones negocio = new GestionPublicaciones();
		
		String x = request.getParameter("titulo");
		String y = request.getParameter("descripcion");
		
		GestionRoles negocio = new GestionRoles();
		try {
			negocio.insertar(x, y);
			response.sendRedirect(request.getContextPath()	+ "/RolBuscarServlet");
		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		try {
			CentroFormacion vo = negocio.(IdPublicacion);
			request.setAttribute("CentroFormacion", vo);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("centroFormacion_Editar.jsp");
		rd.forward(request, response);
		
	}
		
	}

}
