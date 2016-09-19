<%@page import="java.util.ArrayList"%>
<%@page import="bean.ClaimBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Search</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<h2>Search Claims</h2>
<table>
<tr>
	<th>Claim Type</th>
	<th>MediAssist Claim No</th>
	<th>Patient Name</th>
	<th>Relation</th>
	<th>Claim Amount</th>
	<th>Approved Amount</th>
	<th>Claim Status</th>
</tr>
<%ArrayList<ClaimBean> cbList=(ArrayList<ClaimBean>)request.getAttribute("cbList");
for(ClaimBean cb:cbList){%>
<tr>
	<td><%=cb.getClaimType() %></td>
	<td><%=cb.getMediAssistClaimNo() %></td>
	<td><%=cb.getPatientName() %></td>
	<td><%=cb.getRelation() %></td>
	<td><%=cb.getClaimAmt() %></td>
	<td><%=cb.getApprovedAmt() %></td>
	<td><%=cb.getStatus() %></td>			
</tr>
<%} %>
</table>
<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>