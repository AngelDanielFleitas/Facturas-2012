<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/styles.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<title>Sistema de facturacion</title>
<%
	String numint= (String)session.getAttribute("numeroint");
	if(numint == null){
		numint = "";
	}
	%> 
</head>
<body>
	<div id="bg_black">
			<div id="logo">	
				<h1>&nbsp;</h1>
				<a href="facturainicio.jsp"><small><img src="css/images/logo1.png" alt="" width="112" height="89" /></small></a>
			</div>
			<div id="wrap" >
			<h1>&nbsp;</h1>
			<div id="menu">
					<div id="tabs">
					<ul>
						<li><a href="index.jsp" class="active">Inicio</a></li>
						<li><a href="Productos.html">Productos</a></li>
						<li><a href="login.html">Iniciar Sesi&oacute;n</a></li>
						<li><a href="Acerca.html">Acerca de </a></li>
						<li><a href="#">Contacto</a></li>						
					</ul>
						<div class="clear"></div>
					</div>
				</div>	
				<div id="header2" align="center"><br>
						<h1  style="color:red">FAVOR DE VERIFICAR SUS DATOS ANTES DE GENERAR SU FACTURA,<br><br> YA QUE NO ES POSIBLE REALIZAR CORRECCIONES</h1>


	<form method="post" action="ServletFactura" name="datosfactura">
		<table border="0">
                <tr>
                    <td><h2>RFC: </h2></td>
                    <td><input type="text" name="rfc" size="50" readonly value=<%= session.getAttribute("rfc")%>></td>
                </tr>
                <tr>
                    <td><h2>Razon Social: </h2></td>
                    <td><input type="text" name="rsocial" size="50" readonly value=<%= session.getAttribute("razon")%>></td>
                </tr>
                <tr>
                    <td><h2>Calle: </h2></td>
                    <td><input type="text" name="calle" size="50" value=<%= session.getAttribute("calle")%> style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                 <tr>
                    <td><h2>Numero Exterior: </h2></td>
                    <td><input type="text" name="numeroext" value=<%= session.getAttribute("numeroext")%> size="50" style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                <tr>
                    <td><h2>Numero Interior: </h2></td>
                    <td><input type="text" name="numeroint" size="50" value="<%= numint%>" style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();"></td>
                </tr>
                 <tr>
                    <td><h2>Colonia: </h2></td>
                    <td><input type="text" name="colonia" size="50" value=<%= session.getAttribute("colonia")%> style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                <tr>
                    <td><h2>Codigo Postal: </h2></td>
                    <td><input type="text" name="cp" size="50" value=<%= session.getAttribute("cp")%> style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                <tr>
                    <td><h2>Delegacion/Municipio: </h2></td>
                    <td><input type="text" name="municipio" size="50" value=<%= session.getAttribute("municipio")%> style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                <tr>
                    <td><h2>Estado: </h2></td>
                   <td><select name="estado" required>
		<option value="Aguascalientes">Aguascalientes</option>
		<option value="Baja California">Baja California</option>
		<option value="Baja California Sur">Baja California Sur</option>
		<option value="Campeche">Campeche</option>
		<option value="Chiapas">Chiapas</option>
		<option value="Chihuahua">Chihuahua</option>
		<option value="Coahuila de Zaragoza">Coahuila</option>
		<option value="Colima">Colima</option>
		<option value="Distrito Federal">Distrito Federal</option>
		<option value="Durango">Durango</option>
		<option value="Guanajuato">Guanajuato</option>
		<option value="Guerrero">Guerrero</option>
		<option value="Hidalgo">Hidalgo</option>
		<option value="Jalisco">Jalisco</option>
		<option value="Mexico">Mexico</option>
		<option value="Michoacan de Ocampo">Michoacan</option>
		<option value="Morelos">Morelos</option>
		<option value="Nayarit">Nayarit</option>
		<option value="Nuevo Leon">Nuevo Leon</option>
		<option value="Oaxaca">Oaxaca</option>
		<option value="Puebla">Puebla</option>
		<option value="Queretaro de Arteaga">Queretaro</option>
		<option value="Quintana Roo">Quintana Roo</option>
		<option value="San Luis Potosi">San Luis Potosi</option>
		<option value="Sinaloa">Sinaloa</option>
		<option value="Sonora">Sonora</option>
		<option value="Tabasco">Tabasco</option>
		<option value="Tamaulipas">Tamaulipas</option>
		<option value="Tlaxcala">Tlaxcala</option>
		<option value="Veracruz-Llave">Veracruz</option>
		<option value="Yucatan">Yucatan</option>
		<option value="Zacatecas">Zacatecas</option></td>
	</select>
                </tr>
                <tr>
                 <td><h2>Tipo de pago:</h2></td>
                 <td>
					<select name="tipopago" required>
					  <option value="efectivo">EFECTIVO</option>
					  <option value="cheque">CHEQUE</option>
					  <option value="vale">VALE</option>
					  <option value="tarjeta">TARJETA BANCARIA</option>
					</select>
				 </td>
                </tr>
                <tr>
                    <td><h2>Correo electronico: </h2></td>
                    <td><input type="email" name="correo" size="50" value=<%= session.getAttribute("correo")%> required></td>
                </tr>
                 <tr>
                    <td><h2>Codigo de compra </h2></td>
                    <td><input type="text" name="idcompra" size="50" style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Facturar">
                    </td>
                </tr>
          </table>
	</form>
				
				
		
			</div>
		</div>
<div>					
	</div>	

<footer>
	</footer>
</body>
</html>