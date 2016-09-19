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
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h2>Employee Approval</h2>
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
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
	<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
</body>
</html>