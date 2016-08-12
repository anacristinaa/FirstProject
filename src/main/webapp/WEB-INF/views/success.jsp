<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- bootstrap resources -->
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet">

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
				(: Welcome : ${pageContext.request.userPrincipal.name} | ${role } |
				<a href="javascript:document.getElementById('logout').submit()"
					style="color: white"> Logout</a>
			</h2>
		</c:if>

	</center>
	<a href="success/addProduct" style="font-size: 140%; color: black">
		Add Product </a>

	<br />
	<br />
	<table class="table table-hover" style="font-size: 140%;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>CRUD</th>
		</tr>
		<c:forEach var="prod" items="${products}">

			<tr>
				<td><c:out value="${prod.getProduct_id() }" /> <input
					type="hidden" id="prodId" value="${prod.getProduct_id() }"/>
					<p></td>
				<td><c:out value="${prod.getName()}" />
				<input type="hidden" id="nameProd" value="${prod.getName()}"/>
					<p></td>
				<td><c:out value="${prod.getDescription()}" />
				<input type="hidden" id="descrProd" value="${prod.getDescription()}" />
					<p></td>
				<td><c:out value="${prod.getPrice()}" />
				<input type="hidden" id="priceProd" value="${prod.getPrice()}"/>
					<p></td>
				<td>
				<a  id="editBtn" onclick="editFunction()" style="color: #4562d3">Edit</a>
				 &nbsp; | &nbsp; 
					<a id="myBtn" style="color: black">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<p style="font-size: 130%;">Last action: ${lastaction}</p>
	<p style="font-size: 130%;">Table row number: ${listsize}</p>

	<!-- Delete Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">×</span>
			<p style="font-size: 140%;">Sure you want to delete this product?</p>
			<a id="del" onclick="deleteFunction()">Yes</a> &nbsp; &nbsp; <a
				class="cancel"> Cancel</a>
		</div>

	</div>


	<!-- Trigger/Open The Modal -->
	<button id="editBtn" onclick="editFunction()" >Edit</button>

	<!-- The Edit Modal -->
	<div id="editModal" class="clsmodal">

		<!-- Modal content -->
		<div class="emodal-content">
			<div class="emodal-header">
				<span class="closee">×</span>
				<h2>Edit Product</h2>
			</div>
			<div class="emodal-body">
				<form:form action="saveProduct" method="post" modelAttribute="productDTO">
			
                Id: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                <input type="text" id="idP" name="product_id" readonly>
				<br />
				<br />
         		Name: &nbsp; &nbsp;  &nbsp; &nbsp; 
         		<input type="text" id="nameP" name="name">
				<br />
				<br />
         		Description:  <input type="text" id="descrP" name="description">
				<br />
				<br />
         		Price: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
         		<input type="text" id="priceP" name="price" >
				<br />
				<br />
				<a id="saveProd" >Update</a>
				<!-- <input type="submit" class="btn btn-default" value="Update" /> -->
			</form:form>
			</div>
			<div class="emodal-footer">
				
			</div>
		</div>

	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="javascript/main.js"></script>
	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		var span1 = document.getElementsByClassName("cancel")[0];

		// When the user clicks the button, open the modal
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks on <span> (cancel), close the modal
		span1.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		
		// Get the modal
		var modall = document.getElementById('editModal');

		// Get the button that opens the modal
		var ebtn = document.getElementById("editBtn");

		// Get the <span> element that closes the modal
		var spanEdit = document.getElementsByClassName("closee")[0];

		// When the user clicks the button, open the modal
		ebtn.onclick = function() {
		    modall.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		spanEdit.onclick = function() {
		    modall.style.display = "none";
		}
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modall) {
		        modall.style.display = "none";
		    }
		}

		var productsList = new Array();

		<c:forEach items ="${products}" var="prod" varStatus="index">
		productsList[<c:out value="${index.count -1 }"/>] = {
			'product_id' : '<c:out value = "${prod.product_id }"/>',
			'name' : '<c:out value = "${prod.name }"/>',
			'description' : '<c:out value = "${prod.description }"/>',
			'price' : '<c:out value = "${ prod.price}"/>',
		};
		</c:forEach>

		function deleteFunction() {
			var product_id = document.getElementById("prodId").value; 
			document.getElementById("del").href = " success/" + product_id;
		}
		
		function editFunction(){
			
			document.getElementById("idP").value = document.getElementById("prodId").value;
			document.getElementById("nameP").value = document.getElementById("nameProd").value;
			document.getElementById("descrP").value = document.getElementById("descrProd").value;
			document.getElementById("priceP").value = document.getElementById("priceProd").value;
			
		}
		
	</script>

</body>


</html>
