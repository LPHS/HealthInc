<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function myFunction() {
    confirm("Confirm delete");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>

<style>
a:link, a:visited {
    background-color: white;
    color: black;
    padding: 6px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: skyblue;
    color: white;
}

body{
	background-image:url("wood.jpg")

}
</style>


<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
<div class="content" style="padding-left:20%; padding-right:20%; padding-top:7%; padding-bottom:7%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">

<h2><strong><center>Delete Profile of User</center></strong></h2><hr>


<%Object o=request.getAttribute("emp");
EmployeeBean emp=null;
	if(o!=null){
		emp=(EmployeeBean)o;
	} %>

<form action="/HealthInc/MasterController" method="post" name="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><%=emp.getEmp_name() %></td>
			</tr>
			<tr>
				<td>Employee Id</td>
				<td><%=emp.getEmp_id() %></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><%=emp.getEmp_dob() %></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=emp.getEmp_email() %></td>
			</tr>
			<tr>
				<td>Alternate Email</td>
				<td><%=emp.getEmp_alt_email() %></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><%=emp.getEmp_ph_no() %></td>
			</tr>
			<tr>
				<td>Alternate Mobile No.</td>
				<td><%=emp.getEmp_mob_no()%></td>
			</tr>
			<tr>
			<td>Total Sum Insured</td> 
			<td><%=emp.getEmp_tot_sum_ins()%></td>
			</tr>
			
			<tr><td>Bank Account No.</td>
				<td><%=emp.getEmp_acc_no() %>
				</td>
			</tr>
			<tr>
				<td>Name of the Bank</td>
				<td><%=emp.getEmp_bnk_name() %>
				</td>
			</tr>
			<tr>
				<td>IFSC Code</td>
				<td><%=emp.getEmp_bnk_ifsc() %></td>
			</tr>
			<tr>
			<td><input type="submit" name="source" value="delete" onclick="myFunction()"></td>
			
		</table><br>
		<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
</form>
</fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>	
</body>
</html>
