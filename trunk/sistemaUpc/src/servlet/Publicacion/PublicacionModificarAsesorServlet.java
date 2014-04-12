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
import upc.modelo.Usuario;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class PublicacionModificarAsesorServlet
 */
@WebServlet("/PublicacionModificarAsesorServlet")
public class PublicacionModificarAsesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionModificarAsesorServlet() {
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


		String mensajeError = "";
		
		String IdPublicacion = request.getParameter("IdPublicacion");
		String asesor = request.getParameter("asesor");
		
		
		
		GestionPublicaciones negocio = new GestionPublicaciones();
		
		Publicacion modelo = new Publicacion();
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(Integer.parseInt(asesor));
		
		modelo.setIdPublicacion(Integer.parseInt(IdPublicacion));
		modelo.setUsuarioAsesor(usuario);
		

		try {
			negocio.asignarAcesor(modelo);
			//response.sendRedirect(request.getContextPath()	+ "/PublicacionBuscarAprobadosSerlvet");
			RequestDispatcher rd = request.getRequestDispatcher("asesor_Asignar.jsp");
			rd.forward(request, response);
			
			return;
		} catch (DAOExcepcion e) {

			mensajeError = e.getMessage();
		}

		//System.out.println("Mensaje Error : " + mensajeError);
		//response.sendRedirect(request.getContextPath()	+ "/CentroFormacionEditarServlet?id=" + IdCentroFormacion + "&mensajeError=" + mensajeError);
		

		
	}

}
