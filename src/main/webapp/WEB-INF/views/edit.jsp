<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap resources -->
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">

<title>Edit Product</title>

</head>
<body
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="editpr">

			<h1>&nbsp; &nbsp; &nbsp; Edit Product</h1>
			<c:if test="${not empty result}">
					<div class="error">${result}</div>
				</c:if>
			<br />
			<form:form action="saveProduct" method="post" modelAttribute="productDTO">
			
                Id: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input
					type="text" name="product_id"  value="${productDTO.getProduct_id()} " readonly>
				<br />
				<br />
         		Name: &nbsp; &nbsp;  &nbsp; &nbsp; <input type="text"
					name="name" value=" ${productDTO.getName() }">
				<br />
				<br />
         		Description:  <input type="text" name="description"
					value=" ${productDTO.getDescription() }">
				<br />
				<br />
         		Price: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="number"
					name="price" value=" ${productDTO.getPrice() }">
				<br />
				<br />
				<%-- Id user: &nbsp; &nbsp; &nbsp; &nbsp; <input type="text"
					name="user_id" value=" ${product.getUser().getUser_id()}" readonly>
				<br />
				<br /> --%>

				<input type="submit" class="btn btn-default" value="Update" />
			</form:form>

	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</html>
