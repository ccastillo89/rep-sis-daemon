<!DOCTYPE html>
<%@page import="upc.negocio.GestionCentroFormacion"%>
<%@page import="upc.modelo.CentroFormacion"%>
<%@page import="upc.modelo.Usuario"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title></title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">
<link href="css/daemon.css" rel="stylesheet" media="screen">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<p>
			<strong>Mantenimiento de Usuarios &gt; Buscar</strong>
		</p>

		<div class="pageTitle">
			<span>B&uacute;squeda de Usuarios</span>
		</div>
		<br />
		<form id="form1" name="form1" method="post"
			action="UsuariosBuscarServlet" class="form-horizontal" role="form">
			<p>
				Buscar: <label> <input type="text" name="txtNombre"
					id="txtNombre" /></label> Centro de Formaci&oacute;n: <label> <select
					id="ddlCentroFormacion" name="ddlCentroFormacion"
					style="width: 120px;">
						<% 	GestionCentroFormacion negocio = new GestionCentroFormacion();
						CentroFormacion ci = new CentroFormacion();
						ci.setNombre("");
						Collection<CentroFormacion> cf=  negocio.listar(ci) ;
						if(cf!=null)			               
						for(CentroFormacion c:cf){%>
						<option value="<%=c.getIdCentroInformacion() %>"><%=c.getNombre() %></option>
						<%} 
					
					%>
				</select>
				</label> <label> <input type="submit" name="button" id="button"
					value="Buscar" />
				</label> <label> <input type="button" name="button2" id="button2"
					value="Nuevo" onclick="window.location='usuarios_Nuevo.jsp'" />
				</label>
			</p>
		</form>

		<div class="table-responsive">
			<table width="550" height="65" border="1" cellpadding="0"
				cellspacing="0" class="table table-hover">
				<tr>
					<th width="30" scope="col">Nro.</th>
					<th width="20" scope="col">ID</th>
					<th width="250" scope="col">Apellidos y Nombres</th>
					<th width="80" scope="col">Sexo</th>
					<th width="80" scope="col">Tipo de Documento</th>
					<th width="80" scope="col">Nro. de Documento</th>
					<th width="120" scope="col">Email</th>
					<th width="80" scope="col">Celular</th>
				</tr>
				<%@page import="java.util.*, upc.modelo.Usuario"%>
				<%
				Collection<Usuario> arreglo = (ArrayList<Usuario>)request.getAttribute("Usuarios");
				if(arreglo != null) { 
				int i = 1;
				for(Usuario x : arreglo) {
				%>
				<tr>
					<td><%=i++ %></td>
					<td>
						<% out.print(x.getPersona().getIdPersona()); %>
					</td>
					<td>
						<% out.print(x.getPersona().getPaterno() + ' ' + x.getPersona().getMaterno() + ' ' + x.getPersona().getNombres()); %>
					</td>
					<td>
						<% out.print(x.getPersona().getSexo().getDescripcionCodigo()); %>
					</td>
					<td>
						<% out.print(x.getPersona().getTipoDocumento().getDescripcionCodigo()); %>
					</td>
					<td>
						<% out.print(x.getPersona().getNumeroDoc()); %>
					</td>
					<td>
						<% out.print(x.getCorreo()); %>
					</td>
					<td>
						<% out.print(x.getPersona().getCelular()); %>
					</td>
					<td><a
						href="<%=request.getContextPath() %>/UsuariosEditarServlet?id=<%=x.getPersona().getIdPersona() %>">Editar</a>
						- <a
						href="<%=request.getContextPath()%>/UsuariosEliminarServlet?id=<%=x.getPersona().getIdPersona()%>"
						onclick="return confirm('¿Está seguro que desea eliminar?');">Eliminar</a>
					</td>
				</tr>
				<%
					}
	 	 		} %>

			</table>
		</div>

		<!-- Site footer -->
		<div class="footer">
			<p>&nbsp;</p>
			<p>&copy; DAEMON 2014</p>
		</div>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.10.2.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap-3.1.1.js"></script>
</body>

</html>