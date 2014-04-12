package servlet.asesoria;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Asesoria;
import upc.modelo.Codigo;
import upc.modelo.Publicacion;
import upc.negocio.GestionAsesoria;

/**
 * Servlet implementation class AsesoriaRegistrarServlet
 */
@WebServlet("/AsesoriaRegistrarServlet")
public class AsesoriaRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsesoriaRegistrarServlet() {
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
		// TODO Auto-generated method stub
		
		String alumno = request.getParameter("ddlAlumno");
		String publicacion = request.getParameter("ddlPublicacion");
		String obs = request.getParameter("txtObservacion");
		String califica = request.getParameter("ddlCalifica");
		
		GestionAsesoria negocio = new GestionAsesoria();
		Asesoria asesoria = new Asesoria();
		Codigo calificacion = new Codigo();
		Publicacion publicacionss = new Publicacion();

		Asesoria asesoriaRegistrada = new Asesoria();

		try {

			asesoria.setObservacion(obs);
			asesoria.setFechaAsesoria("18/03/2014");
			
			calificacion.setIdCodigo(Integer.parseInt(califica) );
			asesoria.setCalificacion(calificacion);
			
			publicacionss.setIdPublicacion(Integer.parseInt(publicacion));
			asesoria.setPublicacion(publicacionss);
			
			asesoriaRegistrada = negocio.insertar(asesoria);
			
			if (!asesoriaRegistrada.equals(null)) {
				String message = "Registrado Correctamente";
				request.getSession().setAttribute("message", message);
				
				RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
				rd.forward(request, response);
			}
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			String message = e.getMessage();
			request.getSession().setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
			rd.forward(request, response);
		}
		
	}

}
