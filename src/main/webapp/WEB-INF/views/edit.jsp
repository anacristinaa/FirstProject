<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap resources -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="bootstrap/css/bootstrap.min.js"></script>
<title>Edit Product</title>

</head>
<body
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="editpr">
		<center>
			<h1>&nbsp; &nbsp; &nbsp; Edit Product</h1>
			<c:if test="${not empty result}">
					<div class="error">${result}</div>
				</c:if>
			<br />
			<form:form action="saveProduct" method="post" modelAttribute="product">
			
                Id: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input
					type="text" name="product_id"  value="${product.product_id} " readonly>
				<br />
				<br />
         		Name: &nbsp; &nbsp;  &nbsp; &nbsp; <input type="text"
					name="name" value=" ${product.getName() }">
				<br />
				<br />
         		Description:  <input type="text" name="description"
					value=" ${product.getDescription() }">
				<br />
				<br />
         		Price: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="text"
					name="price" value=" ${product.getPrice() }">
				<br />
				<br />
				Id user: &nbsp; &nbsp; &nbsp; &nbsp; <input type="text"
					name="user_id" value=" ${product.getUser_id() }" readonly>
				<br />
				<br />

				<input type="submit" class="btn btn-default" value="Update" />
			</form:form>
		</center>
	</div>
</body>
</html>
