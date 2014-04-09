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
	          <li <%
	          if(pageName.equals("principal.jsp") || pageName.equals("roles_buscar.jsp"))
	          {  out.println("class='active'");  }  
	          else{out.println("class='dropdown'");}%>>
	          <a href="principal.jsp">Inicio</a></li>
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
	              <li><a href="asesor_Asignar.jsp">Asignar Asesor</a></li>	                      
	            </ul>
	          </li>	          
	          <li <% if(pageName.equals("reporte_ideas.jsp"))
	          { 
	            	System.out.println(pageName);
	            	out.println("class='active'");  
	            	}  
	          else{
	        	  out.println("class='dropdown'");
	        	  } %>
	        	   >
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="reporte_ideas.jsp">Reporte de Ideas</a></li>
	             
	            </ul>
	          </li>     
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
	          <li><a href="LogoutServlet">Salir</a></li>
	          
	         
	        </ul>
	        
	        
	        
	        
	        
	        </div>
	         <div class="headerlogin">
	         <b> Nombre :</b> ${sessionScope.PERSONA_ACTUAL.nombreCompleto } &nbsp;&nbsp; | &nbsp;&nbsp;   <b>Cargo :</b> ${sessionScope.USUARIO_ACTUAL.nombretipoUsuario }
	          </div>
	      </div><!--/.nav-collapse -->
	      
	    </div>
	  </div>
</body>
</html>