<!DOCTYPE html>
<%@page import="upc.modelo.CentroFormacion"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Trastienda</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
  		<jsp:include page="header.jsp" />
        

      
	 <div class="container"> 


		<p><strong>Mantenimiento de Centros de Formacion &gt; Buscar</strong></p>
		
		<form id="form1" name="form1" method="post" action="CentroFormacionBuscarServlet" class="form-horizontal" role="form">
		  <p>Buscar: 
		    <label>
		    <input type="text" name="nombre" id="nombre" />
		    </label>
		    <label>
		    <input type="submit" name="button" id="button" value="Buscar" />
		    </label>
		    <label>
		    <input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='centroFormacion_Nuevo.jsp' "  />
		    </label>
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th width="49" scope="col">Nro.</th>
		    <th width="49" scope="col">Codigo</th>
		    <th width="192" scope="col">Nombre</th>
		    <th width="107" scope="col">Tipo</th>
		    <th width="192" scope="col">URL</th>
		    <th width="192" scope="col">Acciones</th>
		    
		  </tr>
		
		<%@page import="java.util.*, upc.modelo.CentroFormacion" %>
		<%
		Collection<CentroFormacion> arreglo = (ArrayList<CentroFormacion>)request.getAttribute("CentroFormaciones");
		if(arreglo != null) { 
		int i = 1;
		for(CentroFormacion x : arreglo) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getIdCentroInformacion()); %></td>
		    <td><% out.print(x.getNombre()); %></td>
		    <td><% out.print(x.getStrTipo()); %></td>
		    <td><% out.print(x.getUrl()); %></td>
		    <td><a href="<%=request.getContextPath() %>/CentroFormacionEditarServlet?id=<%=x.getIdCentroInformacion() %>">Editar</a> - <a href="<%=request.getContextPath()%>
		/CentroFormacionEliminarServlet?id=<%=x.getIdCentroInformacion()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></td>
		  </tr>
		<% }  
		  } %>
		  
		</table>
		</div>

 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; RCondezo 2014 </p>
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
