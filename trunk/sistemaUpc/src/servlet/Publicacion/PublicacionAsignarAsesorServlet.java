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
import upc.modelo.Publicacion;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class PublicacionAsignarAsesorServlet
 */
@WebServlet("/PublicacionAsignarAsesorServlet")
public class PublicacionAsignarAsesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionAsignarAsesorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String a = request.getParameter("id");
		
		
		Integer IdPublicacion = Integer.parseInt(a);
		
		GestionPublicaciones negocio = new GestionPublicaciones();
		
		try {
			Publicacion vo = negocio.obtener(IdPublicacion);
			request.setAttribute("PUBLICACION", vo);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("publicacion_Editar.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
