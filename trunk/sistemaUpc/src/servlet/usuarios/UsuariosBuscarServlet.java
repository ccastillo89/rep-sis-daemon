package servlet.usuarios;

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
import upc.modelo.Persona;
import upc.modelo.Usuario;
import upc.negocio.GestionUsuarios;

/**
 * Servlet implementation class UsuariosBuscarServlet
 */
@WebServlet("/UsuariosBuscarServlet")
public class UsuariosBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosBuscarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x = request.getParameter("txtNombre");
		String centroFormacionId = request.getParameter("ddlCentroFormacion") ; 
		GestionUsuarios negocio = new GestionUsuarios();
		Persona ps = new Persona();
		CentroFormacion cf = new CentroFormacion();
		
		ps.setNombreCompleto(x);
		
		if (centroFormacionId == null){
			centroFormacionId = "1";
		}
		
		cf.setIdCentroInformacion(Integer.parseInt(centroFormacionId));
		ps.setCentroFormacion(cf);
		
		try {
			Collection<Usuario> lista = negocio.BuscarUsuariosPorCentroFormacion(ps);
			// Guardar en el ambiente de request
			request.setAttribute("Usuarios", lista);
			RequestDispatcher rd = request.getRequestDispatcher("usuarios_Buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
