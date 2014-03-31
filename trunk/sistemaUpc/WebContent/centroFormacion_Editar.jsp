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
	  <div class="navbar navbar-default navbar-static-top">
	    <div class="container">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="principal.jsp">Trastienda</a>
	      </div>
	      <div class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	          <li><a href="principal.jsp">Inicio</a></li>
	          <li class="dropdown active">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimientos <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="roles_buscar.jsp">Roles</a></li>
	              <li><a href="#">Productos</a></li>
	              <li><a href="CentroFormacion_Buscar.jsp">Centro de Formaciones</a></li>	              
	            </ul>
	          </li>
	          <li><a href="#">Reportes</a></li>	          
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
      
	 <div class="container"> 

<p><strong>Mantenimiento de Centro de Formaciones &gt; Editar</strong></p>

<form id="form1" name="form1" method="post" action="CentroFormacionModificarServlet">
<%@page import="upc.modelo.CentroFormacion;"%>
<%
CentroFormacion cf = (CentroFormacion)request.getAttribute("CentroFormacion");
%>

  <table width="300" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td>ID</td>
      <td><label>
        <input type="text" name="IdCentroFormacion" id="IdCentroFormacion" 
        value="<%=cf.getIdCentroInformacion() %>"   readonly="readonly"  />
      </label></td>
    </tr>
    <tr>
      <td>Nombre:</td>
      <td><label>
        <input type="text" name="nombre" id="nombre" 
        value="<%=cf.getNombre() %>" />
      </label></td>
    </tr>
    <tr>
      <td>Tipo:</td>
      <td><label>
        <input type="text" name="tipo" id="tipo" 
        value="<%=cf.getTipo() %>"   />
      </label></td>
    </tr>
    <tr>
      <td>URL:</td>
      <td><label>
        <input type="text" name="url" id="url" 
        value="<%=cf.getUrl() %>" />
      </label></td>
    </tr>
    <tr>
      <td>Logo:</td>
      <td><label>
        <input type="text" name="logo" id="logo" 
        value="<%=cf.getLogo() %>" />
      </label></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Guardar" />
        <input type="button" value="Regresar" onclick="window.location='CentroFormacion_Buscar.jsp' " />
	  </td>
    </tr>
  </table>  
  <p>&nbsp;</p>
</form>

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