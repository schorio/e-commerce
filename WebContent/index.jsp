<%@page import="java.util.List"%>
<%@page import="cn.ecommerce.dao.ProduitDao"%>
<%@page import="cn.ecommerce.connection.DbCon"%>
<%@page import="cn.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");

	if(auth != null) {
		request.setAttribute("auth", auth);
	}

	ProduitDao dao_prd = new ProduitDao(DbCon.getConnection());
	List<Produit> produits = dao_prd.getAllProduit();
	
%>



<!DOCTYPE html>
<html>
<head>
	<title>Bienvenue dans la page d'accueil</title>
	<%@include file="includes/head.jsp" %>
</head>

<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container">
	
		<div class="card-header my-3">
			All Products
		</div>
		
		<div class="row">
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="product-image/female-shoes.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Female Shoes</h5>
						<h6 class="price">Price: 20$</h6>
						<h6 class="category">Category: Shoes</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="#">Add to Cart</a> <a
								class="btn btn-primary" href="#">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<%@include file="includes/footer.jsp" %>
</body>
</html>