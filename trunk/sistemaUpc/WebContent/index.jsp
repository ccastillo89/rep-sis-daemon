<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Sistema de Gesti&oacute;n de la Informaci&oacute;n</title>

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

<div class="sheet sheet--dark sheet--transparent sheet--with-bg sheet--hero sheet--padding" style="background-image: url(img/hero-home.jpg); height: 500px;">

    <div class="container">
   
   
   	<form class="form-signin" action="LoginServlet" method="post">
        <h2 class="form-signin-heading">Bienvenido al Sistema de Información DAEMON</h2>
        <input type="text" class="form-control" placeholder="Usuario" autofocus name="usuario">
        <input type="password" class="form-control" placeholder="Clave" name="clave">        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
        <span style="color: red;">${MENSAJE }</span>
    </form>
	
    </div> <!-- /container -->

</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>
  </body>
</html>
