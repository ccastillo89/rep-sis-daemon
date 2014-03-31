package servlet.centroFormacion;

import java.io.IOException;
import java.util.Collection;

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
 * Servlet implementation class CentroFormacionBuscarServlet
 */
@WebServlet("/CentroFormacionBuscarServlet")
public class CentroFormacionBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentroFormacionBuscarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("Dentro de doPost del servlet centroFormacionBuscarSerlvet");
		String x = request.getParameter("nombre");
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		CentroFormacion modelo = new CentroFormacion();
		modelo.setNombre(x);
		try {
			Collection<CentroFormacion> lista = negocio.listar(modelo);
			// Guardar en el ambiente de request
			request.setAttribute("CentroFormaciones", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("centroFormacion_Buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
