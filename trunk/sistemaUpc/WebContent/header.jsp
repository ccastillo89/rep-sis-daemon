<%@page import="upc.modelo.Usuario"%>
<%@page import="upc.modelo.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/daemon.css" rel="stylesheet" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*, upc.modelo.Publicacion"%> 
<% Usuario User= (Usuario) session.getAttribute("USUARIO_ACTUAL"); %>
 <!-- Static navbar -->
	  <div class="navbar navbar-default navbar-static-top">
	    <div class="container">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="principal.jsp">SGI</a>
	      </div>
	      <div class="navbar-collapse collapse">
	      <div>
	  
	      <%
	      String uri = request.getRequestURI();
	      String pageName = uri.substring(uri.lastIndexOf("/")+1);
	      System.out.println(pageName);
	      %>
	      
	        <ul class="nav navbar-nav">
	        
	    <%
	        	out.print("<li ");
	          if(pageName.equals("principal.jsp") || pageName.equals("roles_buscar.jsp")){out.print("class='active' >");}  
	          else{out.print("class='dropdown' >");}
	        	out.print("<a href='principal.jsp'>Inicio</a></li>"); %>
	          
	            <%if(User.getNombretipoUsuario().equals("Administrador")){ %>
	          <li  <% if(pageName.equals("centroFormacion_Buscar.jsp") || pageName.equals("usuarios_Buscar.jsp"))
	          { 
	            	System.out.println(pageName);
	            	out.println("class='active'");  
	            	}  
	          else{
	        	  out.println("class='dropdown'");
	        	  } %> 
	        	  >
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimientos <b class="caret"></b></a>
	            <ul class="dropdown-menu" >
	            
	          <!-- <li><a href="roles_buscar.jsp">Roles</a></li>
	              <li><a href="#">Productos</a></li>-->
	              
	            
	              <li><a href="centroFormacion_Buscar.jsp">Centro de Formacion</a></li>	      
	              <li><a id="lnkUsuario" href="usuarios_Buscar.jsp">Usuarios</a></li>
	             
	            </ul>
	          </li>
	           <%} %>
	           
	           
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Procesos <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	             
	            <%
	            if(User.getNombretipoUsuario().equals("Evaluador de Innovador")){
	            out.print("<li><a href='publicacion_Evaluar.jsp'>Evaluar Publicacion</a></li>");}
	            else if("a"=="b"){
	            out.print("<li><a id='lnkAsesoria' href='asesoria.jsp'>Asesorias</a></li>");}
	            else if("a"=="b"){
	            out.print("<li><a href='asesor_Asignar.jsp'>Asignar Asesor</a></li>");}
	            else if(User.getNombretipoUsuario().equals("Estudiante")){
	            	 out.print("<li><a href='Publicacion_CrearModificar.jsp'>Crear Publicación</a></li>");
	            	 out.print("<li><a href='publicacion_Buscar.jsp'>Buscar Publicación</a></li>");
	             } %>
	                                    
	            </ul>
	          </li>	  
	          
	          <%if(User.getNombretipoUsuario().equals("Evaluador de Innovador")){ %>        
	          <li <% if(pageName.equals("reporte_ideas.jsp"))
	          { 
	            	System.out.println(pageName);
	            	out.println("class='active'");  
	            	}  
	          else{
	        	  out.println("class='dropdown'");
	        	  } %>
	        	   ><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <% 
	              out.print("<li><a href='reporte_ideas.jsp'>Reporte de Ideas</a></li>");
	              %>
	             
	            </ul>
	          </li>     
	          <%} %>
	            
	            <%if(User.getNombretipoUsuario().equals("Administrador")){ %>
	            <li <% if(pageName.equals("calcular_pagos.jsp"))
	          { 
	            	System.out.println(pageName);
	            	out.println("class='active'");  
	            	}  
	          else{
	        	  out.println("class='dropdown'");
	        	  } %>
	        	  >
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cobranzas <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="calcular_pagos.jsp">Calcular Pagos</a></li>
	             
	            </ul>
	          </li>    
	          <%} %>
	          
	          <li><a href="LogoutServlet">Salir</a></li>
	          
	         
	        </ul>
	        
	        
	        
	        
	        
	        </div>
	         <div class="headerlogin">
	         <b> Nombre :</b> ${sessionScope.PERSONA_ACTUAL.nombreCompleto }  |    <b>Cargo :</b> ${sessionScope.USUARIO_ACTUAL.nombretipoUsuario } | <b>C. Formacion :</b> ${sessionScope.CENTRO_FORMACION.nombre }
	          </div>
	      </div><!--/.nav-collapse -->
	      
	    </div>
	  </div>
</body>
</html>