<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de facturacion</title>
</head>
<body>
<h1>Bienvenido al sistema de facturacion</h1>
<form method="post" action="ServletInicio" name ="inicioFactura" >
	<table border="0">
                <tr>
                    <td>RFC: </td>
                    <td><input type="text" name="rfc" size="50" style="text-transform:uppercase;" on keyup="javascript:this.value=this.value.toUpperCase();"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Iniciar Facturacion">
                    </td>
                </tr>
          </table>
</form>
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