<%@page import="cn.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");

	if(auth != null) {
		response.sendRedirect("index.jsp");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Shopping Cart Login</title>
	<%@include file="includes/head.jsp" %>
</head>
<body>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center"> User Login</div>
			<div class="card-body">
				<form action="ut-login" method="post">
					<div class="form-group">
						<label>Adresse Email</label>
						<input type="email" class="form-control" name="login-email" placeholder="Entrer votre adresse email" required>
					</div>
					<div class="form-group">
						<label>Mot de passe</label>
						<input type="password" class="form-control" name="login-password" placeholder="Entrer votre mot de passe" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>