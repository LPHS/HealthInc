<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>
<table>
<tr >
<td colspan="3"><h4>Profile Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=empUpdate">Update Profile</a></td>
<td><a href="/HealthInc/MasterController?source=empDelete">Delete Profile</a></td>
</tr>
<tr >
<td colspan="3"><h4>Dependent Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=addDependent">Add Dependent</a></td>
<td colspan="2"><a href="/HealthInc/MasterController?source=viewDependents">View Dependents</a></td>

</tr>
<tr >
<td colspan="3"><h4>Claim Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=domClaim">Domiciliary Claim</a></td>
<td><a href="/HealthInc/MasterController?source=hospClaim">Hospitalization Claim</a></td>
<td><a href="/HealthInc/MasterController?source=searchClaim">Seacrh Claim</a></td>
</tr>

</table>
</body>
</html>