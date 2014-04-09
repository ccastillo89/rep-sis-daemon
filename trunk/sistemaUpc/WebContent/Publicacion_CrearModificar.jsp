<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
  </head>
<body>
<p><strong>Registro Y Modificacion de Ideas</strong></p>
<form id="form1" name="form1" method="post" action="PublicacionCrearServlet" class="form-horizontal" role="form" >

  <fieldset>
    <legend>Datos de la Idea</legend>
    <p>
    <input type="radio"  name="Tipo" value="modificar">Nuevo 
	<input type="radio"  name="Tipo" value="modificar">Modificar <br>
    Titulo: <input type="text" name="titulo" id="titulo" style="width: 285px; "/> 
    <input type="submit" value="Buscar"> &nbsp;&nbsp;* <br>
    Descripción: <input type="text" name="descripcion" id="descripcion" style="width: 406px; "/>&nbsp;&nbsp;* <br>
    </p>
    </fieldset>
    <br>
    <fieldset>
    <legend>Palabras Clave:</legend>
    <p>
    Palabra 1: <input type="text"> &nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;Palabra 2: <input type="text"> &nbsp;&nbsp; * <br>
    Palabra 3: <input type="text"> &nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;Palabra 4: <input type="text"> &nbsp;&nbsp; * <br>
     </p>
     </fieldset>
    <br>
     <fieldset>
    <legend> </legend>
     <p>
	<input type="checkbox" name="achivo" value="archivo">Subir Archivo<br>
	 Examinar: <input type="text"> <input type="submit" value="ver" /> <br>
	  </p>
     </fieldset>
    
     <p><strong>* Campos Obligatorios</strong></p>
    <input type="submit" value="Guardar" />
    <input type="button" value="Regresar" onclick="window.location='roles_buscar.jsp' " />
    
</form>


</body>
</html>