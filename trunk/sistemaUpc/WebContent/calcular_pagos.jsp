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

<script type="text/javascript">
function validamonto(){
	if(document.getElementById("descripcion").value==""){
		alert('Ingrese un Costo por Usuario');
		return false;
		
	}
	
	
	function validar(e) { 
	    tecla = (document.all) ? e.keyCode : e.which; 
	    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
	    patron = /d/; //ver nota 
	    te = String.fromCharCode(tecla); 
	    return patron.test(te);  
	}  
}
</script>
      
  </head>

  <body>
        
	  <!-- Static navbar -->
	 <jsp:include page="header.jsp" />
      
	 <div class="container"> 


		<div class="pageTitle">
			<span>Calcular Pagos</span>
		</div>
		<br>
		
		<form id="form1" name="form1" method="post" action="CalcularPagosServlet" class="form-horizontal" role="form">
		  <p>Costo por Usuario: 
		    <label>
		    <input type="text" name="titulo" id="descripcion" onkeypress="return validar(event);" />
		    </label>
		    <label>
		    <input type="submit" name="button" id="button" value="Calcular" onclick="return validamonto();" />
		    </label>
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr class="footergrid">
		    <th width="49" scope="col">Tipo</th>
		    <th width="192" scope="col">Nombre</th>
		    <th width="107" scope="col">Web</th>
		    <th width="50" scope="col">Cant.Usuarios</th>
		     <th width="100" scope="col">Pago</th>
		  </tr>
		
		<%@page import="java.util.*, upc.modelo.CentroFormacion" %>
		<%
		
		Collection<CentroFormacion> arreglo = (ArrayList<CentroFormacion>)request.getAttribute("centrosformacion");
		int total=0;
		int totuser=0;
		double suma=0;
		
		if(arreglo != null) { 
		for(CentroFormacion x : arreglo) {
		%>  
		  <tr>
		    <td><% out.print(x.getStrTipo()); %></td>
		    <td><% out.print(x.getNombre());%></td>
		    <td><% out.print(x.getUrl()); %></td>
		     <td><% out.print(x.getPersona().size()); %></td>
		    <td><% out.print(x.getPago());
		    
		    totuser+=x.getPersona().size();
		    suma+=x.getPago();
		     total+=1;%></td>
		  
		   
		  </tr>
		<% }  
		  }%>
		  

		  
		</table>
		</div>
		<div style="width:300px;" >
		<table class="table table-hover">></tr>
		<tr><td><b>Cantidad Centros de Formacion:</b></td><td><%out.print(" "+total); %></td></tr>
		<tr><td><b>Cantidad de Usuarios:</b></td><td><%out.print(" "+totuser); %></td></tr>
		<tr><td><b>Total a Pagar:</b></td><td><%out.print(" "+suma); %></td></tr>
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
