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
import upc.modelo.CentroFormacion;
import upc.modelo.Publicacion;
import upc.negocio.GestionCentroFormacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class CentroFormacionBuscarServlet
 */
@WebServlet("/PublicacionBuscarServlet")
public class PublicacionBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicacionBuscarServlet() {
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
/*
        GestionPublicaciones negocio = new GestionPublicaciones();

        try {
            Collection<Publicacion> listado = negocio.buscarPublicacion("descripcion", 1);

            System.out.println("Total de registros: " + listado.size());

            for (Publicacion publicacion : listado) {
                System.out.println(publicacion.getTitulo());
                System.out.println(publicacion.getEstado());
                System.out.println(publicacion.getUsuario().getIdUsuario());

            }
		
		*/
		
		//System.out.println("Dentro de doPost del servlet PublicacionBuscarSerlvet");
		String x = request.getParameter("nombre");
		int estado = Integer.parseInt(request.getParameter("ddlEstado"));
	//	System.out.println(estado);
		
		GestionPublicaciones negocio = new GestionPublicaciones();
		//Publicacion modelo = new Publicacion();
		//modelo.setNombre(x);
		try {
			Collection<Publicacion> lista = negocio.buscarPublicacion(x,estado);
			// Guardar en el ambiente de request
			request.setAttribute("PUBLICACIONES", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("publicacion_Buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
