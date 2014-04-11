<!DOCTYPE html>
<%@page import="upc.negocio.GestionCodigos"%>
<%@page import="upc.modelo.Codigo"%>
<%@page import="java.util.Collection"%>
<%@page import="upc.negocio.GestionCentroFormacion"%>
<%@page import="upc.modelo.CentroFormacion"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

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

<script type="text/javascript">


	function isNumberKey(evt)
	{
	 var charCode = (evt.which) ? evt.which : event.keyCode
	 if (charCode > 31 && (charCode < 48 || charCode > 57))
	    return false;
		
	 return true;
	}

	function validarCampos() {

		var txtNombres = $("#txtNombres").val();
		var txtApePaterno = $("#txtApePaterno").val();
		var txtApeMaterno = $("#txtApeMaterno").val();
		var ddlSexo = $("#ddlSexo").val();
		var ddlTipo = $("#ddlTipo").val();
		var txtNroDocumento = $("#txtNroDocumento").val();
		var txtCelular = $("#txtCelular").val();
		var txtEmail = $("#txtEmail").val();
		var txtContrasena = $("#txtContrasena").val();
		var txtContrasenaConfir = $("#txtContrasenaConfir").val();
		var ddlCentro = $("#ddlCentro").val();
		var ddlRol = $("#ddlRol").val();

		if (txtNombres == "") {
			alert("Ingrese nombre");
		} else if (txtApePaterno == "") {
			alert("Ingrese apellido paterno");
		} else if (txtApeMaterno == "") {
			alert("Ingrese apellido materno");
		} else if (txtApePaterno == "") {
			alert("Ingrese apellido paterno");
		} else if (ddlSexo == "0") {
			alert("Seleccione sexo");
		} else if (ddlTipo == "0") {
			alert("Seleccione tipo de documento");
		} else if (txtNroDocumento == "") {
			alert("Ingrese número de documento");
		} else if (txtCelular == "") {
			alert("Ingrese celular");
		} else if (txtEmail == "") {
			alert("Ingrese e-mail");
		} else if (txtContrasena == "") {
			alert("Ingrese contraseña");
		} else if (txtContrasenaConfir == "") {
			alert("Ingrese confirmación de contraseña");
		} else if (ddlCentro == "0") {
			alert("Seleccione centro de formación}");
		} else if (ddlRol == "0") {
			alert("Seleccione rol");
		} else {
			if (txtContrasena != txtContrasenaConfir) {
				alert("Las contraseñas ingresadas no coinciden. Verifique.");
			} else {
				document.form.submit();
				return true;
			}

		}
	}
</script>
</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="container">

		<p>
			<strong>Mantenimiento de Usuarios &gt; Nuevo</strong>
		</p>

		<form id="form1" name="form1" method="post"
			action="UsuarioInsertarServlet" class="form-horizontal" role="form">
			<table width="420" height="330" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td>Nombres:</td>
					<td><label> <input type="text" name="txtNombres"
							id="txtNombres" maxlength="50"/>
					</label></td>
				</tr>
				<tr>
					<td>Apellido Paterno:</td>
					<td><label> <input type="text" name="txtApePaterno"
							id="txtApePaterno" maxlength="50"/>
					</label></td>
				</tr>
				<tr>
					<td>Apellido Materno:</td>
					<td><label> <input type="text" name="txtApeMaterno"
							id="txtApeMaterno" maxlength="45"/>
					</label></td>
				</tr>
				<tr>
					<td>Sexo:</td>
					<td><label> <select name="ddlSexo" id="ddlSexo"
							style="width: 120px;">
									<option value="0">Seleccionar</option>
								<%
									GestionCodigos negocioSexo = new GestionCodigos();
									Codigo codesSexo = new Codigo();
									codesSexo.setIdGrupo(5);
									Collection<Codigo> codigosSexo = negocioSexo
											.ListarCodigosPorIdGrupo(codesSexo);
									if (codigosSexo != null)
										for (Codigo c : codigosSexo) {
								%>
								<option value="<%=c.getIdCodigo()%>"><%=c.getDescripcionCodigo()%></option>
								<%
									}
								%>

						</select>
					</label></td>
				</tr>
				<tr>
					<td>Tipo Documento:</td>
					<td><label> <select name="ddlTipo" id="ddlTipo"
							style="width: 120px;">
								<option value="0">Seleccionar</option>
								<%
									GestionCodigos negocioTipo = new GestionCodigos();
									Codigo codesTipo = new Codigo();
									codesTipo.setIdGrupo(4);
									Collection<Codigo> codigosTipos = negocioTipo
											.ListarCodigosPorIdGrupo(codesTipo);
									if (codigosTipos != null)
										for (Codigo c : codigosTipos) {
								%>
								<option value="<%=c.getIdCodigo()%>"><%=c.getDescripcionCodigo()%></option>
								<%
									}
								%>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>Nro Documento:</td>
					<td><label> <input type="text" name="txtNroDocumento"
							id="txtNroDocumento" onkeypress="return isNumberKey(this);" maxlength="15"/>
					</label></td>
				</tr>
				<tr>
					<td>Celular:</td>
					<td><label> <input type="text" name="txtCelular"
							id="txtCelular" onkeypress="return isNumberKey(this);" maxlength="12"/>
					</label></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><label> <input type="text" name="txtEmail"
							id="txtEmail" maxlength="100" />
					</label></td>
				</tr>
				<tr>
					<td>Contrase&ntilde;a:</td>
					<td><label> <input type="password" name="txtContrasena"
							id="txtContrasena" maxlength="100"/>
					</label></td>
				</tr>
				<tr>
					<td>Confirmar Contrase&ntilde;a:</td>
					<td><label> <input type="password"
							name="txtContrasenaConfir" id="txtContrasenaConfir" maxlength="100" />
					</label></td>
				</tr>
				<tr>
					<td>Centro Formaci&oacute;n:</td>
					<td><label> <select name="ddlCentro" id="ddlCentro"
							style="width: 120px;">
								<option value="0">Seleccionar</option>
								<%
									GestionCentroFormacion negocio = new GestionCentroFormacion();
									CentroFormacion ci = new CentroFormacion();
									ci.setNombre("");
									Collection<CentroFormacion> cf = negocio.listar(ci);
									if (cf != null)
										for (CentroFormacion c : cf) {
								%>
								<option value="<%=c.getIdCentroInformacion()%>"><%=c.getNombre()%></option>
								<%
									}
								%>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>Rol:</td>
					<td><label> <select name="ddlRol" id="ddlRol"
							style="width: 120px;">
								<option value="0">Seleccionar</option>
								<%
									GestionCodigos negocioRol = new GestionCodigos();
									Codigo codesRol = new Codigo();
									codesRol.setIdGrupo(1);
									Collection<Codigo> codigosRoles = negocioRol
											.ListarCodigosPorIdGrupo(codesRol);
									if (codigosRoles != null)
										for (Codigo c : codigosRoles) {
								%>
								<option value="<%=c.getIdCodigo()%>"><%=c.getDescripcionCodigo()%></option>
								<%
									}
								%>
						</select>
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Guardar"
						onclick="validarCampos(); return false" /> <input type="button"
						value="Regresar" onclick="window.location='usuarios_Buscar.jsp' " /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
		</form>
		
		<div style="color: red; text-align: left;">
			<p> ${message}</p>
			<c:remove var="message" scope="session" /> 
		</div>
		
		<!-- Site footer -->
		<div class="footer">
			<p>&nbsp;</p>
			<p>&copy; DAEMON 2014</p>
		</div>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.10.2.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap-3.1.1.js"></script>
</body>
</html>