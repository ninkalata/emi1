<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<title>EMI CALCULATOR</title>
 
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<div id="nav-placeholder">

</div>
<script src="simple-slider.js"></script>
<link href="simple-slider.css" rel="stylesheet" type="text/css" />

<script>
$(function(){
  $("#nav-placeholder").load("page.jsp");
});
</script>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
		</div>
	</div>

	<div id="container">
		<h3 >EMI Calculator</h3>
	<small>Nucleus bank</small>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
									
			<table>
				<tbody>
					<tr>
					
						<td><label>Loan Amount:</label></td>
						<td><form:input path="loanAmount" /></td>
					</tr>
					<tr>
						<td><label>Rate of Interest</label></font></td>
						<td><form:input path="rateofInterest" pattern="[a-zA-Z0-9 ]+"
								title="invalid name" /></td>
					</tr>
						<tr>
						<td><font color="blue"><label>Customer Address:</label></font></td>
						<td><form:input path="CustomerAddress" /></td>
					</tr>
<tr>
						<td><font color="blue"><label>Customer Pin Code:</label></font></td>
						<td><form:input path="CustomerPinCode" pattern=".{6}"
								title="Pin code should be 6 digits"/></td>
					</tr>

<tr>
						<td><font color="blue"><label>Customer Email:</label></font></td>
						<td><form:input path="CustomerEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
								title="Invalid Email format" /></td>
					</tr>
					<tr>
						<td><font color="blue"><label> Contact Number:</label></font></td>
						<td><form:input path="ContactNumber" /></td>
					</tr>
					
					
<tr>
						<td><font color="blue"><label>Registration Date:</label></font></td>
						<td><form:input path="RegistrationDate" pattern="^([0-2]?\d|3[0-1])-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-\d{4}"
							title="invalid date"/></td>
					</tr>
					<tr>
						<td><font color="blue"><label>Created By:</label></font></td>
						<td><form:input path="CreatedBy" /></td>
					</tr>
					<tr>
						<td><font color="blue"><label>Modified Date:</label></font></td>
						<td><form:input path="ModifiedDate" pattern="^([0-2]?\d|3[0-1])-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-\d{4}"
							title="invalid date" /></td>
					</tr>
					
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
						

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>



