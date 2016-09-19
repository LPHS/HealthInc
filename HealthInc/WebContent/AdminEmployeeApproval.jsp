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
<body>
	<jsp:include page="Header.jsp"></jsp:include>
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
	<jsp:include page="Footer.jsp"></jsp:include>
	<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
</body>
</html>