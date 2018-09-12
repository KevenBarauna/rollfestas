<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/style.css">

<title>Home</title>
</head>
<body>



<%
	String usuario = (String)session.getAttribute("usuario");
if(usuario == null){
	response.sendRedirect("Login.jsp");
}else{
	out.print("<center>Bem Vindo, " +usuario+ "<center/><br/>");
}


%>

	<h1>Usuário Logado</h1>
	<form action="Deslogar.jsp">
	<button type="submit">Deslogar</button>
	</form>
	
</body>
</html>