<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE>
<html>
<head><title>list Customer</title>
<!--  add the stylesheet page -->
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>
        <div id="wrapper">
		    <div id="header">
			   <h2>CRM - Customer Relationship Manager</h2>
		     </div>
	     </div>
		
	     <div id="container">
	       <div id="content">
	       <input type="button" value="Add Customer"
	        onclick="window.location.href='showFormForAdd';return false;" 
	        class="add-button" />
	     <table>
				<tr>
					 <th>First Name</th>
					 <th>Last Name</th>
					 <th>Email</th>
					 <th>Action</th>
				</tr>
		
	           <c:forEach var="tempCustomer" items="${Customer}">
	           <c:url var="UpdateLink" value="showFromForUpdate"> 
	           <c:param name="customerId"  value="${tempCustomer.id}" >Update</c:param>
	           </c:url>
	           
	           <c:url var="DeleteLink" value="DeleteFrom"> 
	           <c:param name="customerId"  value="${tempCustomer.id}"
	                >Detele</c:param>
	           </c:url>
	
	            <tr>
					<td> ${tempCustomer.firstname} </td>
					<td> ${tempCustomer.lastname} </td>
					<td> ${tempCustomer.email} </td>
					<td><a href="${UpdateLink}">Update</a>
					 <a href="${DeleteLink}" onclick="if(!(confirm('Are sure  want Delete this customer?')))return false">Delete</a></td>
				    </tr>
				</c:forEach>	
		</table> 	
		</div></div>
		
</body>
</html>