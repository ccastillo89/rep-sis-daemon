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
	          <li class="active"><a href="principal.jsp">Inicio</a></li>
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimientos <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="roles_buscar.jsp">Roles</a></li>
	              <li><a href="#">Productos</a></li>
	              <li><a href="centroFormacion_Buscar.jsp">Centro de Formacion</a></li>	      
	                      
	            </ul>
	          </li>
	          <li><a href="#">Reportes</a></li>	          
	          <li><a href="LogoutServlet">Saliree</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
      
	 <div class="container"> 
	   
	   <!-- Jumbotron -->
	   <div class="jumbotron">     
	   		<h4>Bienvenid@ <b> ${sessionScope.USUARIO_ACTUAL.correo }</b></h4>	     
	   </div>
	   
	   <div class="row">
        <div class="col-lg-4">
          <h4>Mantenimiento de Roles</h4>
          <p>Desde esta opción usted podrá crear, modificar, buscar y eliminar los roles de la base de datos. </p>
          <p><a class="btn btn-primary" href="roles_buscar.jsp">Ver detalles &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h4>Mantenimiento de Productos</h4>
          <p>Desde esta opción usted podrá crear, modificar, buscar y eliminar los productos de la base de datos. </p>
          <p><a class="btn btn-primary" href="#">Ver detalles &raquo;</a></p>
       </div>
       <div class="col-lg-4">
          <h4>Mantenimiento de Centros de Formacion</h4>
          <p>Desde esta opción usted podrá crear, modificar, buscar y eliminar los centros de formacion de la base de datos. </p>
          <p><a class="btn btn-primary" href="#">Ver detalles &raquo;</a></p>
       </div>
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
