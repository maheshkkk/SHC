<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTyPE>
<html>
<head><title>save Customer</title></head>

  <link  type="text/css" rel="stylesheet" 
     href="${pageContext.request.contextPath}/resources/css/style.css">
     
<link  type="text/css" rel="stylesheet" 
     href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
   <bodY>

  <div id="wrapper">
		    <div id="header">
			   <h2>CRM - Customer Relationship Manager</h2>
		     </div>
	     </div>
		
	     <div id="container">
	       <div id="content">
           <h2>Save Customer</h2>
      </div></div>
   <form:form  action="saveForm" modelAttribute="customer" method="POST">
         <table>
           <tbody>
            <tr><form:hidden path="id"/>
                   <td> <label>First Name:</label></td>
                   <td><form:input path="firstname"/></td>
           </tr>
           <tr>
                <td>  <label>Last Name:</label></td>
               <td><form:input path="lastname"/></td>
          </tr>
          <tr>
                <td> <label>Email</label></td>
                <td><form:input path="email"/></td>
          </tr>
           <tr>
               <td><label></label></td>
               <td><input type="submit" value="Save" class="save"></td>
          </tr>
           </tbody>      
       </table>
       <div style="clear;boht;"></div>
       <p>
       <a href="${pageContext.request.contextPath}/customer/list">Back TO List</a></p>
   </form:form>
</body>

</html>