package servlet.centroFormacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.negocio.GestionCentroFormacion;

/**
 * Servlet implementation class CentroFormacionModificarServlet
 */
@WebServlet("/CentroFormacionModificarServlet")
public class CentroFormacionModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentroFormacionModificarServlet() {
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


		String IdCentroFormacion = request.getParameter("IdCentroFormacion");
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String url = request.getParameter("url");
		String logo = request.getParameter("logo");		
		
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		CentroFormacion modelo = new CentroFormacion();
		
		modelo.setIdCentroInformacion(Integer.parseInt(IdCentroFormacion));
		modelo.setNombre(nombre);
		modelo.setTipo(Integer.parseInt(tipo));
		modelo.setUrl(url);
		modelo.setLogo(logo);
		try {
			negocio.actualizar(modelo);
			response.sendRedirect(request.getContextPath()	+ "/CentroFormacionBuscarServlet");
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
