<%@page import="bean.ClaimBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Claim Approval</title>
</head>
<body>
<h4>Pending Claim Approvals</h4>

<%
ArrayList<ClaimBean> obj= new ArrayList<ClaimBean>();
obj=(ArrayList<ClaimBean>)request.getAttribute("list");
%>

<table>
<% for(ClaimBean e:obj)
	{
	%>
	<tr>
	<td></td><td></td><td></td><td></td>
	</tr>
<%} %>
</table>
</body>
</html>