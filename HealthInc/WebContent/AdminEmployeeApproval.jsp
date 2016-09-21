<%@page import="bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Approval</title>
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
	<h2><strong><center>Employee Approval</center></strong></h2><hr>
	<table>
		<tr>
			<th>Employee Id</th>
			<th>Employee Hid</th>
			<th>Employee Name</th>
			<th>Employee Email</th>
			<th>Employee Mobile No</th>
			<th>&nbsp;</th>
		</tr>
		<%
			ArrayList<EmployeeBean> empList = (ArrayList<EmployeeBean>) request.getAttribute("empList");
			for (EmployeeBean emp : empList) {
		%>
		<tr>
			<td><%=emp.getEmp_id() %></td>
			<td><%=emp.getEmp_hi_id() %></td>
			<td><%=emp.getEmp_name() %></td>
			<td><%=emp.getEmp_email() %></td>
			<td><%=emp.getEmp_mob_no() %></td>
			<td><a href="/HealthInc/AdminController?source=ApproveEmp&hid=<%=emp.getEmp_hi_id()%>">Approve</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
	</fieldset></div></div>
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>