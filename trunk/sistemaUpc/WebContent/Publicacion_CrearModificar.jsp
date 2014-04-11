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

	<script>
       function validar(){
         var t = document.form1.titulo.value;   
         var d = document.form1.descripcion.value;  
         var p1 = document.form1.palabra1.value;
         var p2 = document.form1.palabra2.value;
         var p3 = document.form1.palabra3.value;
         var p4 = document.form1.palabra4.value;
         
         if (t == ""){
            alert('Ingrese Titulo');
            return false;     }
         else if (d== ""){
             alert('Ingrese Descripcion');
             return false;}
         else if (p1== ""){
             alert('Ingrese Palabra Clave 1');
             return false;} 
         else if (p2== ""){
             alert('Ingrese Palabra Clave 2');
             return false;} 
         else if (p3== ""){
             alert('Ingrese Palabra Clave 3');
             return false;} 
         else if (p4== ""){
             alert('Ingrese Palabra Clave 4');
             return false;} 
         else if (p1 == p2 || p1 == p3 || p1==p4 || p2==p3|| p2==p4 || p3==p4){
 			alert("Las palabras claves no se pueden repetir.");
 		} else {
 				return true;
 			}
         
       }
    </script>




</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">

		<p>
			<strong>Proceso &gt; Crear Publicacion</strong>
		</p>

		<div class="pageTitle">
			<span>Registro Y Modificacion de Ideas</span>
		</div>
		<br />
		<form id="form1" name="form1" method="post" onsubmit="return validar()"  
			action="PublicacionCrearServlet" class="form-horizontal" role="form">

			<fieldset>
				<legend>Datos de la Idea</legend>
				<p>
					<input type="radio" name="Tipo" value="nuevo">Nuevo <input
						type="radio" name="Tipo" value="modificar">Modificar <br>
					Titulo: <input type="text" name="titulo" id="titulo"
						style="width: 285px;" /> <input type="submit" value="Buscar">
					&nbsp;&nbsp;* <br> Descripción: <input type="text"
						name="descripcion" id="descripcion" style="width: 406px;" />&nbsp;&nbsp;*
					<br>
				</p>
			</fieldset>
			<br>
			<fieldset>
				<legend>Palabras Clave:</legend>
				<p>
					Palabra 1: <input type="text" name="palabra1" id="palabra1">
					&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;Palabra 2: <input type="text"
						name="palabra2" id="palabra2"> &nbsp;&nbsp; * <br>
					Palabra 3: <input type="text" name="palabra3" id="palabra3">
					&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;Palabra 4: <input type="text"
						name="palabra4" id="palabra4"> &nbsp;&nbsp; * <br>
				</p>
			</fieldset>
			<br>
			<fieldset>
				<legend> </legend>
				<p>
					<input type="checkbox" name="achivo" value="archivo">Subir
					Archivo<br> Examinar: <input type="text" name="ruta" id="ruta">
					<input type="submit" value="ver" /> <br>
				</p>
			</fieldset>

			<p>
				<strong>* Campos Obligatorios</strong>
			</p>
			<input type="submit" value="Guardar" />

		</form>

	</div>

</body>
</html>