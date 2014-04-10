package servlet.Publicacion;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Usuario usu = new Usuario();
		Codigo cod = new Codigo();
		Utilitarios fecha = new Utilitarios();	
	
		
		String x = request.getParameter("titulo");
		String y = request.getParameter("descripcion");
		String ruta = request.getParameter("descripcion");
		String palab1=	request.getParameter("titulo");
		String palab2=	request.getParameter("titulo");
		String palab3=	request.getParameter("titulo");
		String palab4=	request.getParameter("titulo");
		String pclave = palab1 + ","+palab2+","+palab3+","+palab4;
		try {
			
			
			 usu.setIdUsuario(5);
			cod.setIdCodigo(6);
			  p.setTitulo(x);
			  p.setDescripcion(y);
			  p.setArchivo(ruta);
			  p.setEstado(cod);
			  p.setPalabraClave(pclave);
			 // p.setFechaCreacion(fecha.ObtnerFecha().getTime());
			
			negocio.insertar(p);
			
			
			response.sendRedirect(request.getContextPath()	+ "/RolBuscarServlet");
		} catch (DAOExcepcion | ParseException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("centroFormacion_Editar.jsp");
		rd.forward(request, response);
		
	}
		
	

}
