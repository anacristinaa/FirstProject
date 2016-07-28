
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- bootstrap resources -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="bootstrap/css/bootstrap.min.js"></script>
<title>Success</title>

</head>
<body
	background="<c:url value="https://s-media-cache-ak0.pinimg.com/originals/b6/4b/c9/b64bc9cff23c1adc1771f3b3d7601506.jpg" />">


	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<center>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				(: Welcome : ${pageContext.request.userPrincipal.name} | ${role } | <a
					href="javascript:document.getElementById('logout').submit()"  style="color:white">
					Logout</a>
			</h2>
		</c:if>
		
	</center>
	<a href="success/addProduct" style="font-size:140%; color:black" >  Add Product </a>
	
	<br />
	<br />
	<table class="table table-inverse" style="font-size:140%;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>CRUD</th>
		</tr>
		<c:forEach var="prod" items="${products}">
			<tr>
				<td><c:out value="${prod.getProduct_id() }" />
					<p></td>
				<td><c:out value="${prod.getName() }" />
					<p></td>
				<td><c:out value="${prod.getDescription() }" />
					<p></td>
				<td><c:out value="${prod.getPrice() }" />
					<p></td>
				<td>
				<c:if test ="${prod.getUser_id() == user_id }">
				<a href="success/edit/${prod.product_id}" style="color:white">Edit</a> &nbsp; | &nbsp;
					<a href="success/${prod.product_id}"  style="color:black"> Delete </a> </c:if> </td>
			</tr>
		</c:forEach>
	</table>
	
	<p style="font-size:130%;"> Last action: ${lastaction} </p>
	<p style="font-size:130%;"> Table row number: ${listsize} </p>

</body>
</html>
