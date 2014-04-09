<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>SGI para Centros de Formacion Profesional</title>

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
