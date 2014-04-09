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
import upc.modelo.Codigo;
import upc.modelo.Publicacion;
import upc.negocio.GestionPublicaciones;

/**
 * Servlet implementation class for Servlet: ReporteIdeasServlet
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
		try {
		System.out.println("Dentro de doPost del servlet RolBuscarSerlvet");
		String titulo = (String) request.getParameter("titulo");
		Date fechaini =new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechaini"));
		Date fechafin = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechafin"));
		//int estado = Integer.parseInt(request.getParameter("estado")) ;
		
		Publicacion pub =new Publicacion();
		 String[] ids=request.getParameterValues("estado");
		 String strestados="";
		    // this will get array of values of all checked checkboxes
		    for(String id:ids){
		     // do something with id, this is checkbox value
		    	System.out.println(id);
		    	strestados+=id+",";
		    }
		 
		    strestados= strestados.substring(0, strestados.length()-1);
		    System.out.println(strestados);
		 
		pub.setEstadossel(strestados);
		
		pub.setTitulo(titulo);
		pub.setFechainicio(fechaini);
		pub.setFechafin(fechafin);
		GestionPublicaciones negocio = new GestionPublicaciones();
		
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
