package servlet.Publicacion;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class PublicacionBuscarPublicadosServlet
 */
@WebServlet("/PublicacionBuscarPublicadosServlet")
public class PublicacionBuscarPublicadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionBuscarPublicadosServlet() {
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


		System.out.println("Dentro de doPost del servlet PublicacionBuscarPublicadosSerlvet");
		String nombre = request.getParameter("txtDescripcion");
		GestionPublicaciones negocio = new GestionPublicaciones();
		//Publicacion modelo = new Publicacion();
		//modelo.setNombre(x);
		try {
			Collection<Publicacion> lista = negocio.buscarPublicacion(nombre,7);
			// Guardar en el ambiente de request
			request.setAttribute("PUBLICACIONES", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("publicacion_Evaluar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
