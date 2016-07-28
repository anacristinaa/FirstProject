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
<title>Register page</title>
</head>
<body
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="reguser">
	<center>
		<h1>&nbsp; &nbsp; Register</h1>
		<form:form action="register" method="post" modelAttribute="user">

			<br />
         	<p style="font-size:130%;">	Name: &nbsp;  &nbsp;  &nbsp; <input type="text" name="username">
			<br />
         	<p style="font-size:130%;">	Password:  <input type="password" name="password">
			<br />
			<br />
			<input type="submit" class="btn btn-default btn-lg active" value="Register" />
			<br />

		</form:form>
		</center>
	</div>
</body>
</html>