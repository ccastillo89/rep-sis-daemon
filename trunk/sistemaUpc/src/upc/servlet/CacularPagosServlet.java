package upc.servlet;

 import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import upc.excepcion.DAOExcepcion;
import upc.modelo.CentroFormacion;
import upc.modelo.Codigo;
import upc.modelo.Publicacion;
import upc.negocio.GestionCobranza;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class for Servlet: ReporteIdeasServlet
 * 
 */
@WebServlet("/ReporteIdeasServlet")
public class CacularPagosServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CacularPagosServlet() {
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
		try {
		double titulo = Double.parseDouble(request.getParameter("titulo")) ;
		
		
		CentroFormacion pbeCentroformacion =new CentroFormacion();

		pbeCentroformacion.setCostoporusuario(titulo);
		GestionCobranza negocio = new GestionCobranza();
		
		Collection<CentroFormacion> lista = negocio.ListaCobranza(pbeCentroformacion);
			// Guardar en el ambiente de request
			request.setAttribute("publicaciones", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("reporte_ideas.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
