<%@page import="cn.ecommerce.connection.DbCon"%>
<%@page import="cn.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");

	if(auth != null) {
		request.setAttribute("auth", auth);
	}
%>


<!DOCTYPE html>
<html>
<head>
	<title>Cart Page</title>
	<%@include file="includes/head.jsp" %>
	
	<style type="text/css">
		.table tbody td{
		vertical-align: middle;
		}
		.btn-incre, .btn-decre{
		box-shadow: none;
		font-size: 25px;
		}
	</style>
</head>

<body>
	<%@include file="/includes/navbar.jsp"%>
	
	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $220 </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>Men Watch</td>
					<td>Watch</td>
					<td>20$</td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="#" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="5" readonly> 
								<a class="btn btn-sm btn-decre" href="#"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
				<tr>
					<td>Ladis Bag<</td>
					<td>Bag</td>
					<td>40$</td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="#" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="3" readonly> 
								<a class="btn btn-sm btn-decre" href="#"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

			</tbody>
		</table>
	</div>

	<%@include file="includes/footer.jsp" %>
</body>
</html>