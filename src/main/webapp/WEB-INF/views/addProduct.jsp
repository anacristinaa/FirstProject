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

<title>Add Product to DB</title>

</head>
<body
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="addpr">
	
		<h1>&nbsp; &nbsp; &nbsp; Add Product</h1>
		<form:form action="addProduct" method="post" modelAttribute="productDTO">

			<br />
         	<p style="font-size:130%;">	Name:  &nbsp;  &nbsp;  &nbsp;  &nbsp; <input type="text" name="name" required>
			<br />
         	<p style="font-size:130%;">	Description: <input type="text" name="description" required>
			<br />
         	<p style="font-size:130%;">	Price:  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp; <input type="number" name="price" required>
			<br />
			<br />
			&nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp; <input type="submit" class="btn btn-default btn-lg active" value="Save" />
			<br />

		</form:form>

	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</html>
