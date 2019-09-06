<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/styles.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<title>Sistema de facturacion</title>
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
				<div id="header" >
					<div id="wrapper" >
						<div id="slider-wrapper" >
						<div>
							<div id="slider" class="nivoSlider" >
							
								<img src="css/images/header.jpg" alt=""/>								
								<img src="css/images/header2.jpg" alt="" />
								<img src="css/images/header3.jpg" alt="" />
								<img src="css/images/header4.jpg" alt="" />								
							</div>
						</div>
					</div>		
					
					<div class="ic"></div>
					<script type="text/javascript" src="css/lib/jquery-1.4.3.min.js"></script>
					<script type="text/javascript" src="css/lib/jquery.nivo.slider.pack.js"></script>
					<script type="text/javascript">
					$(window).load(function() {
						$('#slider').nivoSlider();
					});
					</script>
				</div>
				
				
		
			</div>
		</div>
<div>					
	</div>	

<footer>
<%
	String msg = (String)session.getAttribute("msg");
	if(msg == null){
		msg = " ";
	}
	%> 
	<%= msg%>
	</footer>
</body>
</html>