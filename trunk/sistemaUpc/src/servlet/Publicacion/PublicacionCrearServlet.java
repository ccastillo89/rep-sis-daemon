package servlet.Publicacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upc.excepcion.DAOExcepcion;
import upc.modelo.Codigo;
import upc.modelo.Publicacion;
import upc.modelo.Usuario;
import upc.negocio.GestionPublicaciones;
import upc.util.Utilitarios;
/**
 * Servlet implementation class PublicacionCrearServlet
 */
@WebServlet("/PublicacionCrearServlet")
public class PublicacionCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PublicacionCrearServlet() {
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
		
		GestionPublicaciones negocio = new GestionPublicaciones();
		Publicacion p = new Publicacion();
		Publicacion p2 = new Publicacion();
		Usuario usu = new Usuario();
		Codigo cod = new Codigo();
		Utilitarios fecha = new Utilitarios();	
		HttpSession session = request.getSession();
		
		String x = request.getParameter("titulo");
		String y = request.getParameter("descripcion");
		String ruta = request.getParameter("descripcion");
		String palab1=	request.getParameter("palabra1");
		String palab2=	request.getParameter("palabra2");
		String palab3=	request.getParameter("palabra3");
		String palab4=	request.getParameter("palabra4");
		String opcion = request.getParameter("Tipo");
		String pclave = palab1 + ","+ palab2 + ","+ palab3 +","+ palab4;
		try {
			
			//session.getAttribute();
			 usu.setIdUsuario(5);
			 cod.setIdCodigo(6);
			 
			  p.setTitulo(x);
			  p.setDescripcion(y);
			  p.setArchivo(ruta);
			  p.setUsuario(usu);
			  p.setEstado(cod);
			  p.setPalabraClave(pclave);
			  p.setFechaCreacion(fecha.ObtnerFecha());
			
			if (opcion.equals("nuevo")) {
				p2=negocio.insertar(p);
				if (!p2.equals(null)) {
					String message = "Publicacion Creada Correctamente";
					request.getSession().setAttribute("message", message);
					response.sendRedirect(request.getContextPath()	+ "/PublicacionBuscarServlet");
				}
			}			
			else if (opcion.equals("modificar")) {
				negocio.insertar(p);	
			}
						
			RequestDispatcher rd = request.getRequestDispatcher("Publicacion_CrearModificar.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion | ParseException e) {
			System.out.println(e.getMessage());
			String message = e.getMessage();
			request.getSession().setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
					
	}
	
		}
	
}
