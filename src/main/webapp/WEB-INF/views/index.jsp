
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
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
<title>Index</title>

</head>
<body
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="homee">
		<h2>
			<%
				out.println("Hello!! :)");
			%>
		</h2>
		<br />
		<div class="btn-group">
			<a href="login"><button type="button"
					class="btn btn-default btn-lg active">Login</button> </a>
			<a href="register"><button type="button"
					class="btn btn-default btn-lg active">Register</button> </a>
		</div>

	</div>

</body>
</html>


