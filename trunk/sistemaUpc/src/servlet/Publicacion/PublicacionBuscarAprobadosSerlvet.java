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
 * Servlet implementation class PublicacionBuscarAprobadosSerlvet
 */
@WebServlet("/PublicacionBuscarAprobadosSerlvet")
public class PublicacionBuscarAprobadosSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionBuscarAprobadosSerlvet() {
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


System.out.println("Dentro de doPost del servlet PublicacionBuscarAprobadosSerlvet");
		
		String nombre = request.getParameter("txtDescripcion");
		
		if (nombre == null)
		{			
			nombre = "";
		}
				
		GestionPublicaciones negocio = new GestionPublicaciones();

		try {
			Collection<Publicacion> lista = negocio.buscar(nombre,8);
			
			request.setAttribute("PUBLICACIONES", lista);			

			RequestDispatcher rd = request.getRequestDispatcher("asesor_Asignar.jsp");
			rd.forward(request, response);			
			


		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
