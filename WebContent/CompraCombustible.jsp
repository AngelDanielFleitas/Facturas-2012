<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/styles.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<title>Confirmacion</title>
	<link rel="stylesheet" href="./js/development-bundle/themes/base/jquery.ui.all.css">
	<script src="./js/development-bundle/jquery-1.9.1.js"></script>
	<script src="./js/development-bundle/ui/jquery.ui.core.js"></script>
	<script src="./js/development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="./js/development-bundle/ui/jquery.ui.tabs.js"></script>
	<link rel="stylesheet" href="./js/development-bundle/demos/demos.css">
	<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	</script>
</head>
<body>
	<div >
			<div id="logo">	
				<h1>&nbsp;</h1>
				<a href="facturainicio.jsp"><small><img src="css/images/logo1.png" alt="" width="112" height="89" /></small></a>
			</div>
			<div id="wrap">
			<h1>&nbsp;</h1>
			<div id="menu">
					
					<ul>
						<li><a href="index.jsp" class="active">Inicio</a></li>
						<li><a href="Productos.html">Productos</a></li>
						<li><a href="login.html">Iniciar Sesi&oacute;n</a></li>
						<li><a href="Acerca.html">Acerca de </a></li>
						<li><a href="#">Contacto</a></li>						
					</ul>
						<div class="clear"></div>					
			</div>
			<br>	
			<div id="header2" align="center">
			<h2 style="color: #red">Fecha y hora:<%= new Date() %></h2><br>
		<div id="tabs" align="center">
					<ul>
						<li><h2><a href="#tabs-1">Por litro</a></h2></li>
						<li><h2><a href="#tabs-2">Por dinero</a></h2></li>
					</ul>
				<div id="tabs-1">
					<form name="ventalitro" align="center" action="ServletVentas" method="post">
						<table border="0">
                <tr>
                    <td><h2>Cantidad en litros: </h2> </td>
                    <td><input type="text" name="cantidadli" size="50" required></td>
                
                <tr>
                    <td><h2>Magna: </h2></td>
                    <td><input name="combustible" type="radio" value="MAGNA"/></td>
                </tr>
                <tr>
                    <td><h2>Premium: </h2></td>
                    <td><input name="combustible" type="radio" value="PREMIUM"/></td>
                </tr>
				<tr>
                    <td><h2>Diesel: </h2></td>
                    <td><input name="combustible" type="radio" value="DIESEL"/></td>
                </tr>
				<tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Aceptar">
                    </td>
                </tr>
          </table>
		  
					</form>
				</div>
				<div id="tabs-2" >
						<form name="ventadinero" align="center" action="ServletVentas" method="get">
						<table border="0">
                <tr>
                    <td><h2>Cantidad en pesos: </h2> </td>
                    <td><input type="text" name="cantidadpe" size="50" required></td>
                
                <tr>
                    <td><h2>Magna: </h2></td>
                    <td><input name="combustible" type="radio" value="MAGNA"/></td>
                </tr>
                <tr>
                    <td><h2>Premium: </h2></td>
                    <td><input name="combustible" type="radio" value="PREMIUM"/></td>
                </tr>
				<tr>
                    <td><h2>Diesel: </h2></td>
                    <td><input name="combustible" type="radio" value="DIESEL"/></td>
                </tr>
				<tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Aceptar">
                    </td>
                </tr>
          </table>
		  
					</form>
				</div>
												
		</div>

			</div>
			
			</div>
				
				
		
			</div>
		</div>
<div>					
	</div>	

	<footer>
	</footer>
</body>
</html>