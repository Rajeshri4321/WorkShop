<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class = "container">
		
		<h1>Product</h1>
		<hr/>
		
	<form action="${pageContext.request.contextPath}/AddProductController" method="post"> 
	   <table>
	<tr><td>Product Id:</td><td><input type="number" name="id" required></td></tr>
	<tr><td>Product Name:</td><td><input type="text" name="name" required></td></tr>
    <tr><td>Product Price:</td><td>	<input type="number" name="price" required></td></tr>
		
		</table><br>
		<button  type="submit" >Add Product</button></form>
	
	<br><br><HR>
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Update/Delete</th>
			</tr>
			
			<c:forEach items="${productList}" var="product">
			
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/EditProductServlet?action=EDIT&id=${product.id}&name=${product.name}&price=${product.price}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/deleteProduct?action=DELETE&id=${product.id}">Delete</a> 
					</td>
				</tr>
			
			</c:forEach>
			
			
		</table>
		
	</div>
	
	
		
	
		
	

	
</body>
</html>