<!DOCTYPE html>
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
        
	  <!-- Static navbar -->
	 <jsp:include page="header.jsp" />
      
	 <div class="container"> 


		<p><strong>Reporte de Ideas &gt; Buscar</strong></p>
		
		<form id="form1" name="form1" method="post" action="ReporteIdeasServlet" class="form-horizontal" role="form">
		  <p>Buscar: 
		    <label>
		    <input type="text" name="descripcion" id="descripcion" />
		    </label>
		    <label>
		    <input type="submit" name="button" id="button" value="Buscar" />
		    </label>
		    <label>
		    <input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='roles_nuevo.jsp' "  />
		    </label>
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th width="49" scope="col">Estado</th>
		    <th width="192" scope="col">Titulo</th>
		    <th width="107" scope="col">Descripción</th>
		    <th width="192" scope="col">Nombres y Apellidos</th>
		  </tr>
		
		<%@page import="java.util.*, upc.modelo.Publicacion" %>
		<%
		
		Collection<Publicacion> arreglo = (ArrayList<Publicacion>)request.getAttribute("publicaciones");
		if(arreglo != null) { 
		int i = 1;
		for(Publicacion x : arreglo) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getEstado()); %></td>
		    <td><% out.print(x.getTitulo()); %></td>
		    <td><% out.print(x.getDescripcion()); %></td>
		    <td><% out.print(x.getUsuario()); %></td>
		   
		   
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
