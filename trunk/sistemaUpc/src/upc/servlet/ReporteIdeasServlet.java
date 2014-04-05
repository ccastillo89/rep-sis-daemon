package upc.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import upc.excepcion.DAOExcepcion;
import upc.modelo.Publicacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class for Servlet: RolBuscarServlet
 * 
 */
@WebServlet("/ReporteIdeasServlet")
public class ReporteIdeasServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReporteIdeasServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Dentro de doPost del servlet RolBuscarSerlvet");
		String descripcion = (String) request.getParameter("descripcion");
		
		
		Publicacion pub =new Publicacion();
		
		pub.setDescripcion(descripcion);
		GestionPublicaciones negocio = new GestionPublicaciones();
		try {
			Collection<Publicacion> lista = negocio.ReportedePublicaciones(pub);
			// Guardar en el ambiente de request
			request.setAttribute("publicaciones", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("reporte_ideas.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}
}
