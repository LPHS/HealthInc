<%@page import="bean.DependentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dependent Approval</title>
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
	<h2><strong><center>Dependent Approval</center></strong></h2>
	<table>
		<tr>
			<th>Employee Id</th>
			<th>Dependent Hid</th>
			<th>Dependent Name</th>
			<th>Dependent Relationship</th>
			<th>&nbsp;</th>
		</tr>
		<%
			ArrayList<DependentBean> depList = (ArrayList<DependentBean>) request.getAttribute("depList");
			for (DependentBean dep : depList) {
		%>
		<tr>
			<td><%=dep.getDep_id() %></td>
			<td><%=dep.getDep_hi_id() %></td>
			<td><%=dep.getDep_name() %></td>
			<td><%=dep.getDep_relation() %></td>
			<td><a href="/HealthInc/AdminController?source=ApproveDep&hid=<%=dep.getDep_hi_id()%>">Approve</a></td>
		</tr>
		<%
			}
		%>
	</table><br>
	<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
	</fieldset></div></div>
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>