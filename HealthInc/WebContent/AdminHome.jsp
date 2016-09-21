<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>

<style>
a:link, a:visited {
    background-color: white;
    color: black;
    padding: 15px 15px;
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
<div class="content" style="padding-left:20%; padding-right:20%; padding-top:1%; padding-bottom:1%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">
<table>
<tr >
<td colspan="3"><h2><strong>Approval Operations</strong></h2></td>
</tr>
<tr>

<td><a href="/HealthInc/AdminController?source=employeeApproval">Employee Approvals</a></td>
<td><a href="/HealthInc/AdminController?source=DependentApproval">Dependent Approvals</a></td>
</tr>
<tr >
<td colspan="3"><h2><strong>Hospital Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/AdminController?source=addHospital">Add Hospital</a></td>
<td colspan="3"><a href="/HealthInc/AdminController?source=viewHospital">View Hospital</a></td>
</tr>
<tr >
<td colspan="3"><h2><strong>Employee Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/AdminController?source=registration">Add Employee</a></td>
<td><a href="/HealthInc/AdminController?source=employeeUpdate">Update Employee</a></td>
<td><a href="/HealthInc/AdminController?source=deleteEmployee">Delete Employee</a></td>
</tr>
<tr >
<td colspan="3"><h2><strong>Dependent Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/AdminController?source=AdminAddDependent">Add Dependent</a></td>
<td colspan="2"><a href="/HealthInc/AdminController?source=AdminDependents">View Dependents</a></td>
</tr>
</table></fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>