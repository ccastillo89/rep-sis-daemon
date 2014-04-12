<!DOCTYPE html>
<%@page import="upc.modelo.Publicacion"%>
<%@page import="upc.negocio.GestionPublicaciones"%>
<%@page import="upc.modelo.CentroFormacion"%>
<%@page import="upc.modelo.Persona"%>
<%@page import="upc.modelo.Usuario"%>
<%@page import="upc.negocio.GestionUsuarios"%>
<%@page import="upc.modelo.Asesoria"%>
<%@page import="upc.negocio.GestionCodigos"%>
<%@page import="upc.modelo.Codigo"%>
<%@page import="java.util.Collection"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title></title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">
	<link href="css/daemon.css" rel="stylesheet" media="screen">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    
    function validarCampos(){
		var ddlCalifica = $("#ddlCalifica").val();
		var txtObservacion = $("#txtObservacion").val();
		var ddlAlumno = $("#ddlAlumno").val();
		var ddlpublicacion = $("#ddlPublicacion").val();
    	
		if (ddlCalifica == "0") {
			alert("Seleccione calificación");
		} else if (txtObservacion == "") {
			alert("Ingrese Observacion");
		} else if (ddlAlumno == "0") {
			alert("Seleccione alumno");
		} else if (ddlpublicacion == "0") {
			alert("Seleccione publicación}");
		} else {
			document.form.submit();
			return true;
		}
    }
    
    function SeleccionarPersona(){
    	
    }
   
    </script>
    
  </head>

  <body>
	<jsp:include page="header.jsp" />
	
	<div class="container"> 
		<p>
			<strong>Procesos &gt; Registrar reuniones</strong>
		</p>

		<div class="pageTitle">
			<span>Registrar reuniones</span>
		</div>
		<br />
		<form id="form1" name="form1" method="post" action="AsesoriaRegistrarServlet" class="form-horizontal" role="form">
		  
 			<table width="420" height="330" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td>Alumno:</td>
					<td><label> <select name="ddlAlumno" id="ddlAlumno" onchange="SeleccionarPersona();"
							style="width: 120px;">
									<option value="0">Seleccionar</option>
								<%
									GestionUsuarios negocio = new GestionUsuarios();
									Persona ps = new Persona();
									Codigo co = new Codigo();
									co.setIdCodigo(4);
									
									Collection<Usuario> listaPersonas = negocio.buscarPorTipoUsuario(co);
									if (listaPersonas != null)
										for (Usuario c : listaPersonas) {
								%>
								<option value="<%=c.getPersona().getIdPersona() %>"><%=c.getPersona().getNombres() + " " + c.getPersona().getPaterno() + " " + c.getPersona().getMaterno() %></option>
								<%
									}
								%>

						</select>
					</label></td>
				</tr>
				<tr>
					<td>Idea:</td>
					<td><label><select name="ddlPublicacion" id="ddlTipo"
							style="width: 120px;">
								<option value="0">Seleccionar</option>
								<%
									GestionPublicaciones negociop = new GestionPublicaciones();
									Collection<Publicacion> listap = negociop.buscarPubliUsuario(1, 6);
									if (listap != null)
										for (Publicacion  c : listap) {
								%>
								<option value="<%=c.getIdPublicacion() %>"><%=c.getTitulo()%></option>
								<%
									}
								%>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>Observaciones:</td>
					<td><label> <input type="text" name="txtObservacion"
							id="txtObservacion"  maxlength="150" multiple="multiple" />
					</label></td>
				</tr>
				<tr>
					<td>Calificaci&oacute;n:</td>
					<td><label> <select name="ddlCalifica" id="ddlCalifica"
							style="width: 120px;">
								<option value="0">Seleccionar</option>
								<%
									GestionCodigos negocioTipo = new GestionCodigos();
									Codigo codesTipo = new Codigo();
									codesTipo.setIdGrupo(6);
									Collection<Codigo> codigosTipos = negocioTipo
											.ListarCodigosPorIdGrupo(codesTipo);
									if (codigosTipos != null)
										for (Codigo c : codigosTipos) {
								%>
								<option value="<%=c.getIdCodigo()%>"><%=c.getDescripcionCodigo()%></option>
								<%
									}
								%>
						</select>
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Guardar"
						onclick="validarCampos(); return false" /> <input type="button"
						value="Regresar" onclick="window.location='principal.jsp' " /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
		  	 
		</form>

		<div style="color: red; text-align: left;">
			<p> ${message}</p>
			<c:remove var="message" scope="session" /> 
		</div>
		
 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; DAEMON 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
	
	
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>

</body>
</html>