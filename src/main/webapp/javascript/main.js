/**
 * 
 */
	var productsList = new Array();
	
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
			
		//lista
	/*	<c:forEach items ="${products}" var="prod" varStatus="index">
		productsList[<c:out value="${index.count -1 }" />] = {
			'product_id' : '<c:out value = "${prod.product_id }"/>',
			'name' : '<c:out value = "${prod.name }"/>',
			'description' : '<c:out value = "${prod.description }"/>',
			'price' : '<c:out value = "${ prod.price}"/>',
		};
		</c:forEach>*/
		
		function deleteFunction() {
			var product_id = document.getElementById("prodId").value;	
			// document.getElementById("del").action = "success/{" + product_id +"}"; 
			 document.getElementById("del").href =  " success/"+ product_id;
		}