<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Flat HTML5/CSS3 Login Form</title>

<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="nome"/>
      <input type="password" placeholder="senha"/>
      <input type="text" placeholder="e-mail"/>
      <button>Criar</button>
      <p class="message">Já Possui uma conta? <a href="#">Login</a></p>
    </form>
    <form action="index.jsp" class="login-form" method="post" >
      <input type="text" name="usuario" placeholder="usuário"/>
      <input type="password" name="senha" placeholder="senha"/>
      <button type="submit">Login</button>
      <p class="message">Ainda não é cadastrado? <a href="#">Criar uma Conta</a></p>
    </form>
    
    
  </div>
</div>

<%
String usuario = request.getParameter("usuario");
String senha = request.getParameter("senha");

if(usuario != null && senha != null && !usuario.isEmpty() && !senha.isEmpty()){
	session.setAttribute("usuario", usuario);
	response.sendRedirect("DadosPessoais.jsp");
}
%>


  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


</body>
</html>