<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Reporte de Ideas</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
    

  <SCRIPT src="js/mootools-core.js" type="text/javascript"></SCRIPT>
	 
<SCRIPT src="js/mootools-more.js" type="text/javascript"></SCRIPT>
	 
<SCRIPT src="js/Locale.en-US.DatePicker.js" type="text/javascript"></SCRIPT>
	 
<SCRIPT src="js/Picker.js" type="text/javascript"></SCRIPT>
	 
<SCRIPT src="js/Picker.Attach.js" type="text/javascript"></SCRIPT>
	 
<SCRIPT src="js/Picker.Date.js" type="text/javascript"></SCRIPT>


      <LINK href="css/datepicker.css" rel="stylesheet"> 


<SCRIPT>

	window.addEvent('domready', function(){
		new Picker.Date($$('#datepicker'), {
			
			positionOffset: {x: 5, y: 0},			
			useFadeInOut: !Browser.ie,
			format: '%d/%m/%Y'
		});
new Picker.Date($$('#datepicker2'), {
			
			positionOffset: {x: 5, y: 0},
			useFadeInOut: !Browser.ie,
			format: '%d/%m/%Y'
		});
		
	});

	</SCRIPT>
      
  </head>

  <body>
        
	  <!-- Static navbar -->
	 <jsp:include page="header.jsp" />
      
	 <div class="container"> 


		<p><strong>Reporte de Ideas</strong></p>
		
		<form id="form1" name="form1" method="post" action="ReporteIdeasServlet" class="form-horizontal" role="form">
		  <p>Titulo: 
		    <label>
		    <input type="text" name="titulo" id="descripcion" />
		    </label>
		    <label>
		    <input type="submit" name="button" id="button" value="Buscar" />
		    </label>
		  </p>
		  <p>Fecha Inicio:
		 <input type="text" id="datepicker" name="fechaini" value="01/01/2014"  class='date demo'>
		Fecha Fin:
		 <input type="text" id="datepicker2" name="fechafin" value="01/04/2014"  class='date demo'>
		  </p>
		  <p>
		  <input type="radio" name="estado" value="6" checked="checked">Creada
		  <input type="radio" name="estado" value="7">Publicada
		  <input type="radio" name="estado" value="8">Aprobada
		  <input type="radio" name="estado" value="9">Rechazada
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th width="49" scope="col">Estado</th>
		    <th width="192" scope="col">Titulo</th>
		    <th width="107" scope="col">Descripcion</th>
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
		   
		    <td><% out.print(x.getEstado().getDescripcionCodigo()); %></td>
		    <td><% out.print(x.getTitulo()); %></td>
		    <td><% out.print(x.getDescripcion()); %></td>
		    <td><% out.print(x.getUsuario().getPersona().getNombreCompleto()); %></td>
		   
		   
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
