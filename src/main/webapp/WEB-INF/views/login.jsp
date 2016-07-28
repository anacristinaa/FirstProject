<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
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
<title>Spring Login</title>

</head>
<body onload='document.loginForm.username.focus();'
	background="<c:url value="https://shareonline.in/wp-content/uploads/2016/06/nature-flowers-nature-flowers-00397708-ozcqbX.jpg" />">

	<div class="log">
	
		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
				<center>
				<h1>&nbsp; &nbsp; Log in</h1>
				<c:if test="${not empty msg}">
				<div class="msg" style="color:white; font-size:111%">${msg}</div>
			</c:if>
			
			<c:if test="${not empty error}">
				<div class="error" style="color:red; font-size:111%">${error}</div>
			</c:if>
			
			<br /> <p style="font-size:130%;"> Username: <input type="text" name="userName">  
			<br /> <p style="font-size:130%;"> Password:  <input type="password" name="password"> 
			 <br />
				 <br />
			    <input type="submit" value="Login"
				class="btn btn-default btn-lg active" /> <br /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
			</center>
		</form>
		
	</div>
</body>
</html>
