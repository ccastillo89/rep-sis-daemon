<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	              <li><a id="lnkUsuario" href="usuarios_Buscar.jsp">Usuarios</a></li>
	            </ul>
	          </li>
	          
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Procesos <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="publicacion_Evaluar.jsp">Evaluar Publicacion</a></li>
	              <li><a id="lnkAsesoria" href="asesoria.jsp">Asesorias</a></li>	                      
	            </ul>
	          </li>	          
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="reporte_ideas.jsp">Reporte de Ideas</a></li>
	             
	            </ul>
	          </li>     
	            <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cobranzas <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="calcular_pagos.jsp">Calcular Pagos</a></li>
	             
	            </ul>
	          </li>    
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
</body>
</html>