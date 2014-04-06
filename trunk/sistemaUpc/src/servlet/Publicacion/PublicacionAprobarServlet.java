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
 * Servlet implementation class PublicacionAprobarServlet
 */
@WebServlet("/PublicacionAprobarServlet")
public class PublicacionAprobarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionAprobarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String a = request.getParameter("id");
		
		Integer IdPublicacion = Integer.parseInt(a);
		
		Publicacion modeloPub = new Publicacion();
		Codigo modeloCod = new Codigo();
		
		modeloCod.setIdCodigo(8);
		
		modeloPub.setIdPublicacion(IdPublicacion);
		modeloPub.setEstado(modeloCod);
		
				
		GestionPublicaciones negocio = new GestionPublicaciones();
		
		try {
			negocio.actualizarEstado(modeloPub);
			//request.setAttribute("PUBLICACIONES", vo);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("publicacion_Evaluar.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
