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
        
 <jsp:include page="header.jsp" />
      
	 <div class="container">
	 
<script>
function selectInCombo(combo,val)
{
    for(var indice=0 ;indice<document.getElementById(combo).length;indice++)
    {
        if (document.getElementById(combo).options[indice].text==val )
            document.getElementById(combo).selectedIndex =indice;
    }       
}
</script>


<p><strong>Mantenimiento de Centro de Formaciones &gt; Editar</strong></p>

<form id="form1" name="form1" method="post" action="CentroFormacionModificarServlet">
<%@page import="upc.modelo.CentroFormacion;"%>
<%
CentroFormacion cf = (CentroFormacion)request.getAttribute("CentroFormacion");
String msj = (String)request.getAttribute("MENSAJE");

if(msj==null)
{
	msj="";
}

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
        <select name="tipo" id="tipo">
		    <option value="10">Universidad</option>
		    <option value="11">Instituto</option>
		</select>
		<script>selectInCombo('tipo','<%=cf.getStrTipo() %>')</script>
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
        <input type="button" value="Regresar" onclick="window.location='centroFormacion_Buscar.jsp' " />
	  </td>
    </tr>
  </table>  
  <p>&nbsp;</p>
  <span style="color: red;"><%=msj %></span>
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